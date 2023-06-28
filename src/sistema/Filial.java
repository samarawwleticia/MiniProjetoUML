package sistema;

public class Filial {
	
	// Atributos
	private String nomeCidade;
	private Empresa empresa;
	private Produto[] produto = new Produto[101];
	private int qtdProdutos = 0;
	
	// Construtor
	public Filial(String nomeCidade, Empresa empresa){
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
	
	public int getQtdProdutos() {
		return qtdProdutos;
	}
	
	public void adcItem(Produto produto) {
		for (int i = 0; i < this.produto.length - 1; i++) {
			// 1 - Verificar se o produto já existe:
			if (this.produto[i] == null) {
				this.produto[i] = produto;//Produto não existe, cria o produto
				this.produto[i].setIndice(i);
				qtdProdutos++;
				break;
			} else if (this.produto[i].equals(produto)) {//Produto existe, acrescenta sua quantidade
					this.produto[i].preco += produto.preco;
					this.produto[i].descricao+= produto.descricao;
					this.produto[i].quantidade += produto.quantidade;
					break;
			}
		}
	}
	
	public void editarItem(Produto produto, int indice) {
		this.produto[indice] = produto;
	}
	
	public void excluirItem(int indice) {

		for(int i = indice; i < (qtdProdutos); i++) {
			produto[i] = produto[i+1];
		}
		
	}
	
	public Produto buscarItem(String chave) {
		Produto p = null;
		for(Produto item: produto) {
			if (item == null) {
				break;
			} else if(item.nome == chave) {
				p = item;
				break;
			}
		}
		return p;
	}
	
	public String[][] obterCaracteristicasPrincipais() {
		String[][] caracteriticas = new String[101][5];
		int i;
		for(i = 0; i < produto.length; i++) {
			if (produto[i] == null) {
				break;
			} else {
				caracteriticas[i][0] = produto[i].getNome();
				caracteriticas[i][1] = String.valueOf(produto[i].getPreco());
				caracteriticas[i][2] = String.valueOf(produto[i].getQuantidade());
				caracteriticas[i][3] = nomeCidade;
				caracteriticas[i][4] = String.valueOf(produto[i].getClass());
			}
		}
		String[][] listaNomes = new String[i][4];
		for(int c = 0; c < i; c++) {
			listaNomes[c] = caracteriticas[c];
		}
		return listaNomes;
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
	
	@Override
	public String toString() {
		return "Localização: " + nomeCidade + ", Empresa: " + empresa.getRazaoSocial();
	}
	
} // Fim da classe Filial
