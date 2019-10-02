/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Aluno
 */
public class Agencia {
    private ArrayList<Conta> contas = new ArrayList<>();
    private Scanner entrada = new Scanner(System.in);
    
    public void menu(){     
        int opcao;
        do{
            System.out.println("[1] - CRIAR CONTA / [2] - CONSULTAR EXISTÊNCIA DA CONTA / [3] - ACESSAR CONTA / [4] - SAIR: ");
            opcao = entrada.nextInt();
            int numeroConta;
            switch(opcao){
                case 1:
                    criarConta();
                    break;
                case 2:
                    System.out.print("Digite o número da conta");
                    numeroConta = entrada.nextInt();
                    if(existeConta(numeroConta)){
                        System.out.println("Conta existente!");
                    }else{
                        System.out.println("Conta inexistente!");
                    }
                    break;
                case 3:
                    System.out.print("Digite o número da conta: ");
                    numeroConta = entrada.nextInt();
                    acessarConta(numeroConta);
                    break;
                default:
                    System.out.println("Opção inválida! ");
            }     
        }while(opcao != 4);
        
    }
    
    private void criarConta(){
        System.out.println("[1] - Corrente / [2] - Poupança: ");
        int opcao = entrada.nextInt();
        int numero;
        double saldo;
        switch(opcao){
            case 1:
                System.out.print("Digite o número: ");
                numero = entrada.nextInt();
                System.out.print("Digite o saldo: ");
                saldo = entrada.nextDouble();
                System.out.print("Digite a tarifa: ");
                double tarifa = entrada.nextDouble();
                contas.add(new Corrente(numero, saldo, tarifa));
                break;
            case 2:
                System.out.print("Digite o número: ");
                numero = entrada.nextInt();
                System.out.print("Digite o saldo: ");
                saldo = entrada.nextDouble();
                System.out.print("Digite o débito da tarifa: ");
                double rendimento = entrada.nextDouble();
                contas.add(new Poupanca(numero, saldo, rendimento));
                break;
            default:
                System.out.println("Opção inválida");
                
        }
    }
    
    private boolean existeConta(int numero){
        int flag = 0;
        for(int i = 0; i < contas.size(); i++){
            if(contas.get(i).getNumero() == numero){
                flag = 1;
            }
        }
        if(flag == 1){
            return true;
        }else{
            return false;
        }
    }
    
    private void acessarConta(int numero){
        for(int i = 0; i < contas.size(); i++){
            if(contas.get(i).getNumero() == numero){
                contas.get(i).toString();
            }else{
                System.out.println("Conta inexistente! ");
            }
        }
    }
}
