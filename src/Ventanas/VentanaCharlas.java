package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaCharlas extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCharlas frame = new VentanaCharlas();
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
	public VentanaCharlas() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650,450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblCharlas = new JLabel("CHARLAS");
		panelNorte.add(lblCharlas);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		JButton btnInscribirse = new JButton("INSCRIBIRSE");
		panelSur.add(btnInscribirse);
		
		JButton btnAtrs = new JButton("ATRÁS");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaDecision();
			}
		});
		panelSur.add(btnAtrs);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(null);
		
		JTextArea textAreaAsistir = new JTextArea();
		textAreaAsistir.setBounds(408, 6, 211, 341);
		panelCentro.add(textAreaAsistir);
		
		JTextArea textAreaCharlas = new JTextArea();
		textAreaCharlas.setBounds(18, 6, 211, 341);
		panelCentro.add(textAreaCharlas);
		
		JButton buttonInscrip = new JButton("INSCRIBIR");
		buttonInscrip.setBounds(262, 89, 105, 34);
		panelCentro.add(buttonInscrip);
		
		JButton buttonBorrarInscrip = new JButton("BORRAR INSCRIPCIÓN");
		buttonBorrarInscrip.setBounds(241, 179, 158, 52);
		panelCentro.add(buttonBorrarInscrip);
		
		this.setVisible(true);
	}
}
