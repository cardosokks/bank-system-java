package br.com.banco.service;

import br.com.banco.dto.AccountDTO;

public class AccountService {

    private final LogServico logger = new LogServico();

    public void sacar(AccountDTO accountDTO, Double value) {
        try {
            if (value <= 0) {
                logger.out("ERRO - Valor inválido para saque: " + value);
            } else {
                double balance = accountDTO.getBalance();

                if (balance < value) {
                    logger.out("ERRO - Não é possível sacar R$ " + value + ".Disponível na conta: R$" + balance);
                } else {
                    accountDTO.setBalance(balance - value);

                    logger.out("SAQUE - R$" + value + "- Total na conta:R$ " + accountDTO.getBalance());
                }
            }
        } catch (NumberFormatException e){
            logger.out("ERRO - Valor inválido para saque: " + value);
        }
    }

    public void deposit(AccountDTO accountDTO, Double value){
        try {
            if (value <= 0) {
                logger.out("Valor inválido, tente novamente");

            } else {
//                balance += value;
                accountDTO.setBalance(accountDTO.getBalance() + value);
                logger.out("DEPOSITO - R$" + value + "- Total na conta:R$ " + accountDTO.getBalance());
            }
        }catch (NumberFormatException e){
            logger.out("ERRO - Valor inválido para Deposito: " + value);
        }
    }
}
