import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Cliente joao = new PessoaFisica("João", "Av. Antonio Carlos, 6627",
                                        new Date(), "111.111.111-11", 36, 'm');
        Cliente lojinha = new PessoaJuridica("Loja R$1,99", "Av. Afonso Pena, 3000",
                                        new Date(), "000.00000.0000/0001", 25, "Comércio");


        Conta cc = new ContaCorrente(1, 1234, joao, 0, 1500);
        Conta cp = new ContaPoupanca(1,12121, lojinha, 10000, 1500);

        try {
            cc.depositar(1000);
            cc.depositar(2000);
            sleep(100); // Para diferenciar o tempo das transações na impressão
            cc.sacar(500);
            cc.depositar(3000);
            sleep(100); // Para diferenciar o tempo das transações na impressão
            cc.sacar(20);
            cc.sacar(15);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            cc.setLimite(100);
        } catch (IlegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        //Serializa cc
        try {
            cc.serializar();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //Carrega cc em uma nova conta
        try {
            Conta nova;
            nova = cc.deserializar(cc.getNumAgencia(), cc.getNumero());
            nova.imprimirExtrato(1);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }


    }
}