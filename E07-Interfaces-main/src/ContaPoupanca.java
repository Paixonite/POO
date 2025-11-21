public class ContaPoupanca extends Conta {
    ContaPoupanca(int numero, Cliente dono, double saldo, double limite){
        super(numero, dono, saldo, limite);
    }

    @Override
    public void setLimite(double l){
        if(l < 100)
            this.limite = 100;
        if(l > 1000)
            this.limite = 1000;
        this.limite = l;
    }

    @Override
    public double calculaTaxas() {
        return 0;
    }
}
