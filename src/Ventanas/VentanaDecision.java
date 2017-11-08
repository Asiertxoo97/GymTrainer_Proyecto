package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaDecision extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaDecision frame = new VentanaDecision();
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
	public VentanaDecision() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblBienvenido = new JLabel("Bienvenido a GymTrainerUD");
		panelNorte.add(lblBienvenido);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(null);
		
		JButton btnGimnasio = new JButton("GIMNASIO");
		btnGimnasio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaInicio();
				VentanaDecision.this.dispose();
			}
		});
		btnGimnasio.setBounds(255, 117, 117, 29);
		panelCentro.add(btnGimnasio);
		
		JButton btnCharlas = new JButton("CHARLAS DEPORTIVAS");
		btnCharlas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaCharlas();
				VentanaDecision.this.dispose();
			}
		});
		btnCharlas.setBounds(226, 238, 185, 29);
		panelCentro.add(btnCharlas);
		
		this.setVisible(true);
	}
}
