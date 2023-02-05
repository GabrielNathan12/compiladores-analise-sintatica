package Algoritmo;
import java.util.*;;

public class LR {
    private boolean CLR1 = false;
    private int posicao;
    private List<String> loockAhead;
    private Tipo t;

    public LR(Tipo t , boolean CLR1){
        loockAhead = new ArrayList<>();
        t = new Tipo();
        loockAhead.clear();
    }

    public String proximoSimbolo(){

        if(posicao < t.getRegras().size()){
            return t.getRegras().get(posicao);
           
        }else{
            return "";
        }
    }

    public LR lerSimbolo(){
        if(posicao < t.getRegras().size()){
            CLR1 = false;
            LR l = new LR(t, CLR1);
            l.loockAhead = this.loockAhead;
            l.posicao = this.posicao + 1;
            return l;
        }
        return null;
    }

    public boolean reduzir(){
        return posicao == t.getRegras().size();
    }

    public void olharLoockAhead(List<String> loockAhead, int tipo){
        TipoTabela tt = new TipoTabela();
        if(tipo == tt.CLR1){
            this.loockAhead = loockAhead;
        }
    }

    public List<String> calcularLoockAhead(GLC c){
        if(posicao >= t.getRegras().size() - 1){
            return loockAhead;
        }else{
            String Simbolo = "";

            Simbolo += t.getRegras();
            List<String> a =  new ArrayList<>();
            
            if(t.eTerminal(Simbolo)){
                
                a.add(Simbolo);
                return a;
            }else{
                return c.achar(a);
            }
        }
    }
    public boolean getClr1(){
        return CLR1;
    }

    public int getPosicao(){
        return posicao;
    }
    public List<String> getLookAhead(){
        return loockAhead;
    }

}
