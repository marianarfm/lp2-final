package lp2_final;

public class AutoAtendimento {
	
	public AutoAtendimento() {};
	
	Banco banco = new Banco();
	
	public boolean loginCliente(int numConta, int senha) {
		for(int i = 0; i < banco.getClientes().size(); i++) {
			if ( (banco.getClientes().get(i).getConta().getNumero() == numConta) && (banco.getClientes().get(i).getConta().getSenha() == senha) ) {
				return true;
			}
		}
		return false;
	}
	
	public boolean loginGerente(int numAgencia, int senha) {
		if (numAgencia == banco.getAgencia() && senha == banco.getSenhaGerente()) {
			return true;
		}
		return false;
	}
	
	public boolean gerenteCadastrarCliente(Cliente novo) {
		for(int i = 0; i < banco.getClientes().size(); i++) {
    		if(banco.getClientes().get(i).getCPF() == novo.getCPF()) {
    			return false;
    		}
    		if(banco.getClientes().get(i).getConta().getNumero() == novo.getConta().getNumero()) {
    			return false;
    		}
    	}
		banco.cadastrarCliente(novo);
		return true;
	}
	
	public boolean gerenteExcluirCliente(long CPF) {
		for(int i = 0; i < banco.getClientes().size(); i++) {
			if (banco.getClientes().get(i).getCPF() == CPF) {
				banco.excluirCliente(CPF);
				return true;
			}
		}
		return false;
	}
	
	public boolean clienteSacar(int numConta, float valor, int senha) {
		for(int i = 0; i < banco.getClientes().size(); i++) {
			if (banco.getClientes().get(i).getConta().getNumero() == numConta && banco.getClientes().get(i).getConta().getSenha() == senha) {
				if (banco.getClientes().get(i).getConta().sacar(valor) == true) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean clienteDepositar(int numConta, float valor, int senha) {
		for(int i = 0; i < banco.getClientes().size(); i++) {
			if (banco.getClientes().get(i).getConta().getNumero() == numConta && banco.getClientes().get(i).getConta().getSenha() == senha) {
				if(banco.getClientes().get(i).getConta().depositar(valor) == true) {
					return true;
				}
			}
		}
		return false;
	}
	
	public float clienteVerificarSaldo(int numConta, int senha) {
		float saldoRetorno = 0;
		for(int i = 0; i < banco.getClientes().size(); i++) {
			if (banco.getClientes().get(i).getConta().getNumero() == numConta && banco.getClientes().get(i).getConta().getSenha() == senha) {
				saldoRetorno += Math.round(banco.getClientes().get(i).getConta().getSaldo()*100.0)/100.0;
				if(saldoRetorno < 0) {
					banco.getClientes().get(i).getConta().setSaldo(0);
					saldoRetorno = banco.getClientes().get(i).getConta().getSaldo();
				}
			}
		}
		return saldoRetorno;
	}
}
