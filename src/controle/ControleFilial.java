  package controle;

import sistema.*;

public class ControleFilial {
	
	private Filial[] f;
	private int qtdFiliais;
	private static ControleEmpresa empresa;
	private Empresa sisEmpresa;
	
	public ControleFilial(ControleEmpresa ce) {
		
		empresa = ce;
		this.f = ce.empresa.getFilial();
		this.qtdFiliais = ce.empresa.getQtdFiliais();
	}
	
	
	
	
	public String[] getNomeFilial() {
		
		String[] s = new String[qtdFiliais];
		for(int i = 0; i < qtdFiliais; i++) {
		s[i] = f[i].getNomeCidade();
		}
		return s;
	}
	
	public int getQtd() {
		return qtdFiliais;
	}
	
	public void setQtd(int qtd) {
		this.qtdFiliais = qtd;
	}

	public String getNome(int i) {
		return f[i].getNomeCidade();
	}
	
	public boolean inserirEditarFilial(String[] filiais) {
		return true; //so por enquanto
	}
	
	public boolean excluirFilial(int i) {
		
		Filial lugar = empresa.empresa.getFilial()[i];
		
		empresa.empresa.excluirFilial(lugar);
		
		return true;
		
	}

	public void cadastrarFilial(String nomeFilial) {		
		
	empresa.getEmpresa().adcFilial(new Filial(nomeFilial, sisEmpresa));
		
	}
	
}
