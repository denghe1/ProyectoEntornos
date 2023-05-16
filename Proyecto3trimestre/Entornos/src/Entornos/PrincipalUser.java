package Entornos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PrincipalUser extends JFrame implements ActionListener {
private JMenuBar mb = new JMenuBar();
private JMenu menu1 = new JMenu("Libros");
private JMenu menu2 = new JMenu("Peliculas");
private JMenu menu3 = new JMenu("Musica");
private JMenu menu4 = new JMenu("Documentales");
private JMenu menu5 = new JMenu("Salir");





//JMenu lib = new JMenu("Libros");
	JMenuItem Tlib = new JMenuItem("Todos los Libros");
	JMenuItem Ltitulo = new JMenuItem("Consultar por titulo");
	JMenuItem Lautor = new JMenuItem("Consultar por autor");
//JMenu pel = new JMenu("Peliculas");
	JMenuItem Tpel = new JMenuItem("Todas las Peliculas");
	JMenuItem Ptitulo = new JMenuItem("Consultar por titulo");
	JMenuItem Pautor = new JMenuItem("Consultar por autor");
//JMenu mus = new JMenu("Musica");
	JMenuItem Tmus = new JMenuItem("Toda la musica");
	JMenuItem Mtitulo = new JMenuItem("Consultar por titulo");
	JMenuItem Mautor = new JMenuItem("Consultar por autor");
//JMenu doc = new JMenu("Documentales");
	JMenuItem Tdoc = new JMenuItem("Todos los documentales");
	JMenuItem Dtitulo = new JMenuItem("Consultar por titulo");
	JMenuItem Dautor = new JMenuItem("Consultar por autor");
	JMenuItem sal = new JMenuItem("Salir");








public static void main(String[] ar) {
	PrincipalUser formulario1 = new PrincipalUser();
formulario1.setBounds(150, 150, 1000, 500);
formulario1.setTitle("Gestion documental");
formulario1.setVisible(true);
formulario1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}






public PrincipalUser() {
setJMenuBar(mb);
mb.add(menu1);
mb.add(menu2);
mb.add(menu3);
mb.add(menu4);
mb.add(menu5);



		
		

	Tlib.addActionListener(this);
	menu1.add(Tlib);
	Ltitulo.addActionListener(this);
	menu1.add(Ltitulo);
	Lautor.addActionListener(this);
	menu1.add(Lautor);

	Tpel.addActionListener(this);
	menu2.add(Tpel);
	Ptitulo.addActionListener(this);
	menu2.add(Ptitulo);
	Pautor.addActionListener(this);
	menu2.add(Pautor);

	Tmus.addActionListener(this);
	menu3.add(Tmus);
	Mtitulo.addActionListener(this);
	menu3.add(Mtitulo);
	Mautor.addActionListener(this);
	menu3.add(Mautor);

	Tdoc.addActionListener(this);
	menu4.add(Tdoc);
	Dtitulo.addActionListener(this);
	menu4.add(Dtitulo);
	Dautor.addActionListener(this);
	menu4.add(Dautor);
sal.addActionListener(this);
menu5.add(sal);


}

public void actionPerformed(ActionEvent e) {
	

		if (e.getSource() == Tlib) {
			LibrosUser dlib = new LibrosUser();
			dlib.setBounds(300, 200, 1000, 500);
			dlib.setTitle("Todos los Libros");
			dlib.setVisible(true);
			dlib.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		if (e.getSource() == Ltitulo) {
			Ltitulo Ltit = new Ltitulo();
			Ltit.setBounds(300, 200, 1000, 500);
			Ltit.setTitle("Consultar por titulo");
			Ltit.setVisible(true);
			Ltit.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		if (e.getSource() == Lautor) {
			Lautor Laut = new Lautor();
			Laut.setBounds(300, 200, 1000, 500);
			Laut.setTitle("Consultar por autor");
			Laut.setVisible(true);
			Laut.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}

		if (e.getSource() == Tpel) {
			PeliculasUser dpel = new PeliculasUser();
			dpel.setBounds(300, 200, 1000, 500);
			dpel.setTitle("Todas las Peliculas");
			dpel.setVisible(true);
			dpel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		if (e.getSource() == Ptitulo) {
			Ptitulo Ptit = new Ptitulo();
			Ptit.setBounds(300, 200, 1000, 500);
			Ptit.setTitle("Consultar por titulo");
			Ptit.setVisible(true);
			Ptit.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		if (e.getSource() == Pautor) {
			Pautor Paut = new Pautor();
			Paut.setBounds(300, 200, 1000, 500);
			Paut.setTitle("Consultar por autor");
			Paut.setVisible(true);
			Paut.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}

		if (e.getSource() == Tmus) {
			MusicaUser dmus = new MusicaUser();
			dmus.setBounds(300, 200, 1000, 500);
			dmus.setTitle("Todas");
			dmus.setVisible(true);
			dmus.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		if (e.getSource() == Mtitulo) {
			Mtitulo Mtit = new Mtitulo();
			Mtit.setBounds(300, 200, 1000, 500);
			Mtit.setTitle("Consultar por titulo");
			Mtit.setVisible(true);
			Mtit.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		if (e.getSource() == Mautor) {
			Mautor Maut = new Mautor();
			Maut.setBounds(300, 200, 1000, 500);
			Maut.setTitle("Consultar por autor");
			Maut.setVisible(true);
			Maut.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
	
		if (e.getSource() == Tdoc) {
			DocumentalesUser ddoc = new DocumentalesUser();
			ddoc.setBounds(300, 200, 1000, 500);
			ddoc.setTitle("Todas");
			ddoc.setVisible(true);
			ddoc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		if (e.getSource() == Dtitulo) {
			Dtitulo Dtit = new Dtitulo();
			Dtit.setBounds(300, 200, 1000, 500);
			Dtit.setTitle("Consultar por titulo");
			Dtit.setVisible(true);
			Dtit.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		if (e.getSource() == Dautor) {
			Dautor Daut = new Dautor();
			Daut.setBounds(300, 200, 1000, 500);
			Daut.setTitle("Consultar por autor");
			Daut.setVisible(true);
			Daut.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
	
	
	
if (e.getSource() == sal) {
 JOptionPane.showMessageDialog(null, "FIN DEL PROGRAMA");
System.exit(0);
	}

}

}