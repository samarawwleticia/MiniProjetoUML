package sistema;

public abstract class Produto {
	
	// construtor, verificação e reuso de codigo
	
	protected String nome;
	protected double preco;
	protected int quantidade;
	protected String descricao;
	
		
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
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void editarCaracteristica(String nome, String descricao, int quantidade, double preco) {
		
		this.nome = nome;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.preco = preco; 
	}
	
	public void setEntrada(int quantidade) {
		
		if (quantidade >= 1) {
			this.quantidade += quantidade;			
		} else {
			System.out.println("Você não pode comprar zero ou menos itens!");
		}
		
	}
	public void setSaida(int quantidade) {
		
		if (this.quantidade >= quantidade) {
			this.quantidade -= quantidade;
		} else {
			System.out.println("Você não pode vender mais produtos do que possui!");
		}
	}
	
	@Override
	public String toString() {
		return "Nome: " + nome + ", Quantidade: " 
		+ quantidade + ", Preço: R$" + preco + "; \n";
	}
	
} // Fim da classe Produto
