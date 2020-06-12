package com.example.demo.controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import org.kodejava.example.view.DrawGeneralPath;

import com.example.demo.fisiere.Fisier;
import com.example.demo.model.Poliedru;
import com.example.demo.model.Punct;
import com.example.demo.model.Specificatii;



public class SalveazaFiguraListener implements ActionListener {

	private Specificatii specificatii;

	public SalveazaFiguraListener(Specificatii specificatii) {
		this.specificatii = specificatii;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String numeFisier = new String();
		JFileChooser fileChooser = new JFileChooser();
		StringBuilder sb = new StringBuilder();
		if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			numeFisier = selectedFile.getAbsolutePath();
		}
		
		
		Fisier f = new Fisier(numeFisier);
		try {
			System.out.println(specificatii.toString());
			f.salvareFigura(specificatii);
			JOptionPane.showMessageDialog(null, "Figura Salvata", "Salvare figura", JOptionPane.INFORMATION_MESSAGE);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
