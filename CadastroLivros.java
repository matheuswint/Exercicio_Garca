import java.util.ArrayList;
import java.util.Scanner;

class Livro {
    String titulo;
    String autor;
    int anoPublicacao;
    double preco;

    Livro(String titulo, String autor, int anoPublicacao, double preco) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.preco = preco;
    }

    void exibirDados() {
        System.out.println(
            titulo + " - " +
            autor + " - " +
            anoPublicacao + " - R$ " +
            preco
        );
    }

    boolean ehAntigo() {
        return 2026 - anoPublicacao > 20;
    }

    void aplicarDesconto(double percentual) {
        preco -= preco * percentual / 100;
    }
}

public class CadastroLivros {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        ArrayList<Livro> livros = new ArrayList<>();

        for (int i = 0; i < 5; i++) {

            System.out.println("Livro " + (i + 1));

            System.out.print("Título: ");
            String titulo = teclado.nextLine();

            System.out.print("Autor: ");
            String autor = teclado.nextLine();

            System.out.print("Ano de publicação: ");
            int ano = teclado.nextInt();

            System.out.print("Preço: ");
            double preco = teclado.nextDouble();

            teclado.nextLine();

            livros.add(new Livro(titulo, autor, ano, preco));

            System.out.println();
        }

        System.out.println("\nTODOS OS LIVROS:");

        for (Livro l : livros) {
            l.exibirDados();
        }

        System.out.println("\nLIVROS ANTIGOS:");

        for (Livro l : livros) {

            if (l.ehAntigo()) {
                l.exibirDados();

                l.aplicarDesconto(10);
            }
        }

        System.out.println("\nDEPOIS DO DESCONTO:");

        for (Livro l : livros) {
            l.exibirDados();
        }

        System.out.print("\nDigite o nome de um autor: ");
        String autorBusca = teclado.nextLine();

        System.out.println("\nLivros encontrados:");

        for (Livro l : livros) {

            if (l.autor.equalsIgnoreCase(autorBusca)) {
                l.exibirDados();
            }
        }

        teclado.close();
    }
}