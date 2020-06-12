package com.example.demo.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prisma")
public class Prisma extends Poliedru implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "prisma_id")
	private int id;
	
	@Column(name = "latura")
	private double l;
	@Column(name = "inaltime")
	private double h;
	public double getH() {
		return h;
	}

	public void setH(double h) {
		this.h = h;
	}

	public double getL() {
		return l;
	}

	public void setL(double l) {
		this.l = l;
	}

	public Prisma(double l,double h) {
		super();
		this.l = l;
		this.h = h;
	}

	@Override
	public double arieLaterala() {
		// TODO Auto-generated method stub
		return 3*this.l*this.h;
	}

	@Override
	public double arieBaza() {
		// TODO Auto-generated method stub
		double a=this.l*this.l*(Math.sqrt(3))/4;
		return a;
	}

	@Override
	public double arieTotala() {
		// TODO Auto-generated method stub
		return this.arieLaterala()+2*this.arieBaza();
	}

	@Override
	public double Volum() {
		// TODO Auto-generated method stub
		return this.arieBaza()*this.h;
	}

	@Override
	public ArrayList<Punct> calcularePuncte(ArrayList<Punct> list) {
		ArrayList<Punct> puncte = new ArrayList<Punct>();
		Punct p1 = list.get(0);
		Punct p2 = list.get(1);
		int dist = list.get(0).getY() - list.get(1).getY();
		int distanta = (int) list.get(0).distanta(list.get(1));
		int inaltime=(int) Math.sqrt(distanta*distanta+(distanta/2)*(distanta/2));
		Punct p3 = new Punct((list.get(1).getX()+list.get(0).getX())/2 - dist, (list.get(1).getY()+list.get(0).getY())/2 - 2*inaltime/3, ' ');
		Punct p4=new Punct(p3.getX() ,p3.getY() -distanta*3/2, ' ');
		Punct p5=new Punct(p1.getX() ,p1.getY() -distanta*3/2, ' ');
		Punct p6=new Punct(p2.getX() ,p2.getY() -distanta*3/2, ' ');
		puncte.add(p1);
		puncte.add(p2);
		puncte.add(p3);
		puncte.add(p4);
		puncte.add(p5);
		puncte.add(p6);
		puncte.add(p2);
		puncte.add(p1);
		puncte.add(p5);
		puncte.add(p6);
		puncte.add(p4);
		puncte.add(p3);
		return puncte;
	}

}
