public class OperacaoSaque extends Operacao {

    public OperacaoSaque(double valor) {
        super('s', valor);
    }

    @Override
    public String toString(){
        String str = getData() + "\t" + getTipo() + "\t" + getValor() + "\n";
        return str;
    }
}
