public class ContaCorrente extends Conta{
    ContaCorrente(int numero, Cliente dono, double saldo, double limite){
        super(numero, dono, saldo, limite);
    }

    @Override
    public void setLimite(double l){
        if(l < -100)
            this.limite = -100;
        this.limite = l;
    }

    @Override
    public double calculaTaxas() {
        return getDono().calculaTaxas();
    }
}
