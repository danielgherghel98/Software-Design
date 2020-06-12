package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Specificatii  implements Serializable{

	Poliedru p;
	ArrayList<Punct> puncte = new ArrayList<Punct>();
	String actiune;
	String figura;
	String numeFigura;
	
	
	public String getNumeFigura() {
		return numeFigura;
	}

	public void setNumeFigura(String numeFigura) {
		this.numeFigura = numeFigura;
	}

	public String getFigura() {
		return figura;
	}

	public void setFigura(String figura) {
		this.figura = figura;
	}

	public String getActiune() {
		return actiune;
	}

	public void setActiune(String actiune) {
		this.actiune = actiune;
	}

	public Specificatii() {}

	public Specificatii(Poliedru p, ArrayList<Punct> puncte) {
		super();
		this.p = p;
		this.puncte = puncte;
	}
	
	public Poliedru getP() {
		return p;
	}
	public void setP(Poliedru p) {
		this.p = p;
	}
	public ArrayList<Punct> getPuncte() {
		return puncte;
	}
	public void setPuncte(ArrayList<Punct> puncte) {
		this.puncte = puncte;
	}

	@Override
	public String toString() {
		return "Specificatii [p=" + p + ", puncte=" + puncte + "]";
	}
	
	
	
}
