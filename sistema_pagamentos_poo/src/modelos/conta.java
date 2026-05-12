package modelos;

import statusconta.statusconta;

public abstract class conta {
    protected String titular;
    protected double saldo;
    protected statusconta status;

    public conta(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
        this.status = statusconta.ATIVA;
    }

    public void depositar(double valor) {
        if (valor > 0) this.saldo += valor;
    }

    public void sacar(double valor) {
        if (this.status == statusconta.ATIVA && this.saldo >= valor) {
            this.saldo -= valor;
        } else {
            System.out.println("Saque negado: Saldo insuficiente ou conta inativa.");
        }
    }

    public void transferir(conta destino, double valor) {
        if (this.status == statusconta.ATIVA && this.saldo >= valor) {
            this.sacar(valor);
            destino.depositar(valor);
            System.out.println("Transferência realizada com sucesso!");
        }
    }

    public abstract void exibirtipodeconta();

    @Override
    public String toString() {
        return "Saldo de " + this.titular + ": R$ " + String.format("%.2f", this.saldo) + " | Status: " + this.status;
    }
}