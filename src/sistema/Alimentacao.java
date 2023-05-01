package sistema;

public class Alimentacao extends Produto{
	
	private double peso;
	private boolean vegetariano;
	
	
	Alimentacao(String nome, double preco, int qtd, Filial filial,
			String descricao, double peso, boolean vegetariano) {
		setNome(nome);
		setPreco(preco);
		setQuantidade(qtd);
		setFilial(filial);
		setDescricao(descricao);
		setPeso(peso);
		setVegetariano(vegetariano);
	}
	
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		if(peso >= 0.01) {
			this.peso = peso;
		} else {
			System.out.println("O produto não pode pesar menos de uma grama.");
		}
	}
	
	public boolean getVegetariano() {
		return vegetariano;
	}
	
	public void setVegetariano(boolean vegetariano) {
		this.vegetariano = vegetariano;
	}
}
