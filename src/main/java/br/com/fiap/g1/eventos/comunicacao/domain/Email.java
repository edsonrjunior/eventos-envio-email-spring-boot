package br.com.fiap.g1.eventos.comunicacao.domain;

import java.io.Serializable;

public class Email implements Serializable {

	private static final long serialVersionUID = 1L;

	private String email;

	private String nomeCliente;

	public Email(String email, String nomeCliente, Integer numeroPedido) {
		this.email = email;
		this.nomeCliente = nomeCliente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

}
