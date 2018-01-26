package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BaseDeDatos.BD;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaInscripcionCharla extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDNI;
	private JTextField textFieldNombre;
	private JTextField textFieldApellidos;
	private  JTextField textFieldUsuarioPaypal;
	private  JTextField textFieldContraseniaPaypal;
	private  JLabel lblContraseaPaypal;
	private  JLabel lblUsuarioPaypal;
	private  JRadioButton rdbtnPaypal;
	private  JRadioButton rdbtnTarjetaCrdito;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInscripcionCharla frame = new VentanaInscripcionCharla();					
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
	public VentanaInscripcionCharla() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 471, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		VentanaDecision.primeraVez = false;
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
				
		JLabel lblInscripcinACharla = new JLabel("INSCRIPCI\u00D3N A CHARLA");
		panel.add(lblInscripcinACharla);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnInscribirse = new JButton("INSCRIBIRSE");
		btnInscribirse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cuentaBancaria;
				 String charla;
				 String charlas = null;
				 boolean correcto=false;
				 
				if(rdbtnPaypal.isSelected()){
					 cuentaBancaria = textFieldUsuarioPaypal.getText()+"//"+textFieldContraseniaPaypal.getText();
					 VentanaDecision.bd.registrarParticipante(textFieldDNI.getText(), textFieldNombre.getText(), textFieldApellidos.getText(), cuentaBancaria);
					 for(int i=0;i<VentanaCharlas.table_2.getRowCount();i++) {
						  charla= VentanaCharlas.charlas.get(i);
							 charlas ="\n"+ charla +"\n";
							if(!VentanaDecision.bd.insertarInscripcion(VentanaCharlas.lista.get(i),textFieldDNI.getText() , "charla")){
								correcto=true;
							}
							 							
						}
				
					 
					
				}
				else if(rdbtnTarjetaCrdito.isSelected()){
					
					cuentaBancaria= textFieldUsuarioPaypal.getText()+"//"+textFieldContraseniaPaypal.getText();;
					VentanaDecision.bd.registrarParticipante(textFieldDNI.getText(), textFieldNombre.getText(),textFieldApellidos.getText(), cuentaBancaria);
					for(int i=0;i<VentanaCharlas.table_2.getRowCount();i++) {
						 charla= VentanaCharlas.charlas.get(i);
						 charlas ="\n"+ charla +"\n";
						 if(!VentanaDecision.bd.insertarInscripcion(VentanaCharlas.lista.get(i),textFieldDNI.getText() , "charla")){
							 correcto=true;
						}
						 
					}
					
				}
				else{
					JOptionPane.showMessageDialog(null,"Debes introducir una cuenta bancaria.");
				}
				if(correcto){
					 JOptionPane.showMessageDialog(null, "Te has inscrito correctamente para las siguientes charlas:"+charlas);	
				 }
			}
		});
		
		panel_1.add(btnInscribirse);
		
		JButton btnAtras = new JButton("ATRAS");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				VentanaDecision frame = new VentanaDecision();
				frame.setVisible(true);
				VentanaInscripcionCharla.this.dispose();
			}
		});
		panel_1.add(btnAtras);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.WEST);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.EAST);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(null);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(51, 45, 46, 14);
		panel_4.add(lblDni);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(51, 70, 65, 14);
		panel_4.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("APELLIDOS");
		lblApellidos.setBounds(51, 95, 65, 14);
		panel_4.add(lblApellidos);
		
		JLabel lblCuentaBancaria = new JLabel("CUENTA BANCARIA");
		lblCuentaBancaria.setBounds(51, 120, 107, 14);
		panel_4.add(lblCuentaBancaria);
		
		rdbtnPaypal = new JRadioButton("PAYPAL");
		rdbtnPaypal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBounds(100, 100, 471, 358);
				rdbtnTarjetaCrdito.setEnabled(false);
				textFieldUsuarioPaypal.setVisible(true);
				textFieldContraseniaPaypal.setVisible(true);
				lblUsuarioPaypal.setVisible(true);
				lblContraseaPaypal.setVisible(true);
				lblUsuarioPaypal.setText("USUARIO PAYPAL");
				lblContraseaPaypal.setText("CONTRASEÑA PAYPAL");
				if(!rdbtnPaypal.isSelected() && !rdbtnTarjetaCrdito.isSelected()){
					 rdbtnPaypal.setEnabled(true);
					 rdbtnTarjetaCrdito.setEnabled(true);
					 textFieldUsuarioPaypal.setVisible(false);
					 textFieldContraseniaPaypal.setVisible(false);
					 lblUsuarioPaypal.setVisible(false);
					 lblContraseaPaypal.setVisible(false);
					 
				}
				
			}
		});
		rdbtnPaypal.setBounds(164, 116, 109, 23);
		panel_4.add(rdbtnPaypal);
		
		rdbtnTarjetaCrdito = new JRadioButton("TARJETA CR\u00C9DITO");
		rdbtnTarjetaCrdito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnPaypal.setEnabled(false);
				textFieldUsuarioPaypal.setVisible(true);
				textFieldContraseniaPaypal.setVisible(true);
				lblUsuarioPaypal.setVisible(true);
				lblContraseaPaypal.setVisible(true);
				lblUsuarioPaypal.setText("TARJETA CREDITO");
				lblContraseaPaypal.setText("CODIGO DE SEGURIDAD");
				if(!rdbtnPaypal.isSelected() && !rdbtnTarjetaCrdito.isSelected()){
					 rdbtnPaypal.setEnabled(true);
					 rdbtnTarjetaCrdito.setEnabled(true);
					 textFieldUsuarioPaypal.setVisible(false);
					 textFieldContraseniaPaypal.setVisible(false);
					 lblUsuarioPaypal.setVisible(false);
					 lblContraseaPaypal.setVisible(false);
					 
				}
			}
		});
		
		rdbtnTarjetaCrdito.setBounds(165, 145, 143, 23);
		panel_4.add(rdbtnTarjetaCrdito);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setBounds(171, 42, 178, 20);
		panel_4.add(textFieldDNI);
		textFieldDNI.setColumns(10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(171, 67, 178, 20);
		panel_4.add(textFieldNombre);
		
		textFieldApellidos = new JTextField();
		textFieldApellidos.setColumns(10);
		textFieldApellidos.setBounds(171, 92, 178, 20);
		panel_4.add(textFieldApellidos);
		
		lblUsuarioPaypal = new JLabel("USUARIO PAYPAL");
		lblUsuarioPaypal.setBounds(34, 177, 107, 14);
		panel_4.add(lblUsuarioPaypal);
		
		lblContraseaPaypal = new JLabel("CONTRASENA PAYPAL");
		lblContraseaPaypal.setBounds(34, 202, 137, 14);
		panel_4.add(lblContraseaPaypal);
		
		textFieldUsuarioPaypal = new JTextField();
		textFieldUsuarioPaypal.setBounds(171, 174, 178, 20);
		panel_4.add(textFieldUsuarioPaypal);
		textFieldUsuarioPaypal.setColumns(10);
		
		textFieldContraseniaPaypal = new JTextField();
		textFieldContraseniaPaypal.setColumns(10);
		textFieldContraseniaPaypal.setBounds(171, 199, 178, 20);
		panel_4.add(textFieldContraseniaPaypal);
		
		lblContraseaPaypal.setVisible(false);
		 lblUsuarioPaypal.setVisible(false);
		 textFieldContraseniaPaypal.setVisible(false);
		 textFieldUsuarioPaypal.setVisible(false);
		 rdbtnPaypal.setEnabled(true);
		 rdbtnTarjetaCrdito.setEnabled(true);
	}
}