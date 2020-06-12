package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import Controller.Controller;
import Controller.DeschideFiguraListener;
import Controller.IObserver;
import Controller.LanguageListener;
import Controller.LanguageListener1;
import Controller.Limba;
import Controller.SalveazaFiguraListener;
import Model.Poliedru;
import Model.Punct;
import Model.Specificatii;

public class MainView implements IObserver {

	private JFrame frame;
	private JFrame frame1;
	private JLabel mousePos;
	private JTextField numeFigura;
	private MouseAdapter adapter;
	public JComboBox shapes;
	public JComboBox limbaa;
	public JComboBox limbaa1;
	private JLabel Shape;
	private JLabel figura;
	private JLabel Limbaa;
	private JTextField numeFigura1;
	private String numeFisier;
	private JButton b1;
	private JButton b2;
	private JButton b4;
	private JLabel figura1;
	private static Specificatii s;
	JTextArea text = new JTextArea();
	Poliedru p;
	Limba limba = new Limba();

	public JComboBox getLimbaa() {
		return limbaa;
	}

	public JComboBox getLimbaa1() {
		return limbaa1;
	}

	String a = "Cub";
	String b = "Piramida";
	String c = "Trunchi Piramida";
	String d = "Prisma";
	String e = "Tetraedru";
	String f = "Paralelipiped";
	String g = "Figura";
	String h = "Nume Figura";
	String i = "Deschide Figura";
	String j = "Afiseaza";
	String k = "Salveaza";
	String l = "Aria bazei: ";
	String m = "Aria laterala: ";
	String n = "Aria totala: ";
	String o = "Volum: ";

	public MainView() {
	}

	public void run(ObjectOutputStream oos, ObjectInputStream ois, Socket socket) {

		frame1 = new JFrame("Coordonate");
		frame1.setLayout(null);
		
		MainView thisController=this;

		frame1.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 50, 610, 520);
		panel.setSize(new Dimension(610, 520));
		frame1.add(panel);
		panel.setVisible(true);

		Limbaa = new JLabel("Limba/Language/Langue");
		frame1.add(Limbaa);
		Limbaa.setBounds(10, 575, 150, 30);

		limbaa = new JComboBox<>(new String[] { "Romana", "English", "Francais" });
		limbaa.setBounds(160, 575, 90, 30);
		limbaa.setVisible(true);
		frame1.add(limbaa);
		limbaa.addActionListener(new LanguageListener(this));

		Shape = new JLabel(g);
		frame1.add(Shape);
		Shape.setVisible(true);
		Shape.setBounds(5, 10, 50, 30);

		shapes = new JComboBox<>(new String[] { a, b, c, d, e, f });
		shapes.setBounds(45, 10, 120, 30);
		frame1.add(shapes);

		figura = new JLabel(h);
		frame1.add(figura);
		figura.setBounds(170, 10, 105, 30);
		
		figura1 = new JLabel(h);

		ClickListener cl = new ClickListener(new Object());
		panel.addMouseListener(cl);

		frame1.pack();
		frame1.setSize(new Dimension(650, 660));
		frame1.setVisible(true);

		b4 = new JButton(k);
		// b1 = new JButton(i);
		// b2 = new JButton(j);

		// while (true) {
		b2 = new JButton(j);

		figura.setVisible(true);
		shapes.setVisible(true);

		numeFigura = new JTextField();
		numeFigura.setBounds(270, 10, 125, 30);
		frame1.add(numeFigura);
		numeFigura.setVisible(true);

		b2.setBounds(530, 10, 95, 30);
		frame1.add(b2);
		b2.setVisible(true);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Draw GeneralPath Demo");
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				ArrayList<Punct> puncte = new ArrayList<Punct>();
				ClickListener click = new ClickListener();
				Controller c = new Controller(click.getPuncte(), (String) shapes.getSelectedItem());
				// System.out.println((String) shapes.getSelectedItem());
				s = c.desenareFigura();
				puncte = s.getPuncte();
				p = s.getP();

				b4.setBounds(500, 525, 95, 30);
				frame.add(b4);
				b4.setVisible(true);

				
				frame.add(figura1);
				figura1.setVisible(true);
				figura1.setBounds(265, 525, 120, 30);

				numeFigura1 = new JTextField();
				numeFigura1.setBounds(370, 525, 125, 30);
				frame.add(numeFigura1);
				numeFigura1.setVisible(true);

				s.setActiune("save");
				s.setFigura((String) shapes.getSelectedItem());

				b4.addActionListener(new SalveazaFiguraListener(s, oos, ois, socket, numeFigura1));

				frame.getContentPane().add(new DrawGeneralPath(frame, puncte));
				frame.pack();
				frame.setSize(new Dimension(620, 745));
				frame.setVisible(true);

				frame.setLayout(null);

				JLabel Limbaa1 = new JLabel("Limba/Language/Langue");
				frame.add(Limbaa1);
				Limbaa1.setBounds(10, 660, 150, 30);

				limbaa1 = new JComboBox<>(new String[] { "Romana", "English", "Francais" });
				limbaa1.setBounds(160, 660, 90, 30);
				frame.add(limbaa1);
				limbaa1.addActionListener(new LanguageListener1(thisController));

				
				text.setBackground(new Color(255, 255, 255));
				text.setBounds(10, 565, 580, 90);
				text.setSize(new Dimension(580, 90));
				text.setText(l + (float) p.arieBaza() + "\n" + m + (float) p.arieLaterala() + "\n" + n
						+ (float) p.arieTotala() + "\n" + o + (float) p.Volum());
				frame.add(text);
				text.setVisible(true);
				click.update();
				
				frame.addWindowListener(new WindowAdapter() {

		            @Override
		            public void windowClosing(WindowEvent e) {
		            	//limba.RegisterObserver(thisController);
		                System.out.println("Observer deleted");
		            }

		            @Override
		            public void windowClosed(WindowEvent e) {
		                //System.out.println("A has closed");
		            }

		        });
				
			}
		});
		
		b1 = new JButton(i);
		b1.setBounds(400, 10, 125, 30);
		frame1.add(b1);
		b1.setVisible(true);
		b1.addActionListener(new DeschideFiguraListener(frame, numeFigura, shapes, oos, ois, socket));
		
		frame1.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
            	limba.RegisterObserver(thisController);
                System.out.println("Observer deleted");
            }

            @Override
            public void windowClosed(WindowEvent e) {
                //System.out.println("A has closed");
            }

        });

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		this.a = limba.curent.get(0);
		this.b = limba.curent.get(1);
		this.c = limba.curent.get(2);
		this.d = limba.curent.get(3);
		this.e = limba.curent.get(4);
		this.f = limba.curent.get(5);
		this.g = limba.curent.get(6);
		this.h = limba.curent.get(7);
		this.i = limba.curent.get(8);
		this.j = limba.curent.get(9);
		this.k = limba.curent.get(10);
		this.l = limba.curent.get(11);
		this.m = limba.curent.get(12);
		this.n = limba.curent.get(13);
		this.o = limba.curent.get(14);

		this.Shape.setText(this.g);
		this.figura.setText(this.h);
		this.figura1.setText(this.h);
		this.b2.setText(j);
		b2.setVisible(true);
		this.b4.setText(k);
		b4.setVisible(true);
		this.b1.setText(i);
		
		if(p!=null)
		{
			
			text.getText();
			text.setText("");
			text.setText(l +(float)p.arieBaza()+"\n"+m +(float)p.arieLaterala()+"\n"+n+(float)p.arieTotala()+"\n"+o+(float)p.Volum());
			text.setVisible(true);
		}

		shapes.removeAllItems();
		shapes.addItem(a);
		shapes.addItem(b);
		shapes.addItem(c);
		shapes.addItem(d);
		shapes.addItem(e);
		shapes.addItem(f);

	}
}
