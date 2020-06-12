package com.example.demo.controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import org.kodejava.example.view.ClickListener;
import org.kodejava.example.view.DrawGeneralPath;

import com.example.demo.model.Poliedru;
import com.example.demo.model.Punct;
import com.example.demo.model.Specificatii;

public class ControllerPersistenta {
	
	
	private JFrame frame;
	private static JLabel mousePos;
	private static MouseAdapter adapter;
	public static  JComboBox shapes;
	private static JLabel Shape;
	private String numeFisier;
	private static Specificatii s;
	
	
	public ControllerPersistenta() {
	}


	public void run() {
		JFrame frame = new JFrame("Draw GeneralPath Demo");
		JFrame frame1 = new JFrame("Coordonate");
		frame1.setLayout(null);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		
		
		shapes = new JComboBox<>(new String[] {"Cub", "Piramida", "Trunchi Piramida","Prisma","Tetraedru","Paralelipiped" });
		shapes.setBounds(80, 10, 110, 30);
		frame1.add(shapes);
		shapes.setVisible(true);
		
		
		Shape=new JLabel("Shape: ");
		frame1.add(Shape);
		Shape.setVisible(true);
		Shape.setBounds(20, 10, 50, 30);
		
		final JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 50, 580, 520);
		panel.setSize(new Dimension(580, 520));
		frame1.add(panel);
		panel.setVisible(true);
		ClickListener c = new ClickListener();
		panel.addMouseListener(c);
		
				
		mousePos = new JLabel("( , )");
		mousePos.setBounds(20, 560, 30, 50);
		mousePos.setVisible(true);
		frame1.add(mousePos);
		
		
		frame1.pack();
		frame1.setSize(new Dimension(620, 650));
		frame1.setVisible(true);
		//panel.addMouseMotionListener(adapter);
		// puncte = click.getPuncte();
		JButton b = new JButton("Afiseaza");
		JButton b4 = new JButton("Salveaza");
		
		b.setBounds(500, 10, 95, 30);
		frame1.add(b);
		b.setVisible(true);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Punct> puncte = new ArrayList<Punct>();
				ClickListener click = new ClickListener();
				Controller c=new Controller(click.getPuncte(),(String)shapes.getSelectedItem());
				
				s=c.desenareFigura();
				puncte =s.getPuncte();
				Poliedru p=s.getP();

				b4.setBounds(500,525, 95, 30);
				frame.add(b4);
				b4.setVisible(true);
				//System.out.println(s.getPuncte());
				b4.addActionListener(new SalveazaFiguraListener(s));
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
		});
		
		

		JButton b1 = new JButton("Deschide figura");

		b1.setBounds(370, 10, 125, 30);
		frame1.add(b1);
		b1.setVisible(true);
		b1.addActionListener(new DeschideFiguraListener(frame));
		
		
		
		
	}
}
