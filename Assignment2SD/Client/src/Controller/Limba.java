package Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Limba implements ILanguage {
	
	private static List<IObserver> observers = new ArrayList<IObserver>();
	
	public static ArrayList<String> curent;
	public Limba() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void RegisterObserver(IObserver observer) {
		// TODO Auto-generated method stub
		observers.add(observer);
	}
	@Override
	public void RemoveObserver(IObserver observer) {
		// TODO Auto-generated method stub
		observers.remove(observer);
	}
	@Override
	public void NotifyObservers() {
		// TODO Auto-generated method stub
		for (IObserver observer : observers)
        {
            observer.update();
        }
		
	}
	public void citireFisier(String s)
	{
		try {
		      File myObj = new File(s);
		      Scanner myReader = new Scanner(myObj);
		      curent=new ArrayList<>();
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        curent.add(data);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	public void setLimba(String limba) {
		switch (limba){
		case "Romana":
			citireFisier("Romana.txt");
			NotifyObservers();
			break;
		case "English":
			citireFisier("English.txt");
			NotifyObservers();
			break;
		case "Francais":
			citireFisier("Francais.txt");
			NotifyObservers();
			break;
		}
	}
	

}
