package Algoritmo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.swing.JPanel;

public class Tabela {
    private List<String> Gramatica;
    private List<String> estados;
    private Map<Character, String> e;
    private String [][]TabelaLL_0;
    private String [][]TabelaSLR_1;
    private String [][]TabelaCLR_0;

    public Tabela(){
        Gramatica = new ArrayList<>();
        estados = new  ArrayList<>();
        TabelaLL_0 = new String[10][10];
        TabelaSLR_1 = new String[20][20];
        TabelaCLR_0 = new String[20][20];
    }

    public boolean eVariavel(String var){
        return Pattern.compile("[A-Z][1-9]*").matcher(var).matches();
    }
    
    public boolean regraValida(String regra){
        return Pattern.compile("(([A-Z][1-9]*)|[a-z]|\\+)*|\\.").matcher(regra).matches();
      
    }

    public boolean eTerminal(String terminal){
        return Pattern.compile(("[a-z]|\\.|$|\\+")).matcher(terminal).matches();
    }

    public void exetenderGramatica(){
        boolean temRecursao = false;

        String Regra = Gramatica.get(0);
        
        String regra = Regra.substring(0,1);
        

 
        
        for(int i =0; i< Gramatica.size(); i++){
            int a = Gramatica.get(i).indexOf(regra,1);
            if(a != -1){
                temRecursao = true;
            }
        }

        if(temRecursao){
            System.out.println("Removendo a recursao direta com o simbolo inicial");
            Gramatica.add(regra + "'->" + regra +";");
            
        }  
    }

    public void criarTrasicao(){
        
        List<String> antigaGramatica = new ArrayList<>();
        antigaGramatica = Gramatica;
        boolean terminou = false;

        String Regra = Gramatica.get(0);
        String regra = Regra.substring(0,2);

        estados.add(regra);

        for (int i = 0; i < antigaGramatica.size(); i++) {
            
            String estado = antigaGramatica.get(i).substring(i);
            //System.out.println(estado + "\n");
            
            int a = Gramatica.get(i).indexOf("->");
            //int b = Gramatica.get(i).indexOf(">",1);
            if(antigaGramatica.get(i).trim().length() > 1 && !"".equals(antigaGramatica.get(i).trim())){
                //System.out.print(estado);
            }
            //while(a != -1 && terminou){
              //  System.out.print(antigaGramatica);
            //}

            

        }

        for(String s: Gramatica){
            String[] a = s.split("->");

            for(String x: a){
                if(x.trim().length() > 1 && !"".equals(x.trim())){
                    for(int j = 0; j < x.length(); j++){
                        System.out.print(x.charAt(j) + " ");
                    }
                
                }
            }
            
        }
        
       //for(String key: estados){
         // System.out.println(key);

        //}
    }

    public void construirGramatica(String gramatica){
        boolean inseriu = false;
        
        String regra = gramatica.substring(0,1);
        Gramatica.add(regra + "'"+ "->" + regra );

            while(!inseriu){
                String[] g = gramatica.split(";");
                
                for(String gra: g){
                    if(gra.trim().length() > 1 && !"".equals(gra.trim())){
                        Gramatica.add(gra);
                        inseriu = true;
                    }
                }
            }
    }

    public void imprimirGramatica(){
        for(String g: Gramatica){
            System.out.println(g);
        }
        System.out.println("\nTamanho Array = " + Gramatica.size());
    }

    public void calcularItemLR(){
        for(int i = 0; i < Gramatica.size(); i++){
                    
        }
    }


    public void construirTabelaLL_0(){
        
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(TabelaLL_0[i][j] == null){
                    TabelaLL_0[i][j] = "V";
                }
            }
        }
    }
    public void imprimirTabelaLL_0(){

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                System.out.print(TabelaLL_0[i][j] + " ");
            }
        }
        System.out.println(" ");
    }
}

