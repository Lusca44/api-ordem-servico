package com.lucas.orderService.domain;

import java.io.Serializable;

public class Cliente extends Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;

	public Cliente() {
	}

	public Cliente(Integer id, String nome, String cpf, String telefone) {
		super(id, nome, cpf, telefone);
	}
	
	
}
