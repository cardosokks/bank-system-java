package br.com.banco;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String ag;
    private List<Account> accounts;
    private int lastAccount = 1;

    public Bank(String ag){
        this.ag = ag;
        this.accounts = new ArrayList<>();
    }

    public void insertAccount(Account account){
        accounts.add(account);
    }

    public List<Account> getAccounts(){
        return accounts;
    }

    public Account generateAccount(String name){
        Account account = new Account(ag, "" + lastAccount, name);
        lastAccount ++;
        return account;
    }

    public double outputTotal(){
        double total = 0;
        for(Account account: accounts){
            double balance = account.getBalance();
            total += balance;
        }
        return total;
    }

    public String outputContagemContas(){
        int contas = 0;
        for(Account account: accounts){
            contas ++;
        }
        if(contas == 0){
            String msg = "Nenhuma conta criada";
            return msg;
        }else {
            return Integer.toString(contas);
        }
    }
}
