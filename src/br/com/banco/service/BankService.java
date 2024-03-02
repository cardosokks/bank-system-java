package br.com.banco.service;

import br.com.banco.dto.AccountDTO;
import br.com.banco.dto.BankDTO;

import java.util.List;

public class BankService {

    public void insertAccount(AccountDTO accountDTO, BankDTO bankDTO) {
        bankDTO.getAccounts().add(accountDTO);
    }

    public List<AccountDTO> getAccounts(BankDTO bankDTO) {
        return bankDTO.getAccounts();
    }

    public AccountDTO generateAccount(BankDTO bankDTO, String name) {
        AccountDTO accountDTO = new AccountDTO(bankDTO.getAg(), "" + bankDTO.getLastAccount(), name);
        bankDTO.setLastAccount(bankDTO.getLastAccount() + 1);
        return accountDTO;
    }

    public double outputTotal(BankDTO bankDTO) {
        double total = 0;
        for (AccountDTO accountDTO : bankDTO.getAccounts()) {
            double balance = accountDTO.getBalance();
            total += balance;
        }
        return total;
    }

    public int outputContagemContas(BankDTO bankDTO) {
        return bankDTO.getAccounts().size();
    }

    public AccountDTO findByName(BankDTO santander, String nameAccount) {
        for(AccountDTO account: santander.getAccounts()){
            if(account.getName().equalsIgnoreCase(nameAccount)){
                return account;
            }
        }
        return null;
    }
}
