package com.paulo.lab3;

/**
 * Representa os número de telefone de um contato.
 * Todo telefone possui código do país, ddd, número e o tipo de telefone.
 * 
 * @author Paulo Mendes da Silva Júnior - 117210922
 * 
 */
public class Telefone {
	
	/**
	 * Representa o código do país do número de telefone. ex: (+55)
	 */
	private String codigoPais;
	
	/**
	 * Representa o ddd do estado do número de telefone. ex: (83)
	 */
	private String ddd;
	
	/**
	 * Representa o número de telefone. ex: (8845-9039)
	 */
	private String numero;
	
	/**
	 * Tipo do telefone (CELULAR, TRABALHO ou CASA)
	 */
	private String tipo;
	
	/**
	 * Constrói um telefone a partir do código do país, ddd, número de telefone e tipo.
	 * Trata alguns casos específicos de valores inválidos passados ao construtor antes de criar o objeto Telefone.
	 * 
	 * @param codigoPais : código do país ex: (+55)
	 * @param ddd : ex: (083)
	 * @param numero : ex: 98845-9039 ou 988459039 ou 88459039
	 * @param tipo : (CELULAR, TRABALHO ou CASA) 
	 */
	public Telefone(String codigoPais, String ddd, String numero, String tipo) {
		if(codigoPais == null || ddd == null || numero == null || tipo == null)
			throw new NullPointerException();
		
		if(codigoPais.trim().isEmpty() || codigoPais.trim().length() < 2 || codigoPais.trim().length() > 3)
			throw new IllegalArgumentException("Código do país inválido!\n");
		
		if(ddd.trim().isEmpty() || ddd.trim().length() < 2 || ddd.trim().length() > 2)
			throw new IllegalArgumentException("DDD inválido!\n");
		
		if(numero.trim().isEmpty() || numero.trim().length() < 8 || numero.trim().length() > 10)
			throw new IllegalArgumentException("Número de telefone inválido!\n");
		
		if(tipo.trim().isEmpty() || !(tipo.equals("CASA") || tipo.equals("CELULAR") || tipo.equals("TRABALHO")))
			throw new IllegalArgumentException("Tipo de telefone inválido!\n");
		
		this.setCodigoPais(codigoPais);
		this.setDdd(ddd);
		this.setNumero(numero);
		this.setTipo(tipo);
	}

	/**
	 * Retorna o código do país.
	 * 
	 * @return : codigo do país.
	 */
	public String getCodigoPais() {
		return codigoPais;
	}

	/**
	 * Altera o código do país a partir do novo código.
	 * 
	 * @param codigoPais : código do país.
	 */
	public void setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
	}

	/**
	 * Retorna o ddd do telefone.
	 * 
	 * @return : ddd do telefone.
	 */
	public String getDdd() {
		return ddd;
	}

	/**
	 * Altera o ddd do telefone a partir da passagem do novo ddd.
	 * 
	 * @param ddd : ddd do telefone.
	 */
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	/**
	 * Retorna o número de telefone.
	 * 
	 * @return : número do telefone.
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * Altera o número de telefone a partir da passagem do novo número.
	 * 
	 * @param numero : número do telefone.
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * Retorna o tipo de contato.
	 * 
	 * @return : tipo do contato.
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Altera o tipo de contato a partir da passagem do novo tipo.
	 * 
	 * @param tipo : tipo do contato.
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * Retorna a representação String de um objeto do tipo telefone.
	 * A saída atende ao seguinte formato: (CODIGO DDD NUMERO).
	 * 
	 * @return : representação String de um objeto Telefone.
	 */
	@Override
	public String toString() {
		return String.format("%s %s %s", getCodigoPais(), getDdd(), getNumero());
	}
	
	/**
	 * Sobrescreve o método equals.
	 * Verifica se dois telefones são iguais pelo ddd e número do telefone.
	 * 
	 * @param objeto : recebe um objeto mais geral para realizar as devidas comparações.
	 * 
	 * @return : um boolean que representa se os objetos são iguais ou não.
	 */
	@Override
	public boolean equals(Object objeto) {
		if (this == objeto) {
			return true;
		}
		if (objeto == null) {
			return false;
		}
		if (objeto.getClass() != this.getClass()) {
			return false;
		}
		Telefone novoTelefone = (Telefone) objeto;
		if (this.ddd == null) {
			if (novoTelefone.getDdd() != null) {
				return false;
			}
		} else if(!this.ddd.equals(novoTelefone.getDdd())) {
			return false;
		}
		if  (this.numero == null) {
			if (novoTelefone.getNumero() != null) {
				return false;
			}
		} else if (!this.numero.equals(novoTelefone.getNumero())) {
			return false;
		}
		return true;
	}
	
}
