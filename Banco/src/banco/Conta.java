/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

/**
 *
 * @author Aluno
 */
public class Conta {
    private int numero;
    private double saldo;
    
    public Conta(int numero, double saldo){
        this.numero = numero;
        this.saldo = saldo;
    }
    
    public void deposito(double valor){
        if(valor > 0){
            setSaldo(getSaldo() + valor);
        }
    }
    public boolean saque(double valor){
        if(valor > getSaldo()){
            setSaldo(getSaldo() - valor);
            System.out.println("Valor sacado: " + valor);
            return true;
        }else{
            return false;
        }
    }

    public int getNumero(){
        return numero;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }

    public double getSaldo(){
        return saldo;
    }

    public void setSaldo(double saldo){
        this.saldo = saldo;
    }

    @Override
    public final String toString() {
        return "Conta: " + getNumero() + " \n Saldo atual: " + getSaldo();
    }
    
    
}
