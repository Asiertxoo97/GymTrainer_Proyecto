package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class VentanaInscripcionCharlas extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCodigo;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldCuentaBancaria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInscripcionCharlas frame = new VentanaInscripcionCharlas();
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
	public VentanaInscripcionCharlas() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblInscripcinALas = new JLabel("INSCRIPCIÓN A LAS CHARLAS");
		panelNorte.add(lblInscripcinALas);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		JButton btnAtrs = new JButton("ATRÁS");
		panelSur.add(btnAtrs);
		
		JButton btnInscribirse = new JButton("INSCRIBIRSE");
		panelSur.add(btnInscribirse);
		
		JLabel lblCodigo = new JLabel("Código:");
		panelSur.add(lblCodigo);
		
		textFieldCodigo = new JTextField();
		panelSur.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(null);
		
		JTextArea textAreaCharlasInscritas = new JTextArea();
		textAreaCharlasInscritas.setBounds(17, 6, 606, 165);
		panelCentro.add(textAreaCharlasInscritas);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(56, 194, 61, 16);
		panelCentro.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellido");
		lblApellidos.setBounds(56, 245, 61, 16);
		panelCentro.add(lblApellidos);
		
		JLabel lblCuentaBancaria = new JLabel("Cuenta bancaria");
		lblCuentaBancaria.setBounds(56, 296, 101, 16);
		panelCentro.add(lblCuentaBancaria);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(161, 189, 130, 26);
		panelCentro.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(161, 240, 130, 26);
		panelCentro.add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		textFieldCuentaBancaria = new JTextField();
		textFieldCuentaBancaria.setBounds(203, 291, 130, 26);
		panelCentro.add(textFieldCuentaBancaria);
		textFieldCuentaBancaria.setColumns(10);
	}
}
