public class Main {
    public static void main(String[] args) {
        Conta conta1 = new Conta();

        conta1.dono.nome = "JOAO";
        conta1.numeroConta = 12345;
        conta1.saldo = 120.00;
        conta1.limite = 10000;

        conta1.imprimir();
    }
}
