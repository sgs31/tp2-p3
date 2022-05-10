package vistas;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import model.Grafo;
import model.ObjetoArista;
import vistas.util.MessageWindow;
import vistas.util.Observador;
import vistas.util.Sujeto;
import vistas.util.SujetoObservable;

import javax.swing.JPopupMenu;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;

public class Etiqueta<T> extends JLabel implements SujetoObservable  {
	
	private Observador observador;
	private String nombre;
	private Grafo grafo;
	private int id;
	private Sujeto tipo;
	
	public Etiqueta(String nombre, int id, Grafo g, Observador o, Sujeto tipo) {
		this.nombre = nombre;
		this.observador = o;
		this.grafo = g;
		this.id = id;
		
		setText(this.nombre);
		setHorizontalAlignment(SwingConstants.CENTER);
		setFont(new Font("Miriam Mono CLM", Font.BOLD, 11));
		
		if(id%2 == 0) {
			setForeground(Color.BLACK);
		}else {
			setForeground(Color.gray);
		}
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(this, popupMenu);
		
		JButton btnNewButton = new JButton("ELIMINAR");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tipo == Sujeto.ESPIA) {
					if(g.getVecinosDeUnEspia(nombre).size() == 0) {
						g.eliminarEspia(nombre);
						notificar(tipo);
					}else{
						MessageWindow error = new MessageWindow("Error", "No puede eliminar un espia que ya tiene conexion con otro.");
						error.setVisible(true);
					}
				}else {
					ObjetoArista temp = g.getRelacionesEntreEspias().get(id);
					g.eliminarRelacionEntreEspias(temp.getEspia1(), temp.getEspia2());
					notificar(tipo);
				}
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
	public void notificar(Sujeto tipo) {
		observador.actualizar(tipo);
	}
}
