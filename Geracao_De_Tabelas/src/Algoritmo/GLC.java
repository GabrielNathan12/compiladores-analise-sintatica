package Algoritmo;

import java.util.*;
import java.io.*;

public class GLC{
    
    private Constante c;
    private String simboloInicial;
    private List<String> terminal;
    private List<String> variavel;

    public GLC(String arquivo){
        simboloInicial = "";
        terminal = new ArrayList<>();
        variavel = new ArrayList<>();
    
    }

    public List<String> lerArquivo(String arquivo){
        List<String> texto = new ArrayList<>();
        BufferedReader leia = null;

        try{
            leia = new BufferedReader(new FileReader(arquivo));

            String linha;

            while((linha = leia.readLine()) != null){
                texto.add(linha);
            }

        }catch(IOException e){
            System.out.println(e.getMessage());
        }

        return texto;
    }

    public void calcularTerminaisVariaveis(){
         
    }

    public List<String> getTerminal(){
        return terminal;
    }
    public List<String> getVariavel(){
        return variavel;
    }
    public void novoInicial(){
        String novo = simboloInicial + "\n";

    }
    
    public List<String> achar(List<String> a){
        return a;
    }
}
