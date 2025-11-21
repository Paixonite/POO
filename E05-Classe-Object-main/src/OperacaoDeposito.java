public class OperacaoDeposito extends Operacao {

    public OperacaoDeposito(double valor) {
        super('d', valor);
    }

    @Override
    public String toString(){
        String str = getData() + "\t" + getTipo() + "\t" + getValor() + "\n";
        return str;
    }
}
