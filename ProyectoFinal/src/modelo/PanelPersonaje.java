package modelo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;

import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

public class PanelPersonaje extends JPanel {

	public Aliado personaje;
	public Enemigo enemigo;
	private boolean esAliado;
	public PanelPersonaje(Aliado personaje) {//Crear el panel para personajes de tipo aliado
		this.personaje = personaje;
		setToolTipText(personaje.getNombre());
		setBorder(new MatteBorder(15, 15, 15, 15, Color.DARK_GRAY));
		setBackground(Color.WHITE);
		esAliado=true;
	}
	public PanelPersonaje(Enemigo enemigo) {//Crear el panel para personajes de tipo Enemigo
		this.enemigo = enemigo;
		setToolTipText(enemigo.getNombre());
		setBorder(new MatteBorder(15, 15, 15, 15, Color.DARK_GRAY));
		setBackground(Color.WHITE);
		esAliado=false;
	}
	public void paintComponent(Graphics g) {
		if(esAliado==true) {
			super.paintComponent(g);
			Dimension tamano=getSize();
			ImageIcon imagen = personaje.getImagen();
			g.drawImage(imagen.getImage(),8,10,tamano.width-30,tamano.height-30,null);
		}else {
			super.paintComponent(g);
			Dimension tamano=getSize();
			ImageIcon imagen = enemigo.getImagen();
			g.drawImage(imagen.getImage(),8,10,tamano.width-30,tamano.height-30,null);
		}
	}
	public Aliado getPersonaje() {
		return personaje;
	}
	public Enemigo getEnemigo() {
		return enemigo;
	}
}
