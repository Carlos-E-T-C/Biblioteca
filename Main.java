package Biblioteca;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    private static ArrayList < Musica > musicas = new ArrayList < > ();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcao = 0;
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Incluir Musica");
            System.out.println("2 - Pesquisar Musica");
            System.out.println("3 - Remover Musica");
            System.out.println("4 - Sair");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do scanner

            switch (opcao) {
                case 1:
                    incluirMusica(scanner);
                    break;
                case 2:
                    pesquisarMusica(scanner);
                    break;
                case 3:
                    removerMusica(scanner);
                    break;
                case 4:
                    sair();
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }

            System.out.println();
        } while (opcao != 4);
    }

    private static void incluirMusica(Scanner scanner) {
    	int opcao;
    	while (true) {
    	    System.out.println("Escolha uma opção:");
    	    System.out.println("1 - Musica Nacional");
    	    System.out.println("2 - Musica Internacional");
    	    if (scanner.hasNextInt()) {
    	        opcao = scanner.nextInt();
    	        if (opcao == 1 || opcao == 2) {
    	            break;
    	        }
    	    }
    	    scanner.nextLine(); // Limpa o buffer do scanner
    	    System.out.println("Opção inválida. Digite 1 ou 2.");
    	}
    	scanner.nextLine(); // Limpa o buffer do scanner

        String titulo, estilo, interpreteNome;
        int anoGravacao;


        System.out.println("Informe o título:");
        titulo = scanner.nextLine();

        System.out.println("Informe o estilo:");
        estilo = scanner.nextLine();

        do {
            System.out.println("Informe o ano de gravação:");
            while (!scanner.hasNextInt()) {
                System.out.println("Ano de gravação inválido, insira novamente:");
                scanner.next();
            }
            anoGravacao = scanner.nextInt();
            scanner.nextLine();
        } while (anoGravacao <= 0);

        System.out.println("Informe o nome do intérprete:");
        interpreteNome = scanner.nextLine();

        Interprete interprete = new Interprete(interpreteNome);

        if (opcao == 1) {
            String estado, regional;

            List < String > estadosBrasil = Arrays.asList("AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO");

            System.out.println("Informe o Estado do Brasil (sigla):");
            estado = scanner.nextLine();

            while (!estadosBrasil.contains(estado.toUpperCase())) {
                System.out.println("Estado inválido. Informe um estado válido do Brasil:");
                estado = scanner.nextLine();
            }

            do {
                System.out.println("Informe se é uma música regional (N/S):");
                regional = scanner.nextLine();
            } while (!regional.equalsIgnoreCase("N") && !regional.equalsIgnoreCase("S"));

            MusicaNacional musicaNacional = new MusicaNacional(titulo, estilo, anoGravacao, estado, regional, interprete);
            musicas.add(musicaNacional);
        } else if (opcao == 2) {
            String pais, idioma;

            System.out.println("Informe o país:");
            pais = scanner.nextLine();

            System.out.println("Informe o idioma:");
            idioma = scanner.nextLine();

            MusicaInternacional musicaInternacional = new MusicaInternacional(titulo, estilo, anoGravacao, pais, idioma, interprete);
            musicas.add(musicaInternacional);
        } else {
            System.out.println("Opção inválida");
        }
    }

    private static void pesquisarMusica(Scanner scanner) {
        System.out.println("Informe o título da música a ser pesquisada:");
        String titulo = scanner.nextLine();

        for (Musica musica: musicas) {
            if (musica.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("Título: " + musica.getTitulo());
                System.out.println("Estilo: " + musica.getEstilo());
                System.out.println("Ano de gravação: " + musica.getAnoGravacao());
                System.out.println("Interprete: " + musica.getInterprete().getNome());

                // Se for uma música nacional
                if (musica instanceof MusicaNacional) {
                    MusicaNacional musicaNacional = (MusicaNacional) musica;
                    System.out.println("Estado: " + musicaNacional.getEstado());
                    System.out.println("Regional: " + musicaNacional.getRegional());
                }
                // Se for uma música internacional
                else if (musica instanceof MusicaInternacional) {
                    MusicaInternacional musicaInternacional = (MusicaInternacional) musica;
                    System.out.println("País: " + musicaInternacional.getPais());
                    System.out.println("Idioma: " + musicaInternacional.getIdioma());
                }

                return;
            }
        }

        System.out.println("Música não encontrada");
    }

    private static void removerMusica(Scanner scanner) {
        System.out.println("Informe o título da música a ser removida:");
        String titulo = scanner.nextLine();

        for (Musica musica: musicas) {
            if (musica.getTitulo().equalsIgnoreCase(titulo)) {
                musicas.remove(musica);
                System.out.println("Música removida com sucesso");
                return;
            }
        }

        System.out.println("Música não encontrada");
    }


    private static void sair() {
        System.out.println("Encerrando programa...");
        System.out.println("Total de músicas cadastradas: " + musicas.size());
        System.exit(0);
    }
}