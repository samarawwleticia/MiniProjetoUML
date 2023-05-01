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
	public String getNome() {
		return this.razaoSocial;
	}
	public String getCnpj() {
		return this.cnpj;
	}
	
	public Filial gerarFilial(String nomeCidade) {
		return new Filial(nomeCidade, new Empresa(this.razaoSocial, this.cnpj));
	}
	
	public void excluirFilial() {
		// fazer algo pra destruir filiais qnd possível
	}
	
	public void transferirItens() {
		// ainda n tenho ideia de como farei isso
	}
	
	public void listarItens() {
		// o nome diz tudo
	}
	
	public void pesquisarItem() {
		// pesquisa geral
	}
	
	public void pesquisarItem(Filial filial) {
		// pesquisa dentro de uma filial
	}
	
	@Override
	public String toString() {
		return "Razão Social: " + razaoSocial + ", CNPJ: " + cnpj;
	}
	
} // Fim da classe Empresa
