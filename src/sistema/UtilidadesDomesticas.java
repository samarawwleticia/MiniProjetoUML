package sistema;

public class UtilidadesDomesticas extends Produto {
	
	private String material;
	private String marca;
	private String caracteristicas;
	
	
	public void getMaterial(String material) {
		this.material = material;
	}
	
	public String setMaterial () {
		return material;
	}
	
	public void getMarca(String marca) {
		this.marca = marca;
	}

	public String setMarca(){
		return marca;
	}

	
	public void getCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	
	public String setCaracteristicas() {
		return caracteristicas;
	}
		
	
}
