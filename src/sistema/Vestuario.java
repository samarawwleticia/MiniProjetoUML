package sistema;
/**
 * Classe que herda de Produto e simula um produto do tipo Vestuario.
 * @author João Pedro e Samara
 * @since 2023
 * @version 1.1
 *
 */
public class Vestuario extends Produto{
	
	private int tamanho;
	private String genero;
	/**
	 * Construtor do produto do tipo Vestuario.
	 * @param nome
	 * @param preco
	 * @param qtd
	 * @param filial
	 * @param descricao
	 * @param tamanho
	 * @param genero
	 */
	public Vestuario(String nome, double preco, int qtd, Filial filial,
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
		}
	}
	
	
} // Fim da classe Vestuario
