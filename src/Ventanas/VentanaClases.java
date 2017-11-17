package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class VentanaClases extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaClases frame = new VentanaClases();
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
	public VentanaClases() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblClases = new JLabel("CLASES");
		panelNorte.add(lblClases);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		JButton btnAaa = new JButton("INSCRIBIRSE A LAS CLASES SELECCIONADAS");
		panelSur.add(btnAaa);
		
		JButton btnAtrs = new JButton("ATRÁS");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaMenu();
				VentanaClases.this.dispose();
			}
		});
		panelSur.add(btnAtrs);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(null);
		
		JTextArea textAreaClases = new JTextArea();
		textAreaClases.setBounds(16, 6, 211, 341);
		panelCentro.add(textAreaClases);
		
		JTextArea textAreaClasesAAsistir = new JTextArea();
		textAreaClasesAAsistir.setBounds(409, 6, 211, 341);
		panelCentro.add(textAreaClasesAAsistir);
		
		JButton button = new JButton("INSCRIBIR");
		button.setBounds(239, 83, 158, 52);
		panelCentro.add(button);
		
		JButton button_1 = new JButton("BORRAR INSCRIPCIÓN");
		button_1.setBounds(239, 147, 158, 52);
		panelCentro.add(button_1);
		
		JButton button_2 = new JButton("BORRAR TODAS");
		button_2.setBounds(239, 211, 158, 52);
		panelCentro.add(button_2);
		
		
		this.setVisible(true);
	}
}
