package atividades.arrays;

import java.util.Scanner;

public class MaiormenorNumero {
    public static void main(String[] args) {
        //Java básico: refatorando com rename e refactoring EXEMPLO
        final int QUANTIDADE_DE_VEZES = 2 ;
        Scanner scan = new Scanner(System.in);
        int num; 
        int minimo = Integer.MAX_VALUE;
        int maximo = Integer.MIN_VALUE;

        for (int i = 0; i < QUANTIDADE_DE_VEZES; i++) {
            num = recebeInteiro(scan);
            minimo = menorNumeroEntre(num, minimo);
            maximo = maiorNumeroEntre(num, maximo);
        }
        scan.close();
        System.out.println("Menor número: " + minimo);
        System.out.println("Maior número: " + maximo);}

    private static int maiorNumeroEntre(int num, int maximo) {
        if (num > maximo){
           maximo = num;
       }
        return maximo;
    }

    private static int menorNumeroEntre(int num, int minimo) {
        if(num < minimo){
            minimo = num;
        }
        return minimo;
    }

    private static int recebeInteiro(Scanner scan) {
        int num;
        System.out.println("Informe um número: ");
        num = scan.nextInt();
        return num;
    }
}
