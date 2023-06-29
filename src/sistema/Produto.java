package sistema;

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
	
	public boolean equals(Produto produto) {
		if (nome.equalsIgnoreCase(produto.nome) && 
				filial.getNomeCidade().equalsIgnoreCase(produto.filial.getNomeCidade())) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "Nome: " + nome + ", Quantidade: " 
		+ quantidade + ", Preço: R$" + preco + "; \n";
	}
} // Fim da classe Produto
