package com.paulo.lab3;

/**
 * Representa os n�meros de telefone de um contato.
 * Todo telefone possui c�digo do pa�s, ddd, n�mero e o tipo de telefone.
 * 
 * @author Paulo Mendes da Silva J�nior - 117210922
 */
public class Telefone {
	
	/**
	 * Representa o c�digo do pa�s do n�mero de telefone
	 */
	private String codigoPais;
	
	/**
	 * Representa o ddd do estado do n�mero de telefone ex: (83)
	 */
	private String ddd;
	
	/**
	 * Representa o n�mero de telefone ex: (8845-9039)
	 */
	private String numero;
	
	/**
	 * Tipo do telefone (CELULAR, TRABALHO ou CASA)
	 */
	private String tipo;
	
	/**
	 * Constr�i um telefone a partir do c�digo do pa�s, ddd, n�mero de telefone e tipo.
	 * 
	 * @param codigoPais : c�digo do pa�s ex: (+55)
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
	 * Retorna o c�digo do pa�s.
	 * 
	 * @return
	 */
	public String getCodigoPais() {
		return codigoPais;
	}

	/**
	 * Altera o c�digo do pa�s a partir do novo c�digo.
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
	 * Retorna o n�mero de telefone.
	 * 
	 * @return
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * Altera o n�mero de telefone a partir da passagem do novo n�mero.
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
	 * Retorna a representa��o String de um objeto do tipo telefone.
	 * A sa�da atende ao seguinte formato: (CODIGO DDD NUMERO - TIPO)
	 */
	public String toString() {
		return String.format("%s %d %s - TIPO: %s", getCodigoPais(), getDdd(), getNumero(), getTipo());
	}
	
}
