package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BaseDeDatos.BD;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.awt.event.ActionEvent;

public class VentanaRegistrar extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldNick;
	private JPasswordField passwordFieldContrasenia;
	private JTextField textFieldCuentaBancaria;
	private JTextField textFieldDNI;
	private static BD bd;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistrar frame = new VentanaRegistrar(bd);
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
	public VentanaRegistrar(BD bd) {
		

				/*Creamos un manejador de fichero para indicar a qué fichero se mandarán los logs*/
				Handler fileHandler = null;
				try {
					fileHandler = new FileHandler("./Registro.log", true);
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				/*Creamos el log y le asociamos el manejador de ficheros*/
				SimpleFormatter simpleFormatter = new SimpleFormatter(); 
				fileHandler.setFormatter(simpleFormatter);
				Logger logger = Logger.getLogger("myLogger");
				logger.addHandler(fileHandler);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
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
		
		JButton btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String dNI = textFieldDNI.getText();
				String nom = textFieldNombre.getText();
				String ape = textFieldApellido.getText();
				String nic = textFieldNick.getText();
				String con = passwordFieldContrasenia.getText();
				String cuenta = textFieldCuentaBancaria.getText();
			
				if(nom.equals("")){
					JOptionPane.showMessageDialog(null, "El campo nombre no puede estar vacío");
					logger.log(Level.INFO, "Ha dejado el campo nombre vacío");
				}
				else if(con.equals("")){
					JOptionPane.showMessageDialog(null, "El campo contraseña no puede estar vacío", "ERROR!!",JOptionPane.ERROR_MESSAGE);
					logger.log(Level.INFO, "Ha dejado el campo contraseña vacío");
				}
				else{
					
					if(bd.existeUsuario(nic, con) == 0){
						String resp = JOptionPane.showInputDialog("No estás registrado. ¿Quieres registrarte (S/N)?");
						if(resp.equalsIgnoreCase("S")){
							bd.registrarUsuario(dNI,nom, nic,con,ape,cuenta);
							JOptionPane.showMessageDialog(null, "Usuario registrado con éxito","OK",JOptionPane.INFORMATION_MESSAGE);
						//HACER UN MÉTODO PARA VACIAR CAMPO DESPUÉS DE REGISTRARSE 
							}else{
							JOptionPane.showMessageDialog(null, "Hasta otra!!");
						}
					}else if(bd.existeUsuario(nic, con) == 1){
						JOptionPane.showMessageDialog(null, "La contraseña no es correcta!!");
						logger.log(Level.SEVERE, "Se ha equivocado en la contraseña");
					}else{
						JOptionPane.showMessageDialog(null, "BIENVENIDO");
						//Ya existe el Usuario
						VentanaMenu frame2 = new VentanaMenu(bd);
						frame2.setVisible(true);
						VentanaRegistrar.this.dispose();
						//HACER UN MÉTODO PARA VACIAR CAMPO DESPUÉS DE REGISTRARSE
					}
				}
			
			}
		});
		panelSur.add(btnRegistrar);
		
		JButton btnAtrs = new JButton("ATRÃ�S");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//new VentanaInicioSesion();
				

				new VentanaInicio(bd);
				VentanaRegistrar.this.dispose();
//github.com/Asiertxoo97/GymTrainer_Proyecto.git
			}
		});
		panelSur.add(btnAtrs);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(52, 25, 61, 16);
		panelCentro.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(52, 60, 61, 16);
		panelCentro.add(lblApellido);
		
		JLabel lblNick = new JLabel("Nick");
		lblNick.setBounds(52, 140, 61, 16);
		panelCentro.add(lblNick);
		
		JLabel lblContrasenia = new JLabel("Contraseña");
		lblContrasenia.setBounds(52, 179, 71, 16);
		panelCentro.add(lblContrasenia);
		
		JLabel lblCuentaBancaria = new JLabel("Cuenta bancaria");
		lblCuentaBancaria.setBounds(52, 219, 101, 16);
		panelCentro.add(lblCuentaBancaria);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(232, 20, 130, 26);
		panelCentro.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(232, 55, 130, 26);
		panelCentro.add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		textFieldNick = new JTextField();
		textFieldNick.setBounds(232, 135, 130, 26);
		panelCentro.add(textFieldNick);
		textFieldNick.setColumns(10);
		
		passwordFieldContrasenia = new JPasswordField();
		passwordFieldContrasenia.setBounds(232, 176, 130, 21);
		panelCentro.add(passwordFieldContrasenia);
		
		textFieldCuentaBancaria = new JTextField();
		textFieldCuentaBancaria.setBounds(232, 214, 130, 26);
		panelCentro.add(textFieldCuentaBancaria);
		textFieldCuentaBancaria.setColumns(10);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(52, 97, 61, 16);
		panelCentro.add(lblDni);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setBounds(232, 93, 130, 26);
		panelCentro.add(textFieldDNI);
		textFieldDNI.setColumns(10);
		
		this.setVisible(true);
	}
}
