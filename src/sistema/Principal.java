package sistema;

public class Principal {

	public static void main(String[] args) {
			
		Empresa e1 = new Empresa("Comercio geral ltda", "12.345.678/0001-23");
		
		Filial f1 = e1.gerarFilial("Taguatinga");
		
		// Ordem dos argumentos para construtores de produtos:
		// Nome, preco, qtd, filial, descricao, *itens especificos*.
		
		Alimentacao p1 = new Alimentacao("Leite", 5.5, 17, f1, "Leite UHT integral", 1, false);
		
		System.out.println(e1.toString());
		System.out.println(f1.toString());
		System.out.println(p1.toString());
		
		p1.setEntrada(5);
		System.out.println(p1.getQuantidade());
		p1.setSaida(-3);
		System.out.println(p1.getQuantidade());
		
		Alimentacao[] a1 = new Alimentacao[3];
		
		a1[0] = new Alimentacao("Abobora", 4.7, 9, f1, "Alimento organico", 1.4, true);
		a1[1] = new Alimentacao("pao", 6.4, 28, f1, "paozinho de forma", 4.2, false);
		a1[2] = new Alimentacao("Frango", 25.56, 34, f1, "franguinho na panela", 3, false);
		
		for (int i = 0; i < a1.length; i++) {
			System.out.println(a1[i]);
		}
		
		
	}
}
