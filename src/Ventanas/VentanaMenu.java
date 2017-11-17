package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Color;

public class VentanaMenu extends JFrame {

	ImageIcon Imagen;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 * @return 
	 */

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMenu frame = new VentanaMenu();
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
	public VentanaMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 550);
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
		
		JButton btnSalir = new JButton("ATRÁS");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaDecision();
				VentanaMenu.this.dispose();
			}
		});
		panelSur.add(btnSalir);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(null);
		
		JButton btnEjercicios = new JButton(new ImageIcon("Imagenes/Ejercicios.jpg"));
		btnEjercicios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaSeleccionEjercicios();
				VentanaMenu.this.dispose();
			}
		});
		btnEjercicios.setBounds(6, 0, 370, 165);
		panelCentro.add(btnEjercicios);
		
		JButton btnRutina = new JButton(new ImageIcon("Imagenes/RutinaMenu.jpg"));
		btnRutina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaRutina();
				VentanaMenu.this.dispose();
			}
		});
		btnRutina.setBounds(264, 143, 370, 165);
		panelCentro.add(btnRutina);
		
		JButton btnClases = new JButton(new ImageIcon("Imagenes/Clases.jpg"));
		btnClases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaClases();
				VentanaMenu.this.dispose();
			}
		});
		btnClases.setBounds(6, 288, 370, 165);
		panelCentro.add(btnClases);
		
		JTextPane txtpnEjercicios = new JTextPane();
		txtpnEjercicios.setBackground(Color.LIGHT_GRAY);
		txtpnEjercicios.setText("   ¡Accede a nuestra lista variada de ejercicios y trabaja las partes del cuerpo (abdominales, tren superior, tren inferior...) que tu quieras en cualquier momento!");
		txtpnEjercicios.setBounds(388, 6, 190, 110);
		panelCentro.add(txtpnEjercicios);
		
		JTextPane txtpnRutina = new JTextPane();
		txtpnRutina.setBackground(Color.LIGHT_GRAY);
		txtpnRutina.setText("   ¡Realiza los ejercicios programados especificamente para ti día a día y lleva un orden de los ejercicios que realizas!");
		txtpnRutina.setBounds(62, 166, 190, 110);
		panelCentro.add(txtpnRutina);
		
		JTextPane txtpnClases = new JTextPane();
		txtpnClases.setBackground(Color.LIGHT_GRAY);
		txtpnClases.setText("   ¡Apuntate a las clases (aerobic, step, body combat, crossfit, zumba, spinning, body pump, body, balance) de nuestros gimnasios!");
		txtpnClases.setBounds(388, 320, 190, 110);
		panelCentro.add(txtpnClases);
		
		this.setVisible(true);
	}
}
