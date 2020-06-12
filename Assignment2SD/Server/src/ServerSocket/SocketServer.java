package ServerSocket;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import Model.Cub;
import Model.ParalelipipedDreptunghic;
import Model.Piramida;
import Model.Poliedru;
import Model.Prisma;
import Model.Punct;
import Model.Specificatii;
import Model.Tetraedru;
import Model.TrunchiPiramida;
import Repository.CubRepository;
import Repository.JDBConnectionWrapper;
import Repository.ParalelipipedRepository;
import Repository.PiramidaRepository;
import Repository.PrismaRepository;
import Repository.PunctRepository;
import Repository.TetraedruRepository;
import Repository.TrunchiRepository;

/**
 * This class implements java Socket server
 * 
 * @author pankaj
 *
 */
public class SocketServer {

	// static ServerSocket variable
	private static ServerSocket server;
	// socket server port on which it will listen
	private static int port = 9876;
	private JFrame frame;
	static String stop = "";

	public static void main(String args[]) throws IOException, ClassNotFoundException {

		// create the socket server object
		server = new ServerSocket(port);
		
		JFrame frame = new JFrame("Connection");
		frame.setLayout(null);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		//JButton b = new JButton("Shut down Socket Server");
		JTextField oprire= new JTextField();
		
		JLabel text;
		text=new JLabel("Socket Server Running");
		frame.add(text);
		text.setVisible(true);
		text.setBounds(85, 10, 200, 30);
		
//		b.setBounds(50, 50, 200, 30);
//		frame.add(b);
//		b.setVisible(true);
		
		oprire.setBounds(50, 50, 200, 30);
		frame.add(oprire);
		oprire.setVisible(true);
		
		frame.pack();
		frame.setSize(new Dimension(340, 130));
		//frame.setVisible(true);
				
		// conexiune cu baza de date
		JDBConnectionWrapper con = new JDBConnectionWrapper("poliedre");
		PunctRepository pct = new PunctRepository(con);
		CubRepository cub = new CubRepository(con);
		ParalelipipedRepository ppd = new ParalelipipedRepository(con);
		PiramidaRepository pir = new PiramidaRepository(con);
		PrismaRepository pri = new PrismaRepository(con);
		TetraedruRepository tet = new TetraedruRepository(con);
		TrunchiRepository tru = new TrunchiRepository(con);
		
		
		Specificatii sout =new Specificatii(); 
		
	
		// keep listens indefinitely until receives 'exit' call or program terminates
		while (true) {
			//System.out.println("Waiting for the client request");
			// creating socket and waiting for client connection
			Socket socket = server.accept();
			ObjectOutputStream oos=null;
			// read from socket to ObjectInputStream object
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			Specificatii s = (Specificatii) ois.readObject();
			//System.out.println(s.getNumeFigura());
			switch (s.getActiune()) {
			case "save": {
				switch (s.getFigura()) {
				case "Cube":
				case "Cub": {
					Cub c=(Cub)s.getP();
					cub.save(c, s.getNumeFigura());
					pct.saveAll(s.getPuncte(), s.getNumeFigura());
					break;
				}
				case "Parallelepiped":
				case "Parallelepipede":
				case "Paralelipiped": {
					ParalelipipedDreptunghic pa=(ParalelipipedDreptunghic)s.getP();
					ppd.save(pa, s.getNumeFigura());
					pct.saveAll(s.getPuncte(), s.getNumeFigura());
					break;
				}
				case "Pyramid":
				case "Pyramide":	
				case "Piramida": {
					Piramida p=(Piramida)s.getP();
					pir.save(p, s.getNumeFigura());
					pct.saveAll(s.getPuncte(), s.getNumeFigura());
					break;
				}
				case "Prism":
				case "Prisme":
				case "Prisma": {
					Prisma pr=(Prisma)s.getP();
					pri.save(pr, s.getNumeFigura());
					pct.saveAll(s.getPuncte(), s.getNumeFigura());
					break;
				}
				case "Tetrahedron":
				case "Tetraedre":
				case "Tetraedru": {
					Tetraedru t=(Tetraedru)s.getP();
					tet.save(t, s.getNumeFigura());
					pct.saveAll(s.getPuncte(), s.getNumeFigura());
					break;
				}
				case "Pyramid Trunks":
				case "Troncs de Pyramide":
				case "Trunchi Piramida": {
					TrunchiPiramida tr=(TrunchiPiramida)s.getP();
					tru.save(tr, s.getNumeFigura());
					pct.saveAll(s.getPuncte(), s.getNumeFigura());
					break;
				}
				}
				break;
			}
			case "open": {
				switch (s.getFigura()) {
				case "Cube":
				case "Cub": {
					sout.setP(cub.find(s.getNumeFigura()));
					sout.setPuncte(pct.findAll(s.getNumeFigura()));
					oos = new ObjectOutputStream(socket.getOutputStream());
					oos.writeObject(sout);
					break;
				}
				case "Parallelepiped":
				case "Parallelepipede":
				case "Paralelipiped": {
					sout.setP(ppd.find(s.getNumeFigura()));
					sout.setPuncte(pct.findAll(s.getNumeFigura()));
					oos = new ObjectOutputStream(socket.getOutputStream());
					oos.writeObject(sout);
					break;
				}
				case "Pyramid":
				case "Pyramide":	
				case "Piramida": {
					sout.setP(pir.find(s.getNumeFigura()));
					sout.setPuncte(pct.findAll(s.getNumeFigura()));
					oos = new ObjectOutputStream(socket.getOutputStream());
					oos.writeObject(sout);
					break;
				}
				case "Prism":
				case "Prisme":
				case "Prisma": {
					sout.setP(pri.find(s.getNumeFigura()));
					sout.setPuncte(pct.findAll(s.getNumeFigura()));
					oos = new ObjectOutputStream(socket.getOutputStream());
					oos.writeObject(sout);
					break;
				}
				case "Tetrahedron":
				case "Tetraedre":
				case "Tetraedru": {
					sout.setP(tet.find(s.getNumeFigura()));
					sout.setPuncte(pct.findAll(s.getNumeFigura()));
					oos = new ObjectOutputStream(socket.getOutputStream());
					oos.writeObject(sout);
					break;
				}
				case "Pyramid Trunks":
				case "Troncs de Pyramide":
				case "Trunchi Piramida": {
					sout.setP(tru.find(s.getNumeFigura()));
					sout.setPuncte(pct.findAll(s.getNumeFigura()));
					oos = new ObjectOutputStream(socket.getOutputStream());
					oos.writeObject(sout);
					break;
				}
				}
				break;
			}
			}

			// close resources
			ois.close();
			if(oos!=null)
			{
				oos.close();
			}
			socket.close();
			if (stop.equalsIgnoreCase("exit"))
				break;
			//stop=oprire.getText();
		}
		System.out.println("Shutting down Socket server!!");
		// close the ServerSocket object
		server.close();
		
	}

}