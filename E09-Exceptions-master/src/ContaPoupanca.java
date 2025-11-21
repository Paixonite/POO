public class ContaPoupanca extends Conta {
    public ContaPoupanca(int numero, Cliente dono, double saldo, double limite) {
        super(numero, dono, saldo, limite);
    }

    @Override
    public double calcularTaxas() {
        return 0f;
    }

    @Override
    public void setLimite(double limite) throws IlegalArgumentException{
        if (limite <= 1000 && limite >= 100)
            super.limite = limite;
        else
            throw new IlegalArgumentException("Limite impossível pra conta");
    }
}
