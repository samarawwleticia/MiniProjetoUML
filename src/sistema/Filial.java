package sistema;

public class Filial {
	
	//buscarItem ta incompleto
	
	// Atributos
	private String nomeCidade;
	private Empresa empresa;
	private Produto[] produto = new Produto[100];
	
	// Construtor
	Filial(String nomeCidade, Empresa empresa){
		this.nomeCidade = nomeCidade;
		this.empresa = empresa;
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
	
	public Produto[] getProduto() {
		return produto;
	}
	
	public void setProduto(Produto[] produto) {
		this.produto = produto;
	}
	
	public void adcItem(Produto produto) {
		for (int i = 0; i < this.produto.length - 1; i++) {
			// 1 - Verificar se o produto já existe:
			if (this.produto[i] == null) {
				this.produto[i] = produto;//Produto não existe, cria o produto
				break;
			} else if (this.produto[i].equals(produto)) {//Produto existe, acrescenta sua quantidade
					this.produto[i].quantidade += produto.quantidade;
					break;
			}
		}
	}
	
	public void excluirItem(Produto prod) {

		for (int i = 0; i < produto.length - 1; i++) { 
			if(produto[i] == null) {
				break;
			} else if(produto[i].equals(prod)) {
					for(int c = i; c < produto.length - 1; c++) {
						if(produto[c] == null) {
							break;
						} else {
							produto[c] = produto[c+1]; 
						}
					}
			}
		}
	}
	
	public void listarItens() {
		for(Produto n: produto) {
			if (n == null) {
				break;
			} else {
				System.out.println(n);
			}
		}
	}
	
	//public Produto buscarItem(String chave) {
		// Método para fazer uma pesquisa geral
		//return ;
	//}
	
	@Override
	public String toString() {
		return "Localização: " + nomeCidade + ", Empresa: " + empresa.getsetRazaoSocial();
	}
	
} // Fim da classe Filial
