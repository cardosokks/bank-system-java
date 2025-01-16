package br.com.banco.account;

import br.com.banco.tools.LogService;

public class AccountService {

    private final LogService logger = new LogService();

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
                logger.out("Valor inválido, tente novamente.");

            } else {
                if (accountDTO.getBalance() + value > Double.MAX_VALUE) {
                    logger.out("Nao recebemos mais dinheiro aqui nessa peste. NAO CABE MANO");
                } else {
                    accountDTO.setBalance(accountDTO.getBalance() + value);
                    logger.out("DEPOSITO - R$" + String.format("%.2f", value) + "- Total na conta:R$ " + String.format("%.2f", accountDTO.getBalance()));
                }
            }
        } catch (NumberFormatException e) {
            logger.out("ERRO - Valor inválido para Deposito: " + value);
        }
    }

    public void pix(AccountDTO contaBase, AccountDTO contaDestino, Double value){
        try{
            if(value <= 0 || value > Double.MAX_VALUE){
                logger.out("Valor Inválido, tente novamente.");
            } else{
                if(contaBase.getBalance() < value){
                    logger.out("Saldo Insuficiente. Saldo atual: " + contaBase.getBalance());
                } else if(contaBase.getCpf().equals(contaDestino.getCpf())){
                    logger.out("Não é possível fazer essa operação. Conta de destino é igual a conta do Remetente.");
                } else{
                contaBase.setBalance(contaBase.getBalance() - value);
                contaDestino.setBalance(contaDestino.getBalance() + value);
                logger.out("[PIX]" + String.format("%.2f", value) + "- De:" + contaBase.getName() + " - Para: " + contaDestino.getName());
                }
            }
        } catch (NumberFormatException e){
            logger.out("ERRO - Valor Inválido para PIX: " + value);
        }
    }
}
