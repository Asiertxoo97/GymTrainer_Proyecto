package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaRegistrar extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldNick;
	private JPasswordField passwordFieldContrasenia;
	private JTextField textFieldCuentaBancaria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistrar frame = new VentanaRegistrar();
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
	public VentanaRegistrar() {
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
		
		JButton btnRegistrar = new JButton("REGISTRAR");
		panelSur.add(btnRegistrar);
		
		JButton btnAtrs = new JButton("ATRÁS");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaInicio();
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
		lblNick.setBounds(52, 98, 61, 16);
		panelCentro.add(lblNick);
		
		JLabel lblContrasenia = new JLabel("Contraseña");
		lblContrasenia.setBounds(52, 131, 71, 16);
		panelCentro.add(lblContrasenia);
		
		JLabel lblCuentaBancaria = new JLabel("Cuenta bancaria");
		lblCuentaBancaria.setBounds(52, 168, 101, 16);
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
		textFieldNick.setBounds(232, 93, 130, 26);
		panelCentro.add(textFieldNick);
		textFieldNick.setColumns(10);
		
		passwordFieldContrasenia = new JPasswordField();
		passwordFieldContrasenia.setBounds(232, 126, 130, 21);
		panelCentro.add(passwordFieldContrasenia);
		
		textFieldCuentaBancaria = new JTextField();
		textFieldCuentaBancaria.setBounds(232, 158, 130, 26);
		panelCentro.add(textFieldCuentaBancaria);
		textFieldCuentaBancaria.setColumns(10);
		
		this.setVisible(true);
	}

}
