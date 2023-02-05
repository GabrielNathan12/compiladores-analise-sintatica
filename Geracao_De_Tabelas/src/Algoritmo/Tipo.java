package Algoritmo;
import java.util.*;
import java.util.regex.*;  

public class Tipo{
    private Map<String, List<String>> __GLC;
    private Map<String, String> regras;

    public Tipo(){
        __GLC = new HashMap<>();
        regras = new HashMap<>();
    }

    public Map<String, List<String>> getGLC(){
        return __GLC;
    }

    public Map<String, String> getRegras(){
        return regras;
    }


    public boolean eVariavel(String var){
        return Pattern.compile("[A-Z][1-9]*").matcher(var).matches();
    }
    
    public boolean regraValida(String regra){
        return Pattern.compile("(([A-Z][1-9]*)|[a-z]|\\+)*|\\.").matcher(regra).matches();
      
    }

    public boolean eTerminal(String terminal){
        return Pattern.matches(terminal, ("[a-z]|\\.|$|\\+"));
    }
    

    public int tipoTabela(String tipo){
        TipoTabela tipoT = new TipoTabela();

        if(tipo.equals("LR0")){
            return tipoT.LR0;
        }
        else if(tipo.equals("SLR1")){
            return tipoT.SLR1;
        }
        else if(tipo.equals("CLR1")){
            return tipoT.CLR1;
        }else if(tipo.equals("LALR1")){
            return tipoT.LALR1;
        }

        return 0;
    }
}
