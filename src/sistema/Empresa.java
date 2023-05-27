package sistema;

public class Empresa {
	
	// Atributos
	private String razaoSocial;
	private String cnpj;
	
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
	
	public Filial gerarFilial(String nomeCidade) {
		return new Filial(nomeCidade, new Empresa(this.razaoSocial, this.cnpj));
	}
	
	public void excluirFilial() {
		// Método para destruir uma filial
	}
	
	public void listarItens() {
		// Método para listar todos os itens disponíveis na empresa
	}
	
	public void pesquisarItem() {
		// Método para fazer uma pesquisa geral
	}
	
	public void pesquisarItem(Filial filial) {
		// Método para fazer uma pesquisa dentro de uma filial
	}
	
	@Override
	public String toString() {
		return "Razão Social: " + razaoSocial + ", CNPJ: " + cnpj;
	}
	
} // Fim da classe Empresa
