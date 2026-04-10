import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Funcionario f = new Funcionario();
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Digite sua matricula: ");
        f.setMatricula(sc.nextInt());
        System.out.println("Digite O seu nome:");
        f.setNome(sc2.nextLine());
        System.out.println("Digite seu salário bruto:");
        f.setSalario_Bruto(sc.nextDouble());

        System.out.println("Aqui está seu contracheque:");
        System.out.println("Nome:"+f.getNome()+"e Matrícula:"+f.getMatricula());
        System.out.println("Salário bruto: R$"+f.getSalario_Bruto());
        System.out.println(f.exibirContracheque());

    }
}
