import re
from typing import List, Set
import copy;

def getTerminal(var):
    x = re.compile('[a-z+*/-]');
    q = x.findall(var);
    
    if q:
        return q;
        

def getNaoTerminal(var):
    x = re.compile('[A-Z]');
    q = x.findall(var);
    
    if q:
        return q;

def derivacaoGramatica(regras, naoTerminal, simboloInicial):
    novasRegras = []
    
    novoSimbolo = simboloInicial + "'";
    
    while novoSimbolo in naoTerminal:
        novoSimbolo += "'";
    
    novasRegras.append([novoSimbolo, ['.', simboloInicial]]);
    
    for r in regras:
        k = r.split("->");
        lhs = k[0].strip();
        rhs = k[1].strip();
        
        aux = rhs.split('|');
        
        for h in aux:
            h = h.strip().split();
            h.insert(0,'.');
            novasRegras.append([lhs, h]);
        
    return novasRegras;

def acharFecho(entrada, naoSimbolo):
    global SimboloInicial, \
        separarRegras, \
        disciEstados;
        
    fecho = [];
    
    if naoSimbolo == SimboloInicial:
        for r in separarRegras:
            if r[0] == naoSimbolo:
                fecho.append(r);
    else:
        fecho = entrada;
    
    
    i = -1;
    
    while i != len(fecho):
        i = len(fecho);
        
        auxFecho = [];
        
        for r in fecho:
            index1 = r[1].index('.');
            
            if r[1][-1] != '.':
                aux2 = r[1][index1 + 1];
                
                for j in separarRegras:
                    if aux2 == j[0] and \
                        j not in auxFecho:
                            auxFecho.append(j);
                
                for r in auxFecho:
                    if r not in fecho:
                        fecho.append(r);
    return  fecho;     
            
            
    
def computacao(estado):
    global disciEstados, estadoSaida;
    
    gerarEstados = []
    
    for r in disciEstados[estado]:
        
        if r[1][-1] != '.':
            index1 = r[1].index('.');
            aux = r[1][index1 + 1];
            
            if aux not in gerarEstados:
                gerarEstados.append(aux);
    
    if len(gerarEstados) != 0:
        for s in gerarEstados:
            GOTO(estado, s);
    return

def GOTO(estado, proximoEstado):
    global disciEstados, estadoSaida, mapEstados;
    
    novoEstado = [];
    
    for r in disciEstados[estado]:
        index1 = r[1].index('.');
        if r[1][index1 + 1] == \
            proximoEstado:
                
                shift = copy.deepcopy(r);
                shift[1][index1] = \
                    shift[1][index1 + 1]
                shift[1][index1 + 1] = '.'
                novoEstado.append(shift);
                
                
    addFecho = []
    
    for r in novoEstado:
        index1 = r[1].index('.');
        if r[1][-1] != '.':
            fechoAux = \
                acharFecho(novoEstado , r[1][index1 + 1]);
            
            for r in fechoAux:
                if r not in addFecho \
                    and r not in novoEstado:
                    addFecho.append(r);
    
    for r in addFecho:
        novoEstado.append(r);
        
    saida = -1;
    
    for s in disciEstados:
        if disciEstados[s] == novoEstado:
            saida = s;
            break;
    
    if saida == -1:
    
        estadoSaida += 1;
        disciEstados[estadoSaida] = novoEstado;
        mapEstados[(estado, proximoEstado)] = estadoSaida;
    else:
        mapEstados[(estado, proximoEstado)] = saida;
    return

def gerarEstados(disEstados):
    tam = -1;
    chamarGoto = []
    
    while len(disEstados) != tam:
        tam = len(disEstados);
        chave = list(disEstados.keys());
        
        for c in chave:
            if c not in chamarGoto:
                chamarGoto.append(c);
                computacao(c)
    return 


def Primeiro(regra):
    global regras, NaoTerminal, \
        Terminal, seguidor, primeiro;
        
    
    if len(regra) != 0 and (regra is not None):
        if regra[0] in Terminal:
            return regra[0];
        elif regra[0] == '#':
            return '#';
    
    if len(regra) != 0:
        if regra[0] in list(seguidor.keys()):
            aux = [];
            
            auxRegras = seguidor[regra[0]];
            
            for i in auxRegras:
                ind = Primeiro(i);
                if type(ind) is list:
                    aux.append(i);
                else:
                    aux.append(ind);
            
            if '#' not in aux:
                return aux;
            else:
                
                novaLista = [];
                aux.remove('#');
                
                if len(regra) > 1:
                    aux2 = Primeiro(regra[1:]);
                    if aux2 != None:
                        if type(aux2) is list:
                            novaLista = aux + aux2;
                        else:
                            novaLista = aux + [aux2];
                    else:
                        novaLista = aux;
                    return novaLista;
                
                aux.append('#');
                return aux;
            
def Seguidor(regra):
    global SimboloInicial , regras , NaoTerminal, \
        Terminal, seguidor, primeiro, seguidores;
    
    extender = set();
    
    if regra == SimboloInicial:
        extender.add('$');
        
    for i in disciEstados:
        rhs = disciEstados[i];
        for j in rhs:
            if regra in j:
                
                while regra in j:
                    indexi = i.index(regra);
                    j = j[indexi + 1:];
                    
                    if len(j) != 0:
                        
                        res = Primeiro(j);
                        
                        if '#' in res:
                            novaLista = [];
                            seg = Seguidor(i);
                            
                            if seg != None:
                                if type(seg) is list:
                                    novaLista = res + seg;
                                else:
                                    novaLista = res + [seg];
                            else:
                                novaLista = res;
                            res = novaLista;
                    else:
                        
                        if regra != i:
                            res = Seguidor(i);
                    
                    if res is not None:
                        if res is not list:
                            for k in res:
                                extender.add(k);
                        else:
                            extender.add(res);
    return list(extender);
                        
                    

def criarTabelaParse(disciEstado, mapEstado, T , regra):
    global separarRegras , seguidor;
    
    linhas = list(disciEstado.keys());
    colunas = T+['$']+regra;
    
    
    tabela = [];
    auxLinhas = []
    
    for i in range(len(colunas)):
        auxLinhas.append('');
    
    for j in range(len(linhas)):
        tabela.append(copy.deepcopy(auxLinhas));
        
    for i in mapEstado:
        estado = i[0];
        simbolo = i[1];
        
        a = linhas.index(estado);
        b = colunas.index(simbolo);
        
        if simbolo in regra:
            tabela[a][b] = tabela[a][b]\
                + f"S{mapEstado[i]}";
    
    num = {};
    chaves = 0;
    
    for r in separarRegras:
        auxLinhas = copy.deepcopy(r);
        auxLinhas[1].remove('.');
        num[chaves] = auxLinhas;
        chaves += 1;

    addRegras = f"{separarRegras[0][0]} -> "\
        f"{separarRegras[0][0][1]}"
    regras.insert(0, addRegras);
    
    for r in regras:
        k = r.split("->");
        
        k[0] = k[0].strip();
        k[1] = k[1].strip();
        
        rhs = k[1];
        multRegras = rhs.split('|');
        
        for i in range(len(multRegras)):
            multRegras[i] = multRegras[i].strip();
            multRegras[i] = multRegras[i].split();
        disciEstados[k[0]] = multRegras;
        
    for s in disciEstado:
        for r in disciEstado[s]:
            if r[1][-1] == '.':
                aux3 = copy.deepcopy(r);
                aux3[1].remove('.');
                
                for k in num:
                    if num[k] == aux3:
                        seguidorRes = Primeiro(r[0]);
                        
                        for j in seguidorRes:
                            index = colunas.index(j);
                            if k ==0:
                                tabela[s][index] = "ACT";
                            else:
                                tabela[s][index] =\
                                    tabela[s][index]+f"R{k}";

    print("\nTabela SLR(1):");

    tam = "{:>8}" * len(colunas);
    print(" " , tam.format(*colunas), "\n");
    ptr = 0;
    j = 0;
    for y in tabela:
        tam = "{:>8}" * len(y);
        print(f"{{:>3}}"f"{tam.format(*y)}".format('I'+str(j)))
        j += 1;

def printResultado(regras):
    for r in regras:
        print(f"{r[0]} ->"
              f"{' '}.join(r[1])");

def printTodasComputacao(Disc):
    for i in Disc:
        print(f"Goto ( I{i[0]})," f"{i[1]} ) = I{mapEstados[i]}");
        

regras = []
#getTerminal("G+a*briel");

with open("criacao_de_tabelas/gramatica.txt") as arq:
    for linha in arq:
        linha  = linha.strip();
        regras.append(linha)


auxNaoTerminais = []

with open ("criacao_de_tabelas/gramatica.txt") as arq:   
    for linha in arq:
        linha  = linha.split("->");
        for i in linha:
            if getNaoTerminal(i) != None:
                auxNaoTerminais.append(getNaoTerminal(i));


    
NaoTerminal = []
for i in auxNaoTerminais:
    for j in i:
        NaoTerminal.append(j);

for i in regras:
    SimboloInicial = i[0];
    
auxTerminais = []

with open ("criacao_de_tabelas/gramatica.txt") as arq:   
    for linha in arq:
        linha  = linha.split("->");
        for i in linha:
            if getTerminal(i) != None:
                auxTerminais.append(getTerminal(i));
        
Terminal = []
for i in auxTerminais:
    for j in i:
        Terminal.append(j);

NaoTerminal = list(set(NaoTerminal));
Terminal = list(set(Terminal));



print("Gramatica Original:");
#SimboloInicial = auxNaoTerminais[0];
for i in regras:
    print(i);

print("Terminais: ",Terminal);
print("Nao Terminais: ", NaoTerminal);
print("Estado inicial: ",SimboloInicial);


print("\nProcessos de Derivação: \n");

separarRegras = \
    derivacaoGramatica(regras,
                       NaoTerminal, 
                       SimboloInicial);
    
printResultado(separarRegras);

SimboloInicial = separarRegras[0][0];

print("\nProcessos de derivacao: \n");
I0 = acharFecho(0, SimboloInicial);
print(I0);

disciEstados = {};
mapEstados = {};

disciEstados[0] = I0;
estadoSaida = 0;

gerarEstados(disciEstados);

print("\nEstados Gerados pela gramatica:");

for i in disciEstados:
    print(f"Estado = {i}");
    printResultado(disciEstados[i]);
    print();

print("Trasicao da computacao:\n");
printTodasComputacao(mapEstados);

seguidor = {}

criarTabelaParse(disciEstados, mapEstados, Terminal, NaoTerminal);


arq.close();


