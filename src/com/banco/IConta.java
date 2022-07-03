package com.banco;

public interface IConta {
    void sacar(double valor);
    void transferir(Conta contaDestino, double valor);
    void depositar(double valor);
    void imprimirExtrato();

    void retirarChequeEspecial(double valor);
}
