package com.banco;

public class Emprestimo {
    private static double TAXA = 0.08;
    private int qtdParcelas;
    private Conta conta;
    private double valorEmprestimo;
    private double mensalidade;


    public Emprestimo(int qtdParcelas, Conta conta, double valorEmprestimo) {
        this.qtdParcelas = qtdParcelas;
        this.conta = conta;
        this.valorEmprestimo = valorEmprestimo;
        this.analisarEmprestimo(this.valorEmprestimo);
    }

    public int getQtdParcelas() {
        return qtdParcelas;
    }

    public void analisarEmprestimo(double valor) {
        if(this.conta.getCliente().getScore() > 0 && this.conta.getCliente().getScore() < 500) {
            System.out.println("Empréstimo Negado");
        } else if (this.conta.getCliente().getScore() > 500) {
            System.out.println("Empréstimo Aprovado");
            this.conta.depositar(valor);
            this.valorEmprestimo += valor + (valor * this.TAXA);
            this.mensalidade += valor / this.qtdParcelas;
        }
    }



    public void cobrarEmprestimo() {
        if(this.valorEmprestimo > 0) {
            if(this.conta.getSaldo() < this.mensalidade) {
                this.conta.retirarChequeEspecial(this.mensalidade);
            } else {
                this.conta.sacar(this.mensalidade);
            }
        }
    }
}
