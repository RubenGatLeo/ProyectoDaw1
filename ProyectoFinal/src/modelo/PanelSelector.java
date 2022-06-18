package modelo;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.EscuchadorPersonajes;

public class PanelSelector extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EscuchadorPersonajes escPersonaje;
	private ArrayList<Aliado> listaPersonajes=new ArrayList<Aliado>();
	private ArrayList<Enemigo> listaEnemigos=new ArrayList<Enemigo>();
	private boolean esAliado;
	
	public PanelSelector(Frame parent, boolean modal,EscuchadorPersonajes escPersonaje) {//Para elegir al aliado
		super(parent, modal);
		this.escPersonaje=escPersonaje;
		esAliado=true;
		crearPersonajes();
		setLayout(new BorderLayout());
		setBounds(0,300,800,500);
		escPersonaje.setDialogo(this);

		JLabel eleccion=new JLabel("ELIGE QUE PERSONAJE QUIERES SER");
		eleccion.setHorizontalAlignment(JLabel.CENTER);
		eleccion.setFont(new Font("Serif", Font.PLAIN, 18));
		
		JPanel dialogo = new JPanel();
		dialogo.setLayout(new GridLayout(2, 4)); //Especie de parrilla para los 8 paneles
		
		for (int i =0; i<listaPersonajes.size();i++) {
			Aliado personaje=listaPersonajes.get(i);
			PanelPersonaje p=new PanelPersonaje(personaje);
			dialogo.add(p);
			p.addMouseListener(escPersonaje);
			escPersonaje.setPanel(p);
		}	
		add(eleccion,BorderLayout.NORTH);
		add(dialogo, BorderLayout.CENTER);
		
		setTitle("Seleccionar Personaje");
		
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(true);
		setVisible(true);
	}
	
	public PanelSelector(Frame parent,EscuchadorPersonajes escPersonaje) {//para elegir al enemigo
		super(parent, true);
		this.escPersonaje=escPersonaje;
		esAliado=false;
		crearEnemigos();
		setLayout(new BorderLayout());
		setBounds(0,300,800,500);
		escPersonaje.setDialogo(this);

		JLabel eleccion=new JLabel("ELIGE A QUIEN QUIERES ENFRENTARTE");
		eleccion.setHorizontalAlignment(JLabel.CENTER);
		eleccion.setFont(new Font("Serif", Font.PLAIN, 18));

		JPanel dialogo = new JPanel();
		dialogo.setLayout(new GridLayout(2, 4)); 
		
		for (int i =0; i<listaEnemigos.size();i++) {
			Enemigo enemigo=listaEnemigos.get(i);
			PanelPersonaje p=new PanelPersonaje(enemigo);
			dialogo.add(p);
			p.addMouseListener(escPersonaje);
			escPersonaje.setPanel(p);
		}	
		add(eleccion,BorderLayout.NORTH);
		add(dialogo, BorderLayout.CENTER);
		
		setTitle("Seleccionar Enemigo");
		
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(true);
		setVisible(true);
	}
	
	
	public void cerrarDialogo() {
		dispose();
	}
	public void crearPersonajes() {
		listaPersonajes.add(new Aliado("Ruben",20,50,15,new Arma("Arco",0.5),new ImageIcon(getClass().getResource("/imagenes/centauro.png"))));
		listaPersonajes.add(new Aliado("Novato",10,20,10,new Arma("Pistola Laser",0.6),new ImageIcon(getClass().getResource("/imagenes/chico.png"))));
		listaPersonajes.add(new Aliado("Vega",14,30,15,new Arma("Espada",0.4),new ImageIcon(getClass().getResource("/imagenes/centauroF.png"))));
		listaPersonajes.add(new Aliado("MUtante",18,20,5,new Arma("Cencerro",0.3),new ImageIcon(getClass().getResource("/imagenes/vaca.png"))));
		listaPersonajes.add(new Aliado("Batman",19,45,12,new Arma("Batarang",0.9),new ImageIcon(getClass().getResource("/imagenes/batman.png"))));
		listaPersonajes.add(new Aliado("Humberto",18,30,9,new Arma("Pistolas",0.5),new ImageIcon(getClass().getResource("/imagenes/pirata.png"))));
		listaPersonajes.add(new Aliado("Pandillo",10,10,10,new Arma("Lanza",0.2),new ImageIcon(getClass().getResource("/imagenes/pardillo.png"))));
		listaPersonajes.add(new Aliado("GluGluGlus",10,25,6,new Arma("Tridente",0.5),new ImageIcon(getClass().getResource("/imagenes/peces.png"))));
	}

	
	public void crearEnemigos() {
		listaEnemigos.add(new Enemigo("Ryu",14,20,15,new Arma("Botellas",0.8),new ImageIcon(getClass().getResource("/imagenes/ryu.png"))));
		listaEnemigos.add(new Enemigo("Wof LightYear",15,40,15,new Arma("Mando Espacial",0.8),new ImageIcon(getClass().getResource("/imagenes/mascota.png"))));
		listaEnemigos.add(new Enemigo("Bluebie",12,50,2,new Arma("Mordisco",0.8),new ImageIcon(getClass().getResource("/imagenes/zombie.png"))));
		listaEnemigos.add(new Enemigo("Caballero Invisible",15,20,12,new Arma("Espada",0.8),new ImageIcon(getClass().getResource("/imagenes/caballeroInvisible.png"))));
		listaEnemigos.add(new Enemigo("Rocky",20,20,11,new Arma("Gancho de derechas",0.8),new ImageIcon(getClass().getResource("/imagenes/boxeador.png"))));
		listaEnemigos.add(new Enemigo("Joker",20,50,15,new Arma("Gas de la risa",0.8),new ImageIcon(getClass().getResource("/imagenes/joker.png"))));
		listaEnemigos.add(new Enemigo("Yunke",16,35,11,new Arma("Jab",0.8),new ImageIcon(getClass().getResource("/imagenes/yunque.png"))));
		listaEnemigos.add(new Enemigo("Piranio",14,30,8,new Arma("Tecnologia",0.8),new ImageIcon(getClass().getResource("/imagenes/pez.png"))));
	}


	public void setEscuchador(EscuchadorPersonajes escPersonaje) {
		this.escPersonaje=escPersonaje;
		
	}
	public boolean esAliado() {
		return esAliado;
	}
}
