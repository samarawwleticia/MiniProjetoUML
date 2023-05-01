package sistema;

public class Vestuario extends Produto{
	
	private int tamanho;
	private String genero;
	
	Vestuario(String nome, double preco, int qtd, 
			String descricao, int tamanho, String genero) {
		setNome(nome);
		setPreco(preco);
		setQuantidade(qtd);
		setDescricao(descricao);
		setTamanho(tamanho);
		setGenero(genero);
	}

	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public int getTamanho() {
		return tamanho;
	}
	
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	
	
} // Fim da classe Vestuario
