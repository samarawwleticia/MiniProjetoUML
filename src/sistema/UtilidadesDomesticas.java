package sistema;

public class UtilidadesDomesticas extends Produto {
	
	private String material;
	private String marca;
	private String caracteristicas;
	
	
	public void getmaterial(String material) {
		this.material = material;
	}
	
	public String setmaterial () {
		return material;
	}
	
	public void getmarca(String marca) {
		this.marca = marca;
	}

	public String setmarca(){
		return marca;
	}

	
	public void getcaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	
	public String setcaracteristicas() {
		return caracteristicas;
	}
		
	
}
