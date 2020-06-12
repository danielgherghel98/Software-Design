package com.example.demo.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "punct")
public class Punct extends ElementGeometric implements Serializable{

	@Override
	public String toString() {
		return "Punct [x=" + x + ", y=" + y + "]";
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "punct_id")
	private int id;
	
	@Column(name = "x")
	private int x;
	@Column(name = "y")
	private int y;
	@Column(name = "identificator")
	char identificator;
	
	public Punct(int x, int y, char identificator) {
		super();
		this.x = x;
		this.y = y;
		this.identificator = identificator;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public char getIdentificator() {
		return identificator;
	}
	public void setIdentificator(char identificator) {
		this.identificator = identificator;
	}
	
	public double distanta(Punct x)
	{
		return Math.sqrt((x.getX()-this.x)*(x.getX()-this.x)+(x.getY()-this.y)*(x.getY()-this.y));
	}

	@Override
	public void desenare() {
		// TODO Auto-generated method stub
		
	}
}
