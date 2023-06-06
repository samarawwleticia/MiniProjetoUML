package sistema;

public class Principal {

	public static void main(String[] args) {
			
		Empresa e1 = new Empresa("Comercio geral ltda", "12.345.678/0001-23");
		
		/* Forma antiga de declarar as coisas:
		Filial f1 = e1.gerarFilial("Taguatinga");
		Alimentacao p1 = new Alimentacao("Leite", 5.5, 17, f1, "Leite UHT integral", 1, false);
		*/
		
		// Forma nova:
		
		e1.adcFilial(new Filial("Taguatinga", e1));
		e1.adcFilial(new Filial("Riacho Fundo", e1));
		e1.adcFilial(new Filial("Gama", e1));
		
		e1.buscarFilial("Taguatinga").adcItem(new Alimentacao("melancia", 20.5, 10, "blablabla", 7, true ));
		e1.buscarFilial("Taguatinga").adcItem(new Alimentacao("melancia", 20.5, 10, "blablabla", 7, true ));
		e1.buscarFilial("Taguatinga").adcItem(new Vestuario("calça", 100, 7, "sarja", 42, "unissex" ));
		
		e1.buscarFilial("Gama").adcItem(new Alimentacao("melancia", 20.5, 10,  "blablabla", 7, true ));
		e1.buscarFilial("Gama").adcItem(new UtilidadesDomesticas("colher", 2.45, 100, "blablabla", "madeira","7", "true" ));
		e1.buscarFilial("Gama").adcItem(new UtilidadesDomesticas("Vassoura", 15, 3, "blablabla", "aço","7", "true" ));
		
		e1.buscarFilial("Riacho Fundo").adcItem(new Vestuario("blusa", 60, 10, "preta basica", 7, "helicoptero" ));
		e1.buscarFilial("Riacho Fundo").adcItem(new Vestuario("calça", 100, 7,"sarja", 42, "unissex" ));
		e1.buscarFilial("Riacho Fundo").adcItem(new Alimentacao("Leite condensado", 5, 1, "blablabla", 7, false));
		
		
	}
}
