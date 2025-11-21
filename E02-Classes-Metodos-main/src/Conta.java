public class Conta {
    Cliente dono = new Cliente();
    int numeroConta;
    double saldo;
    double limite;

    void imprimir(){
        System.out.println("Nome do dono da conta: " + this.dono.nome);
        System.out.println("Número da conta: " + this.numeroConta);
        System.out.println("Saldo atual: " + this.saldo);
        System.out.println("Limite: " + this.limite);
    }
}
