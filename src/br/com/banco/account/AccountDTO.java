package br.com.banco.account;

public class AccountDTO {

    private static final int MAX_LENGTH = 30;

    private String ag;
    private String cc;
    private String name;
    private String cpf;
    private Double balance = 0.0;

    public AccountDTO(String agencia, String conta, String name, String cpf) {
        this.ag = agencia;
        this.cc = conta;
        this.cpf = cpf;
        setName(name);
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
        if (name.length() > MAX_LENGTH) {
            this.name = name.substring(0, MAX_LENGTH);
        } else {
            this.name = name;
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return ag + "/" + cc + " - " + name + " - " + "CARTEIRA: R$ " + String.format("%.2f", balance);
    }
}
