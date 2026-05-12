package contacorrente;

import modelos.conta;
import interfacePagamentos.pagamento;

public class contacorrente extends conta implements pagamento {
    private double limiteChequeEspecial;

    public contacorrente(String titular, double saldo, double limite) {
        super(titular, saldo);
        this.limiteChequeEspecial = limite;
    }

    @Override
    public void processarpagamento(double valor, String modalidade) {
        // Regras de Limite
        if (modalidade.equalsIgnoreCase("Pix") && valor > 5000) {
            System.out.println("Erro: Limite Pix excedido."); return;
        }
        if (modalidade.equalsIgnoreCase("Cartão") && valor > 20000) {
            System.out.println("Erro: Limite Cartão excedido."); return;
        }
        if (modalidade.equalsIgnoreCase("Boleto") && valor <= 0) {
            System.out.println("Erro: Valor do boleto inválido."); return;
        }

        double valorComJuros = valor * 1.05; // Juros 5%
        this.sacar(valorComJuros);
        System.out.println("Pagamento via " + modalidade + " realizado.");
    }

    @Override
    public void exibirtipodeconta() {
        System.out.println("Conta Corrente | Limite: " + limiteChequeEspecial);
    }
}