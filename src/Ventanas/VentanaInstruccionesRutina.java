package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

public class VentanaInstruccionesRutina extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInstruccionesRutina frame = new VentanaInstruccionesRutina();
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
	public VentanaInstruccionesRutina() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblInstrucciones = new JLabel("INSTRUCCIONES");
		panelNorte.add(lblInstrucciones);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		JButton btnAtrs = new JButton("ATRÁS");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new VentanaMenu(null);
				VentanaInstruccionesRutina.this.dispose();
			}
		});
			
		panelSur.add(btnAtrs);
		
			
		
		
		JButton btnIrRutina = new JButton("IR A LA RUTINA");
		btnIrRutina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaRutina();
				VentanaInstruccionesRutina.this.dispose();
			}
		});
			
		panelSur.add(btnIrRutina);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
		

}
			
