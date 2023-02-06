package Algoritmo;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Tabela {
    private List<String> Gramatica;
    private String [][]TabelaLL_0;
    private String [][]TabelaSLR_1;
    private String [][]TabelaCLR_0;

    public Tabela(){
        Gramatica = new ArrayList<>();
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

    public void construirGramatica(String gramatica){
        boolean inseriu = false;
        
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

