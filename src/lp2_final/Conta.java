package lp2_final;

public class Conta {
	private int numero;
	private float saldo;
	private int senha;

	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
	    this.numero = numero;
	}
	public float getSaldo() {
	    return saldo;
	}
	public void setSaldo(float saldo) {
	    this.saldo = saldo;
	}
	public int getSenha() {
	    return senha;
	}
	public void setSenha(int senha) {
	    this.senha = senha;
	}
	  
	public Conta(int numero, float saldo, int senha) {
	    this.setNumero(numero);
	    this.setSaldo(saldo);
	    this.setSenha(senha);
	}

	public boolean depositar(float valor) {
	    if (valor >= 0) {
	    	this.setSaldo(this.saldo + valor);
	    	return true;
	    } else {
	    	return false;
	    }
	}

	public boolean sacar(float valor) {
	    if (valor <= getSaldo() && valor > 0) {
	    	this.saldo -= valor;
	    	return true;
	    } else {
	    	return false;
	    }
	}

	public float verificarSaldo(int senha) {
	    return getSaldo();
	}
}