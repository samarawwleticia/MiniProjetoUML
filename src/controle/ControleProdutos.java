package controle;

import sistema.*;

/**
 * @author João Pedro
 * Essa classe é responsável por fazer alterações totalmente relacionadas aos produtos. 
 */

public class ControleProdutos{
	
	private Empresa empresa;
	
	/**
	 * O construtor serve apenas para receber o ControleEmpresa para obter a Empresa.
	 * @param ce
	 */
	
	public ControleProdutos(ControleEmpresa ce){
		
		this.empresa = ce.getEmpresa();
	}
	
	/**
	 * Esse método serve tanto para cadastrar quanto editar um produto, a 
	 * depender do valor de op. O método recebe todos os valores de todas as classes 
	 * filhas de Produto, porém utiliza apenas os necessárioa para cada classe filha 
	 * a depender de quais valores são realmente entregues.
	 * 
	 * @param nomeFilial
	 * @param nomeProduto
	 * @param preco
	 * @param qtd
	 * @param descricao
	 * @param peso
	 * @param vegetariano
	 * @param tamanho
	 * @param genero
	 * @param material
	 * @param marca
	 * @param caracteristica
	 * @param op Decide se o produto está apenas sendo editado ou se está sendo cadastrado. 
	 * Se 2, cadastra o produto. Se 1, edita o produto.  
	 * @param indice É o índice do produto dentro de uma filial, serve para facilitar o acesso a um produto.
	 */
	
	public void cadastrarEditarProduto(String nomeFilial, String nomeProduto, double preco , int qtd, String descricao, double peso, 
			boolean vegetariano, int tamanho, String genero, String material, String marca, String caracteristica, int op, int indice) {
		
		Filial filial = empresa.buscarFilial(nomeFilial);
		
		if (genero == null && material == null) {
				
			if (op == 2) {
				filial.adcItem(new Alimentacao(nomeProduto, preco, 
					qtd, filial, descricao, peso, vegetariano));
			} else {
				filial.editarItem(new Alimentacao(nomeProduto, preco, 
						qtd, filial, descricao, peso, vegetariano), indice);
			}
				
		} else if(peso == 0 && genero == null) {
				
			if (op == 2) {
				filial.adcItem(new UtilidadesDomesticas(nomeProduto, preco, 
					qtd,filial, descricao, material, marca, caracteristica));
			} else {
				filial.editarItem(new UtilidadesDomesticas(nomeProduto, preco, 
						qtd, filial, descricao, material, marca, caracteristica), indice);
			}	
				
		} else if (peso == 0 && material == null) {
				
			if (op == 2) {
				filial.adcItem(new Vestuario(nomeProduto, preco, 
					qtd, filial, descricao, tamanho, genero));
			} else {
				filial.editarItem(new Vestuario(nomeProduto, preco, 
						qtd,filial, descricao, tamanho, genero), indice);
			}
				
		}
	}
	/**
	 * Exclui o produto a partir do seu índice. :P
	 * @param nomeFilial
	 * @param indice
	 */
	public void excluirProduto(String nomeFilial, int indice) {
		empresa.buscarFilial(nomeFilial).excluirItem(indice);
	}
	
} // Fim da classe.