/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria;

/**
 *
 * @author Gustavo
 */
public class Residencial extends Imovel{
    private int numeroQuartos;
    
    public Residencial(int codigo, String regiao, double valor, boolean disponivel, int numeroQuartos){
        super(codigo, regiao, valor, disponivel);
        this.numeroQuartos = numeroQuartos;
    }
    
    

    public int getNumeroQuartos() {
        return numeroQuartos;
    }

    public void setNumeroQuartos(int numeroQuartos) {
        this.numeroQuartos = numeroQuartos;
    }

    @Override
    public String toString() {
        return "Residencial{" + "numeroQuartos=" + numeroQuartos + '}';
    }
}
