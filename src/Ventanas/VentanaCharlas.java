package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

//import org.jvnet.substance.skin.SubstanceRavenLookAndFeel;

import BaseDeDatos.BD;
import Datos.Charla;
import Datos.Clase;
//import Utiles.Temas;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class VentanaCharlas extends JFrame {

	private JPanel contentPane;
	private static BD bd = new BD();
	private JTable table;
	private static VentanaCharlas frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new VentanaCharlas();
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
		btnAaa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaInscripcionCharla frame = new VentanaInscripcionCharla();
				frame.setVisible(true);
				VentanaCharlas.this.dispose();
			}
		});
		panelSur.add(btnAaa);

		JButton btnAtrs = new JButton("ATRÃ�S");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaDecision();
				VentanaCharlas.this.dispose();
			}
		});
		panelSur.add(btnAtrs);

		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(null);

		JButton button = new JButton("INSCRIBIR");

		button.setBounds(6, 151, 158, 52);
		panelCentro.add(button);

		JButton button_1 = new JButton("BORRAR INSCRIPCIÃ“N");
		button_1.setBounds(349, 151, 158, 52);
		panelCentro.add(button_1);

		JButton button_2 = new JButton("BORRAR TODAS");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrarTodas();
			}
		});
		button_2.setBounds(176, 151, 158, 52);
		panelCentro.add(button_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 7, 628, 143);
		panelCentro.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(6, 204, 628, 143);
		panelCentro.add(scrollPane_1);

		table_2 = new JTable();
		scrollPane_1.setViewportView(table_2);
		
		/*JButton btnCambiartema = new JButton("CambiarTema");
		btnCambiartema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new Temas("Tema Substance");
				    frame.dispose();
				    new VentanaClases();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});*/
		//btnCambiartema.setBounds(517, 163, 117, 29);
		//panelCentro.add(btnCambiartema);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inscribirCharla();
			}
		});

		this.setVisible(true);

		crearColumnas();
		mostrarCharlasEnTabla();
	}

	private DefaultTableModel modelTabla = new DefaultTableModel();
	private DefaultTableModel modelTabla_2 = new DefaultTableModel();
	private JTable table_2;

	private void crearColumnas() {
		modelTabla_2.addColumn("Cod_Clase");
		modelTabla_2.addColumn("Nombre");
		modelTabla_2.addColumn("Profesor");
		modelTabla_2.addColumn("Fecha");
		modelTabla_2.addColumn("Tiempo");

		modelTabla.addColumn("Cod_Clase");
		modelTabla.addColumn("Nombre");
		modelTabla.addColumn("Profesor");
		modelTabla.addColumn("Fecha");
		modelTabla.addColumn("Tiempo");
	}

	private void mostrarCharlasEnTabla() {
		List<Charla> listaCharlas = bd.obtenerCharlas();
		for (Charla c : listaCharlas) {
			modelTabla.addRow(new Object[] { c.getCod_charla(), c.getNombre(), c.getImpartidor().getNombre(), c.getfecha(),
					c.getTiempo() });
		}
		table.setModel(modelTabla);
	}

	private void borrarTodas() {
		for (int i = 0; i < modelTabla_2.getRowCount(); i++) {
			modelTabla_2.removeRow(i);
			table_2.setModel(modelTabla_2);
		}
	}

	private void inscribirCharla() {
		String cod_Charla = (String) table.getValueAt(table.getSelectedRow(), 0);
		boolean dev = false; // Si no estÃ¡ en la tabla2 es false

		System.out.println();

		if (modelTabla_2.getRowCount() > 0) {

			for (int i = 0; i < modelTabla_2.getRowCount(); i++) {
				if (modelTabla_2.getValueAt(i, 0).equals(cod_Charla)) {
					dev = true;
				}
			}

			if (dev == false) {
				List<Charla> listaCharlas = bd.obtenerCharlas();
				for (Charla c : listaCharlas) {
					if (c.getCod_charla().equals(cod_Charla)) {
						modelTabla_2.addRow(new Object[] { c.getCod_charla(), c.getNombre(), c.getImpartidor().getNombre(),
								c.getfecha(), c.getTiempo() });
					}
				}
				table_2.setModel(modelTabla_2);
			}

		} else {

			List<Charla> listaCharlas = bd.obtenerCharlas();
			for (Charla c : listaCharlas) {
				if (c.getCod_charla().equals(cod_Charla)) {
					modelTabla_2.addRow(new Object[] { c.getCod_charla(), c.getNombre(), c.getImpartidor().getNombre(),
							c.getfecha(), c.getTiempo() });
				}
			}
			table_2.setModel(modelTabla_2);
		}
	}
}
