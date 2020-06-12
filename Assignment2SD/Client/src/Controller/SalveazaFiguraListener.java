package Controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Model.Specificatii;



public class SalveazaFiguraListener implements ActionListener,IObserver {

	public SalveazaFiguraListener() {
		super();
		// TODO Auto-generated constructor stub
	}


	private Specificatii specificatii;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	Socket socket1;
	JTextField numeFigura;

	public SalveazaFiguraListener(Specificatii specificatii,ObjectOutputStream oos, ObjectInputStream ois,Socket socket,JTextField numeFigura) {
		this.specificatii = specificatii;
		this.oos=oos;
		this.ois=ois;
		this.socket1=socket;
		this.numeFigura=numeFigura;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		specificatii.setNumeFigura(numeFigura.getText());
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
			oos.writeObject(specificatii);
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
	
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public JComboBox getLimbaa() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public JComboBox getLimbaa1() {
		// TODO Auto-generated method stub
		return null;
	}

}
