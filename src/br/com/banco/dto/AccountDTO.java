package br.com.banco.dto;

public class AccountDTO {

    private static final int MAX_LENGTH = 12; // propriedade constante, onde o valor não muda. "FINAL"

    private String ag;
    private String cc;
    private String name;
    private Double balance = 0.0;

    public AccountDTO(String agencia, String conta, String nome){
        this.ag = agencia;
        this.cc = conta;
        setName(nome);
    }

    public String getAg() {
        return ag;
    }

    public void setAg(String ag) {
        this.ag = ag;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getName() {
        return name;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void setName(String name) {
        if(name.length() > MAX_LENGTH){
            this.name = name.substring(0, MAX_LENGTH);
        } else {
            this.name = name;
        }
    }

    public double getBalance(){
        return balance;
    }

    @Override
    public String toString() {
        return ag + "/" + cc + " - " + name + " - " +"CARTEIRA: R$ " + balance;
    }
}
