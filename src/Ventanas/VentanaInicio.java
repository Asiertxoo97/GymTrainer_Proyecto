package Ventanas;
import BaseDeDatos.BD;
import Datos.Usuario;

import java.awt.BorderLayout;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BaseDeDatos.BD;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.awt.event.ActionEvent;

public class VentanaInicio extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNick;
	private JPasswordField passwordFieldContrasenia;
	public static String dni;
	public static String nick;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicio frame = new VentanaInicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaInicio() {
		
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblGymtrainerud = new JLabel("GymTrainerUD");
		panelNorte.add(lblGymtrainerud);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		JLabel lblaunNoEsts = new JLabel("¿Aún no estás registrado?");
		lblaunNoEsts.setForeground(Color.RED);
		panelSur.add(lblaunNoEsts);
		
		JButton btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaRegistrar();
			}
		});
		panelSur.add(btnRegistrar);
		
		JButton btnAtrs = new JButton("ATRÃS");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaDecision();
			}
		});
		panelSur.add(btnAtrs);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(null);
		
		JLabel lblNick = new JLabel("Nick");
		lblNick.setBounds(67, 54, 61, 16);
		panelCentro.add(lblNick);
		
		JLabel lblContrasenia = new JLabel("Contraseña");
		lblContrasenia.setBounds(67, 96, 71, 16);
		panelCentro.add(lblContrasenia);
		
		textFieldNick = new JTextField();
		textFieldNick.setBounds(209, 49, 130, 26);
		panelCentro.add(textFieldNick);
		textFieldNick.setColumns(10);
		
		passwordFieldContrasenia = new JPasswordField();
		passwordFieldContrasenia.setBounds(209, 91, 130, 26);
		panelCentro.add(passwordFieldContrasenia);
		
		JButton btnIniciarSesion = new JButton("INICIAR SESIÓN");
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(VentanaDecision.bd.existeUsuario(textFieldNick.getText(), passwordFieldContrasenia.getText())==0){
					//NICK MAL INTRODUCIDO. 
					JOptionPane.showMessageDialog(null, "El Nick introducido no es correcto. Vuelva a introducirlo o registrese.");
					textFieldNick.setText("");
					passwordFieldContrasenia.setText("");
					
				}else if (VentanaDecision.bd.existeUsuario(textFieldNick.getText(), passwordFieldContrasenia.getText())==1){
					//CONSTRASEÑA MAL INTRODUCIDA.
					JOptionPane.showMessageDialog(null, "La contraseña introducida no es correcta. Vuelva a introducirlo.");
					textFieldNick.setText("");
					passwordFieldContrasenia.setText("");
					
				}else{
					//NICK Y CONTRASEÑA BIEN INTRODUCIDOS; USUARIO EXISTE.
					JOptionPane.showMessageDialog(null, "BIENVENIDO");
					if(textFieldNick.getText().equals("admin")&&passwordFieldContrasenia.getText().equals("admin")){
						//EL USUARIO ES ADMINISTRADOR; ACCEDE A VENTANA ADMINISTRADOR Y TIENE VENTAJAS DE ADMINISTRADOR
		//TODO			//VentanaAdministrador frame = new VentanaAdministrador();
						VentanaAdministrador frame2 = new VentanaAdministrador();
						frame2.setVisible(true);
						VentanaInicio.this.dispose();
						
					}else{
						dni=VentanaDecision.bd.obtenerDNIUsuario(textFieldNick.getText(),passwordFieldContrasenia.getText());
						nick=textFieldNick.getText();
					VentanaMenu frame2 = new VentanaMenu();
					frame2.setVisible(true);
					VentanaInicio.this.dispose();
					}
				}
			}
		});
		btnIniciarSesion.setBounds(209, 148, 130, 29);
		panelCentro.add(btnIniciarSesion);
		
		
		 
		
		
		
		this.setVisible(true);
	}
	
}