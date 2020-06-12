package com.example.demo.fisiere;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.example.demo.model.Specificatii;

public class Fisier {

	private String numeFisier;
	
	public Fisier(String numeFisier) {
		this.numeFisier = numeFisier;
	}

	public boolean salvareFigura(Specificatii e) throws FileNotFoundException, IOException {
		ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(numeFisier));
		// Srie figura in fisier
		System.out.println("======="+e.toString());
		o.writeObject(e);
		o.close();
		return true;
	}

	public Specificatii getFigura() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream o = new ObjectInputStream(new FileInputStream(numeFisier));
 
		// Read perfumes
		Specificatii specificatii = (Specificatii) o.readObject();

		o.close();
		return specificatii;

	}
}

