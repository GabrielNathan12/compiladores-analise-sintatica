package Algoritmo;

import java.io.Serializable;

public class Pares<U, V> extends Object implements Serializable{
    public final U primeiro;
    public final V segundo;

    private Pares(U primeiro, V segundo){
        this.primeiro = primeiro;
        this.segundo = segundo;
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }

        Pares<?,?> pares = (Pares<?,?>) o;

        if(!primeiro.equals(pares.primeiro)){
            return false;
        }

        return segundo.equals(pares.segundo);
    }

    public static <U,V> Pares<U,V> of(U a, V b){
        return new Pares<>(a, b);
    }

    public U getPrimeiro(){
        return primeiro;
    }
    public V getSegundo(){
        return segundo;
    }

    @Override
    public int hashCode(){
        return 31* primeiro.hashCode() + segundo.hashCode();
    }

    @Override
    public String toString(){
        return "( " + primeiro + " ," + segundo + ")";
    }
}
