import re
from typing import List, Set

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

print("Terminais: ",Terminal);
print("Nao Terminais: ", NaoTerminal);

arq.close();
