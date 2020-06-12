package View;


import Model.Punct;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClickListener implements MouseListener {
	private JFrame frame;
	private static ArrayList<Punct> puncte;
	
	public ClickListener() {
		super();		
		// TODO Auto-generated constructor stub
	}
	public ClickListener(Object o) {
		super();		
		puncte=new ArrayList<Punct>();
		// TODO Auto-generated constructor stub
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("Mouse exist  "+e.getX()+" " +e.getY());
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		//System.out.println("Mouse exist  "+e.getX()+" " +e.getY());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Mouse click  "+e.getX()+" " +e.getY());
		
		Punct p=new Punct(e.getX(),e.getY(),' ');
		puncte.add(p);
		System.out.println(puncte.size());
			
		
	}

	public ArrayList<Punct> getPuncte() {
		return puncte;
	}

	public void update() {
		puncte.removeAll(getPuncte());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//System.out.println("Mouse released  "+e.getX()+" " +e.getY());
	}

}
