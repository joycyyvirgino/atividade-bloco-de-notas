package  projetos;

import java.util.Scanner;

public class UsaConta {

    public static void main(String[] args)throws Exception {
        Scanner scanner= new Scanner(System.in);
        //ContaCorrente conta = new ContaCorrente(1, "Raquel", "000111", 2);
        Agencia ag = new Agencia(1,"ufpb-rio tinto");
        System.out.println("nome: ");
        String nome = scanner.nextLine();
        System.out.println("cpf: ");
        String cpf = scanner.nextLine();
        try {
            ag.adicionarConta("", "1324532");
            System.out.println("Isso vai rodar?");
        }catch (Exception ex) {
            System.err.println("Sinto muito,erro:\n" + ex.getLocalizedMessage());
        }



    }
}
