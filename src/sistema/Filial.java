package sistema;

/**
 * Simula uma filial que tem sua determinada empresa e pode receber, deletar e editar produtos.
 * @author João Pedro e Samara
 * @since 2023
 * @version 1.1
 */
public class Filial {
	
	// Atributos
	private String nomeCidade;
	private Empresa empresa;
	private Produto[] produto = new Produto[101];
	private int qtdProdutos = 0;
	
	// Construtor
	/**
	 * Construtor de filial que tem o nome do lugar onde a filial esta
	 * localizada e sua empresa.
	 * @param nomeCidade nome da Filial
	 * @param empresa
	 */
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
	
	/**
	 * Adiciona um novo item na filial.
	 * @param produto
	 */
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
	/**
	 * Edita as caracteristicas de um produto.
	 * @param produto
	 * @param indice
	 */
	public void editarItem(Produto produto, int indice) {
		this.produto[indice] = produto;
	}
	
	/**
	 * Deleta um item da Filial. O parametro indice do produto dentro de uma filial
	 * serve para facilitar o acesso a um produto.
	 * @param indice
	 */
	public void excluirItem(int indice) {

		for(int i = indice; i < (qtdProdutos); i++) {
			produto[i] = produto[i+1];
			qtdProdutos--;
		}
		
	}
	
	/**
	 * Busca um produto dentro da filial.
	 * @param chave
	 * @return produto
	 */
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
	
	/**
	 * 
	 * @return Um vetor de duas dimensoes de Strings com
	 * as caracteristicas principais de um produto dentro da filial.
	 * Nome do produto, valor, quantidade e a filial a qual ele pertence.
	 */
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
	
	/**
	 * Constroi uma String contendo todos os valores de uma Filial.
	 */
	@Override
	public String toString() {
		return "Localização: " + nomeCidade + ", Empresa: " + empresa.getRazaoSocial();
	}
	
} // Fim da classe Filial
