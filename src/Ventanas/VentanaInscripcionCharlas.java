package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BaseDeDatos.BD;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaInscripcionCharlas extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCodigo;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldCuentaBancaria;
	private JTextField textFieldDNI;
	private static BD bd;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInscripcionCharlas frame = new VentanaInscripcionCharlas(bd);
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
	public VentanaInscripcionCharlas(BD bd) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblInscripcinALas = new JLabel("INSCRIPCIÃ“N A LAS CHARLAS");
		panelNorte.add(lblInscripcinALas);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		JButton btnAtrs = new JButton("ATRÃ�S");
		panelSur.add(btnAtrs);
		
		JButton btnInscribirse = new JButton("INSCRIBIRSE");
		btnInscribirse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bd.registrarParticipante(textFieldDNI.getText(), textFieldNombre.getText()
						, textFieldApellido.getText(), textFieldCuentaBancaria.getText());
			}
		});
		panelSur.add(btnInscribirse);
		
		JLabel lblCodigo = new JLabel("CÃ³digo:");
		panelSur.add(lblCodigo);
		
		textFieldCodigo = new JTextField();
		panelSur.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(null);
		
		JTextArea textAreaCharlasInscritas = new JTextArea();
		textAreaCharlasInscritas.setBounds(20, 6, 603, 122);
		panelCentro.add(textAreaCharlasInscritas);
		
		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setBounds(56, 156, 61, 16);
		panelCentro.add(lblDNI);
		
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
		textFieldNombre.setBounds(161, 194, 130, 26);
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
		
		textFieldDNI = new JTextField();
		textFieldDNI.setColumns(10);
		textFieldDNI.setBounds(161, 154, 130, 26);
		panelCentro.add(textFieldDNI);
	}
}
