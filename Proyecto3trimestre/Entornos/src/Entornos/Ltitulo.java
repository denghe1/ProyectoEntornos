package Entornos;

import javax.swing.*;

import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
public class Ltitulo extends JFrame implements ActionListener {
	  private JTextField textField;
	  private JButton searchButton;
	  private JTextArea resultsArea;

	  public Ltitulo() {
	    // Crear el campo de texto y el botón de búsqueda
	    textField = new JTextField(20);
	    searchButton = new JButton("Buscar");
	    searchButton.addActionListener(this);

	    // Crear el panel para colocar el campo de texto y el botón de búsqueda
	    JPanel searchPanel = new JPanel();
	    searchPanel.add(textField);
	    searchPanel.add(searchButton);

	    // Crear el área de resultados
	    resultsArea = new JTextArea(10, 40);

	    // Agregar los componentes a la ventana principal
	    add(searchPanel, BorderLayout.NORTH);
	    add(resultsArea, BorderLayout.CENTER);

	    // Configurar la ventana principal
	    setTitle("Barra de búsqueda");
	    setSize(500, 300);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(true);
	  }

	  public void actionPerformed(ActionEvent e) {
	    // Leer el texto ingresado en el campo de texto
	    String searchText = textField.getText();

	    // Realizar la búsqueda
	    Pattern pattern = Pattern.compile(searchText);
	    Matcher matcher = pattern.matcher("Texto de ejemplo para buscar");
	    StringBuilder sb = new StringBuilder();
	    while (matcher.find()) {
	      sb.append("Coincidencia encontrada en el índice " + matcher.start() + "\n");
	    }

	    // Mostrar los resultados de la búsqueda
	    resultsArea.setText(sb.toString());
	  }

	  public static void main(String[] args) {
		  Ltitulo busqueda = new Ltitulo();
	  }
	}