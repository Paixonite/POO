public class ContaUniversitaria extends Conta {
    ContaUniversitaria(int numero, Cliente dono, double saldo, double limite){
        super(numero, dono, saldo, limite);
    }

    @Override
    public void setLimite(double l){
        if(l < 0)
            this.limite = 0;
        if(l > 500)
            this.limite = 500;
        this.limite = l;
    }

    @Override
    public double calculaTaxas() {
        return 0;
    }
}
