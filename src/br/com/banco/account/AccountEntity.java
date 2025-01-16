package br.com.banco.account;


public class AccountEntity {

    private static final int MAX_LENGTH = 12; // propriedade constante, onde o valor não muda. "FINAL"

    private String ag;
    private String cc;
    private String name;
    private String cpf;
    private Double balance = 0.0;

    public AccountEntity(){}

    public AccountEntity(String agency, String account, String name, String cpf) {
        this.ag = agency;
        this.cc = account;
        this.name = name;
        this.cpf = cpf;
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

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
