/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Aluno
 */
public class Loja {
    private ArrayList<Pessoa> lista = new ArrayList<>();
    private Scanner entrada = new Scanner(System.in);
    private String nome, cpf;
    private int matricula;
    private double salario;
    
    public void menu(){
        int opcao;
        do{
            System.out.println("\t loja");
            System.out.println("1-Cadastrar pessoas");
            System.out.println("2-Remover pessoa");
            System.out.println("3-Buscar pessoa");
            System.out.println("4-Adicionar Produtividade");
            System.out.println("5-Gerar Folha Pagamento");
            System.out.println("6-Sair");
            System.out.print(": ");
            opcao = entrada.nextInt();
            switch(opcao){
                case 1:
                    cadastrar();
                    break;
                case 2:
                    remover();
                    break;
                case 3:
                    buscar();
                    break;
                case 4:
                    adicionarProdutividade();
                    break;
                case 5:
                    gerarFolhaPagamento();
                    break;
                case 6:
                    System.out.println("Programa finalizado");
                    break;
                default:
                    System.out.println("Por favor, digite uma opção válida");
            }
        }while(opcao != 6);
    }
    
    private void cadastrar(){
        int opcao;
        do{
            System.out.println("1-Cliente");
            System.out.println("2-Administrativo");
            System.out.println("3-Vendedor");
            System.out.println("4-Voltar");
            System.out.print(": ");
            opcao = entrada.nextInt();
            switch(opcao){
                case 1:
                    System.out.print("Digite o nome: ");
                    nome = entrada.next();
                    System.out.print("Digite o CPF: ");
                    cpf = entrada.next();
                    System.out.print("Digite o código: ");
                    String codigo = entrada.next();
                    lista.add(new Cliente(nome, cpf, codigo));
                    break;
                case 2:
                    System.out.print("Digite o nome: ");
                    nome = entrada.next();
                    System.out.print("Digite o CPF: ");
                    cpf = entrada.next();
                    System.out.print("Digite a matrícula: ");
                    matricula = entrada.nextInt();
                    System.out.print("Digite o salário: ");
                    salario = entrada.nextDouble();
                    System.out.println("Digite as horas: ");
                    double horas = entrada.nextDouble();
                    lista.add(new Administrativo(nome, cpf, matricula, salario, horas));
                    break;   
                case 3:
                    System.out.print("Digite o nome: ");
                    nome = entrada.next();
                    System.out.print("Digite o CPF: ");
                    cpf = entrada.next();
                    System.out.print("Digite a matrícula: ");
                    matricula = entrada.nextInt();
                    System.out.print("Digite o salário: ");
                    salario = entrada.nextDouble();
                    System.out.print("Digite as vendas: ");
                    double vendas = entrada.nextDouble();
                    lista.add(new Vendedor(nome, cpf, matricula, salario, vendas));
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Por favor, digite uma opção válida");
                    
            }
        }while(opcao != 4);
    }
    
    private Pessoa buscar(String cpf){
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i).getCpf().equalsIgnoreCase(cpf)){
                return lista.get(i);
            }
        }
        return null;
    }
    
    private void buscar(){
        System.out.print("Informe o cpf: ");
        cpf = entrada.next();
        if(buscar(cpf) != null){
            buscar(cpf).toString();
        }else{
            System.out.println("Usuário não encontrado");
        }
    }
    
    private void remover(){
        System.out.print("Informe o cpf: ");
        cpf = entrada.next();
        if(buscar(cpf) != null){
            lista.remove(buscar(cpf));
        }else{
            System.out.println("Usuário não encontrado");
        }
    }
    
    private void listar(){
        for(Pessoa i: lista){
            i.toString();
        }
    }
    
    private void adicionarProdutividade(){
        System.out.print("Informe o cpf: ");
        cpf = entrada.next();
        if(buscar(cpf) != null){
            System.out.print("Digite a produtividade: ");
            double produtividade = entrada.nextDouble();
            if(buscar(cpf) instanceof Administrativo){
                ((Administrativo) buscar(cpf)).setHoras(produtividade);
            }else if(buscar(cpf) instanceof Vendedor){
                ((Vendedor) buscar(cpf)).setVendas(produtividade);
            }else{
                System.out.println("Um cliente não pode usar essa função");
            }
        }else{
            System.out.println("Usuário não encontrado");
        }
    }
    
    private void gerarFolhaPagamento(){
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i) instanceof Administrativo){
                ((Administrativo) lista.get(i)).calculaPagamento();
                ((Administrativo) lista.get(i)).toString();
            }else if(lista.get(i) instanceof Vendedor){
                ((Vendedor) lista.get(i)).calculaPagamento();
                ((Vendedor) lista.get(i)).toString();
            }else{
                System.out.println("Um cliente não pode usar essa função");
            }
        }
    }
}
