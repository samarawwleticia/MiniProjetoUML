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
		
		empresa.buscarFilial("lugar1").adcItem(new UtilidadesDomesticas("mouse", 100, 20, empresa.buscarFilial("lugar1"), "Ele é wireless!", "Plastico duro", "Corsair", "Meu mouse."));
		empresa.buscarFilial("lugar1").adcItem(new Vestuario("blusa", 60, 10, empresa.buscarFilial("lugar1"), "preta basica", 7, "helicoptero" ));
		empresa.buscarFilial("lugar2").adcItem(new Vestuario("calça", 100, 7,  empresa.buscarFilial("lugar2"),"sarja", 42, "unissex" ));
		empresa.buscarFilial("lugar2").adcItem(new UtilidadesDomesticas("teclado", 120, 10,  empresa.buscarFilial("lugar2"),"sarja", "42", "unissex", "Aperta e faz barulho." ));
		empresa.buscarFilial("lugar3").adcItem(new Alimentacao("Leite", 5, 10,  empresa.buscarFilial("lugar3"),"blablabla", 7, false));
		empresa.buscarFilial("lugar3").adcItem(new Alimentacao("caderno", 40, 13, empresa.buscarFilial("lugar3"), "blablabla", 7, false));
	}

	//public DefaultListModel<String> getNomesFiliais() {
    //    DefaultListModel<String> model = new DefaultListModel<>();
        
    //    for (Filial filial : filiais) {
    //        model.addElement(filial.getNomeCidade());
     //   }
        
  //      return model;
  //  }
	
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
			if(todosProdutos[i][0].equals(nomeProduto)) {
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
		
		for (int i = 0; i < filiais.length; i++) {
			
			if(filiais[i] == null) {
				break;
			}
			
			Produto[] produto = filiais[i].getProduto();
			
			for(int c = 0; i < produto.length; c++) {
				if(produto[c] == null) {
					break;
				} else if(produto[c].getNome().equals(nomeProduto) && 
						produto[c].getFilial().getNomeCidade().equals(nomeFilial)) {
					p = new String[6];
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
	
}
