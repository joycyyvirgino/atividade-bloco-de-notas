package projetos;

import java.util.Scanner;
import banco.entidades.Agencia;
import banco.entidades.Conta;
import banco.entidades.ContaSimples;

public class CaixaChatBot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean continuar = true;
        Conta conta = null;

        do {

            System.out.println("Bem Vindo\n1. para criar uma nova conta\n2. para localizar uma conta já existente através de seu número.\n3. Sair");
            int escolha = scan.nextInt();
            scan.nextLine();


            switch (escolha) {
                case 1:
                    System.out.println("Informe o seu nome completo: ");
                    String nome = scan.nextLine();
                    System.out.println("Informe seu cpf: ");
                    String cpf = scan.nextLine();
                    ContaSimples contaAberta = new ContaSimples(nome, cpf);
                    Agencia.abrirCaixa();
                    Agencia.addConta(contaAberta);
                    Agencia.fecharCaixa();
                    System.out.println(contaAberta);
                    break;
                case 2:
                    System.out.print("Informe o número da conta: ");
                    int numeroConta = scan.nextInt();
                    conta = Agencia.localizarConta(numeroConta);
                    if (conta != null) {
                        System.out.println("Conta Localizada");
                        while (true) {
                            System.out.println("1. Depositar\n2. Sacar\n3. Transferir\n4. Saldo\n5. Sair ");
                            int opcaoEscolhida = scan.nextInt();
                            scan.nextLine();

                            if (opcaoEscolhida == 1) {
                                System.out.println("Qual valor deseja ser depositado: ");
                                double valorDepositado = scan.nextDouble();
                                System.out.println(valorDepositado);
                                conta.depositar(valorDepositado);
                            } else if (opcaoEscolhida == 2) {
                                System.out.println("Quanto deseja sacar: ");
                                double valorSaque = scan.nextDouble();
                                if (conta.sacar(valorSaque)) {
                                    System.out.println("Saque realizado com sucesso");
                                } else {
                                    System.out.println("Saldo insuficiente");
                                }
                            } else if (opcaoEscolhida == 3) {
                                System.out.print("Digite o número da conta de destino: ");
                                int contaDestinoNumero = scan.nextInt();
                                scan.nextLine();
                                System.out.println("Qual valor deseja transferir: ");
                                double valorTransferir = scan.nextDouble();
                                Conta contaDestino = Agencia.localizarConta(contaDestinoNumero);
                                if (contaDestino != null) {
                                    if (conta.transferir(contaDestino, valorTransferir)) {
                                        System.out.println("Transferência realizada com sucesso!");
                                        System.out.println("Saldo atual: " + conta.getSaldo());
                                    } else {
                                        System.out.println("Saldo insuficiente para realizar a transferência.");
                                    }
                                } else {
                                    System.out.println("Conta de destino não encontrada.");
                                }
                            } else if (opcaoEscolhida == 4) {
                                System.out.println("Seu saldo é " + conta.getSaldo());
                            } else if (opcaoEscolhida == 5) {
                                    // Sair
                                    System.out.println("Encerrando o atendimento...");
                                    System.out.println("Saldo final: " + conta.getSaldo());
                                    Agencia.addConta(conta);
                                    break;
                            } else {
                                System.out.println("Opção inválida. Escolha novamente.");
                            }
                        }

                    } else {
                        System.out.println("Conta não encontrada");
                    }
                    break;
                case 3:
                    continuar = false;
            }
        } while (continuar);
    }
}
