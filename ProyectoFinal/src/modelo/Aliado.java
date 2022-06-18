package modelo;

import javax.swing.ImageIcon;

public class Aliado extends Personaje{
	public Aliado(String nombre, int dano, int vida, int velocidad, Arma arma, ImageIcon img) {
		super(nombre, dano, vida, velocidad, arma, img);
	
	}
	private Enemigo enemigo;

	
	public void setEnemigo(Enemigo enemigo) {
		this.enemigo=enemigo;
	}
	public String atacar(){
		
		if(enemigo.estaProtegido()==true) {
			enemigo.recibirAtaque(0);
			return getNombre()+ " ha atacado a "+enemigo.getNombre()+" pero se esta protegiendo y no ha recibido daño ";
		}else {
			int ataque=realizarAtaque();
			enemigo.recibirAtaque(ataque);
			if(ataque==0) {
				return getNombre()+ " ha intentado atacar a "+enemigo.getNombre()+" pero ha fallado";
			}else {
				return getNombre()+ " ha atacado a "+enemigo.getNombre()+" y le ha hecho "+ataque+" puntos de daño";
			}
		}
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
}
