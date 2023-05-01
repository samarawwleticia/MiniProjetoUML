package sistema;

public class Vestuario extends Produto{
	
	private int tamanho;
	private String genero;
	
	Vestuario(String nome, double preco, int qtd, Filial filial, 
			String descricao, int tamanho, String genero) {
		setNome(nome);
		setPreco(preco);
		setQuantidade(qtd);
		setFilial(filial);
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
		if (tamanho >= 1) {
			this.tamanho = tamanho;
		} else {
			System.out.println("Não existe tamanho menor que um.");
		}
	}
	
	
} // Fim da classe Vestuario
