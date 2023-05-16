package sistema;

public class UtilidadesDomesticas extends Produto {
	
	private String material;
	private String marca;
	private String caracteristicas;
	
	
	UtilidadesDomesticas(String nome, double preco, int qtd, Filial filial, 
			String descricao,String material, String marca, String caracteristicas){
		setNome(nome);
		setPreco(preco);
		setQuantidade(qtd);
		setFilial(filial);
		setDescricao(descricao);
		setMaterial(material);
		setMarca(marca);
		setCaracteristicas(caracteristicas);
		}
	
	public String getMaterial() {
		return material;
	}
	
	public void setMaterial (String material) {
		this.material = material;
	}
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca){
		this.marca = marca;
	}

	
	public String getCaracteristicas() {
		return caracteristicas;
	}
	
	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
		
	
}
