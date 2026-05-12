package contapoupanca;

import modelos.conta;
import statusconta.statusconta;

public class contapoupanca extends conta {
    private double taxaRendimento;

    public contapoupanca(String titular, double saldo, double taxaRendimento) {
        super(titular, saldo);
        this.taxaRendimento = taxaRendimento;
    }

    public void aplicarRendimento() {
        // Verifica se a conta está ativa antes de render
        if (this.status == statusconta.ATIVA) {
            this.saldo += this.saldo * (taxaRendimento / 100);
            System.out.println("Rendimento aplicado! Novo saldo: R$ " + this.saldo);
        } else {
            System.out.println("Operação negada: Conta não está ativa.");
        }
    }

    @Override
    public void exibirtipodeconta() {
        System.out.println("Tipo de Conta: Poupança | Rendimento: " + taxaRendimento + "%");
    }
}