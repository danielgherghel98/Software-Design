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



public class DeschideFiguraListener implements ActionListener {

	private JFrame frame;

	public DeschideFiguraListener(JFrame frame) {
		this.frame = frame;
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
		
		ArrayList<Punct> puncte = new ArrayList<Punct>();
		
		Fisier f = new Fisier(numeFisier);
		Specificatii s = null;
		
		try {
			s = f.getFigura();
			JOptionPane.showMessageDialog(null, "Figura importata cu succes", "Importare Figura", JOptionPane.INFORMATION_MESSAGE);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		puncte = s.getPuncte();
		Poliedru p=s.getP();
		//System.out.println(puncte);
		
		frame.getContentPane().add(new DrawGeneralPath(frame, puncte));
		frame.pack();
		frame.setSize(new Dimension(620, 730));
		frame.setVisible(true);
		
		
		frame.setLayout(null);
		

		final JTextArea text = new JTextArea();
		text.setBackground(new Color(255, 255, 255));
		text.setBounds(10, 565, 580, 90);
		text.setSize(new Dimension(580, 90));
		text.setText("Aria bazei: "+(float)p.arieBaza()+"\n"+"Aria laterala: "+(float)p.arieLaterala()+"\n"+"Aria totala: "+(float)p.arieTotala()+"\n"+"Volum: "+(float)p.Volum());
		frame.add(text);
		text.setVisible(true);

	}

}
