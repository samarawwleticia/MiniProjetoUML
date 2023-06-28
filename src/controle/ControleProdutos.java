package controle;

//import sistema.Alimentacao;
//import sistema.Filial;
import sistema.*;
//import sistema.UtilidadesDomesticas;
//import sistema.Vestuario;
public class ControleProdutos{
	
	ControleEmpresa ce;
	Empresa empresa;
	Filial filiais[];
	
	public ControleProdutos(ControleEmpresa ce){
		
		this.ce = ce;
		this.empresa = ce.getEmpresa();
		this.filiais = empresa.getFilial();
	}
	
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
	
	public void excluirProduto(String nomeFilial, int indice) {
		empresa.buscarFilial(nomeFilial).excluirItem(indice);
	}
	
	
	/*Codigo a prova de erros externos:
	public String[][] getCaracteristicasPrincipais() {
		int i;
		int d;
		int posicao = 0;
		String [][] produtos;
		String [][] temporario;
		String [][] produtosInteiros;
		
		for(i = 0; i <= empresa.getNumMaxFiliais(); i++) {
			if (filiais[i] == null) {
				break;
			}
		}
		produtos = new String[(i-1)*100][4];
		
		for(int c = 0; c <= (i-1); c++) {
			temporario = filiais[c].obterCaracteristicasPrincipais();
			for(d = 0; d < temporario.length; d++) {
				produtos[posicao] = temporario[d];
				posicao += 1;
			}
		}
		produtosInteiros = new String[posicao][4];
		for(int j = 0; j < posicao; j++) {
			produtosInteiros[j] = produtos[j];
		}
		return produtosInteiros;
	}
	*/
	
} // Fim da classe.