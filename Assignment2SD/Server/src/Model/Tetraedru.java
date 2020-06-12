package Model;
import java.io.Serializable;
import java.util.ArrayList;

public class Tetraedru extends Poliedru implements Serializable{

	public Tetraedru() {
		super();
		// TODO Auto-generated constructor stub
	}

	private int id;
	private double l;
	private double h;
	public double getH() {
		return h;
	}

	public void setH(double h) {
		this.h = h;
	}

	public double getL() {
		return l;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setL(double l) {
		this.l = l;
	}

	public Tetraedru(double l,double h) {
		super();
		this.l = l;
		this.h = h;
	}
	@Override
	public double arieLaterala() {
		// TODO Auto-generated method stub
		return 3*this.arieBaza();
	}

	@Override
	public double arieBaza() {
		// TODO Auto-generated method stub
		double a=this.l*this.l*(Math.sqrt(3)/4);
		return a;
	}

	@Override
	public double arieTotala() {
		// TODO Auto-generated method stub
		return 4*this.arieBaza();
	}

	@Override
	public double Volum() {
		// TODO Auto-generated method stub
		return this.arieBaza()*this.h/3;
	}

	@Override
	public ArrayList<Punct> calcularePuncte(ArrayList<Punct> list) {
		ArrayList<Punct> puncte = new ArrayList<Punct>();
		Punct p1 = list.get(0);
		Punct p2 = list.get(1);
		Punct p4 = list.get(2);
		int dist = list.get(0).getY() - list.get(1).getY();
		int distanta = (int) list.get(0).distanta(list.get(1));
		int inaltime=(int) Math.sqrt(distanta*distanta+(distanta/2)*(distanta/2));
		Punct p3 = new Punct((list.get(1).getX()+list.get(0).getX())/2 - dist, (list.get(1).getY()+list.get(0).getY())/2 - 2*inaltime/3, ' ');
		p4.setX((p1.getX()+p2.getX()+p3.getX())/3);
		//System.out.println("Distanta"+distanta);
		puncte.add(p1);
		puncte.add(p2);
		puncte.add(p3);
		puncte.add(p4);
		puncte.add(p2);
		puncte.add(p1);
		puncte.add(p4);
		puncte.add(p3);
		return puncte;
	}

}
