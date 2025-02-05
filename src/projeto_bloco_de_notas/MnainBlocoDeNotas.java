package projeto_bloco_de_notas;

import java.util.List;
import java.util.Scanner;

public class MnainBlocoDeNotas {
    public static void main(String[] args) {
        BlocoDeNotas blocoDeNotas = new BlocoDeNotas();

        boolean continuar = true;
        final Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("=-=-=-=-= BLOCO DE NOTAS =-=-=-=");
            System.out.println("1 - CRIAR ANOTAÇÃO");
            System.out.println("2 - VER MINHAS ANOTAÇÕES");
            System.out.println("3 - REMOVER ANOTAÇÃO");
            System.out.println("4 - PESQUISAR ANOTAÇÕES");
            System.out.println("5 - EDITAR ANOTAÇÃO");

            int opcao  = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.print("Digite sua anotação: ");
                    String texto = scanner.nextLine();
                    blocoDeNotas.adicionarTexto(texto);
                    break;
                case 2:
                    blocoDeNotas.exibirAnotacoes();
                    break;
                case 3:
                    System.out.print("Digite o id da anotação que você deseja remover: ");
                    int index = Integer.parseInt(scanner.nextLine());
                    blocoDeNotas.remover(index);
                    break;
                case 4:
                    System.out.print("Digite um texto que você deseja pesquisar: ");
                    String pesquisa = scanner.nextLine();
                    List<Anotacoes> listaAnotacoes = blocoDeNotas.bucarAnotacao(pesquisa);
                    System.out.println("=-=-=-= ANOTAÇÕES COM '"+ pesquisa + "' =-=-=-=");
                    for (Anotacoes anotacoes : listaAnotacoes) {
                        System.out.println(anotacoes.getId() + " - " + anotacoes.getTexto() + " - " + anotacoes.getDataDeCriacao());
                    }
                    break;
                case 5:
                    System.out.print("Digite o id da anotação que você deseja editar: ");
                    int indexEdit = Integer.parseInt(scanner.nextLine());
                    System.out.print("Digite o novo texto que você deseja colocar: ");
                    String novoTexto = scanner.nextLine();
                    blocoDeNotas.editarAnotacao(indexEdit, novoTexto);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
            System.out.println("Você deseja continuar? [S / N]");
            String resp = scanner.nextLine();
            if (resp == "S") {
                continuar = false;
            }
        } while (continuar != false);
    }
}
