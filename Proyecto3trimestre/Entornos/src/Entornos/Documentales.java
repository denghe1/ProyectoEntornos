package Entornos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Documentales extends JFrame implements ActionListener {
    private JTextField txtTitulo, txtAutor;
    private JButton btnAgregar, btnEliminar;
    private DefaultListModel<String> listaLibros;
    private JList<String> jList;

    
    
    public static void main(String[] args) {
        Documentales Altas_y_bajas = new Documentales();
    }
    
    

    
    
    public Documentales() {
        super("Gestión de Libros");

        // Crear los componentes
        JLabel lblTitulo = new JLabel("Título:");
        JLabel lblAutor = new JLabel("Autor:");
        txtTitulo = new JTextField(20);
        txtAutor = new JTextField(20);
        btnAgregar = new JButton("Agregar");
        btnEliminar = new JButton("Eliminar");
        listaLibros = new DefaultListModel<String>();
        jList = new JList<String>(listaLibros);

        // Agregar los componentes a la ventana
        Container contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout());
        JPanel panelCampos = new JPanel(new GridLayout(2, 2));
        panelCampos.add(lblTitulo);
        panelCampos.add(txtTitulo);
        panelCampos.add(lblAutor);
        panelCampos.add(txtAutor);
        contenedor.add(panelCampos, BorderLayout.NORTH);
        contenedor.add(new JScrollPane(jList), BorderLayout.CENTER);
        JPanel panelBotones = new JPanel();
        panelBotones.add(btnAgregar);
        panelBotones.add(btnEliminar);
        contenedor.add(panelBotones, BorderLayout.SOUTH);

        // Agregar los listeners
        btnAgregar.addActionListener(this);
        btnEliminar.addActionListener(this);

        // Configurar la ventana
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAgregar) {
            String titulo = txtTitulo.getText();
            String autor = txtAutor.getText();
            if (!titulo.isEmpty() && !autor.isEmpty()) {
                listaLibros.addElement(titulo + " - " + autor);
            }
            txtTitulo.setText("");
            txtAutor.setText("");
        } else if (e.getSource() == btnEliminar) {
            int indice = jList.getSelectedIndex();
            if (indice != -1) {
                listaLibros.remove(indice);
            }
        }
    }
       
}

