package Model;

import java.io.Serializable;


public class Segment extends ElementGeometric implements Serializable{

	
	private int id;
	Punct p1;
	Punct p2;
	
	public Segment(Punct p1, Punct p2) {
		super();
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public Punct getP1() {
		return p1;
	}
	public void setP1(Punct p1) {
		this.p1 = p1;
	}
	public Punct getP2() {
		return p2;
	}
	public void setP2(Punct p2) {
		this.p2 = p2;
	}
	
	public double lungime() {
		return p1.distanta(p2);
	}

	@Override
	public void desenare() {
		// TODO Auto-generated method stub
		
	}
}
