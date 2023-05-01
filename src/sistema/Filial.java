package sistema;

public class Filial {
	
	// Atributos
	private String nomeCidade;
	private Empresa empresa;
	
	// Construtor
	Filial(String nomeCidade, Empresa empresa){
		this.nomeCidade = nomeCidade;
		this.empresa = empresa;
	}
	
	Filial(String nomeCidade){
		this.nomeCidade = nomeCidade;
	}
	
	// Métodos
	public String getNomeCidade() {
		return nomeCidade;
	}
	
	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}
	
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public void adcItem() {
		// add contrutor objeto produto
	}
	
	public void excluirItem() {
		// add destrutor item
	}
	
	public void listarItens() {
		
	}
	
	@Override
	public String toString() {
		return "Localização: " + nomeCidade + ", " + empresa.getsetRazaoSocial();
	}
} // Fim da classe Filial
