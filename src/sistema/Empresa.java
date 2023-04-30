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
	public String obterNome(Empresa empresa) {
		return this.razaoSocial;
	}
	public String obterCnpj(Empresa empresa) {
		return this.cnpj;
	}
	
	public void gerarFilial(String nomeCidade) {
		// adicionar o construtor de uma filial qnd existir filial
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
	
	public void pesquisarItemNaFilial() {
		// pesquisa específica na filial
	}
} // Fim da classe Empresa
