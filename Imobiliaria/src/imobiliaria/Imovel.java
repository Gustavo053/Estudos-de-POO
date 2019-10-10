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
public class Imovel {
    private int codigo;
    private String regiao;
    private double valor;
    private boolean disponivel;

    public Imovel(int codigo, String regiao, double valor, boolean disponivel) {
        this.codigo = codigo;
        this.regiao = regiao;
        this.valor = valor;
        this.disponivel = disponivel;
    }

    
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Região: " + regiao + "\n valor: " + valor + "\nDisponível? " + disponivel + "\nCódigo: " + codigo;
    }
}
