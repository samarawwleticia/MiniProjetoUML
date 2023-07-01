package controle;
import sistema.*;
/**
 * Classe onde ficam os objetos que estao registrados na empresa (produtos e filiais)
 * e alguns metodos de pesquisa e busca desses objetos
 * @author João Pedro e Samara
 * @since 2023
 * @version 1.1
 */
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
	
	/**
	 * 
	 * @return objeto empresa que armazena as filiais e os objetos.
	 */
	
	public Empresa getEmpresa() {
		return empresa;
	}
	/**
	 * Esse metodo busca as filiais dentro da empresa.
	 * 
	 * 	 * @return Um vetor de Strings de tamanho [quantidade de filiais
	 * 		cadastradas] contendo o nome das filiais dentro da empresa.
	 * 		Esse metodo foi utilizado para exibir as filiais cadastradas na
	 * 		classe InterfaceFilial.
	 * 		@see InterfaceFilial(ControleEmpresa ce)
	 */
	
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
	
	/**
	 * Esse metodo busca dentro da empresa as características 
	 * mais importantes dos produtos.
	 * 
	 * @return Um vetor de duas dimensoes de  Strings
	 * de tamanho [quantidade de produtos cadastrados][4] contendo essas caracteristicas,
	 * que sao utilizadas na JTable da InterfaceProduto. As caracteristicas sao:
	 * [0]Nome, [1]Preço, [2]Quantidade e [3]Filial.
	 * 
	 */
	public String[][] getCaracteristicasPrincipais() {
		
		int indice = 0;
		int qtdProdutosCadastrados = 0;
		String[][] caracteristicas;
		//Se eu criar um var int em empresas com um getter para 
		//acessar o valor dessa var, posso tirar o primeiro for loop.
		for (int i = 0; i < empresa.getQtdFiliais(); i++){
		
			qtdProdutosCadastrados += filiais[i].getQtdProdutos();
		}
		
		caracteristicas = new String[qtdProdutosCadastrados][4];
		
		for (int i = 0; i < empresa.getQtdFiliais(); i++){
			
			for(int j = 0; j < filiais[i].getQtdProdutos(); j++) {
				
				caracteristicas[indice] = filiais[i].obterCaracteristicasPrincipais()[j];
				indice++;
			}
		}
		return caracteristicas;
	}
	/**
	 * Esse metodo pesquisa itens de acordo com a String nomeProduto.
	 * @param nomeProduto é a chave de busca para encontrar as características
	 * de um produto desejado. 
	 * @return Um vetor de duas dimensoes contendo as caracteristicas 
	 * de produtos cujos nomes sao iguais as chave de pesquisa.
	 */
	public String[][] pesquisaItens(String nomeProduto){
		int k = 0;
		String[][] todosProdutos = this.getCaracteristicasPrincipais();
		String[][] produtos = new String[empresa.getQtdFiliais()][];
		String[][] prod;
		for(int i = 0; i < todosProdutos.length; i++) {
			if(todosProdutos[i][0].equalsIgnoreCase(nomeProduto)) {
				for(int j = 0; j < 5; j++) {
					produtos[k] = todosProdutos[i];
				}
				k++;
			}
		}
		prod = new String[k][4];
		for(int l = 0; l < k; l++) {
			prod[l] = produtos[l];
		}
		return prod;
	}
	/**
	 * Esse metodo busca as caracteristicas do único produto cujo 
	 * nome e filial se igualam aos parametros dados.
	 * @param nomeProduto Primeira chave de pesquisa.
	 * @param nomeFilial Segunda chave de pesquisa.
	 * @return Um vetor com as características do produto.
	 */
	public String[] buscarItem(String nomeProduto, String nomeFilial) { 
		
		String[] p = null;
		
		for (int i = 0; i < empresa.getQtdFiliais(); i++) {
			
			Produto[] produto = filiais[i].getProduto();
			
			for(int c = 0; i < empresa.getQtdFiliais(); c++) {
				if(produto[c] == null) {
					break;
					
				} else if(produto[c].getNome().equals(nomeProduto) && 
						produto[c].getFilial().getNomeCidade().equals(nomeFilial)) {
					
					p = new String[10];
					
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
					p[9] = String.valueOf(produto[c].getIndice());
					break;
				}
			}
		}
		return p;
	}
	
}//Fim da classe ControleEmpresa
