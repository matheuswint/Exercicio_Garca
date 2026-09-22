import java.util.ArrayList;
import java.util.Scanner;

class ContaBancaria {
    int codigo;
    String cliente;
    double dinheiro;

    ContaBancaria(int codigo, String cliente, double dinheiro) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.dinheiro = dinheiro;
    }

    void colocar(double valor) {
        if (valor > 0) {
            dinheiro += valor;
        } else {
            System.out.println("Valor inválido.");
        }
    }

    void retirar(double valor) {
        if (valor > 0 && valor <= dinheiro) {
            dinheiro -= valor;
        } else {
            System.out.println("Não foi possível realizar o saque.");
        }
    }

    double verSaldo() {
        return dinheiro;
    }

    void mostrarConta() {
        System.out.println("Número: " + codigo);
        System.out.println("Titular: " + cliente);
        System.out.println("Saldo: R$ " + dinheiro);
        System.out.println();
    }
}

public class Banco {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        ArrayList<ContaBancaria> listaContas = new ArrayList<>();

        for (int i = 0; i < 5; i++) {

            System.out.println("Cadastro da conta " + (i + 1));

            System.out.print("Digite o número da conta: ");
            int codigo = entrada.nextInt();

            entrada.nextLine();

            System.out.print("Digite o nome do titular: ");
            String cliente = entrada.nextLine();

            System.out.print("Digite o saldo inicial: ");
            double dinheiro = entrada.nextDouble();

            entrada.nextLine();

            listaContas.add(new ContaBancaria(codigo, cliente, dinheiro));

            System.out.println();
        }

        System.out.print("Informe o número da conta que deseja acessar: ");
        int contaProcurada = entrada.nextInt();

        for (ContaBancaria conta : listaContas) {

            if (conta.codigo == contaProcurada) {

                System.out.println("1 - Colocar");
                System.out.println("2 - Retirar");

                System.out.print("Escolha uma opção: ");
                int escolha = entrada.nextInt();

                System.out.print("Digite o valor: ");
                double valor = entrada.nextDouble();

                if (escolha == 1) {
                    conta.colocar(valor);
                } else if (escolha == 2) {
                    conta.retirar(valor);
                }
            }
        }

        ContaBancaria contaMaiorSaldo = listaContas.get(0);

        System.out.println("\nContas cadastradas:");

        for (ContaBancaria conta : listaContas) {

            conta.mostrarConta();

            if (conta.verSaldo() > contaMaiorSaldo.verSaldo()) {
                contaMaiorSaldo = conta;
            }
        }

        System.out.println(
            "Conta com maior saldo: " +
            contaMaiorSaldo.codigo +
            " - " +
            contaMaiorSaldo.cliente
        );

        entrada.close();
    }
}