package atividades.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class EncaixaouNao {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numero = Integer.parseInt(scan.nextLine());


        for (int i = 0; i < numero; i++) {

            String[] numeros = scan.nextLine().split(" "); // Divide a entrada em duas partes
            String a = numeros[0];
            String b = numeros[1];


            if (a.endsWith(b)) {
                System.out.println("encaixa");
            } else {
                System.out.println("nao encaixa");
            }
        }

        scan.close(); // Fecha o scanner
    }
}
