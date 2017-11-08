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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		textAreaAsistir.setBounds(264, 6, 159, 191);
		panelCentro.add(textAreaAsistir);
		
		JTextArea textAreaCharlas = new JTextArea();
		textAreaCharlas.setBounds(18, 6, 159, 191);
		panelCentro.add(textAreaCharlas);
		
		JButton buttonDcha = new JButton(">");
		buttonDcha.setBounds(200, 47, 40, 34);
		panelCentro.add(buttonDcha);
		
		JButton buttonIzq = new JButton("<");
		buttonIzq.setBounds(200, 112, 40, 34);
		panelCentro.add(buttonIzq);
		
		this.setVisible(true);
	}
}
