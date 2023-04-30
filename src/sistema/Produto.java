package sistema;

public abstract class Produto {
	
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
		this.preco = preco;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
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
		this.quantidade += quantidade;
	}
	public void setSaida(int quantidade) {
		this.quantidade -= quantidade;
	}
}
