package atividades.arrays;

import java.util.Scanner;


public class Atividade {
    public static void main(String[] args) {
        //Receber os valores
        Scanner scan = new Scanner(System.in);//entrada padrão do teclado
        //Criação da variavel n e m
        int n , m ;
        // Criação da condição
        do{
            System.out.println("Tamanho do vetor 1: ");
            n = scan.nextInt();
        }while (n <= 1 || n >= 10);// || ou

        do {
            System.out.println("Tamanho vetor 2:  ");
            m = scan.nextInt();
        }while (m <= 1 || m >= 10);

        //Criação dos arrays
        int[] vetorUm = new int [n];
        int[] vetorDois = new int [m];
        int[] vetorIntercalacao= new int [n + m];

        //Criação dos multiplos de 3 e 2
        for (int i = 0; i < n; i++) {
            vetorUm[i] = (i + 1) * 3;
        }
        for (int i = 0; i < m; i++) {
            vetorDois[i] = (i + 1) * 2;
        }

        //Intercalação
        int  i = 0, j = 0, k = 0;

        while (i < n && j < m ){
            vetorIntercalacao[k++] = vetorUm[i++];// O k serve de ind*
            vetorIntercalacao[k++] = vetorDois[j++];
        }

        //Adicionado elementos ao vetor 1
        while (i < n){
            vetorIntercalacao[k++] = vetorUm[i++];
        }

        //Adicionado elemento ao vetor 2
        while (j < m){
            vetorIntercalacao[k++] = vetorDois[j++];
        }
        System.out.println("vetorUm:");
        imprimirVetor(vetorUm);

        System.out.println("vetorDois:");
        imprimirVetor(vetorDois);

        System.out.println("vetorIntercalacao:");
        imprimirVetor(vetorIntercalacao);

        scan.close();






    }

    static void imprimirVetor(int[]  vetor) {
        for (int num : vetor) {

        }
        System.out.println();
    }
}
