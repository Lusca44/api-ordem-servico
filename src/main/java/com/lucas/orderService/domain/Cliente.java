package com.lucas.orderService.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Cliente extends Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "cliente")
	private List<OrdemServico> ordemServico = new ArrayList<>();

	public Cliente() {
	}

	public Cliente(Integer id, String nome, String cpf, String telefone) {
		super(id, nome, cpf, telefone);
	}

	public List<OrdemServico> getOrdemServico() {
		return ordemServico;
	}
}
