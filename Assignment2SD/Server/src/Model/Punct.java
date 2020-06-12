package Model;
import java.io.Serializable;




public class Punct extends ElementGeometric implements Serializable{

	public Punct() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Punct [x=" + x + ", y=" + y + "]";
	}

	//private int id;
	private int x;
	private int y;
	char identificator;
	
	public Punct(int x, int y, char identificator) {
		super();
		this.x = x;
		this.y = y;
		this.identificator = identificator;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public char getIdentificator() {
		return identificator;
	}
	public void setIdentificator(char identificator) {
		this.identificator = identificator;
	}
	
	public double distanta(Punct x)
	{
		return Math.sqrt((x.getX()-this.x)*(x.getX()-this.x)+(x.getY()-this.y)*(x.getY()-this.y));
	}

	@Override
	public void desenare() {
		// TODO Auto-generated method stub
		
	}
}
