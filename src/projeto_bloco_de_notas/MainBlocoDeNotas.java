package projeto_bloco_de_notas;

import java.util.List;
import java.util.Scanner;

public class MainBlocoDeNotas {
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
            System.out.println("6 - SAIR");

            int opcao;
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite um número válido!");
                continue;
            }
            switch (opcao) {
                case 1:
                    System.out.print("Digite sua anotação: ");
                    String texto = scanner.nextLine();
                    try {
                        blocoDeNotas.adicionarTexto(texto);
                        System.out.println("anotação adicionada com sucesso");
                    }
                    catch (Exception  e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    blocoDeNotas.exibirAnotacoes();
                    break;
                case 3:
                    System.out.print("Digite o id da anotação que você deseja remover: ");
                    try{
                        int index = Integer.parseInt(scanner.nextLine());
                        if(index < 0 || index > blocoDeNotas.getAnotacoes().size()){
                            System.out.println("Erro: ID inválido!");
                        }else{
                            blocoDeNotas.remover(index);
                            System.out.println("Anotação removida com sucesso!");
                        }
                    }
                    catch (Exception e){
                        System.out.println("Erro: Digite um número válido!");
                    }
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
                    try{
                        int indexEdit = Integer.parseInt(scanner.nextLine());

                            if (indexEdit <= 0 || indexEdit > blocoDeNotas.getAnotacoes().size()){
                                System.out.println("Erro: ID inválido!");
                            break;
                        }
                        System.out.println("Novo texto: ");
                        String novoTexto = scanner.nextLine();
                        try{
                            blocoDeNotas.editarAnotacao(indexEdit, novoTexto);
                            System.out.println("Anotação adicionada com sucesso");
                        }
                        catch (Exception e){
                        System.out.println(e.getMessage());
                        }
                    }catch (Exception e){
                        System.out.println("Erro: Digite um número válido!");
                    }
                    break;
                    default:
                        System.out.println("Opção inválida!");
                    break;

            }
            System.out.println("Você deseja continuar? [S / N]");
            String resp = scanner.nextLine();
            if (resp.equalsIgnoreCase("n")) { // Verifica se o usuário digitou "N" ou "n"
                continuar = false;
                System.out.println("Saindo...");
            }
        } while (continuar); // Mantém o loop enquanto continuar for true
        scanner.close();
    }

}
