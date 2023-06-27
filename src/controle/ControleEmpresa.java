package controle;
import sistema.*;
import javax.swing.DefaultListModel;
import javax.swing.JList;

public class ControleEmpresa {
	
	public Empresa empresa = new Empresa("Nome da Empresa", "1234567-1234/78");
	Filial[] filiais = empresa.getFilial();
	
	public ControleEmpresa(){		
		empresa.adcFilial(new Filial("lugar1", empresa));
		empresa.adcFilial(new Filial("lugar2", empresa));
		empresa.adcFilial(new Filial("lugar3", empresa));
		
		empresa.buscarFilial("lugar1").adcItem(new UtilidadesDomesticas("Mouse", 100, 20, empresa.buscarFilial("lugar1"), "Um produto feito pra "
				+ "espetar a ponta do cabo no computador e ficar mechendo uma setinha no monitor.", "Plastico duro", "Corsair", "Ele pisca!"));
		empresa.buscarFilial("lugar1").adcItem(new Vestuario("Blusa", 60, 10, empresa.buscarFilial("lugar1"), "preta basica", 7, "helicoptero" ));
		empresa.buscarFilial("lugar2").adcItem(new Vestuario("Calça", 100, 7,  empresa.buscarFilial("lugar2"),"sarja", 42, "unissex" ));
		empresa.buscarFilial("lugar2").adcItem(new UtilidadesDomesticas("Teclado", 120, 10,  empresa.buscarFilial("lugar2"),"Teclado brabo "
				+ "pra vc virar o maior digitador de todos os tempos!", "Plastico", "HyperX", "Aperta e faz barulho." ));
		empresa.buscarFilial("lugar3").adcItem(new Alimentacao("Leite", 5, 10,  empresa.buscarFilial("lugar3"),"blablabla", 7, false));
		empresa.buscarFilial("lugar3").adcItem(new Alimentacao("Soja", 40, 13, empresa.buscarFilial("lugar3"), "blablabla", 7, true));
	}

	public String[] getNomesFiliais( ) {
		String[] nomesFiliais = new String[filiais.length];
		for (int i = 0; i < filiais.length; i++) {
			
			if(filiais[i] == null) {
				break;
			} else {
				
			nomesFiliais[i] = filiais[i].getNomeCidade();
			
			}
		}
		return nomesFiliais;
		
}

	public String[][] getCaracteristicasPrincipais() {
		
		int i;
		int d;
		int posicao = 0;
		for(i = 0; i <= empresa.getNumMaxFiliais(); i++) {
			if (filiais[i] == null) {
				break;
			}
		}
		String [][] produtos = new String[(i-1)*100][4];
		String [][] temporario;
		for(int c = 0; c <= (i-1); c++) {
			temporario = filiais[c].obterCaracteristicasPrincipais();
			for(d = 0; d < temporario.length; d++) {
				produtos[posicao] = temporario[d];
				posicao += 1;
			}
		}
		String [][] produtosInteiros = new String[posicao][4];
		for(int j = 0; j < posicao; j++) {
			produtosInteiros[j] = produtos[j];
		}
		return produtosInteiros;
	}//Fim do método
	
	public String[][] buscaItemGeral(String nomeProduto){
		int k = 0;
		String[][] todosProdutos = this.getCaracteristicasPrincipais();
		String[][] produtos = new String[empresa.getQtdFiliais()][];
		for(int i = 0; i < todosProdutos.length; i++) {
			if(todosProdutos[i][0].equalsIgnoreCase(nomeProduto)) {
				for(int j = 0; j < 5; j++) {
					produtos[k] = todosProdutos[i];
				}
				k++;
			}
		}
		String[][] prod = new String[k][4];
		for(int l = 0; l < k; l++) {
			prod[l] = produtos[l];
		}
		return prod;
	}
	
	public String[] buscarItem(String nomeProduto, String nomeFilial) { 
		String[] p = null;
		
		for (int i = 0; i < empresa.getQtdFiliais(); i++) {
			
			Produto[] produto = filiais[i].getProduto();
			
			for(int c = 0; i < empresa.getQtdFiliais(); c++) {
				if(produto[c] == null) {
					break;
					
				} else if(produto[c].getNome().equals(nomeProduto) && 
						produto[c].getFilial().getNomeCidade().equals(nomeFilial)) {
					
					p = new String[9];
					
					if(produto[c] instanceof Alimentacao) {
						
						Alimentacao a = (Alimentacao)produto[c];
						p[6] = String.valueOf(a.getPeso());
						p[7] = String.valueOf(a.getVegetariano());
						
					} else if(produto[c] instanceof Vestuario) {
						
						Vestuario a = (Vestuario)produto[c];
						p[6] = String.valueOf(a.getTamanho());
						p[7] = a.getGenero();
						
					} else if(produto[c] instanceof UtilidadesDomesticas) {
						
						UtilidadesDomesticas a = (UtilidadesDomesticas)produto[c];
						p[6] = a.getMaterial();
						p[7] = a.getMarca();
						p[8] = a.getCaracteristicas();
					}
					
					p[0] = produto[c].getNome();
					p[1] = String.valueOf(produto[c].getPreco());
					p[2] = String.valueOf(produto[c].getQuantidade());
					p[3] = produto[c].getFilial().getNomeCidade();
					p[4] = produto[c].getDescricao();
					p[5] = String.valueOf(produto[c].getClass());

					break;
				}
			}
		}
		return p;
	}
	
	public void cadastrarProduto(String nomeFilial, String nomeProduto, double preco , int qtd, String descricao, double peso, 
			boolean vegetariano, int tamanho, String genero, String material, String marca, String caracteristica) {
		//TODO: Terminar de adicionar os metodos para cadastrar produtos e 
		//fazer uma estrutura de decisão para ver qual construtor de produto usar
		
		 {
			empresa.buscarFilial(nomeFilial).adcItem(new UtilidadesDomesticas(nomeProduto, preco, qtd, empresa.buscarFilial(nomeFilial), 
				descricao, material, marca, caracteristica));
		}
	}
	
}//Fim da classe ControleEmpresa
