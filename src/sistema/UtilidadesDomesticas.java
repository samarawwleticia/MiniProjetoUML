package sistema;
/**
 * Classe que herda de Produto e simula um produto do tipo Utilidades Domesticas
 * @author João Pedro e Samara
 * @since 2023
 * @version 1.1
 *
 */
public class UtilidadesDomesticas extends Produto {
	
	private String material;
	private String marca;
	private String caracteristicas;
	
	/**
	 * Construtor do Produto do tipo Utilidades Domesticas.
	 * @param nome
	 * @param preco
	 * @param qtd
	 * @param filial
	 * @param descricao
	 * @param material
	 * @param marca
	 * @param caracteristicas
	 */
	public UtilidadesDomesticas(String nome, double preco, int qtd, Filial filial,
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
