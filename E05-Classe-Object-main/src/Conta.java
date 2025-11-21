public class Conta {

    private int numero;

    private Cliente dono;

    private double saldo;

    private double limite;

    private Operacao[] operacoes;

    private int proximaOperacao;

    private static int totalContas = 0;

    public Conta(int numero, Cliente dono, double saldo, double limite) {
        this.numero = numero;
        this.dono = dono;
        this.saldo = saldo;
        this.limite = limite;

        this.operacoes = new Operacao[1000];
        this.proximaOperacao = 0;

        Conta.totalContas++;
    }



    public boolean sacar(double valor) {
        if (valor >= 0 && valor <= this.limite) {
            this.saldo -= valor;

            this.operacoes[proximaOperacao] = new OperacaoSaque(valor);
            this.proximaOperacao++;
            return true;
        }

        return false;
    }

    public void depositar(double valor) {
        this.saldo += valor;

        this.operacoes[proximaOperacao] = new OperacaoDeposito(valor);
        this.proximaOperacao++;
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
        String contaStr =
        "===== Conta " + this.numero + " =====" + "\n" +
        this.dono.toString() + "\n" +
        "Saldo: " + this.saldo + "\n" +
        "Limite: " + this.limite + "\n" +
        "====================" + "\n" ;
        return contaStr;
    }

    public boolean equals(Conta c){
        return this.numero == c.numero;
    }

    public void imprimirExtrato() {
        System.out.println("======= Extrato Conta " + this.numero + "======");
        for(Operacao atual : this.operacoes) {
            if (atual != null) {
                atual.imprimir();
            }
        }
        System.out.println("====================");
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

    public void setLimite(double limite) {
        if (limite < 0)
            limite = 0;

        this.limite = limite;
    }
}
