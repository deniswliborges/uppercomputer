package com.deniswillian.uppercomputer.enums;


public enum TipoFuncionario {

	DESENVOLVEDOR(1,"DEV"),
	ANAL_BANCO_DADOS(2,"DBA"),
	ANAL_NEGOCIO(3,"BI"),
	GER_PROJETO(4,"MANAGER_PROJECT");

	private Integer cod;
	private String descricao;
	
	
	private TipoFuncionario(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoFuncionario toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for(TipoFuncionario x : TipoFuncionario.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: "+cod);
	}
	
	
	
	
}
