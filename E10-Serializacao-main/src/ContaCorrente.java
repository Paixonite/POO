import java.awt.*;
import java.io.Serializable;

public class ContaCorrente extends Conta {

    public ContaCorrente(int numAgencia, int numero, Cliente dono, double saldo, double limite) {
        super(numAgencia, numero, dono, saldo, limite);
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
