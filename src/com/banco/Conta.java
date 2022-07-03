package com.banco;

public abstract class Conta implements IConta {
    private static int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    protected int agencia;
    protected int numero;
    protected double saldo;
    private Cliente cliente;

    private double chequeEspecial = 1000;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "agencia=" + agencia +
                ", numero=" + numero +
                ", cliente=" + cliente +
                '}';
    }

    @Override
    public void sacar(double valor) {
        this.saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }
    @Override
    public void transferir(Conta contaDestino, double valor) {
        if(this.saldo < valor) {
            System.out.println("Saldo Insuficiênte");
        } else {
            this.saldo -= valor;
            contaDestino.saldo += valor;
        }
    }
    protected void imprimirInfosComuns() {
        System.out.println(this.cliente);
        System.out.println("Agência: " + this.agencia);
        System.out.println("Conta: " + this.numero);
        System.out.println("Saldo: " + this.saldo);
    }

    @Override
    public void retirarChequeEspecial(double valor) {
        if(this.chequeEspecial - valor > 0) {
            this.chequeEspecial -= valor;
        } else {
            System.out.println("CHEQUE ESPECIAL ESGOTADO");
        }
    }


}
