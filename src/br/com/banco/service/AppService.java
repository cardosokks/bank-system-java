package br.com.banco.service;

import br.com.banco.account.AccountDTO;
import br.com.banco.account.AccountService;
import br.com.banco.bank.BankDTO;
import br.com.banco.bank.BankService;

import java.util.List;
import java.util.Scanner;

public class AppService {

    BankService bankService = new BankService();
    AccountService accountService = new AccountService();

    public void inicializar() {
        BankDTO santander = new BankDTO("0001");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int contagemContas = bankService.outputContagemContas(santander);
            System.out.print("Contas Criadas: ");

            if (contagemContas == 0) {
                System.out.println("Nenhuma conta criada.");
            } else {
                System.out.println(contagemContas);
            }

            System.out.println("Dinheiro armazenado no banco: R$ " + String.format("%.2f", bankService.outputTotal(santander)));
            System.out.println("Oque deseja fazer?\nCRIAR CONTA = C\nLISTAR CONTAS = L\nENTRAR EM UMA CONTA = E \nSAIR = S");
            System.out.println("----------------------------");
            String op = scanner.nextLine();


            if (op.equalsIgnoreCase("C")) {
                System.out.println("Digite o seu nome.");
                System.out.println("----------------------------");
                String name = scanner.nextLine();
                AccountDTO accountDTO = bankService.generateAccount(santander, name);
                bankService.insertAccount(accountDTO, santander);
                OperateAccount(accountDTO);
            } else if (op.equalsIgnoreCase("L")) {
                List<AccountDTO> accountDTOList = santander.getAccounts();
                if (accountDTOList.isEmpty()) {
                    System.out.println("Ainda não foram criadas contas neste banco.");
                } else {
                    System.out.println("------------ CONTAS ------------");
                    System.out.println("---[AGENCY]---[NAME]---[CA$H]---");
                    for (AccountDTO cc : accountDTOList) {
                        System.out.println(cc);
                    }
                    System.out.println("-----------------------------");
                }
            }else if(op.equalsIgnoreCase("E")){
                System.out.println("Em qual conta deseja entrar?");
                String nomeConta = scanner.nextLine();
                AccountDTO accountDTO = bankService.findByName(santander, nomeConta);
                if(accountDTO != null){
                    OperateAccount(accountDTO);
                }else {
                    System.out.println("Conta não encontrada");
                }


            } else if (op.equalsIgnoreCase("S")) {
                break;
            } else {
                System.out.println("Comando Inválido");
            }
        }
    }

    public void OperateAccount(AccountDTO accountDTO) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem Vindo ao Banco Santander");
        System.out.println("----------------------------");

        while (true) {
            System.out.println(accountDTO.toString());
            System.out.println("----------------------------");
            System.out.println("Oque deseja fazer? \nDEPOSITAR = D\nSACAR = S\nSAIR = E");
            System.out.println("----------------------------");
            String op = scanner.nextLine();

            if (op.equalsIgnoreCase("S")) {
                System.out.println("Digite um valor para sacar //");
                System.out.println("Disponível para saque:" + String.format("%.2f", accountDTO.getBalance()));
                Double value = scanner.nextDouble();
                scanner.nextLine();
                accountService.sacar(accountDTO, value);
            } else if (op.equalsIgnoreCase("D")) {
                System.out.println("Digite o valor que deseja depositar");
                Double value2 = scanner.nextDouble();
                scanner.nextLine();
                accountService.deposit(accountDTO, value2);
            } else if (op.equalsIgnoreCase("E")) {
                break;
            } else {
                System.out.println("Comando inválido, tente novamente.");
            }

        }

    }
}
