package ClientSocket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import Controller.DeschideFiguraListener;
import Controller.Limba;
import Controller.SalveazaFiguraListener;
import View.MainView;


/**
 * This class implements java socket client
 * 
 * @author pankaj
 *
 */
public class SocketClient {

	public static void main(String[] args)
			throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException {
		// get the localhost IP address, if server is running on some other IP, you need
		// to use that
		InetAddress host = InetAddress.getLocalHost();
		Socket socket = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		MainView c=new MainView();
		
		Limba limba=new Limba();
		DeschideFiguraListener d=new DeschideFiguraListener();
		SalveazaFiguraListener s=new SalveazaFiguraListener();
		limba.RegisterObserver(c);
		
		c.run(oos,ois,socket);
		
		
		//ois.close();
		//oos.close();
		Thread.sleep(100);

	}
}
