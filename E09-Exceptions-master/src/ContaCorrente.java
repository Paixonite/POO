public class ContaCorrente extends Conta {

    public ContaCorrente(int numero, Cliente dono, double saldo, double limite) {
        super(numero, dono, saldo, limite);
    }


    @Override
    public double calcularTaxas() {
        return this.getDono().calcularTaxas();
    }

    @Override
    public void setLimite(double limite) throws IlegalArgumentException{
        if (limite >= -100)
            super.limite = limite;
        else
            throw new IlegalArgumentException("Limite impossível pra conta");
    }
}
