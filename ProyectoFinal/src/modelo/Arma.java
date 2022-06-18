package modelo;

public class Arma {
	private String nombre;
	private double bonificacion;
	
	public Arma(String nombre,double bonificacion) {
		this.nombre=nombre;
		this.bonificacion=bonificacion;
	}
	public double getBonificacion() {
		return bonificacion;
	}
	public String getNombre() {
		return nombre;
	}
}
