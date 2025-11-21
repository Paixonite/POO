public abstract class Conta implements ITaxas{

    private int numero;

    protected Cliente dono;

    private double saldo;

    protected double limite;

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

    public void imprimirExtrato() {
        System.out.println("======= Extrato Conta " + this.numero + "======");
        for(Operacao atual : this.operacoes) {
            if (atual != null) {
                System.out.println(atual);
            }
        }
        System.out.println("====================" + '\n');
    }

    public void imprimirExtratoTaxas(){
        double t = 0;
        System.out.println("======= Extrato Taxas Conta " + this.numero + " ======");
        System.out.println("Manutenção da conta: " + calculaTaxas());
        t += calculaTaxas();
        for (int i = 0; i < operacoes.length; i++){
            if (operacoes[i] != null && operacoes[i].getTipo() == 's') {
                System.out.println("Saque: " + operacoes[i].calculaTaxas());
                t += operacoes[i].calculaTaxas();
            }
        }
        System.out.println("\nTotal: " + t);
        System.out.println("=============================================" + '\n');
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
