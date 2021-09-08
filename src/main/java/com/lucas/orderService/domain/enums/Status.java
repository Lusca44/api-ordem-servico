package com.lucas.orderService.domain.enums;

public enum Status {

	ABERTO(0, "ABERTO"), ANDAMENTO(1, "ANDAMENTO"), ENCERRADO(2, "ENCERRADO");

	private int code;
	private String descricao;

	private Status(int code, String descricao) {
		this.code = code;
		this.descricao = descricao;
	}

	public Integer getCode() {
		return code;
	}

	public String getDescricao() {
		return descricao;
	}

	public static Status toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (Status x : Status.values()) {
			if (cod.equals(x.getCode())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Status Inválido" + cod);
	}
}
