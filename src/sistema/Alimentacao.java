package sistema;

public class Alimentacao extends Produto{
	
	private double peso;
	private boolean vegetariano;
	
	Alimentacao(String nome, double preco, int qtd,
			boolean vegetariano){
		setNome(nome);
		setPreco(preco);
		setQuantidade(qtd);
		setVegetariano(vegetariano);
	}
	
	Alimentacao(String nome, double preco, int qtd, 
			String descricao, double peso, boolean vegetariano) {
		setNome(nome);
		setPreco(preco);
		setQuantidade(qtd);
		setDescricao(descricao);
		setPeso(peso);
		setVegetariano(vegetariano);
	}
	
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public boolean getVegetariano() {
		return vegetariano;
	}
	
	public void setVegetariano(boolean vegetariano) {
		this.vegetariano = vegetariano;
	}
}
