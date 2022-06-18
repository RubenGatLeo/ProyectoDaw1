package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import modelo.Aliado;
import modelo.Enemigo;
import modelo.InfoBatalla;

public class EscuchadorPelea implements ActionListener{
	private JPanel acciones;
	private JProgressBar barraVidaAliado;
	private JProgressBar barraVidaEnemigo;
	private Aliado elegido;
	private Enemigo enemigo;
	private JLabel cuadroTexto;
	private JLabel vidaAliado;
	private JLabel vidaEnemigo;
	private boolean ataqueEspecial=false;

	@Override
	public void actionPerformed(ActionEvent e) {
	
		int accionPrimera;
		int accionSegunda;
			
		if(e.getActionCommand().equalsIgnoreCase("Atacar")) {//accion para el boton atacar 
			ataqueEspecial=false;
			if(elegido.getVelocidad()>=enemigo.getVelocidad()) {//comprueba velocidad y crea un hilo en el que el jugador ataca
			ataqueEspecial=false;
			accionPrimera=1;
			accionSegunda=0;
			
			
			
			InfoBatalla pelea=new InfoBatalla(cuadroTexto,acciones,elegido,enemigo,barraVidaAliado,barraVidaEnemigo,vidaAliado,vidaEnemigo);
			pelea.setAccionPrimera(accionPrimera);
			pelea.setAccionSegunda(accionSegunda);
			pelea.start();
			
			}else {
				accionPrimera=0;
				accionSegunda=1;
				
				InfoBatalla pelea=new InfoBatalla(cuadroTexto,acciones,elegido,enemigo,barraVidaAliado,barraVidaEnemigo,vidaAliado,vidaEnemigo);
				pelea.setAccionPrimera(accionPrimera);
				pelea.setAccionSegunda(accionSegunda);
				pelea.start();
			}
			//cuadroTexto.setVisible(false);
			}else if(e.getActionCommand().equalsIgnoreCase("Curarse")) {//accion para boton curarse
				
				if(elegido.vidaRestante()==elegido.getVidaMax()) {//En caso de que la vida ya este al maximo
					acciones.setVisible(true);
					JOptionPane.showMessageDialog(null, "Tu vida ya esta al maximo");
				}else if(elegido.getVelocidad()>=enemigo.getVelocidad()) {//comprueba velocidad y crea un hilo en el que el jugador se cura
					ataqueEspecial=false;
					accionPrimera=2;
					accionSegunda=0;
					
					InfoBatalla pelea=new InfoBatalla(cuadroTexto,acciones,elegido,enemigo,barraVidaAliado,barraVidaEnemigo,vidaAliado,vidaEnemigo);
					pelea.setAccionPrimera(accionPrimera);
					pelea.setAccionSegunda(accionSegunda);
					pelea.start();
					}else {
						ataqueEspecial=false;
						accionPrimera=0;
						accionSegunda=2;
						
						InfoBatalla pelea=new InfoBatalla(cuadroTexto,acciones,elegido,enemigo,barraVidaAliado,barraVidaEnemigo,vidaAliado,vidaEnemigo);
						pelea.setAccionPrimera(accionPrimera);
						pelea.setAccionSegunda(accionSegunda);
						pelea.start();
					}
				
			}else if(e.getActionCommand().equalsIgnoreCase("Protegerse")) {//accion para boton protegerse
				
				if(elegido.estaProtegido()==true) {//en caso de que ya se este protegiendo 
					acciones.setVisible(true);
					JOptionPane.showMessageDialog(null, "Ya te estas protegiendo");
					
				}else if(elegido.getVelocidad()>=enemigo.getVelocidad()) {//comprueba velocidad y crea un hilo en el que el jugador se protege
					ataqueEspecial=false;
					accionPrimera=3;
					accionSegunda=0;
					
					InfoBatalla pelea=new InfoBatalla(cuadroTexto,acciones,elegido,enemigo,barraVidaAliado,barraVidaEnemigo,vidaAliado,vidaEnemigo);
					pelea.setAccionPrimera(accionPrimera);
					pelea.setAccionSegunda(accionSegunda);
					pelea.start();
			
				}else {
					ataqueEspecial=false;
					accionPrimera=0;
					accionSegunda=3;
					
					InfoBatalla pelea=new InfoBatalla(cuadroTexto,acciones,elegido,enemigo,barraVidaAliado,barraVidaEnemigo,vidaAliado,vidaEnemigo);
					pelea.setAccionPrimera(accionPrimera);
					pelea.setAccionSegunda(accionSegunda);
					pelea.start();
				}
				
			}else if(e.getActionCommand().equalsIgnoreCase("Arma especial")) {//ACcion para el boton de arma especial
				if(ataqueEspecial==true) {//no se puede usar en dos asaltos seguidos asiq comprueba si lo acaba de utilizar
					JOptionPane.showMessageDialog(null, "No puedes usar el Arma Especial hasta el proximo asalto");
				
				}else if(elegido.getVelocidad()>=enemigo.getVelocidad()) {//comprueba velocidad y crea un hilo en el que el jugador usa su armaespecial
					ataqueEspecial=true;
					accionPrimera=4;
					accionSegunda=0;
					
					
					
					InfoBatalla pelea=new InfoBatalla(cuadroTexto,acciones,elegido,enemigo,barraVidaAliado,barraVidaEnemigo,vidaAliado,vidaEnemigo);
					pelea.setAccionPrimera(accionPrimera);
					pelea.setAccionSegunda(accionSegunda);
					pelea.start();
					
					}else {
						ataqueEspecial=true;
						accionPrimera=0;
						accionSegunda=4;
						
						InfoBatalla pelea=new InfoBatalla(cuadroTexto,acciones,elegido,enemigo,barraVidaAliado,barraVidaEnemigo,vidaAliado,vidaEnemigo);
						pelea.setAccionPrimera(accionPrimera);
						pelea.setAccionSegunda(accionSegunda);
						pelea.start();
					}
			}
	}
	//Setters de los atributos
	public void setPanel(JPanel acciones) {
		this.acciones = acciones;
	}

	public void setPersonajeElegido(Aliado elegido) {
		this.elegido=elegido;
	}
	public void setPersonajeEnemigo(Enemigo enemigo) {
		this.enemigo=enemigo;
	}
	
	public void setBarraVidaAliado(JProgressBar barraVidaAliado) {
		this.barraVidaAliado = barraVidaAliado;
	}
	public void setBarraVidaEnemigo(JProgressBar barraVidaEnemigo) {
		this.barraVidaEnemigo = barraVidaEnemigo;
	}
	public void setCuadroTexto(JLabel cuadroTexto) {
		this.cuadroTexto = cuadroTexto;
	}
	public void setVidaAliado(JLabel vidaAliado) {
		this.vidaAliado = vidaAliado;
	}
	public void setVidaEnemigo(JLabel vidaEnemigo) {
		this.vidaEnemigo = vidaEnemigo;
	}
	
	
}
