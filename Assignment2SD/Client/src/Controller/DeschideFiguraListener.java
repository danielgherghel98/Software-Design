package Controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import Model.Poliedru;
import Model.Punct;
import Model.Specificatii;
import View.DrawGeneralPath;


public class DeschideFiguraListener implements ActionListener,IObserver {

	private JFrame frame;
	JTextField numeFigura;
	JComboBox shapes;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	Socket socket1;
	JComboBox limbaa;
	JLabel Limbaa;
	static JTextArea text = new JTextArea();
	static Poliedru p=null;

	Limba limba = new Limba();
	static String l = "Aria bazei: ";
	static String m = "Aria laterala: ";
	static String n = "Aria totala: ";
	static String o = "Volum: ";
	
	public DeschideFiguraListener(JFrame frame,JTextField numeFigura,JComboBox shapes,ObjectOutputStream oos, ObjectInputStream ois,Socket socket) {
		//this.frame = frame;
		this.numeFigura=numeFigura;
		this.oos=oos;
		this.ois=ois;
		this.shapes=shapes;
		this.socket1=socket;
		limba.RegisterObserver(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JFrame frame=new JFrame();
		
		ArrayList<Punct>puncte =new ArrayList<Punct>();
		Specificatii s1=new Specificatii();
		s1.setActiune("open");
		s1.setNumeFigura(numeFigura.getText());
		s1.setFigura((String)shapes.getSelectedItem());
		
		InetAddress host=null;
		try {
			host = InetAddress.getLocalHost();
		} catch (UnknownHostException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		
		Socket socket=null;
		try {
			socket = new Socket(host.getHostName(), 9876);
		} catch (UnknownHostException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		
		try {
			oos = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			oos.writeObject(s1);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		Specificatii s=null;
		try {
			ois = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			s = (Specificatii)ois.readObject();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		puncte = s.getPuncte();
		p=s.getP();
		//System.out.println(puncte.size());
		
		frame = new JFrame("Draw GeneralPath");
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		frame.getContentPane().add(new DrawGeneralPath(frame, puncte));
		frame.pack();
		frame.setSize(new Dimension(620, 745));
		frame.setVisible(true);
		
		
		frame.setLayout(null);
		
		Limbaa = new JLabel("Limba/Language/Langue");
		frame.add(Limbaa);
		Limbaa.setBounds(10, 660, 150, 30);
		
		limbaa = new JComboBox<>(
				new String[] { "Romana", "English", "Francais"});
		limbaa.setBounds(160, 660, 90, 30);
		frame.add(limbaa);
		limbaa.addActionListener(new LanguageListener(this));
		//frame.setBackground(new Color(175,175,175));

		
		text.setBackground(new Color(255, 255, 255));
		text.setBounds(10, 565, 580, 90);
		text.setSize(new Dimension(580, 90));
		text.setText(this.l +(float)p.arieBaza()+"\n"+this.m +(float)p.arieLaterala()+"\n"+this.n+(float)p.arieTotala()+"\n"+this.o+(float)p.Volum());
		frame.add(text);
		text.setVisible(true);
		try {
			ois.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			oos.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		IObserver obs=this;
		
		frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
            	limba.RegisterObserver(obs);
                System.out.println("Observer deleted");
            }

            @Override
            public void windowClosed(WindowEvent e) {
                //System.out.println("A has closed");
            }

        });

	}

	public DeschideFiguraListener() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		this.l = limba.curent.get(11);
		this.m = limba.curent.get(12);
		this.n = limba.curent.get(13);
		this.o = limba.curent.get(14);
		if(p!=null)
		{
			
			text.getText();
			text.setText("");
			text.setText(l +(float)p.arieBaza()+"\n"+m +(float)p.arieLaterala()+"\n"+n+(float)p.arieTotala()+"\n"+o+(float)p.Volum());
			text.setVisible(true);
		}
	}

	@Override
	public JComboBox getLimbaa() {
		// TODO Auto-generated method stub
		return this.limbaa;
	}

	@Override
	public JComboBox getLimbaa1() {
		// TODO Auto-generated method stub
		return null;
	}

}
