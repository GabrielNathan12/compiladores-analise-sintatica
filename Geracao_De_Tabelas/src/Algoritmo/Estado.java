package Algoritmo;
import java.util.*
;
public class Estado{
   private int id = -1;
   private List<String> dados;
   private Map<String, Estado> transicao;

    public Estado(int id){
        this.id = id == -1 ? 0: id;
        dados = new ArrayList<>();
        transicao = new HashMap<>();
    }

    public int getId(){
        return id;
    }

    public List<String> getDados(){
        return dados;
    }

    public Map<String, Estado> getTransicao(){
        return transicao;
    }

    public void addDado(LR dado){
        if(find(dado.begin())){

        }
    }
    public void transicao(){

    }
    
}
