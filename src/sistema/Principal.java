package sistema;

public class Principal {

	public static void main(String[] args) {
	
		//Testes dos produtos
		Alimentacao p1 = new Alimentacao("Leite", 5.5, 17, "Leitinho de vaca pra sua família!", 1, false);
		
		System.out.printf("%s %8s %n", "Nome", "Quantidade" );
		
		System.out.println(p1.toString());
		
		p1.setEntrada(5);
		p1.setEntrada(-3);
		
		System.out.println(p1.getQuantidade());
		
		p1.setSaida(3);
		
		System.out.println(p1.getQuantidade());
		//System.out.println(p1.getPeso());
		
		//Produto p3 = new Alimentacao("sds", 2.4, 23, "dhfhdfuhd");
		
		// Testes da empresa e filiais
		
		Empresa e1 = new Empresa("Comercio de aço ltda", "1111151411/00001");
		
		Filial f1 = e1.gerarFilial("Taguatinga");
		
		System.out.println(e1.toString());
		System.out.println(f1.toString());
		
	}
}
