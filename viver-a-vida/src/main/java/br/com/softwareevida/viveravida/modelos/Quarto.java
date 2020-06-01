/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.softwareevida.viveravida.modelos;

public class Quarto {
    private int numero;
    private int status;
    
    public Quarto() {}
    //Status: 0 - Disponível | 1 - Alugado
    public Quarto(int numero, int status) {
        this.numero = numero;
        this.status = status;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Quarto{" + "numero=" + numero + ", status=" + status + '}';
    }
    
}
