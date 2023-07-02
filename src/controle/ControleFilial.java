  package controle;


import sistema.*;

/**
 * Controla as filiais dentro da Empresa, com metodos para adicionar
 * excluir ou alterar Filiais.
 * @author João Pedro e Samara
 * @since 2023
 * @version 1.1
 */
public class ControleFilial {
	
	private Filial[] f;
	private int qtdFiliais;
	private static ControleEmpresa empresa;
	private Empresa sisEmpresa;
	
	/**
	 * Construtor para receber a classe ControleEmpresa, também possuí o método
	 * getFilial que está na classe Empresa e o método qtdFilials.
	 * Ambos os métodos são usados para buscar uma Filial específica e também
	 * para obter a quantidade de filiais na empresa.
	 * @param ce
	 */
	
	public ControleFilial(ControleEmpresa ce) {
		
		empresa = ce;
		this.f = ce.empresa.getFilial();
		this.qtdFiliais = ce.empresa.getQtdFiliais();
	}
	
	
	/**
	 * Metodo que busca o nome de uma Filial. Esse metodo é utilizado no botão
	 * que atualiza a lista de Filiais cadastradas.
	 * 
	 * @return String s
	 */
	
	public String[] getNomeFilial() {
		
		String[] s = new String[qtdFiliais];
		for(int i = 0; i < qtdFiliais; i++) {
		s[i] = f[i].getNomeCidade();
		}
		return s;
	}
	
	public int getQtd() {
		return qtdFiliais;
	}
	
	public void setQtd(int qtd) {
		this.qtdFiliais = qtd;
	}
	
	/**
	 * Esse metodo busca o nome de uma filial em específico. 
	 * @param i
	 * @return
	 */

	public String getNome(int i) {
		return f[i].getNomeCidade();
	}
	
	/**
	 * Esse metodo busca o local em que a Filial está armazenada e passa ela pelo método que
	 * exclui a filial, localizado no pacote Sistema na classe Empresa.
	 * @param i
	 * @return true
	 */
	public boolean excluirFilial(int i) {
		
		Filial lugar = empresa.empresa.getFilial()[i];
		
		empresa.empresa.excluirFilial(lugar);
		
		return true;
		
	}
	
	/**
	 * Recebe uma String que contem o nome da Filial a ser cadastrada e em seguida
	 * cria uma filial através do metodo adcFilial que esta localizada na classe 
	 * Empresa no pacote Filial.
	 * @param nomeFilial
	 */

	public void cadastrarFilial(String nomeFilial) {		
		
	empresa.getEmpresa().adcFilial(new Filial(nomeFilial, sisEmpresa));
		
	}
	
	/**
	 * Verifica se o nome da filial está vazia, está apenas com espaços em brancos,
	 * contém apenas números ou se tem menos que 2 caracteres.
	 * @param nomeFilial
	 * @return falso se um dos if's forem verdadeiros e true se não forem.
	 */
	public static boolean checkNome(String nomeFilial) {
		
		if (nomeFilial.isBlank() || nomeFilial.isEmpty() || nomeFilial.matches("[0-9]+")
				|| nomeFilial.length() <= 2) {
			return false;
		} else {
		return true;
		}	
	}
	
	
}
