package br.com.banco.service;

import br.com.banco.dto.AccountDTO;

public class AccountService {

    private final LogServico logger = new LogServico();

    public void sacar(AccountDTO accountDTO, Double value) {
        try {
            if (value <= 0) {
                logger.out("ERRO - Valor inválido para saque: " + String.format("%.2f", value));
            } else {
                double balance = accountDTO.getBalance();

                if (balance < value) {
                    logger.out("ERRO - Não é possível sacar R$ " + String.format("%.2f", value) + ".Disponível na conta: R$" + String.format("%.2f", balance));
                } else {
                    accountDTO.setBalance(balance - value);

                    logger.out("SAQUE - R$" + value + "- Total na conta:R$ " + String.format("%.2f", accountDTO.getBalance()));
                }
            }
        } catch (NumberFormatException e) {
            logger.out("ERRO - Valor inválido para saque: " + value);
        }
    }

    public void deposit(AccountDTO accountDTO, Double value) {
        try {
            if (value <= 0 || value > Double.MAX_VALUE) {
                logger.out("Valor inválido, tente novamente");

            } else {
                if (accountDTO.getBalance() + value > Double.MAX_VALUE) {
                    System.out.println("Nao recebemos mais dinheiro aqui nessa peste. NAO CABE MANO");
                } else {
                    accountDTO.setBalance(accountDTO.getBalance() + value);
                    logger.out("DEPOSITO - R$" + String.format("%.2f", value) + "- Total na conta:R$ " + String.format("%.2f", accountDTO.getBalance()));
                }
            }
        } catch (NumberFormatException e) {
            logger.out("ERRO - Valor inválido para Deposito: " + value);
        }
    }
}
