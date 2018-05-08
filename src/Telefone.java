
public class Telefone {
	
	private String codigoPais;
	private int ddd;
	private String numero;
	private String tipo;
	
	public Telefone(String codigoPais, int ddd, String numero, String tipo) {
		this.setCodigoPais(codigoPais);
		this.setDdd(ddd);
		this.setNumero(numero);
		this.setTipo(tipo);
	}

	public String getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
	}

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String toString() {
		return String.format("%s %d %s - TIPO: %s", getCodigoPais(), getDdd(), getNumero(), getTipo());
	}
	
}
