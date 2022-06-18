package modelo;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class InfoBatalla extends Thread{
	
	private Aliado elegido;
	private Enemigo enemigo;
	private int accionPrimera;
	private int accionSegunda;
	private JProgressBar barraVidaAliado;
	private JProgressBar barraVidaEnemigo;
	private JLabel cuadroTexto;
	private JLabel vidaAliado;
	private JLabel vidaEnemigo;
	private JPanel panel;
	
	public InfoBatalla(JLabel cuadroTexto,JPanel panel,Aliado elegido,Enemigo enemigo,JProgressBar barraVidaAliado,JProgressBar barraVidaEnemigo,JLabel vidaAliado,JLabel vidaEnemigo) {
		this.cuadroTexto=cuadroTexto;
		this.panel=panel;
		this.elegido=elegido;
		this.enemigo=enemigo;
		this.barraVidaAliado=barraVidaAliado;
		this.barraVidaEnemigo=barraVidaEnemigo;
		this.vidaAliado=vidaAliado;
		this.vidaEnemigo=vidaEnemigo;
	}
	@Override
	public void run() {
		panel.setVisible(false);
		cuadroTexto.setVisible(true);
		String accion1="";
		String accion2="";
		int vidaEnemigoActual=enemigo.vidaRestante();// vidas del enemigo y aliado antes de empezar el asalto
		int vidaAliadoActual=elegido.vidaRestante();
		if(accionPrimera==0) {//Si el enemigo es el mas rapido realizara una accion al azar
			
			
			accion1=enemigo.realizarAccion();
			for(int i=vidaEnemigoActual;i<enemigo.vidaRestante();i++) {// en caso de curarse
				barraVidaEnemigo.setValue(barraVidaEnemigo.getValue()+1);
				vidaEnemigo.setText(barraVidaEnemigo.getValue()+"/"+enemigo.getVidaMax());
				if(barraVidaEnemigo.getValue()>(enemigo.getVidaMax()/2)) {
					barraVidaEnemigo.setForeground(new Color(0,128,0));
				}else if(barraVidaEnemigo.getValue()>5 && barraVidaEnemigo.getValue()<=(enemigo.getVidaMax()/2)) {
					barraVidaEnemigo.setForeground(Color.ORANGE);
				}else {
					barraVidaEnemigo.setForeground(Color.RED);
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			for(int i=vidaAliadoActual;i>elegido.vidaRestante();i--) {// en caso de atacar
				barraVidaAliado.setValue(barraVidaAliado.getValue()-1);
				vidaAliado.setText(barraVidaAliado.getValue()+"/"+elegido.getVidaMax());
				if(barraVidaAliado.getValue()>(elegido.getVidaMax()/2)) {
					barraVidaAliado.setForeground(new Color(0,128,0));
				}else if(barraVidaAliado.getValue()>5 && barraVidaAliado.getValue()<=(elegido.getVidaMax()/2)) {
					barraVidaAliado.setForeground(Color.ORANGE);
				}else {
					barraVidaAliado.setForeground(Color.RED);
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		
		}else if(accionPrimera==1) {//Si el aliado es mas rapido y ataca
			accion1=elegido.atacar();
			for(int i=vidaEnemigoActual;i>enemigo.vidaRestante();i--) {
				barraVidaEnemigo.setValue(barraVidaEnemigo.getValue()-1);
				vidaEnemigo.setText(barraVidaEnemigo.getValue()+"/"+enemigo.getVidaMax());
				if(barraVidaEnemigo.getValue()>(enemigo.getVidaMax()/2)) {
					barraVidaEnemigo.setForeground(new Color(0,128,0));
				}else if(barraVidaEnemigo.getValue()>5 && barraVidaEnemigo.getValue()<=(enemigo.getVidaMax()/2)) {
					barraVidaEnemigo.setForeground(Color.ORANGE);
				}else {
					barraVidaEnemigo.setForeground(Color.RED);
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}else if(accionPrimera==2) {//Si el aliado es mas rapido y se cura
			accion1=elegido.curarse();
			
			for(int i=vidaAliadoActual;i<elegido.vidaRestante();i++) {
				barraVidaAliado.setValue(barraVidaAliado.getValue()+1);
				vidaAliado.setText(barraVidaAliado.getValue()+"/"+elegido.getVidaMax());
				if(barraVidaAliado.getValue()>(elegido.getVidaMax()/2)) {
					barraVidaAliado.setForeground(new Color(0,128,0));
				}else if(barraVidaAliado.getValue()>5 && barraVidaAliado.getValue()<=(elegido.getVidaMax()/2)) {
					barraVidaAliado.setForeground(Color.ORANGE);
				}else {
					barraVidaAliado.setForeground(Color.RED);
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}else if(accionPrimera==3) {//Si el aliado es mas rapido y se protege
			accion1=elegido.protegerse();
		
		}else if(accionPrimera==4) {// si el aliado es mas rapido y hace ataque con arma especial
			accion1=elegido.atacarConArma();
			for(int i=vidaEnemigoActual;i>enemigo.vidaRestante();i--) {
				barraVidaEnemigo.setValue(barraVidaEnemigo.getValue()-1);
				vidaEnemigo.setText(barraVidaEnemigo.getValue()+"/"+enemigo.getVidaMax());
				if(barraVidaEnemigo.getValue()>(enemigo.getVidaMax()/2)) {
					barraVidaEnemigo.setForeground(new Color(0,128,0));
				}else if(barraVidaEnemigo.getValue()>5 && barraVidaEnemigo.getValue()<=(enemigo.getVidaMax()/2)) {
					barraVidaEnemigo.setForeground(Color.ORANGE);
				}else {
					barraVidaEnemigo.setForeground(Color.RED);
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		for(int i=0;i<accion1.length();i++) {
			accion2=accion2+accion1.charAt(i);
			cuadroTexto.setText(accion2);
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(elegido.vidaRestante()<=0) {
			JOptionPane.showMessageDialog(null, "Has perdido contra "+enemigo.getNombre()+" otra vez sera ;)");
			System.exit(0);
		}else if (enemigo.vidaRestante()<=0){
			JOptionPane.showMessageDialog(null, "Has derrotado a "+enemigo.getNombre()+" Enhorabuena");
		
			System.exit(0);
		}
			String accionLento="";
			String accionLento2="";
			vidaEnemigoActual=enemigo.vidaRestante();// vidas del enemigo y aliado antes de empezar el asalto
			vidaAliadoActual=elegido.vidaRestante();
			if(accionSegunda==0) {//Si el enemigo es mas lento ataca despues accion aleatoria
				accionLento=enemigo.realizarAccion();
				for(int i=vidaEnemigoActual;i<enemigo.vidaRestante();i++) {
					barraVidaEnemigo.setValue(barraVidaEnemigo.getValue()+1);
					vidaEnemigo.setText(barraVidaEnemigo.getValue()+"/"+enemigo.getVidaMax());
					if(barraVidaEnemigo.getValue()>(enemigo.getVidaMax()/2)) {
						barraVidaEnemigo.setForeground(new Color(0,128,0));
					}else if(barraVidaEnemigo.getValue()>5 && barraVidaEnemigo.getValue()<=(enemigo.getVidaMax()/2)) {
						barraVidaEnemigo.setForeground(Color.ORANGE);
					}else {
						barraVidaEnemigo.setForeground(Color.RED);
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {// en caso de  curarse
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
					for(int i=vidaAliadoActual;i>elegido.vidaRestante();i--) {// en caso de atacar
						barraVidaAliado.setValue(barraVidaAliado.getValue()-1);
						vidaAliado.setText(barraVidaAliado.getValue()+"/"+elegido.getVidaMax());
						if(barraVidaAliado.getValue()>(elegido.getVidaMax()/2)) {
							barraVidaAliado.setForeground(new Color(0,128,0));
						}else if(barraVidaAliado.getValue()>5 && barraVidaAliado.getValue()<=(elegido.getVidaMax()/2)) {
							barraVidaAliado.setForeground(Color.ORANGE);
						}else {
							barraVidaAliado.setForeground(Color.RED);
						}
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				
				
				
			}else if(accionSegunda==1) {//Si el aliado es mas lento ataca despues 
				accionLento=elegido.atacar();
				for(int i=vidaEnemigoActual;i>enemigo.vidaRestante();i--) {
					barraVidaEnemigo.setValue(barraVidaEnemigo.getValue()-1);
					vidaEnemigo.setText(barraVidaEnemigo.getValue()+"/"+enemigo.getVidaMax());
					if(barraVidaEnemigo.getValue()>(enemigo.getVidaMax()/2)) {
						barraVidaEnemigo.setForeground(new Color(0,128,0));
					}else if(barraVidaEnemigo.getValue()>5 && barraVidaEnemigo.getValue()<=(enemigo.getVidaMax()/2)) {
						barraVidaEnemigo.setForeground(Color.ORANGE);
					}else {
						barraVidaEnemigo.setForeground(Color.RED);
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
			}else if(accionSegunda==2) {//Si el aliado es mas lento se cura despues
				accionLento=elegido.curarse();
				//simular que la barra de vida va subiendo
				for(int i=vidaAliadoActual;i<elegido.vidaRestante();i++) {
					barraVidaAliado.setValue(barraVidaAliado.getValue()+1);
					vidaAliado.setText(barraVidaAliado.getValue()+"/"+elegido.getVidaMax());
					if(barraVidaAliado.getValue()>(elegido.getVidaMax()/2)) {
						barraVidaAliado.setForeground(new Color(0,128,0));
					}else if(barraVidaAliado.getValue()>5 && barraVidaAliado.getValue()<=(elegido.getVidaMax()/2)) {
						barraVidaAliado.setForeground(Color.ORANGE);
					}else {
						barraVidaAliado.setForeground(Color.RED);
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}else if(accionSegunda==3) {//Si el aliado es mas lento se protege despues
				accionLento=elegido.protegerse();
				
			}else if(accionSegunda==4) {// si el aliado es mas lento y hace ataque con arma especial
				accionLento=elegido.atacarConArma();
				for(int i=vidaEnemigoActual;i>enemigo.vidaRestante();i--) {
					barraVidaEnemigo.setValue(barraVidaEnemigo.getValue()-1);
					vidaEnemigo.setText(barraVidaEnemigo.getValue()+"/"+enemigo.getVidaMax());
					if(barraVidaEnemigo.getValue()>(enemigo.getVidaMax()/2)) {
						barraVidaEnemigo.setForeground(new Color(0,128,0));
					}else if(barraVidaEnemigo.getValue()>5 && barraVidaEnemigo.getValue()<=(enemigo.getVidaMax()/2)) {
						barraVidaEnemigo.setForeground(Color.ORANGE);
					}else {
						barraVidaEnemigo.setForeground(Color.RED);
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			for(int i=0;i<accionLento.length();i++) {
				accionLento2=accionLento2+accionLento.charAt(i);
				cuadroTexto.setText(accionLento2);
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}	
			
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		if(elegido.vidaRestante()<=0) {
			JOptionPane.showMessageDialog(null, "Has perdido contra "+enemigo.getNombre()+" otra vez sera ;)");
			System.exit(0);//Cierra el programa
			
			
		}else if (enemigo.vidaRestante()<=0){
			JOptionPane.showMessageDialog(null, "Has derrotado a "+enemigo.getNombre()+" Enhorabuena");
			System.exit(0);
			
		}
		panel.setVisible(true);
		cuadroTexto.setText("");
	}
	public void setAccionPrimera(int accionPrimera) {
		this.accionPrimera = accionPrimera;
	}

	public void setAccionSegunda(int accionSegunda) {
		this.accionSegunda = accionSegunda;
	}
	
}
