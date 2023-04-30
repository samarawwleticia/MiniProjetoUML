package sistema;

public class Produto {
	
	private String nome;
	private double preco;
	private int quantidade;
	private String descricao; 
	
	public String getnome() {
		return nome;
	}
	
	public void setnome(String nome) {
		this.nome = nome;
	}
	
	public double getpreco() {
		return preco;
	}
	
	public void setpreco(double preco) {
		this.preco = preco;
	}
	
	public int getquantidade() {
		return quantidade;
	}
	
	public void setquantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public String getdescricao() {
		return descricao;
	}
	
	public void setdescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void editarCaracteristica(String nome, String descricao, int quantidade, double preco) {
		
		this.nome = nome;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.preco = preco; 
		
	}
	
	public void Entrada_Saida(int quantidade) {
		this.quantidade = quantidade;
	}
}
