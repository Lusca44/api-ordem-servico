package com.lucas.orderService.domain;

import java.io.Serializable;

public class Tecnico extends Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;

	public Tecnico() {
	}

	public Tecnico(Integer id, String nome, String cpf, String telefone) {
		super(id, nome, cpf, telefone);
	}
	
	
}
