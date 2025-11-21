import java.util.ArrayList;
import java.util.Collections;

public abstract class Conta implements ITaxas {

    private int numero;

    private Cliente dono;

    private double saldo;

    protected double limite;

    private static int totalContas = 0;

    private ArrayList<Operacao> operacoes;

    public Conta(int numero, Cliente dono, double saldo, double limite) {
        this.numero = numero;
        this.dono = dono;
        this.saldo = saldo;
        this.limite = limite;

        this.operacoes = new ArrayList<>();

        Conta.totalContas++;
    }

    public boolean sacar(double valor) {
        if (valor >= 0 && valor <= this.limite) {
            this.saldo -= valor;

            this.operacoes.add(new OperacaoSaque(valor));
            return true;
        }

        return false;
    }

    public void depositar(double valor) {
        this.saldo += valor;

        this.operacoes.add(new OperacaoDeposito(valor));
    }

    public boolean transferir(Conta destino, double valor) {
        boolean valorSacado = this.sacar(valor);
        if (valorSacado) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return dono.toString() + '\n' +
                "---\n" +
                "numero=" + numero + '\n' +
                "saldo=" + saldo + '\n' +
                "limite=" + limite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o instanceof Conta) {
            Conta conta = (Conta) o;
            return numero == conta.numero;
        }
        return false;
    }

    public void imprimirExtrato(int sortType) {
        System.out.println("======= Extrato Conta " + this.numero + "======");
        if(sortType == 1) {
            for (Operacao atual : this.operacoes) {
                System.out.println(atual);
            }
        } else if (sortType == 2) {
            ArrayList<Operacao> operacoesOrdenadas = new ArrayList<>(operacoes);

            Collections.sort(operacoesOrdenadas);
            for (Operacao atual : operacoesOrdenadas) {
                System.out.println(atual);
            }
        }
        System.out.println("===============================");
    }

    public void imprimirExtratoTaxas() {
        System.out.println("=== Extrato de Taxas ===");
        System.out.printf("Manutenção:\t%.2f\n", this.calcularTaxas());

        double totalTaxas = this.calcularTaxas();

        for(Operacao atual : this.operacoes) {
            totalTaxas += atual.calcularTaxas();
            System.out.printf("%c:\t%.2f\n", atual.getTipo(), atual.calcularTaxas());
        }

        System.out.printf("Total:\t%.2f\n", totalTaxas);
    }

    public int getNumero() {
        return numero;
    }

    public Cliente getDono() {
        return dono;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimite() {
        return limite;
    }

    public static int getTotalContas() {
        return Conta.totalContas;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setDono(Cliente dono) {
        this.dono = dono;
    }

    public abstract void setLimite(double limite);
}
