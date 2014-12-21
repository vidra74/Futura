package com.example.livescorer;

public class Klub {
	
	private String ImeKluba;
	private Integer IdKlub;
	private Integer IdSport;
	private Integer IdSavez;
	public String getImeKluba() {
		return ImeKluba;
	}
	public Integer getIdKlub() {
		return IdKlub;
	}
	public Integer getIdSport() {
		return IdSport;
	}
	public Integer getIdSavez() {
		return IdSavez;
	}
	public Klub() {
		ImeKluba = "Nepoznato";
		IdKlub = -1;
		IdSport = -1;
		IdSavez = -1;
		
	}
	
	
	

}
