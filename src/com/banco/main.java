package com.banco;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        Cliente odeir = new Cliente("Odeir", 450);
        Cliente eddie = new Cliente("Eddie", 850);
        Conta cc = new ContaCorrente(odeir);
        Conta cp = new ContaPoupanca(eddie);
        Conta ccEddie = new ContaCorrente(eddie);
        Banco banco = new Banco("New and improved Panamericano");
        List<Conta> contas = new ArrayList<>();
        contas.add(cc);
        contas.add(cp);
        contas.add(ccEddie);


        cc.depositar(350d);
        cp.depositar(1500d);
        cc.imprimirExtrato();
        cp.imprimirExtrato();
        cp.transferir(cc, 1000d);
        cc.imprimirExtrato();
        cp.imprimirExtrato();

        banco.setContas(contas);
        System.out.println(banco);

        System.out.println(" ------------ ");
        banco.listarClientes();

        System.out.println(" --- Criando Empréstimo (Falha) ---");
        Emprestimo emprestimoOdeir = new Emprestimo(10, cc, 1500);

        System.out.println(" --- Criando Empréstimo (Sucesso) ---");
        Emprestimo emprestimoEddie = new Emprestimo(2, ccEddie, 2000);

        emprestimoEddie.cobrarEmprestimo();
        ccEddie.imprimirExtrato();

        emprestimoEddie.cobrarEmprestimo();
        ccEddie.imprimirExtrato();

        emprestimoEddie.cobrarEmprestimo();
        ccEddie.imprimirExtrato();

    }
}
