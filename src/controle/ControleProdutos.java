package controle;
import sistema.*;

public class ControleProdutos {
	
	private Filial[] filiais;
	private Produto[] produtos;
	
	public String[][] obterCaracteristicasPrincipais(Empresa e) {
		
		filiais = e.getFilial();
		produtos = e.getProdutos();
		
		int i;
		int d;
		int posicao = 0;
		for(i = 0; i < filiais.length; i++) {
			if (filiais[i] == null) {
				break;
			}
		}
		String [][] produtos = new String[(i-1)*100][4];
		String [][] temporario;
		for(int c = 0; c < (i-1); c++) {
			temporario = filiais[c].obterCaracteristicasPrincipais();
			for(d = 0; d < temporario.length; d++) {
				produtos[posicao] = temporario[d];
			}
			posicao += d;
		}
		
		return produtos;
	}//Fim do método
	
	
}
