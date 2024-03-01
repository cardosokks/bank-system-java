package br.com.banco;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Bank santander = new Bank("0001");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Contas online: " + santander.outputContagemContas());
            System.out.println("Dinheiro armazenado no banco: R$ " + santander.outputTotal());
            System.out.println("Oque deseja fazer?\nCRIAR CONTA = C\nLISTAR CONTAS = L\nSAIR = E");
            System.out.println("----------------------------");
            String op = scanner.nextLine();
            if (op.equals("C")) {
                System.out.println("Digite o seu nome.");
                System.out.println("----------------------------");
                String name = scanner.nextLine();
                Account account = santander.generateAccount(name);
                santander.insertAccount(account);
                OperateAccount(account);
            }else if(op.equals("L")){
                List<Account> accountList = santander.getAccounts();
                if(accountList.isEmpty()){
                    System.out.println("Ainda não foram criadas contas neste banco.");
                }else {
                    System.out.println("--------- CONTAS ------------");
                    for (Account cc : accountList) {
                        System.out.println(cc);
                    }
                    System.out.println("----------------------------");
                }
            } else if (op.equals("E")) {
                break;
            } else {
                System.out.println("Comando Inválido");
            }
        }
    }

    static void OperateAccount(Account account){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem Vindo ao Banco Santander");
        System.out.println("----------------------------");
        while(true) {
            System.out.println(account.toString());
            System.out.println("----------------------------");
            System.out.println("Oque deseja fazer? \nDEPOSITAR = D\nSACAR = S\nSAIR = E");
            System.out.println("----------------------------");
            String op = scanner.nextLine();
            if (op.equals("S")) {
                System.out.println("Digite um valor para sacar //");
                System.out.println("Disponível para saque:" + account.getBalance());
                Double value = scanner.nextDouble();
                scanner.nextLine();
                account.sacar(value);
            } else if (op.equals("D")) {
                System.out.println("Digite o valor que deseja depositar");
                Double value2 = scanner.nextDouble();
                scanner.nextLine();
                account.deposit(value2);
            } else if (op.equals("E")) {
                break;
            } else {
                System.out.println("Comando inválido, tente novamente.");
            }
        }


    }
}
