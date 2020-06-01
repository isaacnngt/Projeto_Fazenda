/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.softwareevida.viveravida.modelos;

import java.util.ArrayList;
import java.util.List;

public class Fachada {
    private ArrayList<Cliente> clientes;
    private ArrayList<Quarto>  quartos;
    private ArrayList<AlugarQuarto>  alugarQuartos;
    
    public Fachada() {
        this.clientes = new ArrayList<>();
        this.quartos = new ArrayList<>();
        this.alugarQuartos = new ArrayList<>();
    }
    
    public void cadastrarCliente(String nome, String telefone, String CPF) {
        this.clientes.add(new Cliente(nome, telefone, CPF));
    }
    
    public void cadastrarQuarto(int numero, int status) {
        this.quartos.add(new Quarto(numero, status));
    }
     
     public void alugarQuarto(String nomeDoCliente, int numeroDoQuarto) {    
        Cliente cliente = buscarClientePeloNome(nomeDoCliente);
        Quarto quarto = buscarQuartoPeloNumero(numeroDoQuarto);
         
        //Caso o quarto e cliente existam, e verifica se o quarto está disponível
        if(quarto != null && cliente != null && quarto.getStatus() == 0) {
            quarto.setStatus(1);
            AlugarQuarto aluguel = new AlugarQuarto(cliente, quarto);
            this.alugarQuartos.add(aluguel);
        } else {
            throw new IllegalArgumentException("O quarto ou cliente não esta disponível ou não existe.");
        }     
     }
     
     public void fecharQuarto(int numero) {
        AlugarQuarto aluguel = buscarQuartoNoAlugarQuartos(numero);
        
        if(aluguel != null && aluguel.getQuarto().getStatus() == 1) {
            aluguel.getQuarto().setStatus(0);
        } else {
            throw new IllegalArgumentException("O quarto se encontra desocupado ou não existe.");
        }    
     }
     
     public List<Quarto> exibirQuartos() {
        quartos.forEach(System.out :: println);
        return this.quartos;
     }
     
     public Cliente buscarClientePeloNome(String nome) {
         Cliente cliente = null;
         
         for (Cliente c : clientes) {
             if(c.getNome().equals(nome)) {
                 cliente = c;
             }
         }
         
         return cliente;
     }
     
     public Quarto buscarQuartoPeloNumero(int numero) {
         Quarto quarto = null;
         
         for (Quarto q : quartos) {
             if(q.getNumero() == numero) {
                 quarto = q;
             }
         }
         
         return quarto;
     }
     
     public AlugarQuarto buscarQuartoNoAlugarQuartos(int numeroDoQuarto) {
        AlugarQuarto alugarQuarto = null;
         
        for (AlugarQuarto aq : alugarQuartos ) {
            if(aq.getQuarto().getNumero() == numeroDoQuarto) {
                alugarQuarto = aq;
            }
        }
         
         return alugarQuarto;
     }
}
