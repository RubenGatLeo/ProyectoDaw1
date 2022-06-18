package modelo;

import javax.swing.ImageIcon;

public class Enemigo extends Personaje{
	public Enemigo(String nombre, int dano, int vida, int velocidad, Arma arma, ImageIcon img) {
		super(nombre, dano, vida, velocidad, arma, img);
	
	}
	private Aliado enemigo;

	
	public void setEnemigo(Aliado enemigo) {
		this.enemigo=enemigo;
	}
	public String realizarAccion() {
		int eleccion=(int)(Math.random()*50)+1;
		String accion="";
		int numero;
		//genera uhn numero entre 1 y 51 dependeiedno el que sea atca se cura se protege o hace ataque especial
	
		if(eleccion>=1&&eleccion<30) {
			//comprueba que el rival no este protegido
			if(enemigo.estaProtegido()==true) {
				numero= realizarAtaque();
				return getNombre()+ " ha atacado a "+enemigo.getNombre()+" pero se esta protegiendo y no ha recibido daño ";
			}else {
				numero= realizarAtaque();
				if(numero==0) {
					return getNombre()+ " ha intentado atacar a "+enemigo.getNombre()+" pero ha fallado";
				}else {
					accion=getNombre()+" ha atacado a "+enemigo.getNombre()+" y le ha hecho "+numero+" puntos de daño";
				}
			}
			//comprueba no tener la vida al maximo
		}else if(eleccion>=30&&eleccion<40){
			if(vidaRestante()==getVidaMax()) {
				if(enemigo.estaProtegido()==true) {
					numero= realizarAtaque();
					return getNombre()+ " ha atacado a "+enemigo.getNombre()+" pero se esta protegiendo y no ha recibido daño ";
				}else {
					numero= realizarAtaque();
					if(numero==0) {
						return getNombre()+ " ha intentado atacar a "+enemigo.getNombre()+" pero ha fallado";
					}else {
						accion=getNombre()+" ha atacado a "+enemigo.getNombre()+" y le ha hecho "+numero+" puntos de daño";
					}
				}
			}else {
				accion=curarse();
			}
			
		}else if(eleccion>=40&&eleccion<=49) {
			//comprueba que no se este protegiendo ya 
			if(estaProtegido()==true) {
				if(enemigo.estaProtegido()==true) {
					numero= realizarAtaque();
					return getNombre()+ " ha atacado a "+enemigo.getNombre()+" pero se esta protegiendo y no ha recibido daño ";
				}else {
					numero= realizarAtaque();
					if(numero==0) {
						return getNombre()+ " ha intentado atacar a "+enemigo.getNombre()+" pero ha fallado";
					}else {
						accion=getNombre()+" ha atacado a "+enemigo.getNombre()+" y le ha hecho "+numero+" puntos de daño";
					}
				}
			}else {
			accion=protegerse();
			}
		}else {
			accion=atacarConArma();
		}
		return accion;
		
	}
	
public String atacarConArma(){
		
		if(enemigo.estaProtegido()==true) {
			enemigo.recibirAtaque(0);
			return getNombre()+ " ha atacado a "+enemigo.getNombre()+" pero se esta protegiendo y no ha recibido daño ";
		}else {
			double dano=arma.getBonificacion();
			int ataque=realizarAtaque();
			ataque=ataque+(int)(ataque*dano);
			
			enemigo.recibirAtaque(ataque);
			if(ataque==0) {
				return getNombre()+ " ha intentado atacar a "+enemigo.getNombre()+" pero ha fallado";
			}else {
				return getNombre()+ " ha atacado a "+enemigo.getNombre()+" utilizando " +arma.getNombre()+ " y  le ha hecho "+ataque+" puntos de daño";
			}
		}
	}
	public int realizarAtaque(){
		int ataque=super.realizarAtaque();
		enemigo.recibirAtaque(ataque);
		return ataque;
		}

}
