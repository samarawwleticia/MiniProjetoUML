package sistema;

public class Alimentacao extends Produto{
	
	private double peso;
	private boolean vegetariano;
	
	public double getPeso() {
		return peso;
	}
	public void setpeso(double peso) {
		this.peso = peso;
	}
	
	public boolean getVegetariano() {
		return vegetariano;
	}
	
	public void setVegetariano(boolean vegetariano) {
		this.vegetariano = vegetariano;
	}
}
