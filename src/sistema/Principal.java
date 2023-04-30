package sistema;

public class Principal {

	public static void main(String[] args) {
	
		
		Produto p1 = new Alimentacao();
		Alimentacao p2 = new Alimentacao();
		
		System.out.println(p1.getNome());
		System.out.println(p2.getNome());
		
		//System.out.println(p1.getPeso());
		System.out.println(p2.getPeso());
		
		
		
		
	}
}
