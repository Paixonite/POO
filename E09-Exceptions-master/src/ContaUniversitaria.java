public class ContaUniversitaria extends Conta {
    public ContaUniversitaria(int numero, Cliente dono, double saldo, double limite) {
        super(numero, dono, saldo, limite);
    }

    @Override
    public double calcularTaxas() {
        return 0f;
    }

    @Override
    public void setLimite(double limite) throws IlegalArgumentException{
        if (limite <= 500 && limite >= 0)
            super.limite = limite;
        else
            throw new IlegalArgumentException("Limite impossível pra conta");
    }
}
