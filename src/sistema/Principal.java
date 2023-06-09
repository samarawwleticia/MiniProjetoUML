package sistema;

public class Principal {

	public static void main(String[] args) {
		Empresa e1 = new Empresa("Comercio geral ltda", "12.345.678/0001-23");
		
		/*Filial f1 = e1.gerarFilial("Taguatinga");
		
		Alimentacao p1 = new Alimentacao("Leite", 5.5, 17, f1, "Leitinho de vaca pra sua família!", 1, false);

		System.out.println(e1.toString());
		System.out.println(f1.toString());
		
		System.out.printf("%s %8s %n", "Nome", "Quantidade" );
		
		System.out.println(p1.toString());
		
		p1.setEntrada(5);
		p1.setEntrada(-3);
		*/
		
		e1.buscarFilial("Riacho Fundo").adcItem(new Vestuario("blusa", 60, 10, "preta basica", 7, "helicoptero" ));
		e1.buscarFilial("Riacho Fundo").adcItem(new Vestuario("calça", 100, 7,"sarja", 42, "unissex" ));
		e1.buscarFilial("Riacho Fundo").adcItem(new Alimentacao("Leite", 5, 1, "blablabla", 7, false));
		
		e1.buscarFilial("Riacho Fundo").listarItens();
		e1.listarItensGeral();	
		
		String[] string = e1.buscarFilial("Riacho Fundo").obterNomes();
		
		for(String s: string) { // Imprime os valores, é só pra testar se o método de pegar os nomes deu certo.
			if(s == null){
				break;
			} else {
				System.out.println(s);
			}
		}
		

	}
}
