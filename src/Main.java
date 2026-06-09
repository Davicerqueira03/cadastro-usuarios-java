import controller.UsuarioController;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UsuarioApiClient apiClient = new UsuarioApiClient();

        int opcao;

        do {
            System.out.println("\n Opções:");
            System.out.println("1 - Adicionar usuario");
            System.out.println("2 - Listar usuarios");
            System.out.println("3 - Atualizar usuario");
            System.out.println("4 - Remover usuario");
            System.out.println("0 - Sair");


            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o ID do usuario: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Digite o nome do usuario: ");
                    String nome = scanner.nextLine();

                    System.out.print("Digite o email do usuario: ");
                    String email = scanner.nextLine();

                    apiClient.criarUsuario(id, nome, email);
                    break;

                case 2:
                    apiClient.listarUsuarios();
                    break;

                case 3:
                    System.out.print("Digite o ID do usuario que deseja atualizar: ");
                    int idAtualizar = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Digite o novo nome: ");
                    String novoNome = scanner.nextLine();

                    System.out.print("Digite o novo email: ");
                    String novoEmail = scanner.nextLine();

                    apiClient.atualizarUsuario(idAtualizar, novoNome, novoEmail);
                    break;

                case 4:
                    System.out.print("Digite o ID do usuario que deseja remover: ");
                    int idRemover = scanner.nextInt();
                    scanner.nextLine();

                    apiClient.removerUsuario(idRemover);
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}