package sistema;

public class Empresa {
	
	//setFlial n sei como fazer
	//buscarItemGeral ta incompleto
	
	// Atributos
	private String razaoSocial;
	private String cnpj;
	private Filial[] filial = new Filial[25];
	
	// Construtor
	Empresa(String razaoSocial, String cnpj){
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
	}
	
	// Métodos
	public String getsetRazaoSocial() {
		return this.razaoSocial;
	}
	
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	public String getCnpj() {
		return this.cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public Filial[] getFilial() {
		return filial;
	}
	
	public void setFilial(Filial filial) {
		for (int i = 0; i < this.filial.length - 1; i++) {
			if (this.filial[i] == null) {
				this.filial[i] = filial;
				break;
			} else if (this.filial[i].equals(filial)) {
					break;
			}
		}
	}
	
	public Filial gerarFilial(String nomeCidade) {
		return new Filial(nomeCidade, new Empresa(this.razaoSocial, this.cnpj));
	}
	
	public void excluirFilial(Filial fil) {
		for (int i = 0; i < filial.length - 1; i++) { 
			if(filial[i] == null) {
				break;
			} else if(filial[i].equals(fil)) {
					for(int c = i; c < filial.length - 1; c++) {
						if(filial[c] == null) {
							break;
						} else {
							filial[c] = filial[c+1]; 
						}
					}
			}
		}
	}
	
	public void listarItensGeral() {
		for (int i = 0; i < filial.length; i++) {
			if (filial[i] == null) {
				break;
			} else {
				filial[i].listarItens();
			}
		}
	}
	
	//public Produto buscarItemGeral(String chave) {
		// Método para fazer uma pesquisa geral
		//return;
	//}
	
	@Override
	public String toString() {
		return "Razão Social: " + razaoSocial + ", CNPJ: " + cnpj;
	}
	
} // Fim da classe Empresa
