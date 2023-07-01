package sistema;

/**
 * Herda de Produto e constroi objetos do tipo Alimentacao.
 * @author João Pedro e Samara
 * @since 2023
 * @version 1.1
 *
 */
public class Alimentacao extends Produto{
	
	private double peso;
	private boolean vegetariano;
	
	/**
	 * Esse e o construtor do produto alimentacao e recebe todos os valores necessarios 
	 * para um produto desse tipo.
	 * @param nome
	 * @param preco
	 * @param qtd
	 * @param filial
	 * @param descricao
	 * @param peso
	 * @param vegetariano
	 */
	public Alimentacao(String nome, double preco, int qtd, Filial filial,
			String descricao, double peso, boolean vegetariano) {
		setNome(nome);
		setPreco(preco);
		setQuantidade(qtd);
		setFilial(filial);
		setDescricao(descricao);
		setPeso(peso);
		setVegetariano(vegetariano);
	}
	
	//Métodos
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		if(peso >= 0.01) {
			this.peso = peso;
		}
	}
	
	public boolean getVegetariano() {
		return vegetariano;
	}
	
	public void setVegetariano(boolean vegetariano) {
		this.vegetariano = vegetariano;
	}
}
