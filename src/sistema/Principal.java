package sistema;

public class Principal {

	public static void main(String[] args) {
	
		
		Produto p1 = new Alimentacao("Melão", 3.45, 43, true);
		Alimentacao p2 = new Alimentacao("Costela", 14.23, 21, false);
		Alimentacao p3 = new Alimentacao("Leite", 5.5, 17, false);
		
		System.out.println(p1.getNome());
		System.out.println(p2.getNome());
		System.out.println(p3.getNome());
		
		//System.out.println(p1.getPeso());
		System.out.println(p2.getPeso());
		System.out.println(p3.getQuantidade());
		
		//Produto p3 = new Alimentacao("sds", 2.4, 23, "dhfhdfuhd");
		
		
	}
}
