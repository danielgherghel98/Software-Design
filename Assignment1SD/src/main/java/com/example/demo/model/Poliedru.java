package com.example.demo.model;

import java.util.ArrayList;

public abstract class Poliedru extends ElementGeometric {

	public abstract double arieLaterala();
	public abstract double arieBaza();
	public abstract double arieTotala();
	public abstract double Volum();
	public abstract ArrayList<Punct> calcularePuncte(ArrayList<Punct> list);
	
	public void desenare() {}
}
