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


    public void setTipo(int dado){

    }
    public void limpa(){

    }
    public void criarAutomato(){

    }

    public Estado gerar(){
        return null;
    }
    public void imprimir(){
        
    }

    public Estado preencherEstado(Estado e){
        return null;
    }

    public void verificar(Estado e){

    }
    public Estado criarUmEstado(LR dado){
        Estado e = new Estado(estados.size());
        //e.add(dado);
        return preencherEstado(e);
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
