
package org.kodejava.example.view;

import javax.swing.*;

import com.example.demo.controller.Controller;
import com.example.demo.controller.DeschideFiguraListener;
import com.example.demo.controller.SalveazaFiguraListener;
import com.example.demo.model.Poliedru;
import com.example.demo.model.Punct;
import com.example.demo.model.Specificatii;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;

public class DrawGeneralPath extends JPanel{
	
	private String numeFisier;

	private GeneralPath path;
	ArrayList<Punct> puncte = new ArrayList<Punct>();

	public DrawGeneralPath(JFrame frame, ArrayList<Punct> puncte) {
		super();
		this.puncte = puncte;
	}

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		// Draw another path, a start
		g2.setStroke(new BasicStroke(4.0f));
		g2.setPaint(Color.BLUE);
		path = new GeneralPath(GeneralPath.WIND_NON_ZERO);
		path.moveTo(puncte.get(0).getX(), puncte.get(0).getY());
		//puncte.remove(0);
		//System.out.println("Lista :" + puncte.size());
		for (Punct p : puncte) {
			path.lineTo(p.getX(), p.getY());
			//System.out.print(p.getX() + "  " + p.getY() + ",  ");
		}

		path.closePath();
		g2.draw(path);

	}

	

	public class MouseHandler implements MouseMotionListener{
		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			System.out.println(e.getX() + " " + e.getY());

		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			

		}
	}

	public String getNumeFisier() {
		return numeFisier;
	}

	public void setNumeFisier(String numeFisier) {
		this.numeFisier = numeFisier;
	}
	
	


}
