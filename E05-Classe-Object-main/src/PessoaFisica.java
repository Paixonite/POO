import java.util.Date;

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

    public boolean equals(PessoaFisica pf) {
        return this.cpf == pf.cpf;
    }
}
