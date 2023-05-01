package sistema;

public class Principal {

	public static void main(String[] args) {
		
		
		
		Empresa e1 = new Empresa("Comercio geral ltda", "12.345.678/0001-23");
		
		Filial f1 = e1.gerarFilial("Taguatinga");
		
		Alimentacao p1 = new Alimentacao("Leite", 5.5, 17, f1, "Leitinho de vaca pra sua família!", 1, false);

		System.out.println(e1.toString());
		System.out.println(f1.toString());
		
		System.out.printf("%s %8s %n", "Nome", "Quantidade" );
		
		System.out.println(p1.toString());
		
		p1.setEntrada(5);
		p1.setEntrada(-3);
		
		System.out.println(p1.getQuantidade());
		
		p1.setSaida(3);
		
		System.out.println(p1.getQuantidade());
	}
}
