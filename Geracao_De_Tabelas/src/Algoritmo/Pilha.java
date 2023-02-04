package Algoritmo;

public class Pilha {
    static final int MAX = 1000;
    private int topo;
    private String a[];

    public Pilha(){
        topo = -1;
        a = new String[MAX];
    }

    public boolean vazia(){
        return topo < 0;
    }

    public boolean Empilha(String x){
        if(topo >= MAX-1){
            System.out.print("Pilha estourada");
            return false;
        }
        else{
            a[++topo] = x;
            return true;
        }

    }

    public String Desenpilha(){
        String texto = "";
        if(topo < 0){
            texto = "Pilha vazia";
            return texto;
        }else{
            String aux = a[topo--];
            return aux;
        }
    }
}
