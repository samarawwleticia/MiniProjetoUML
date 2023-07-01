package sistema;

/**
 * Classe abstrata que simula um produto dentro da filial.
 * @author João Pedro e Samara
 * @since 2023
 * @version 1.1
 *
 */
public abstract class Produto {
	
	protected String nome;
	protected double preco;
	protected int quantidade;
	protected Filial filial;
	protected String descricao;
	protected int indice;
	
		
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		if(preco >= 0.01) {
			this.preco = preco;
		}
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		if(quantidade >= 0) {
			this.quantidade = quantidade;
		}
	}
	
	public Filial getFilial() {
		return filial;
	}
	
	public void setFilial(Filial filial) {
			this.filial = filial;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public int getIndice() {
		return indice;
	}
	
	public void setIndice(int indice) {
		this.indice = indice;
	}
	/**
	 * Esse metodo é usado para editar as caracteristicas de um produto
	 * que ja existe dentro de uma determinada filial.
	 * @param nome
	 * @param preco
	 * @param quantidade
	 * @param descricao
	 * @param filial
	 */
	public void editarCaracteristica(String nome, double preco, int quantidade,String descricao, Filial filial) {
		
		setNome(nome);
		setPreco(preco); 
		setQuantidade(quantidade);
		setDescricao(descricao);
		setFilial(filial);
		
	}
	
	public void setEntrada(int quantidade) {
		
		if (quantidade >= 1) {
			this.quantidade += quantidade;			
		}
		
	}
	public void setSaida(int quantidade) {
		
		if (this.quantidade >= quantidade && quantidade >= 1) {
			this.quantidade -= quantidade;
		}
	}
	
	/**
	 * É uma sobrescrita de um metodo padrão do Java. Verifica se um objeto
	 * é igual ao objeto que foi passado como parametro.
	 * @param produto
	 * @return true se e igual, false se não for.
	 */
	public boolean equals(Produto produto) {
		if (nome.equalsIgnoreCase(produto.nome) && 
				filial.getNomeCidade().equalsIgnoreCase(produto.filial.getNomeCidade())) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Constroi uma String com os valores principais de um Produto.
	 */
	@Override
	public String toString() {
		return "Nome: " + nome + ", Quantidade: " 
		+ quantidade + ", Preço: R$" + preco + "; \n";
	}
} // Fim da classe Produto
