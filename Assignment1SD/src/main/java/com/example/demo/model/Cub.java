package com.example.demo.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cub")
public class Cub extends Poliedru implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "cub_id")
	private int id;
	
	@Column(name = "latura")
	private double l;
	
	public double getL() {
		return l;
	}

	public void setL(double l) {
		this.l = l;
	}

	public Cub(double l) {
		super();
		this.l = l;
	}

	@Override
	public double arieLaterala() {
		
		return 4*this.arieBaza();
	}

	@Override
	public double arieBaza() {
		// TODO Auto-generated method stub
		return this.l*this.l;
	}

	@Override
	public double arieTotala() {
		// TODO Auto-generated method stub
		return 6*this.arieBaza();
	}

	@Override
	public double Volum() {
		// TODO Auto-generated method stub
		return this.l*this.l*this.l;
	}

	@Override
	public ArrayList<Punct> calcularePuncte(ArrayList<Punct> list) {
		ArrayList<Punct> puncte = new ArrayList<Punct>();
		Punct p1=list.get(0);
		Punct p2=list.get(1);
		int dist = list.get(0).getY() - list.get(1).getY();
		int distanta=(int) list.get(0).distanta(list.get(1));
		Punct p4 = new Punct(list.get(0).getX() - dist,list.get(0).getY() -distanta, ' ');
		Punct p3 = new Punct(list.get(1).getX() - dist,list.get(1).getY() - distanta, ' ');
		Punct p5=new Punct(2*distanta/5+p4.getX(),p4.getY()-2*distanta/5,' ');
		Punct p6=new Punct(2*distanta/5+p3.getX(),p3.getY()-2*distanta/5,' ');
		Punct p7=new Punct(2*distanta/5+p2.getX(),p2.getY()-2*distanta/5,' ');
		Punct p8=new Punct(2*distanta/5+p1.getX(),p1.getY()-2*distanta/5,' ');
		puncte.add(p1);
		puncte.add(p2);
		puncte.add(p7);
		puncte.add(p8);
		puncte.add(p5);
		puncte.add(p4);
		puncte.add(p3);
		puncte.add(p6);
		puncte.add(p5);
		puncte.add(p8);
		puncte.add(p7);
		puncte.add(p6);
		puncte.add(p3);
		puncte.add(p2);
		puncte.add(p1);
		puncte.add(p4);
		puncte.add(p5);
		puncte.add(p8);
		return puncte;
	}

}
