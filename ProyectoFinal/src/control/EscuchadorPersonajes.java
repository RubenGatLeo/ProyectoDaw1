package control;



import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import modelo.PanelPersonaje;
import modelo.PanelSelector;
import vista.ProyectoPelea;

public class EscuchadorPersonajes implements MouseListener{
	private ProyectoPelea juego;
	private PanelSelector dialogo;
	private ArrayList<PanelPersonaje> listaPersonajes=new ArrayList<PanelPersonaje>();
	@Override
	public void mouseClicked(MouseEvent e) {//Accion cuando clique en uno de los personajes
		if(dialogo.esAliado()==true) {
			for (int i =0; i<listaPersonajes.size();i++) {
				if(e.getSource()==listaPersonajes.get(i)) {
					juego.setAliado(listaPersonajes.get(i).getPersonaje());
					break;
				}
			}
		}else {
			for (int i =0; i<listaPersonajes.size();i++) {
				if(e.getSource()==listaPersonajes.get(i)) {
					juego.setEnemigo(listaPersonajes.get(i).getEnemigo());
					break;
				}
			}
		}
		dialogo.cerrarDialogo();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {

		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) { //cuando entra en el panel del personaje que cambie el fondo
		for (int i =0; i<listaPersonajes.size();i++) {
			if(e.getSource()==listaPersonajes.get(i)) {
				listaPersonajes.get(i).setBackground(Color.YELLOW);
				
				break;
			}
		}	
		
	}

	@Override
	public void mouseExited(MouseEvent e) {//cuando salga del panel que vuelva el color de fondo al color del principio
		for (int i =0; i<listaPersonajes.size();i++) {
			if(e.getSource()==listaPersonajes.get(i)) {
				listaPersonajes.get(i).setBackground(Color.WHITE);
				break;
			}
		}	
		
	}

	public void setPanel(PanelPersonaje p) {
		listaPersonajes.add(p);
	}
	public void setFrame(ProyectoPelea juego) {
		this.juego=juego;
	}
	public void setDialogo(PanelSelector dialogo) {
		this.dialogo=dialogo;
	}
}
