package contaempresarial;

import modelos.conta;
import interfacePagamentos.pagamento;

public class contaempresarial extends conta implements pagamento {
    private String cnpj;
    private double limiteCredito;
    private String nomeEmpresa;

    public contaempresarial(String titular, double saldo, String cnpj, double limite, String nome) {
        super(titular, saldo);
        this.cnpj = cnpj;
        this.limiteCredito = limite;
        this.nomeEmpresa = nome;
    }

    @Override
    public void processarpagamento(double valor, String modalidade) {
        if (modalidade.equalsIgnoreCase("Boleto") && valor <= 0) {
            System.out.println("Erro: Valor do boleto inválido."); return;
        }

        double valorComJuros = valor * 1.10; // Juros 10%
        this.sacar(valorComJuros);
        System.out.println("Pagamento Empresarial processado.");
    }

    @Override
    public void exibirtipodeconta() {
        System.out.println("Conta Empresarial: " + nomeEmpresa + " | CNPJ: " + cnpj);
    }
}