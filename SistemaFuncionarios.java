import java.util.ArrayList;
import java.util.Scanner;

class Funcionario {
    String nome;
    String cargo;
    double salario;
    int anosEmpresa;

    Funcionario(String nome, String cargo, double salario, int anosEmpresa) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.anosEmpresa = anosEmpresa;
    }

    void aumentarSalario(double percentual) {
        salario += salario * percentual / 100;
    }

    double calcularBonus() {

        if (anosEmpresa < 2) {
            return salario * 0.05;
        } else if (anosEmpresa <= 5) {
            return salario * 0.10;
        } else {
            return salario * 0.15;
        }
    }

    void exibirDados() {
        System.out.println(
            nome + " - " +
            cargo + " - Salário: R$ " +
            salario + " - Bônus: R$ " +
            calcularBonus()
        );
    }
}

public class SistemaFuncionarios {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        for (int i = 0; i < 5; i++) {

            System.out.println("Funcionário " + (i + 1));

            System.out.print("Nome: ");
            String nome = teclado.nextLine();

            System.out.print("Cargo: ");
            String cargo = teclado.nextLine();

            System.out.print("Salário: ");
            double salario = teclado.nextDouble();

            System.out.print("Anos na empresa: ");
            int anos = teclado.nextInt();

            teclado.nextLine();

            funcionarios.add(
                new Funcionario(nome, cargo, salario, anos)
            );

            System.out.println();
        }

        System.out.println("\nFUNCIONÁRIOS:");

        for (Funcionario f : funcionarios) {
            f.exibirDados();
        }

        for (Funcionario f : funcionarios) {
            f.aumentarSalario(10);
        }

        Funcionario maior = funcionarios.get(0);

        System.out.println("\nDEPOIS DO AUMENTO:");

        for (Funcionario f : funcionarios) {

            f.exibirDados();

            if (f.salario > maior.salario) {
                maior = f;
            }
        }

        System.out.println(
            "\nFuncionário com maior salário: " +
            maior.nome
        );

        teclado.close();
    }
}