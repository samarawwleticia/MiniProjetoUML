package controle;
import sistema.*;

public class ControleEmpresa {
	
	Empresa empresa = new Empresa("Nome da Empresa", "1234567-1234/78");
	Filial[] filiais = empresa.getFilial();
	
	public ControleEmpresa(){
		empresa.adcFilial(new Filial("lugar1", empresa));
		empresa.adcFilial(new Filial("lugar2", empresa));
		empresa.adcFilial(new Filial("lugar3", empresa));
		
		empresa.buscarFilial("lugar1").adcItem(new Vestuario("mouse", 100, 20, "preta basica", 7, "helicoptero" ));
		empresa.buscarFilial("lugar1").adcItem(new Vestuario("blusa", 60, 10, "preta basica", 7, "helicoptero" ));
		empresa.buscarFilial("lugar2").adcItem(new Vestuario("calça", 100, 7,"sarja", 42, "unissex" ));
		empresa.buscarFilial("lugar2").adcItem(new Vestuario("teclado", 120, 10,"sarja", 42, "unissex" ));
		empresa.buscarFilial("lugar3").adcItem(new Alimentacao("Leite", 5, 10, "blablabla", 7, false));
		empresa.buscarFilial("lugar3").adcItem(new Alimentacao("caderno", 40, 13, "blablabla", 7, false));
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
		String[][] produtos = new String[empresa.getQtdFiliais()][4];
		for(int i = 0; i < todosProdutos.length; i++) {
			if(todosProdutos[i][0].equals(nomeProduto)) {
				for(int j = 0; j < 4; j++) {
					produtos[k][j] = todosProdutos[i][j];
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
	
}
