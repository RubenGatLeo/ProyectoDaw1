package vista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import control.EscuchadorPelea;
import control.EscuchadorPersonajes;
import modelo.Aliado;
import modelo.Arma;
import modelo.Enemigo;
import modelo.MiPanel;
import modelo.PanelSelector;
import java.awt.Dialog.ModalExclusionType;


public class ProyectoPelea {

	private JFrame frmJuego;
	private JLabel vidaAliado;
	private Aliado elegido;
	private Enemigo enemigo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProyectoPelea window = new ProyectoPelea();
					window.frmJuego.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProyectoPelea() {
		initialize();
	}

	public void setAliado(Aliado elegido) {
		this.elegido=elegido;
	}
	
	public void setEnemigo(Enemigo enemigo) {
		this.enemigo=enemigo;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmJuego = new JFrame();
		frmJuego.setResizable(false);
		frmJuego.setTitle("Juego");
		frmJuego.setBounds(600, 300, 719, 437);
		frmJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJuego.getContentPane().setLayout(null);
		
		EscuchadorPersonajes escPersonaje=new EscuchadorPersonajes();
		escPersonaje.setFrame(this);
	
		EscuchadorPersonajes escEnemigo=new EscuchadorPersonajes();
		escEnemigo.setFrame(this);
		

		PanelSelector selectorAliado=new PanelSelector(frmJuego,true,escPersonaje);
		PanelSelector selectorEnemigo=new PanelSelector(frmJuego,escEnemigo);
		
		MiPanel panel = new MiPanel();
		panel.setBounds(0, 0, 703, 327);
		frmJuego.getContentPane().add(panel);
		panel.setLayout(null);

		
		JProgressBar barraVidaAliado = new JProgressBar();
		barraVidaAliado.setForeground(new Color(0, 128, 0));
		barraVidaAliado.setBackground(Color.WHITE);
		barraVidaAliado.setBounds(22, 125, 146, 14);
		panel.add(barraVidaAliado);
		
		JProgressBar barraVidaEnemigo = new JProgressBar();
		barraVidaEnemigo.setValue(100);
		barraVidaEnemigo.setForeground(new Color(0, 128, 0));
		barraVidaEnemigo.setBackground(Color.WHITE);
		barraVidaEnemigo.setBounds(479, 36, 146, 14);
		panel.add(barraVidaEnemigo);
		
		
		
		//Asignaciones al escuchador y de los botones
		EscuchadorPelea escPelea=new EscuchadorPelea();
		panel.setImagenAliado(elegido.getImagen());
		panel.setImagenEnemigo(enemigo.getImagen());
		
		elegido.setEnemigo(enemigo);
		enemigo.setEnemigo(elegido);
		escPelea.setPersonajeElegido(elegido);
		escPelea.setPersonajeEnemigo(enemigo);
		barraVidaAliado.setValue(elegido.vidaRestante());
		barraVidaAliado.setMaximum(elegido.vidaRestante());
		barraVidaEnemigo.setValue(enemigo.vidaRestante());
		barraVidaEnemigo.setMaximum(enemigo.vidaRestante());
		escPelea.setBarraVidaAliado(barraVidaAliado);
		escPelea.setBarraVidaEnemigo(barraVidaEnemigo);
		vidaAliado = new JLabel(elegido.getVidaMax()+"/"+elegido.getVidaMax());
		vidaAliado.setBounds(122, 100, 46, 14);
		panel.add(vidaAliado);
		escPelea.setVidaAliado(vidaAliado);
		
		JLabel vidaEnemigo = new JLabel(enemigo.getVidaMax()+"/"+enemigo.getVidaMax());
		vidaEnemigo.setBounds(485, 11, 46, 14);
		escPelea.setVidaEnemigo(vidaEnemigo);
		panel.add(vidaEnemigo);
				
				JPanel acciones = new JPanel();
				acciones.setBounds(0, 326, 703, 72);
				frmJuego.getContentPane().add(acciones);
				acciones.setLayout(null);
				JButton atacar = new JButton("Atacar");
				atacar.setBounds(10, 23, 89, 23);
				acciones.add(atacar);
			
				
				JButton curar = new JButton("Curarse");
				curar.setBounds(128, 23, 89, 23);
				acciones.add(curar);
				
						
				JButton proteger = new JButton("Protegerse");
				proteger.setBounds(255, 23, 106, 23);
				acciones.add(proteger);
						
						
				JButton btnNewButton_3 = new JButton("Arma especial");
				btnNewButton_3.setBounds(400, 23, 148, 23);
				acciones.add(btnNewButton_3);
				escPelea.setPanel(acciones);
				
				JPanel panel_2 = new JPanel();
				panel_2.setBounds(0, 326, 703, 72);
				frmJuego.getContentPane().add(panel_2);
				panel_2.setLayout(null);
				panel_2.setVisible(true);
				JLabel cuadroTexto = new JLabel();
				cuadroTexto.setBounds(10, 5, 693, 67);
				panel_2.add(cuadroTexto);
				
				escPelea.setCuadroTexto(cuadroTexto);
				
		btnNewButton_3.addActionListener(escPelea);
		proteger.addActionListener(escPelea);
		curar.addActionListener(escPelea);
		atacar.addActionListener(escPelea);
		
				
	}
	
}
