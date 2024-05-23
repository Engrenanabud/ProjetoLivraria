import java.util.List;
import java.util.Scanner;

public class Livraria {
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        int opcao = 0;
        while (opcao != 6) {

            System.out.println("Bem vindo a Livraria Abud");
            System.out.println("Digite a opcao desejada: ");
            System.out.println("[1] Para cadastrar livro");
            System.out.println("[2] Para Buscar por autor");
            System.out.println("[3] Para Buscar por gênero");
            System.out.println("[4] Para Buscar por isbn");
            System.out.println("[5] Para Buscar por título");
            System.out.println("[6] Para sair do programa");
            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:

                    Livro livroRegistrado = cadastrarLivro();
                    System.out.println("Livro cadastrado com sucesso: " + livroRegistrado);
                    Acervo.salvarLivro(livroRegistrado);

                    break;
                case 2:
                    System.out.println("Digite o autor desejado para encontrar seus livros: ");
                    String autorDigitado = scanner.next();

                    List<Livro> todasOsLivros = Acervo.buscarLivros();

                    if (!todasOsLivros.isEmpty()) {
                        System.out.println("Livros do mesmo autor: ");
                        for (Livro livro : todasOsLivros) {
                            if (livro.getAutor().equalsIgnoreCase(autorDigitado)) {
                                System.out.println("Título: " + livro.getTitulo() + " " + "Autor: " + livro.getAutor() + " Isbn: " + livro.getIsbn() + " Gênero: " + livro.getGenero() + " Preço: " + livro.getPreco());
                            }
                        }
                    } else {
                        System.out.println("Nenhuma conta registrada no banco.");
                    }

                    break;
                case 3:

                    System.out.println("Digite o gênero desejado para encontrar seus livros: ");
                    String generoDesejado = scanner.next();

                    List<Livro> todosOsLivrosPorGenero = Acervo.buscarLivros();

                    if (!todosOsLivrosPorGenero.isEmpty()) {
                        System.out.println("Livros do mesmo gênero: ");
                        for (Livro livro : todosOsLivrosPorGenero) {
                            if (livro.getGenero().equalsIgnoreCase(generoDesejado)) {
                                System.out.println("Título: " + livro.getTitulo() + " " + "Autor: " + livro.getAutor() + " Isbn: " + livro.getIsbn() + " Gênero: " + livro.getGenero() + " Preço: " + livro.getPreco());
                            }
                        }
                    } else {
                        System.out.println("Nenhum livro encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Digite o numero do isbn desejado: ");
                    String isbnDesejado = scanner.next();

                    List<Livro> todosOsLivrosPorIsbn = Acervo.buscarLivros();

                    if (!todosOsLivrosPorIsbn.isEmpty()) {
                        System.out.println("Livros do mesmo gênero: ");
                        for (Livro livro : todosOsLivrosPorIsbn) {
                            if (livro.getGenero().equalsIgnoreCase(isbnDesejado)) {
                                System.out.println("Título: " + livro.getTitulo() + " " + "Autor: " + livro.getAutor() + " Isbn: " + livro.getIsbn() + " Gênero: " + livro.getGenero() + " Preço: " + livro.getPreco());
                            }
                        }
                    } else {
                        System.out.println("Nenhum livro encontrado.");
                    }

                    break;
                case 5:

                    System.out.println("Digite o numero do isbn desejado: ");
                    String tituloDesejado = scanner.next();

                    List<Livro> todosPorTitulo = Acervo.buscarLivros();

                    if (!todosPorTitulo.isEmpty()) {
                        System.out.println("Livros do mesmo gênero: ");
                        for (Livro livro : todosPorTitulo) {
                            if (livro.getGenero().equalsIgnoreCase(tituloDesejado)) {
                                System.out.println("Título: " + livro.getTitulo() + " " + "Autor: " + livro.getAutor() + " Isbn: " + livro.getIsbn() + " Gênero: " + livro.getGenero() + " Preço: " + livro.getPreco());
                            }
                        }
                    } else {
                        System.out.println("Nenhum livro encontrado.");
                    }

                    break;
                case 6:

                    break;
                default:
                    System.out.println("Insira uma opcao valida por favor");
            }
        }

    }

    //FUNCOES
    public static Livro cadastrarLivro() {

        System.out.print("Digite o título do livro a ser cadastrado: ");
        scanner.nextLine();
        String titulo = scanner.nextLine();

        System.out.println("Digite o autor: ");
        String autor = scanner.nextLine();

        System.out.println("Digite o Isbn: ");
        int isbn = scanner.nextInt();

        System.out.println("Digite o genero: ");
        String genero = scanner.next().toLowerCase();

        System.out.println("Digite o preço do livro: ");
        float preco = scanner.nextFloat();

        Livro livroCadastrado = new Livro();

        livroCadastrado.setTitulo(titulo);
        livroCadastrado.setAutor(autor);
        livroCadastrado.setIsbn(isbn);
        livroCadastrado.setGenero(genero);
        livroCadastrado.setPreco(preco);
        return livroCadastrado;

    }

    //vai ler o autor da entrada, percorrer a lista e achar todos os cadastros com o mesmo autor.
    public static Livro buscarPorAutor() {
        System.out.println("Digite o autor desejado para encontrar seus livros: ");
        String autorDigitado = scanner.next();

        for (Livro todasOsLivrosCadastrados : Acervo.buscarLivros()) {
            if (autorDigitado.equalsIgnoreCase(todasOsLivrosCadastrados.getAutor())) {
                return todasOsLivrosCadastrados;
            }
        }
        return null;
    }
}
