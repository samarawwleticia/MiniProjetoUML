package controle;

import javax.swing.JOptionPane;

import sistema.*;

/**
 * Responsavel por fazer alteraçoes totalmente relacionadas aos produtos. 
 * @author João Pedro e Samara
 * @since 2023
 * @version 1.1
 */
public class ControleProdutos{
	
	private static Empresa empresa;

	
	/**
	 * O construtor serve apenas para receber o ControleEmpresa para obter a Empresa.
	 * @param ce
	 */
	
	public ControleProdutos(ControleEmpresa ce){
		
		ControleProdutos.empresa = ce.getEmpresa();
	}
	
	/**
	 * Esse metodo serve tanto para cadastrar quanto editar um produto, a 
	 * depender do valor de op. O metodo recebe todos os valores de todas as classes 
	 * filhas de Produto, porém utiliza apenas os necessarias para cada classe filha 
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
	
	public static void cadastrarEditarProduto(String nomeFilial, String nomeProduto, double preco , int qtd, String descricao, double peso, 
			boolean vegetariano, int tamanho, String genero, String material, String marca, String caracteristica, int op, int indice) {
		
		Filial filial = empresa.buscarFilial(nomeFilial);
		
		if (filial.getQtdProdutos() < 100 || op == 2) {
		
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
		} else {
			JOptionPane.showMessageDialog(null, "O limite do estoque dessa filial foi atingido.");
		}
	}
	/**
	 * Exclui o produto a partir do seu índice.
	 * @param nomeFilial
	 * @param indice
	 */
	public static void excluirProduto(String nomeFilial, int indice) {
		empresa.buscarFilial(nomeFilial).excluirItem(indice);
	}
	
	/**
	 * Cadastra diversos produtos. 
	 * @param n é o numero de produtos a serem adicionados.
	 * @return boolean para verificar se o numero de produtos foram adicionados ou não.
	 */
	public static boolean cadastrarProduto(int n) {
		
		ControleProdutos.empresa = new Empresa("", "");
		ControleProdutos.empresa.adcFilial(new Filial("LugarIrrelevante", ControleProdutos.empresa));
		
		
			for(int i = 0; i < n; i++) {
				cadastrarEditarProduto("LugarIrrelevante", "Produto "+i, (i+i*0.4), i, "Descricao", i, (i%2==0)? true: false, 0, null, null, null, null, 2, 0);
			}
		
			try {
				Produto p = ControleProdutos.empresa.getFilial()[0].getProduto()[n];
				if (p == null) {
					return true;
				} else {
					return false;
				}
			}
			catch(ArrayIndexOutOfBoundsException aiobe) {
				return false;
			}
			catch(NullPointerException npe) {
				return false;
			}	
	}
	
	
	/**
	 * Deleta diversos produtos.
	 * @param n é a quantidade de produtos a ser excluída.
	 * @return boolean para verificar se todos os produtos foram excluidos ou não.
	 */
	
	public static boolean deletarProduto(int n) {
		
		cadastrarProduto(100);
		
		for(int i = 100; i >= n; i--) {
			excluirProduto("LugarIrrelevante", i);
		}
		
		try {
			Produto p = ControleProdutos.empresa.getFilial()[0].getProduto()[n];
			if (p == null) {
				return true;
			} else {
				return false;
			}
		}
		catch(ArrayIndexOutOfBoundsException aiobe) {
			return false;
		}
		catch(NullPointerException npe) {
			return false;
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
} // Fim da classe.