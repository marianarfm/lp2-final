package lp2_final;

public class Cliente {
	private String nome;
	private long CPF;
	private Conta conta;

	public String getNome() {
	    return nome;
	}
	public void setNome(String nome) {
	    this.nome = nome;
	}
	public long getCPF() {
	    return CPF;
	}
	public void setCPF(long CPF) {
	    this.CPF = CPF;
	}
	public Conta getConta() {
	    return conta;
	}
	public void setConta(Conta conta) {
	    this.conta = conta;
	}

	public Cliente(String nome, long CPF, Conta conta) {
	    this.setNome(nome);
	    this.setCPF(CPF);
	    this.setConta(conta);
	}
}
