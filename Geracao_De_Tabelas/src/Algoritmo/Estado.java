package Algoritmo;
import java.util.*
;
public class Estado{
   private int id = -1;
   private List<LR> dados;
   private Map<String, Estado> transicao;

    public Estado(int id){
        this.id = id == -1 ? 0: id;
        dados = new ArrayList<>();
        transicao = new HashMap<>();
    }

    public int getId(){
        return id;
    }

    public List<LR> getDados(){
        return dados;
    }

    public Map<String, Estado> getTransicao(){
        return transicao;
    }

    public void addDado(LR dado){
        dados.add(dado);
    }
    public void transicao(String c, Estado estado){
        transicao.put(c, estado);
    }

    public String printar(String saida, Estado e){
        String texto = "Estados:\n";
        texto += e.id + "\n";

        for(LR i: e.dados){
            texto += i + "\n";
        }
        for(String i: e.transicao.keySet()){
            texto += i + "\n";
        }

        return texto;
    }
}
