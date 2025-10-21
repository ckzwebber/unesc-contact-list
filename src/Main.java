import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Agenda agenda = new Agenda();
        int opcao = -1;

        while (opcao != 11) {
            System.out.println("\n--- AGENDA DE CONTATOS ---");
            System.out.println("1 - Importar Contatos");
            System.out.println("2 - Exportar Contatos");
            System.out.println("3 - Inserir Contato");
            System.out.println("4 - Remover Contato (Telefone)");
            System.out.println("5 - Remover Contato (Nome)");
            System.out.println("6 - Localizar Contato (Nome)");
            System.out.println("7 - Localizar Contato (Telefone)");
            System.out.println("8 - Listar Todos os Contatos");
            System.out.println("9 - Realizar Chamada");
            System.out.println("10 - Limpar Agenda");
            System.out.println("11 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1: {
                    System.out.print("Informe o caminho do arquivo para importação: ");
                    String caminho = scanner.nextLine();
                    ArrayList<Contato> contatos = agenda.importContatos(caminho);
                    for (Contato c : contatos) {
                        agenda.addContato(c);
                    }
                    System.out.println(contatos.size() + " contatos importados com sucesso!");
                    break;
                }
                case 2: {
                    System.out.print("Informe o caminho para exportar os contatos: ");
                    String caminho = scanner.nextLine();
                    agenda.exportContatos(caminho);
                    break;
                }
                case 3: {
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Telefone (11 dígitos): ");
                    String telefone = scanner.nextLine();
                    System.out.print("Endereço: ");
                    String endereco = scanner.nextLine();

                    Contato novo = new Contato(nome, telefone, endereco);
                    agenda.addContato(novo);
                    System.out.println("Contato adicionado com sucesso!");
                    break;
                }
                case 4: {
                    System.out.print("Informe o telefone: ");
                    String telefone = scanner.nextLine();
                    boolean removido = agenda.removeContatoByTelefone(telefone);
                    System.out.println(removido ? "Contato removido!" : "Contato não encontrado.");
                    break;
                }
                case 5: {
                    System.out.print("Informe o nome: ");
                    String nome = scanner.nextLine();
                    boolean removido = agenda.removeContatoByNome(nome);
                    System.out.println(removido ? "Contato removido!" : "Contato não encontrado.");
                    break;
                }
                case 6: {
                    System.out.print("Informe o nome: ");
                    String nome = scanner.nextLine();
                    Contato c = agenda.getContatoByNome(nome);
                    System.out.println(c != null ? c : "Contato não encontrado.");
                    break;
                }
                case 7: {
                    System.out.print("Informe o telefone: ");
                    String telefone = scanner.nextLine();
                    Contato c = agenda.getContatoByTelefone(telefone);
                    System.out.println(c != null ? c : "Contato não encontrado.");
                    break;
                }
                case 8: {
                    ArrayList<Contato> contatos = agenda.getAllContatos();
                    if (contatos.isEmpty()) {
                        System.out.println("Nenhum contato cadastrado.");
                    } else {
                        System.out.println("\nLista de Contatos:");
                        contatos.forEach(System.out::println);
                    }
                    break;
                }
                case 9: {
                    System.out.print("Informe o telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.println(agenda.call(telefone));
                    break;
                }
                case 10: {
                    agenda.clearAgenda();
                    System.out.println("Agenda limpa com sucesso!");
                    break;
                }
                case 11: {
                    System.out.println("Saindo da agenda...");
                    break;
                }
                default: System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }
}
