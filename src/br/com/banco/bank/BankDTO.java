package br.com.banco.bank;

import br.com.banco.account.AccountDTO;

import java.util.ArrayList;
import java.util.List;

public class BankDTO {
    private String ag;
    private List<AccountDTO> accountDTOS;
    private int lastAccount = 1;

    public BankDTO(String ag){
        this.ag = ag;
        this.accountDTOS = new ArrayList<>();
    }

    public String getAg() {
        return ag;
    }

    public void setAg(String ag) {
        this.ag = ag;
    }

    public List<AccountDTO> getAccounts() {
        return accountDTOS;
    }

    public void setAccounts(List<AccountDTO> accountDTOS) {
        this.accountDTOS = accountDTOS;
    }

    public int getLastAccount() {
        return lastAccount;
    }

    public void setLastAccount(int lastAccount) {
        this.lastAccount = lastAccount;
    }
}
