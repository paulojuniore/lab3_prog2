package com.paulo.lab3;

/**
 * Representa os números de telefone de um contato.
 * Todo telefone possui código do país, ddd, número e o tipo de telefone.
 * 
 * @author Paulo Mendes da Silva Júnior - 117210922
 */
public class Telefone {
	
	/**
	 * Representa o código do país do número de telefone
	 */
	private String codigoPais;
	
	/**
	 * Representa o ddd do estado do número de telefone ex: (83)
	 */
	private String ddd;
	
	/**
	 * Representa o número de telefone ex: (8845-9039)
	 */
	private String numero;
	
	/**
	 * Tipo do telefone (CELULAR, TRABALHO ou CASA)
	 */
	private String tipo;
	
	/**
	 * Constrói um telefone a partir do código do país, ddd, número de telefone e tipo.
	 * 
	 * @param codigoPais : código do país ex: (+55)
	 * @param ddd : ex: (083)
	 * @param numero : ex: 98845-9039
	 * @param tipo : CELULAR, TRABALHO ou CASA 
	 */
	public Telefone(String codigoPais, String ddd, String numero, String tipo) {
		this.setCodigoPais(codigoPais);
		this.setDdd(ddd);
		this.setNumero(numero);
		this.setTipo(tipo);
	}

	/**
	 * Retorna o código do país.
	 * 
	 * @return
	 */
	public String getCodigoPais() {
		return codigoPais;
	}

	/**
	 * Altera o código do país a partir do novo código.
	 * 
	 * @param codigoPais
	 */
	public void setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
	}

	/**
	 * Retorna o ddd do telefone.
	 * 
	 * @return
	 */
	public String getDdd() {
		return ddd;
	}

	/**
	 * Altera o ddd do telefone a partir da passagem do novo ddd.
	 * 
	 * @param ddd
	 */
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	/**
	 * Retorna o número de telefone.
	 * 
	 * @return
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * Altera o número de telefone a partir da passagem do novo número.
	 * 
	 * @param numero
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * Retorna o tipo de contato.
	 * 
	 * @return
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Altera o tipo de contato a partir da passagem do novo tipo.
	 * 
	 * @param tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * Retorna a representação String de um objeto do tipo telefone.
	 * A saída atende ao seguinte formato: (CODIGO DDD NUMERO - TIPO)
	 */
	public String toString() {
		return String.format("%s %d %s - TIPO: %s", getCodigoPais(), getDdd(), getNumero(), getTipo());
	}
	
}
