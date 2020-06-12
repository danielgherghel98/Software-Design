package Model;

import java.io.Serializable;
import java.util.ArrayList;



public class TrunchiPiramida extends Poliedru implements Serializable{

	public TrunchiPiramida() {
		super();
		// TODO Auto-generated constructor stub
	}

	private int id;
	private double l;
	private double L;
	private double h;
	public TrunchiPiramida(double l, double l2, double h) {
		super();
		this.l = l;
		L = l2;
		this.h = h;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getLMic() {
		return l;
	}

	public void setLMic(double l) {
		this.l = l;
	}

	public double getL() {
		return L;
	}

	public void setL(double l) {
		L = l;
	}

	public double getH() {
		return h;
	}

	public void setH(double h) {
		this.h = h;
	}

	@Override
	public double arieLaterala() {
		// TODO Auto-generated method stub
		double ab=this.L-this.l;
		double at=Math.sqrt(this.h*this.h+ab*ab);
		double p=4*this.l;
		double P=4*this.l;
		return (P+p)*at/2;
	}

	@Override
	public double arieBaza() {
		// TODO Auto-generated method stub
		return this.L*this.L;
	}

	public double arieBazaMica() {
		return this.l*this.l;
	}

	
	@Override
	public double arieTotala() {
		// TODO Auto-generated method stub
		return this.arieBaza()+this.arieBazaMica()+this.arieLaterala();
	}

	@Override
	public double Volum() {
		// TODO Auto-generated method stub
		return (this.h*(this.arieBaza()+this.arieBazaMica()+Math.sqrt(this.arieBaza()*this.arieBazaMica())))/3;
	}

	@Override
	public ArrayList<Punct> calcularePuncte(ArrayList<Punct> list) {
		ArrayList<Punct> puncte = new ArrayList<Punct>();
		Punct p1=list.get(0);
		Punct p2=list.get(1);
		int dist = list.get(0).getY() - list.get(1).getY();
		int distanta=(int) list.get(0).distanta(list.get(1));
		Punct p4 = new Punct(p1.getX() - dist + distanta/4,p1.getY() -2*distanta/5, ' ');
		Punct p3 = new Punct(p2.getX() - dist - distanta/4,p2.getY() -2*distanta/5, ' ');
		Punct p5=new Punct(distanta/3+p4.getX(),p4.getY()-distanta/3,' ');
		Punct p6=new Punct(distanta/3+p3.getX(),p3.getY()-distanta/3,' ');
		Punct p7=new Punct(distanta/3+p2.getX(),p2.getY()-distanta/3,' ');
		Punct p8=new Punct(distanta/3+p1.getX(),p1.getY()-distanta/3,' ');
		puncte.add(p1);
		puncte.add(p2);
		puncte.add(p7);
		puncte.add(p8);
		puncte.add(p5);
		puncte.add(p4);
		puncte.add(p3);
		puncte.add(p6);
		puncte.add(p5);
		puncte.add(p8);
		puncte.add(p7);
		puncte.add(p6);
		puncte.add(p3);
		puncte.add(p2);
		puncte.add(p1);
		puncte.add(p4);
		puncte.add(p5);
		puncte.add(p8);
		return puncte;
	}

}
