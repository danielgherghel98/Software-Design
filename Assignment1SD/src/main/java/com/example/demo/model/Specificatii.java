package com.example.demo.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Specificatii  implements Serializable{

	Poliedru p;
	ArrayList<Punct> puncte = new ArrayList<Punct>();
	
	
	public Specificatii() {}

	public Specificatii(Poliedru p, ArrayList<Punct> puncte) {
		super();
		this.p = p;
		this.puncte = puncte;
	}
	
	public Poliedru getP() {
		return p;
	}
	public void setP(Poliedru p) {
		this.p = p;
	}
	public ArrayList<Punct> getPuncte() {
		return puncte;
	}
	public void setPuncte(ArrayList<Punct> puncte) {
		this.puncte = puncte;
	}

	@Override
	public String toString() {
		return "Specificatii [p=" + p + ", puncte=" + puncte + "]";
	}
	
	
	
}
