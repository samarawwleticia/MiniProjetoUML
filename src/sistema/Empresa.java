package sistema;

public class Empresa {
	
	private String razaoSocial;
	private String cnpj;
	
	Empresa(String razaoSocial, String cnpj){
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
	}
	
	public String obterNome(Empresa empresa) {
		return this.razaoSocial;
	}
	public String cnpj(Empresa empresa) {
		return this.cnpj;
	}
}
