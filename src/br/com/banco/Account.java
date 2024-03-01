package br.com.banco;

public class Account {

    private static final int MAX_LENGTH = 12; // propriedade constante, onde o valor não muda. "FINAL"

    private String ag;
    private String cc;
    private String name;
    private Double balance = 0.0;

    private Log logger = new Log();



    public Account(String agencia, String conta, String nome){
        this.ag = agencia;
        this.cc = conta;
        setName(nome);
    }

    public void setName(String name) {
        if(name.length() > MAX_LENGTH){
            this.name = name.substring(0, MAX_LENGTH);
        } else {
            this.name = name;
        }
    }

    public void sacar(Double value){
        if(balance < value){
            logger.out("ERRO - Não é possível sacar R$ " + value + ".Disponível na conta: R$" + balance );
        }else{
            balance -= value;
            logger.out("SAQUE - R$" + value + "- Total na conta:R$ " + balance);
        }
    }

    public void deposit(Double value){
        if(value <= 0){
            logger.out("Valor inválido, tente novamente");
        } else{
            balance += value;
            logger.out("DEPOSITO - R$" + value + "- Total na conta:R$ " + balance);
        }

    }

    public double getBalance(){
        return balance;
    }

    @Override
    public String toString() {
        return "A conta " + name + " " + ag +"/" + cc + " possui R$ " + balance;
    }
}
