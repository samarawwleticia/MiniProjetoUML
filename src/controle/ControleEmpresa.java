package controle;
import sistema.*;

public class ControleEmpresa {
	
	Empresa empresa = new Empresa("Nome da Empresa", "1234567-1234/78");
	Filial[] filiais = empresa.getFilial();
	
	public String[][] obterCaracteristicasPrincipais() {
		
		int i;
		int d;
		int posicao = 0;
		for(i = 0; i < empresa.getNumMaxFiliais(); i++) {
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
