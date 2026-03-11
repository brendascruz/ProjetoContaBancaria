import java.math.BigDecimal;

public class ContaBancaria {

    private String titular;
    private BigDecimal saldo;
    private int numeroConta;

    public ContaBancaria(String titular, BigDecimal saldo, int numeroConta) {
        this.titular = titular;
        this.saldo = saldo;
        this.numeroConta = numeroConta;
    }

    public boolean depositar(BigDecimal valor){
        if(valor.compareTo(BigDecimal.ZERO) <= 0){
            return false;
        }

        saldo = saldo.add(valor);
        return true;
    }

    public boolean sacar(BigDecimal valor){
        if(valor.compareTo(BigDecimal.ZERO) <= 0){
            return false;
        }

        if(saldo.compareTo(valor) < 0){
            return false;
        }

        saldo = saldo.subtract(valor);
        return true;
    }

    public boolean transferir(ContaBancaria destinatario, BigDecimal valor){
        if(destinatario == null || destinatario == this){
            return false;
        }

        if(this.sacar(valor)){
            destinatario.depositar(valor);
            return true;
        }

        return false;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    @Override
    public String toString() {
        return "Titular: " + titular +
                "\nConta: " + numeroConta +
                "\nSaldo: " + saldo +
                "\n";
    }
}
