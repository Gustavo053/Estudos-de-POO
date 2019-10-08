/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Gustavo
 */
public class Imobiliaria {
    private ArrayList<Imovel> imoveis = new ArrayList<>();
    private String regiaoImovel;
    private double valorImovel;
    private int codigo = 0;
    private Scanner leitor = new Scanner(System.in);
    
    public void menu(){
        int opcao;
        do{
            System.out.println("--------Menu Imobiliária--------");
            System.out.println("1 - Cadastrar Imóvel");
            System.out.println("2 - Alugar Imovel");
            System.out.println("3 - Listar Imóveis");
            System.out.println("4 - Sair");
            System.out.print(": ");
            opcao = leitor.nextInt();
            switch(opcao){
                case 1:
                    cadastrarImoveis();
                    break;
                case 2:
                    alugarImoveis();
                    break;
                case 3:
                    listarImoveis();
                    break;
                case 4:
                    System.out.println("Finalizado");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }while(opcao != 4);
    }
    
    private void cadastrarImoveis(){
        int opcao;
        int qtdQuartos;
        double areaUtil;
        do{
            System.out.println("--------Cadastrar Imóvel--------");
            System.out.println("1 - Residencial");
            System.out.println("2 - Comercial");
            System.out.println("3 - Voltar");
            System.out.print(": ");
            opcao = leitor.nextInt();
            switch(opcao){
                case 1:
                    System.out.print("Digite a região do imóvel: ");
                    regiaoImovel = leitor.next();
                    System.out.print("Digite o valor do imóvel: ");
                    valorImovel = leitor.nextDouble();
                    System.out.print("Digite a quantidade de quartos: ");
                    qtdQuartos = leitor.nextInt();
                    imoveis.add(new Residencial(++codigo, regiaoImovel, valorImovel, true, qtdQuartos));
                    System.out.println("Imóvel cadastrado com sucesso!");
                    break;
                case 2:
                    System.out.print("Digite a região do imóvel: ");
                    regiaoImovel = leitor.next();
                    System.out.print("Digite o valor do imóvel: ");
                    valorImovel = leitor.nextDouble();
                    System.out.print("Digite a área útil do imóvel em (m): ");
                    areaUtil = leitor.nextDouble();
                    imoveis.add(new Comercial(++codigo, regiaoImovel, valorImovel, true, areaUtil));
                    System.out.println("Imóvel cadastrado com sucesso!");
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opção inválida");
                    
            }
        }while(opcao != 3);
    }
    
    private boolean listarImoveis(){
        if(imoveis.isEmpty()){
            System.out.println("Sem imóveis cadastrados");
            return false;
        }else{
            for(Imovel i: imoveis){
                i.toString();
            }
            return true;
        }
    }
    
    private void alugarImoveis(){
        int codigoImovel;
        listarImoveis();
        System.out.println("Digite o código do imóvel desejado: ");
        codigoImovel = leitor.nextInt();
        for(Imovel i: imoveis){
            if(i.getCodigo() == codigoImovel){
                if(i.isDisponivel()){
                    i.setDisponivel(false);
                    System.out.println("Imóvel alugado com sucesso!");
                }
            }else{
                System.out.println("Código inexistente");
            }
        }
    }
}
