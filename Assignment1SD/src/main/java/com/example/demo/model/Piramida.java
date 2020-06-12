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
@Table(name = "piramida")
public class Piramida extends Poliedru implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "piramida_id")
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

	public Piramida(double l, double h) {
		super();
		this.l = l;
		this.h = h;
	}

	@Override
	public double arieLaterala() {
		// TODO Auto-generated method stub
		double ap = Math.sqrt(this.h * this.h + (this.l / 2) * (this.l / 2));
		return (4 * this.l * ap) / 2;
	}

	@Override
	public double arieBaza() {
		// TODO Auto-generated method stub
		return this.l * this.l;
	}

	@Override
	public double arieTotala() {
		// TODO Auto-generated method stub
		return this.arieBaza() + this.arieLaterala();
	}

	@Override
	public double Volum() {
		// TODO Auto-generated method stub
		return (this.arieBaza() * this.h) / 3;
	}

	@Override
	public ArrayList<Punct> calcularePuncte(ArrayList<Punct> list) {
		ArrayList<Punct> puncte = new ArrayList<Punct>();
		Punct p1 = list.get(0);
		Punct p2 = list.get(1);
		Punct p5 = list.get(2);
		int dist = list.get(0).getY() - list.get(1).getY();
		int distanta = (int) list.get(0).distanta(list.get(1));
		Punct p4 = new Punct(list.get(0).getX() - dist+distanta/2, list.get(0).getY() - distanta/2, ' ');
		Punct p3 = new Punct(list.get(1).getX() - dist+distanta/2, list.get(1).getY() - distanta/2, ' ');
		p5.setX((p1.getX()+p3.getX())/2);
		puncte.add(p1);
		puncte.add(p2);
		puncte.add(p3);
		puncte.add(p4);
		puncte.add(p5);
		puncte.add(p1);
		puncte.add(p2);
		puncte.add(p5);
		puncte.add(p3);
		puncte.add(p4);
		return puncte;
	}

}
