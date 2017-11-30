package Ventanas;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Paneles.PanelAbdominales;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class VentanaAbdominales extends JFrame {

	private JPanel contentPane;
	private JButton btnContinuar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAbdominales frame = new VentanaAbdominales();
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
	public VentanaAbdominales() {
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblEjerciciosDeAbdominales = new JLabel("Ejercicios de abdominales");
		panelNorte.add(lblEjerciciosDeAbdominales);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton botonPulsado=(JButton)e.getSource();
				if(botonPulsado==btnVolver){
					JOptionPane.showMessageDialog(null, "Esperemos que vuelvas");
					VentanaElegirEjercicios nuevaVentana = new VentanaElegirEjercicios();
					nuevaVentana.setVisible(true);
					VentanaAbdominales.this.dispose();
				}
			}
		});
		panelSur.add(btnVolver);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panelSur.add(btnSalir);
		
		JPanel panelIzquierda = new JPanel();
		contentPane.add(panelIzquierda, BorderLayout.WEST);
		
		JPanel panelDerecha = new JPanel();
		contentPane.add(panelDerecha, BorderLayout.EAST);
		
		
		JPanel panelCentro = new JPanel();
		JScrollPane scroll = new JScrollPane(panelCentro);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scroll, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(0, 2, 0, 0));
		ArrayList<String> aRutas = VentanaElegirEjercicios.bd.obtenerRutasFotosAbdominales();
		for(int j=0;j<aRutas.size();j++){
			String ruta = aRutas.get(j);
			System.out.println(ruta);
			
			ImageIcon im = new ImageIcon(ruta);
			JLabel lblImagen = new JLabel(im);
			panelCentro.add(lblImagen);
		}
		
		this.setVisible(true);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setResizable(false);
	
	}
		
	
}
