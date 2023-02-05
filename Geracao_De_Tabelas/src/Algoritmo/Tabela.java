package Algoritmo;

import java.util.HashMap;
import java.util.Map;

import java.util.*;

public class  Tabela {
    private Map<Integer, Map<String, String>> tabela;

    public Tabela(){
        tabela = new HashMap<>();
    }

    public void iniciartabela(Autonomo a){
        GLC gramatic = a.getGlc();
        List<String> colunas = new ArrayList<>();

        for(String s: gramatic.getTerminal()){
            colunas.add(s);
        }
        colunas.add("$");

        for(String s: gramatic.getVariavel()){
            colunas.add(s);
        }

        for(int i = 0; i < a.getEstados().size(); i++){
            for(String s: colunas){
                tabela[i][s] = "";
            }
        }
    }
    public void preecherTabela(Autonomo a){

    }
    public List<String> colunasPorItem(Autonomo a, LR dado){
        List<String> vetor = new ArrayList<>();

        if(a.getTipo() == dado.){

        }

    }

    public String[] reduzirColunas(Autonomo a, String[] vetor, String[] colunas, String j, int index){

    }

    public  int getIndex(String[] vetor, String texto){
    }

    public  void tabelaPasing(Autonomo a){

    }
    
    public  void Imprimir(Autonomo a){

    }
}

