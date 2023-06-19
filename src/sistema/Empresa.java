package sistema;

public class Empresa {
	
	// Atributos
	private String razaoSocial;
	private String cnpj;
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
	
	public void adcFilial(Filial filial) {
		for (int i = 0; i < numMaxFiliais - 1; i++) {
			if (this.filial[i] == null) {
				this.filial[i] = filial;
				break;
			} else if (this.filial[i].equals(filial)) {
					break;
			}
		}
	}
	
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
					}
			}
		}
	}
	
	public void listarItensGeral() {
		for (int i = 0; i < numMaxFiliais; i++) {
			if (filial[i] == null) {
				break;
			} else {
				filial[i].listarItens();
			}
		}
	}
	
	public Filial buscarFilial(String nomeFilial) {
		Filial fil = null;
		for(Filial f: filial) {
			if (f == null) {
				break;
			} else if (f.getNomeCidade() == nomeFilial) {
				fil = f;
				break;
			}
		}
		return fil;
	}
	
	public Produto buscarItemGeral(String nomeProduto) { 
		Produto p = null;
		
		for (int i = 0; i < numMaxFiliais; i++) {
			
			if(filial[i] == null) {
				break;
			}
			
			Produto[] produto = filial[i].getProduto();
			
			for(int c = 0; i < filial[i].getProduto().length; c++) {
				if(produto[c] == null) {
					break;
				} else if(produto[c].nome == nomeProduto) {
					p = produto[c];
					break;
				}
			}
		}
		return p;
	}
	
	public String[] obterNomesCidades() {
		String[] nomes = new String[26];
		int i;
		for(i = 0; i < numMaxFiliais; i++) {
			if (filial[i] == null) {
				break;
			} else {
				nomes[i] = filial[i].getNomeCidade();
			}
		}
		String[] listaNomes = new String[i];
		for(int c = 0; c < i; c++) {
			listaNomes[c] = nomes[c];
		}
		return listaNomes;
	}
	
	@Override
	public String toString() {
		return "Razão Social: " + razaoSocial + ", CNPJ: " + cnpj;
	}
	
} // Fim da classe Empresa
