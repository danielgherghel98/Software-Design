package com.example.demo.model;

import java.awt.Color;
import java.util.ArrayList;

public abstract class ElementGeometric {
	
	protected Color color;
	//protected Pen still;
	protected String tip;
	
	public abstract void desenare();

	public ArrayList<Punct> calcularePuncte(ArrayList<Punct> list) {
		// TODO Auto-generated method stub
		return null;
	}

}
