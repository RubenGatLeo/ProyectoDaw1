package modelo;

import javax.swing.ImageIcon;

public class Personaje {
	protected String nombre;
	protected int dano;
	protected int vida;
	protected int vidaMax;
	protected int velocidad;
	protected boolean protegerse;
	protected Arma arma;
	protected ImageIcon img;
	
	public Personaje(String nombre,int dano,int vida,int velocidad, Arma arma, ImageIcon img) {
		this.nombre=nombre;
		this.dano=dano;
		this.vida=vida;
		vidaMax=vida;
		this.velocidad=velocidad;
		this.arma=arma;
		this.img=img;
	}
	public int realizarAtaque() {
		int ataque=(int)(Math.random()*(dano+1));
		return ataque;
	}
	public void recibirAtaque(int ataque) {
		if (this.protegerse==true) {
			this.protegerse=false;
		}else {
			vida=vida-ataque;
			if(vida<0) {
				vida=0;
			}
		
		}
	}
	public String curarse() {
		int cura=(int)(Math.random()*11);
		vida=vida+cura;
		if (vida>vidaMax) {
			vida=vidaMax;
		}
		String accion="";
		if(cura==0) {
			accion=getNombre()+" ha intentado curarse pero ha fallado \r\n Vida restante de "+getNombre()+" "+vidaRestante();
		}else {
		accion=getNombre()+" se ha curado "+cura+" puntos de vida \r\n Vida restante de "+getNombre()+" "+vidaRestante();
		}
		return accion;
	}
	public String protegerse(){
		this.protegerse=true;
		return getNombre()+" se ha protegido y no recibira daño la proxima vez que le ataquen";
	}
	public boolean estaProtegido() {
		if (protegerse==true) {
			return true;
		}
		return false;
	}
	public int vidaRestante() {
		return vida;
	}
	
	public void setArma(Arma a) {
		arma=a;
	}
	public int getVelocidad() {
		return velocidad;
	}
	public String getNombre() {
		return nombre;
	}
	public ImageIcon getImagen() {
		return img;
	}
	public int getVidaMax() {
		return vidaMax;
	}
	public int getDano() {
		return dano;
	}
}
