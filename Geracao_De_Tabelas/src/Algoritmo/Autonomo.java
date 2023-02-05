package Algoritmo;
import java.util.*;

public class Autonomo{
    private List<String> estados;
    private int tipo;
    private GLC gramatica;


    public Autonomo(GLC gramatica,String tipo){
        this.gramatica = gramatica;
        estados = new ArrayList<>();
    }
    public Autonomo(char arquivo, String tipo){

    }

    public void criarAutomato(){

    }

    public List<String> getEstados(){
        return estados;
    }
    public int getTipo(){
        return tipo;
    }
    public GLC getGlc(){
        return gramatica;
    }
}
