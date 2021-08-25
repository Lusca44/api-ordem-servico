package com.lucas.orderService.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Tecnico extends Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "tecnico")
	private List<OrdemServico> ordermServico = new ArrayList<>();

	public Tecnico() {
	}

	public Tecnico(Integer id, String nome, String cpf, String telefone) {
		super(id, nome, cpf, telefone);
	}

	public List<OrdemServico> getOrdermServico() {
		return ordermServico;
	}
}
