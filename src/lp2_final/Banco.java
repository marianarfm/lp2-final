package lp2_final;

import java.util.ArrayList;

public class Banco {
    private String nome = "Banco do Brasil";
    private int agencia = 505505;
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private int senhaGerente = 150503;

    public String getNome() {
    	return nome;
    }
    public void setNome(String nome) {
    	this.nome = nome;
    }
    public int getAgencia() {
    	return agencia;
    }
    public void setAgencia(int agencia) {
    	this.agencia = agencia;
    }
    public ArrayList<Cliente> getClientes() {
    	return clientes;
    }
    public void setClientes(ArrayList<Cliente> clientes) {
    	this.clientes = clientes;
    }
    public int getSenhaGerente() {
    	return senhaGerente;
    }
    public void setSenhaGerente(int senhaGerente) {
    	this.senhaGerente = senhaGerente;
    }

    public void cadastrarCliente(Cliente novo) {
    	clientes.add(novo);
    }

    public void excluirCliente(long CPF) {
    	this.clientes.removeIf(cliente -> cliente.getCPF() == CPF);
    }
}