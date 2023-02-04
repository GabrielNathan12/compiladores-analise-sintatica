package Algoritmo;

public class Teste {
    public static  void main(String[] args){
        Pilha pilha = new Pilha();


        pilha.Empilha("a");
        pilha.Empilha("b");
        pilha.Empilha("A");
        pilha.Empilha("C");

        while(!pilha.vazia()){
            String a = pilha.Desenpilha();
            System.out.print(a + "\n");
        }
    }
}
