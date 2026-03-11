
import java.util.ArrayList;
import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void mostrarMenu() {
        System.out.println("------- Banco -------");
        System.out.println("1 - Criar conta");
        System.out.println("2 - Sacar");
        System.out.println("3 - Depositar");
        System.out.println("4 - Transferir");
        System.out.println("5 - Ver informações da conta");
        System.out.println("6 - Sair");
        System.out.print("Escolha uma opcao: ");
    }

    public static void criarConta(ArrayList<ContaBancaria> contas, Scanner input){
        System.out.print("Digite o titular: ");
        String titular = input.nextLine();
        System.out.print("Digite o saldo inicial: ");
        BigDecimal saldo = BigDecimal.valueOf(input.nextDouble());
        System.out.print("Digite o numero da conta: ");
        int numero = input.nextInt();
        input.nextLine();

        ContaBancaria novaConta = new ContaBancaria(titular, saldo, numero);
        contas.add(novaConta);
        System.out.println("Conta criada com sucesso");
    }

    public static void depositar(ArrayList<ContaBancaria> contas, Scanner input){
        System.out.println("Digite o numero da conta: ");
        int numero = input.nextInt();

        ContaBancaria contaEncontrada = null;

        for(ContaBancaria conta: contas){
            if(conta.getNumeroConta() == numero){
                contaEncontrada = conta;
                break;
            }
        }
        if(contaEncontrada == null){
            System.out.println("Conta nao encontrada");
            return;
        }
        System.out.println("Nome do titular da conta: "+contaEncontrada.getTitular());
        System.out.println("Digite o valor do deposito: ");
        BigDecimal valor = BigDecimal.valueOf(input.nextDouble());

        if(contaEncontrada.depositar(valor)){
            System.out.println("Deposito realizado com sucesso");
        }
        else{
            System.out.println("Deposito nao realizado");
        }
    }

    public static void sacar(ArrayList<ContaBancaria> contas, Scanner input){
        System.out.println("Digite o numero da conta: ");
        int numero = input.nextInt();

        ContaBancaria contaEncontrada = null;

        for(ContaBancaria conta: contas){
            if(conta.getNumeroConta() == numero){
                contaEncontrada = conta;
                break;
            }
        }
        if(contaEncontrada == null){
            System.out.println("Conta nao encontrada");
            return;
        }
        System.out.println("Nome do titular da conta: "+contaEncontrada.getTitular());

        System.out.println("Digite o valor do saque: ");
        BigDecimal valor = BigDecimal.valueOf(input.nextDouble());

        if(contaEncontrada.sacar(valor)){
            System.out.println("Saque realizado com sucesso");
        }
        else{
            System.out.println("Saque não realizado");
        }
    }

    public static void transferir(ArrayList<ContaBancaria> contas, Scanner input){
        System.out.println("Digite o numero da conta remetente: ");
        int numero = input.nextInt();
        ContaBancaria contaExistente = null;
        for(ContaBancaria conta : contas){
            if(conta.getNumeroConta() == numero){
                contaExistente = conta;
                break;
            }
        }
        if(contaExistente == null){
            System.out.println("Conta nao encontrada");
            return;
        }
        System.out.println("Nome do titular da conta: "+contaExistente.getTitular());

        System.out.println("Digite o numero da conta destinataria: ");
        int numero2 = input.nextInt();
        ContaBancaria contaExistente2 = null;
        for(ContaBancaria conta : contas){
            if(conta.getNumeroConta() == numero2){
                contaExistente2 = conta;
                break;
            }
        }
        if(contaExistente2 == null){
            System.out.println("Conta nao encontrada");
            return;
        }
        System.out.println("Nome do titular da conta: "+contaExistente2.getTitular());

        System.out.println("Digite o valor da transferencia: ");
        BigDecimal valor = BigDecimal.valueOf(input.nextDouble());

        if(contaExistente.transferir(contaExistente2, valor)){
            System.out.println("Transferencia realizada com sucesso");
        }
        else{
            System.out.println("Transferencia nao realizada");
        }
    }

    public static void mostrar(ArrayList<ContaBancaria> contas, int numero){
        ContaBancaria contaEncontrada = null;
        for(ContaBancaria conta: contas){
            if(conta.getNumeroConta() == numero){
                contaEncontrada = conta;
                break;
            }
        }
        if(contaEncontrada == null){
            System.out.println("Conta nao encontrada");
            return;
        }

        System.out.println(contaEncontrada);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<ContaBancaria> contas = new ArrayList<>();

        int escolha = 0;
        while(escolha != 6){
            mostrarMenu();
            escolha = input.nextInt();
            switch (escolha){
                case 1:
                    input.nextLine();
                    criarConta(contas, input);
                    break;
                case 2:
                    input.nextLine();
                    sacar(contas, input);
                    break;
                case 3:
                    input.nextLine();
                    depositar(contas, input);
                    break;
                case 4:
                    input.nextLine();
                    transferir(contas, input);
                    break;
                case 5:
                    input.nextLine();
                    System.out.println("Digite o numero da conta: ");
                    int numero = input.nextInt();
                    mostrar(contas, numero);
                    break;
                case 6:
                    System.out.println("Saindo...");
            }
        }
        input.close();
    }
}
