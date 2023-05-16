package Entornos;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Iniciar extends JFrame implements ActionListener {
    private JTextField userField;
    private JPasswordField passField;
    private JButton loginBtn;
    private JButton registerBtn;
    private JLabel messageLabel;

    public Iniciar() {
        super("Iniciar");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear componentes
        userField = new JTextField(20);
        passField = new JPasswordField(20);
        loginBtn = new JButton("Login");
        loginBtn.addActionListener(this);
        registerBtn = new JButton("Register");
        registerBtn.addActionListener(this);
        messageLabel = new JLabel("");

        // Crear paneles
        JPanel userPanel = new JPanel();
        userPanel.add(new JLabel("Username:"));
        userPanel.add(userField);

        JPanel passPanel = new JPanel();
        passPanel.add(new JLabel("Password:"));
        passPanel.add(passField);

        JPanel btnPanel = new JPanel();
        btnPanel.add(loginBtn);
        btnPanel.add(registerBtn);

        // Agregar componentes al contenedor
        Container c = getContentPane();
        c.setLayout(new GridLayout(4, 1));
        c.add(userPanel);
        c.add(passPanel);
        c.add(btnPanel);
        c.add(messageLabel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginBtn) {
            // Verificar credenciales de inicio de sesión
            String username = userField.getText();
            String password = new String(passField.getPassword());

            if (username.equals("admin") && password.equals("adminpass")) {
                // Mostrar interfaz de administrador
                dispose();
                new AdminUI();
                
            } else if (username.equals("user") && password.equals("userpass")) {
                // Mostrar interfaz de usuario normal
                dispose();
                new UserUI();
            } else {
                // Credenciales inválidas
                messageLabel.setText("Invalid username or password");
            }
        } else if (e.getSource() == registerBtn) {
            // Mostrar interfaz de registro
            dispose();
            new RegisterUI();
        }
    }

    public static void main(String[] args) {
        // Iniciar programa con la interfaz de inicio de sesión
    	Iniciar interfaz = new Iniciar();
    	interfaz.setBounds(150, 150, 1000, 500);
    	interfaz.setVisible(true);
    	interfaz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class AdminUI extends JFrame {
    public AdminUI() {
        super("Admin Interface");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear componentes
        JLabel titleLabel = new JLabel("Welcome, Admin");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        // Agregar componentes al contenedor
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add(titleLabel, BorderLayout.CENTER);

        
        setVisible(true);
        PrincipalAdmin.main(null);
    }
}

class UserUI extends JFrame {
    public UserUI() {
        super("User Interface");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear componentes
        JLabel titleLabel = new JLabel("Welcome, User");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        // Agregar componentes al contenedor
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add(titleLabel, BorderLayout.CENTER);

        setVisible(true);
        PrincipalUser.main(null);
    }
}

class RegisterUI extends JFrame {
    public RegisterUI() {
        super("Registration");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}