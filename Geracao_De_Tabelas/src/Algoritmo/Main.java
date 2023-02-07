package Algoritmo;

import java.util.Scanner;

public class Main {
    public static  void main(String[] args){
        Scanner input = new Scanner(System.in);
        String gramatica;
        
        System.out.println("Exemplos de entrada de Gramatica: ");
        System.out.println("Toda regra precisa de um ponto e virgula para indicar o final da regra\n");
        System.out.println("Exemplo 1: ");
        System.out.println("S-> aS | bA; A-> a;");
        System.out.println("\nExemplo 2: ");
        System.out.println("S-> aS | bA; A-> a | bC; C-> c;");
        System.out.println("\nSem o ponto e virgula separando as regras causara erro");

        System.out.println("\nDigite sua Gramatica: ");
        gramatica = input.nextLine();
        System.out.println();
        Tabela t = new Tabela();

        t.construirGramatica(gramatica);
        t.exetenderGramatica();
        System.out.println("Gramatica inserida: ");
        t.imprimirGramatica();
 
            


        input.close();
    }
 
}
