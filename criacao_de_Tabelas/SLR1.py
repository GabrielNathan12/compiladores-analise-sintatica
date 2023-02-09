regras = []
with open("gramatica.txt") as arq:
    
    for linha in arq:
        linha  = linha.strip();
        regras.append(linha)

print("Digite os estados não terminais da gramática");

print(regras);
#print(regras)
input();
arq.close();
