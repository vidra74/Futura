package com.example.livescorer;

public class Podaci {
	private int ID;
	private String Podatak;
	
	public Podaci(){
		ID = 1;
	}

	public String getPodatak() {
		return Podatak;
	}

	public void setPodatak(String strPodaci) {
		Podatak = strPodaci;
	}

	public int getID() {
		return ID;
	}
	
	

}
