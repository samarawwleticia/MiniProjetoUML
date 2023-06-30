package sistema;

public class Empresa {
	
	// Atributos
	private String razaoSocial;
	private String cnpj;
	private int qtdFiliais;
	private final int numMaxFiliais = 26;
	private Filial[] filial = new Filial[numMaxFiliais];
	
	// Construtor
	public Empresa(String razaoSocial, String cnpj){
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
	}
	
	// Métodos
	public String getRazaoSocial() {
		return this.razaoSocial;
	}
	
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	public String getCnpj() {
		return this.cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public Filial[] getFilial() {
		return filial;
	}
	
	public void setFilial(Filial[] filial) {
		this.filial = filial;
	}
	
	public int getQtdFiliais() {
		return qtdFiliais;
	}
	
	public int getNumMaxFiliais() {
		return numMaxFiliais;
	}
	
	/**
	 * Procura um item igual, se houver, o cadastro da filial 
	 * é interompido. Se não encontra uma filial igual, 
	 * adiciona a filial na primeira posição vazia. 
	 * @param filial
	 */
	public void adcFilial(Filial filial) {
		for (int i = 0; i < numMaxFiliais - 1; i++) {
			if (this.filial[i] == null) {
				this.filial[i] = filial;
				qtdFiliais++;
				break;
			} else if (this.filial[i].equals(filial)) {
					break;
			}
		}
	}
	
	/**
	 * Procura uma filial igual á do parametro, se encontra, a filial
	 * é substituida pela filial na posição seguinte, até que a ultima 
	 * filial recebe o valor nulo.
	 * @param fil
	 */
	public void excluirFilial(Filial fil) {
		for (int i = 0; i < numMaxFiliais - 1; i++) { 
			if(filial[i] == null) {
				break;
			} else if(filial[i].equals(fil)) {
					for(int c = i; c < numMaxFiliais - 1; c++) {
						if(filial[c] == null) {
							break;
						} else {
							filial[c] = filial[c+1]; 
						}
					
					}qtdFiliais--;
			}
		}
	}
	
	/**
	 * Busca a filial cujo nome seja igual ao parametro.
	 * @param nomeFilial
	 * @return Filial
	 */
	public Filial buscarFilial(String nomeFilial) {
		Filial fil = null;
		for(Filial f: filial) {
			if (f == null) {
				break;
			} else if (f.getNomeCidade().equalsIgnoreCase(nomeFilial)) {
				fil = f;
				break;
			}
		}
		return fil;
	}
	
	@Override
	public String toString() {
		return "Razão Social: " + razaoSocial + ", CNPJ: " + cnpj;
	}
	
} // Fim da classe Empresa
