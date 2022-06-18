 package modelo;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MiPanel extends JPanel{
	
	private ImageIcon imagen;
	private ImageIcon aliado;
	private ImageIcon enemigo;
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Dimension tamano=getSize();
		imagen=new ImageIcon(getClass().getResource("/imagenes/campo3.jpg"));
		g.drawImage(imagen.getImage(),0,0,tamano.width,tamano.height,null);
		//setOpaque(false);
		g.drawImage(aliado.getImage(),10, 150, 150, 150,null);
		g.drawImage(enemigo.getImage(),500, 60, 150, 150,null);
		
		//super.paint(g);
	}
	public void setImagenAliado(ImageIcon aliado) {
		this.aliado=aliado;
	}
	public void setImagenEnemigo(ImageIcon enemigo) {
		this.enemigo=enemigo;
	}
}
