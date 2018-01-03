package Utiles;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.LookAndFeel;
import javax.swing.UIManager;

import org.jvnet.substance.skin.SubstanceMagmaLookAndFeel;
import org.jvnet.substance.skin.SubstanceRavenGraphiteGlassLookAndFeel;
import org.jvnet.substance.skin.SubstanceRavenLookAndFeel;

public class Temas {

	/**
	 * 
	 * @param tema
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public Temas(String tema) throws FileNotFoundException, IOException {
		ComprobarTemaElegido(tema);
	}

	/**
	 * 
	 * @param tema
	 */
	private void ComprobarTemaElegido(String tema) {
		try {
			if (tema.equals("Tema Substance")) {
				try {
					UIManager.setLookAndFeel((LookAndFeel) new SubstanceRavenGraphiteGlassLookAndFeel());
				} catch (Exception ex) {

				}

			} else if (tema.equals("Tema Magma")) {
				try {
					UIManager.setLookAndFeel((LookAndFeel) new SubstanceMagmaLookAndFeel());
				} catch (Exception ex) {

				}

			} else if (tema.equals("Tema Raven")) {
				try {
					UIManager.setLookAndFeel((LookAndFeel) new SubstanceRavenLookAndFeel());
				} catch (Exception ex) {

				}

			}
		} catch (Exception e) {

		}
	}
}
