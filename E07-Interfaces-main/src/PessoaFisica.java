import java.util.Date;
import java.util.Objects;

public class PessoaFisica extends Cliente {

    private String cpf;

    private int idade;

    private char genero;

    public PessoaFisica(String nome, String endereco, Date data, String cpf, int idade, char genero) {
        super(nome, endereco, data);
        this.cpf = cpf;
        this.idade = idade;
        this.genero = genero;
    }

    @Override
    public boolean autenticar(String s){
        if (s == this.cpf)
            return true;
        return false;
    }

    @Override
    public String toString() {
        String PFstr =
                "---- PF ----" +  "\n" +
                        "nome = " + this.getNome() + "\n" +
                        "data = " + this.getData() + "\n" +
                        "endereco = " + this.getEndereco() + "\n" +
                        "cpf = " + cpf + "\n" +
                        "idade = " + idade + "\n" +
                        "genero = " + genero + "\n" +
                        "------------";
        return PFstr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(o instanceof PessoaFisica) {
            PessoaFisica pessoa = (PessoaFisica) o;
            return Objects.equals(cpf, pessoa.cpf);
        }
        return false;
    }

    @Override
    public double calculaTaxas() {
        return 10;
    }
}
