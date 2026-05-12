import java.util.Scanner;
import contacorrente.contacorrente;
import contaempresarial.contaempresarial;
import contapoupanca.contapoupanca;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.println("BEM VINDO AO SISTEMA DE PAGAMENTOS OKANE");

        System.out.print("Digite o saldo inicial da Conta Corrente: ");
        double saldoCC = leitor.nextDouble();
        contacorrente cc = new contacorrente("Leandro Oliveira", saldoCC, 2000.0);

        System.out.print("Digite o saldo inicial da Conta Poupança: ");
        double saldoCP = leitor.nextDouble();
        contapoupanca cp = new contapoupanca("Maria da Silva", saldoCP, 0.5);

        System.out.print("Digite o saldo inicial da Conta Empresarial: ");
        double saldoCE = leitor.nextDouble();
        contaempresarial ce = new contaempresarial("Bali Store", saldoCE, "13.458.678/0001-95", 15000.0, "Bali Store LTDA");

        System.out.println("\nSISTEMA PRONTO PARA OPERAÇÕES");

        System.out.println("Em qual conta deseja realizar um pagamento?");
        System.out.println("1 - Conta Corrente");
        System.out.println("2 - Conta Empresarial");
        System.out.print("Opção: ");
        int escolha = leitor.nextInt();

        System.out.print("\nDigite a modalidade (Pix/Cartão/Boleto): ");
        String modalidade = leitor.next();
        System.out.print("Digite o valor do pagamento: ");
        double valorPgto = leitor.nextDouble();

        if (modalidade.equalsIgnoreCase("Cartão")) {
            System.out.print("Como deseja pagar? digite (1) para pagar À vista ou (2) para pagar a prazo? ");
            int opcaoCartao = leitor.nextInt();
            if (opcaoCartao == 2) {
                System.out.print("Deseja dividir em quantas parcelas? ");
                int parcelas = leitor.nextInt();
                double taxa = (escolha == 1) ? 1.05 : 1.10;
                System.out.println("Parcelamento: " + parcelas + "x de R$ " + String.format("%.2f", (valorPgto * taxa) / parcelas));
            }
        }

        if (escolha == 1) {
            cc.processarpagamento(valorPgto, modalidade);
        } else {
            ce.processarpagamento(valorPgto, modalidade);
        }

        System.out.println("\nAplicando rendimento mensal na Poupança");
        cp.aplicarRendimento();

        System.out.println("\n" + "=".repeat(45));
        System.out.println("      RESUMO ATUALIZADO DAS CONTAS");
        System.out.println("=".repeat(45));
        System.out.println(cc);
        System.out.println(cp);
        System.out.println(ce);
        System.out.println("=".repeat(45));

        leitor.close();
    }
}