package sistema;

public class Principal {

	public static void main(String[] args) {
	
		//Testes dos produtos
		Produto p1 = new Alimentacao("Melão", 3.45, 43, true);
		Alimentacao p2 = new Alimentacao("Costela", 14.23, 21, false);
		Alimentacao p3 = new Alimentacao("Leite", 5.5, 17, false);
		
		System.out.printf("%s %8s %n", "Nome", "Quantidade" );
		
		System.out.println(p1.toString());
		System.out.print(p2.toString());
		System.out.print(p3.toString());
		
		p3.setEntrada(5);
		p3.setEntrada(-3);
		
		System.out.println(p3.getQuantidade());
		
		p3.setSaida(3);
		
		System.out.println(p3.getQuantidade());
		//System.out.println(p1.getPeso());
		
		//Produto p3 = new Alimentacao("sds", 2.4, 23, "dhfhdfuhd");
		
		// Testes da empresa e filiais
		
		Empresa e1 = new Empresa("Comercio de aço ltda", "1111151411/00001");
		
		Filial f1 = e1.gerarFilial("Taguatinga");
		
		System.out.println(e1.toString());
		System.out.println(f1.toString());
		
	}
}
