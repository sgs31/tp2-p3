package vistas;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import vistas.util.Observador;
import vistas.util.Sujeto;
import vistas.util.SujetoObservable;

import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;

public class Etiqueta<T> extends JLabel implements SujetoObservable  {
	
	private Observador observador;
	private String nombre;
	private ArrayList<T> container;
	private int id;
//	, ArrayList<T> container, int id, Observador o
	
	public Etiqueta(String nombre) {
		this.nombre = nombre;
//		this.observador = o;
//		this.container = container;
//		this.id = id;
		
		setText(this.nombre);
		setHorizontalAlignment(SwingConstants.CENTER);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(this, popupMenu);
		
		JButton btnNewButton = new JButton("ELIMINAR");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				container.remove(id);
				observador.actualizar();
			}
		});
		popupMenu.add(btnNewButton);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	@Override
	public void notificar() {
		// TODO Auto-generated method stub
		
	}
}
