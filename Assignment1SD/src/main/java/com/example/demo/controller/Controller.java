package com.example.demo.controller;

import java.util.ArrayList;

import com.example.demo.model.Cub;
import com.example.demo.model.ParalelipipedDreptunghic;
import com.example.demo.model.Piramida;
import com.example.demo.model.Poliedru;
import com.example.demo.model.Prisma;
import com.example.demo.model.Punct;
import com.example.demo.model.Specificatii;
import com.example.demo.model.Tetraedru;
import com.example.demo.model.TrunchiPiramida;

public class Controller {
	ArrayList<Punct> puncte = new ArrayList<Punct>();
	private String figura;

	public Controller(ArrayList<Punct> puncte, String figura) {
		super();
		this.puncte = puncte;
		this.figura = figura;
	}

	public ArrayList<Punct> getPuncte() {
		return puncte;
	}

	public void setPuncte(ArrayList<Punct> puncte) {
		this.puncte = puncte;
	}

	public String getFigura() {
		return figura;
	}

	public void setFigura(String figura) {
		this.figura = figura;
	}

	public Specificatii desenareFigura() {
		ArrayList<Punct> puncteFinal = new ArrayList<Punct>();
		switch (figura) {
		case "Cub": {
			double distanta = this.puncte.get(0).distanta(this.puncte.get(1));
			Poliedru c = new Cub(distanta);
			puncteFinal = c.calcularePuncte(this.puncte);
			Specificatii s=new Specificatii(c,puncteFinal);
			return s;
		}
		case "Paralelipiped": {
			double distanta = this.puncte.get(0).distanta(this.puncte.get(1));
			Poliedru p = new ParalelipipedDreptunghic(distanta / 2, distanta);
			puncteFinal = p.calcularePuncte(this.puncte);
			Specificatii s=new Specificatii(p,puncteFinal);
			return s;

		}
		case "Piramida": {
			double distanta = this.puncte.get(0).distanta(this.puncte.get(1));
			Piramida p = new Piramida(distanta, 0);
			puncteFinal = p.calcularePuncte(this.puncte);
			Punct mij=new Punct((puncteFinal.get(0).getX()+puncteFinal.get(2).getX())/2,(puncteFinal.get(0).getY()+puncteFinal.get(2).getY())/2,' ');
			double inaltimea=puncteFinal.get(4).distanta(mij);
			p.setH(inaltimea);
			Specificatii s=new Specificatii(p,puncteFinal);
			return s;
		}
		case "Prisma": {
			double distanta = this.puncte.get(0).distanta(this.puncte.get(1));
			Prisma p = new Prisma(distanta, 0);
			puncteFinal = p.calcularePuncte(this.puncte);
			double inaltimea=puncteFinal.get(0).distanta(puncteFinal.get(1));
			p.setH(inaltimea*3/2);
			Specificatii s=new Specificatii(p,puncteFinal);
			return s;
		}
		case "Tetraedru": {
			double distanta = this.puncte.get(0).distanta(this.puncte.get(1));
			Tetraedru p = new Tetraedru(distanta, 0);
			puncteFinal = p.calcularePuncte(this.puncte);
			Punct mij=new Punct((puncteFinal.get(0).getX()+puncteFinal.get(1).getX()+puncteFinal.get(2).getX())/3,(puncteFinal.get(0).getY()+puncteFinal.get(1).getY()+puncteFinal.get(2).getY())/3,' ');
			double inaltimea=puncteFinal.get(3).distanta(mij);
			p.setH(inaltimea);
			Specificatii s=new Specificatii(p,puncteFinal);
			return s;

		}
		case "Trunchi Piramida": {
			double distanta = this.puncte.get(0).distanta(this.puncte.get(1));
			TrunchiPiramida p = new TrunchiPiramida(distanta/2,distanta, 0);
			puncteFinal = p.calcularePuncte(this.puncte);
			//Punct mij=new Punct((puncteFinal.get(0).getX()+puncteFinal.get(2).getX())/2,(puncteFinal.get(0).getY()+puncteFinal.get(2).getY())/2,' ');
			//double inaltimea=puncteFinal.get(4).distanta(mij);
			p.setH(distanta/3);
			Specificatii s=new Specificatii(p,puncteFinal);
			return s;
		}
		}
		return null;
	}
}
