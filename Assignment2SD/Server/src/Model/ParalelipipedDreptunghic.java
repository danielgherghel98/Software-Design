package Model;

import java.io.Serializable;
import java.util.ArrayList;



public class ParalelipipedDreptunghic extends Poliedru implements Serializable{

	public ParalelipipedDreptunghic() {
		super();
		// TODO Auto-generated constructor stub
	}

	private int id;
	
	private double l;
	private double L;
	public ParalelipipedDreptunghic(double l, double l2) {
		super();
		this.l = l;
		L = l2;
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

	@Override
	public double arieLaterala() {
		// TODO Auto-generated method stub
		return 2*this.l*this.l+2*this.L*this.l;
	}

	@Override
	public double arieBaza() {
		// TODO Auto-generated method stub
		return this.l*this.L;
	}

	@Override
	public double arieTotala() {
		// TODO Auto-generated method stub
		return this.arieBaza()+this.arieLaterala();
	}

	@Override
	public double Volum() {
		// TODO Auto-generated method stub
		return this.L*this.l*this.l;
	}

	@Override
	public ArrayList<Punct> calcularePuncte(ArrayList<Punct> list) {
		ArrayList<Punct> puncte = new ArrayList<Punct>();
		Punct p1=list.get(0);
		Punct p2=list.get(1);
		int dist = list.get(0).getY() - list.get(1).getY();
		int distanta=(int) list.get(0).distanta(list.get(1));
		Punct p4 = new Punct(list.get(0).getX() - dist,list.get(0).getY() -distanta/2, ' ');
		Punct p3 = new Punct(list.get(1).getX() - dist,list.get(1).getY() - distanta/2, ' ');
		Punct p5=new Punct(distanta/4+p4.getX(),p4.getY()-distanta/4,' ');
		Punct p6=new Punct(distanta/4+p3.getX(),p3.getY()-distanta/4,' ');
		Punct p7=new Punct(distanta/4+p2.getX(),p2.getY()-distanta/4,' ');
		Punct p8=new Punct(distanta/4+p1.getX(),p1.getY()-distanta/4,' ');
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
