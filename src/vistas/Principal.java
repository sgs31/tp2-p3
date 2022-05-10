package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;

import model.Grafo;
import model.Kruskal;
import vistas.util.MessageWindow;
import vistas.util.Observador;
import vistas.util.Sujeto;

import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Hashtable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import java.awt.Rectangle;
import java.awt.GridLayout;
import javax.swing.ImageIcon;

public class Principal implements Observador{
	
	private JFrame frmTemibleOperarioDel;
	private JTextField inputEspia;
	private Grafo grafo;
	private JPanel espiasContainer;
	private JPanel conexionesContainer;
	private JComboBox comboBoxEspia1;
	private JComboBox comboBoxEspia2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frmTemibleOperarioDel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Principal() {
		grafo = new Grafo();
		initialize();
	}

	private void initialize() {
		Principal ref = this;
		frmTemibleOperarioDel = new JFrame();
		frmTemibleOperarioDel.setTitle("Temible operario del recontraespionaje");
		frmTemibleOperarioDel.setBounds(100, 100, 731, 491);
		frmTemibleOperarioDel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTemibleOperarioDel.getContentPane().setLayout(null);
		
		JLabel indicadorEspiasContainer = new JLabel("Nuestros espias");
		indicadorEspiasContainer.setHorizontalAlignment(SwingConstants.CENTER);
		indicadorEspiasContainer.setFont(new Font("Miriam Mono CLM", Font.BOLD, 11));
		indicadorEspiasContainer.setBounds(44, 123, 185, 23);
		frmTemibleOperarioDel.getContentPane().add(indicadorEspiasContainer);
		
		JLabel misionLabel = new JLabel("MISION: Temible operario del recontraespionaje.");
		misionLabel.setFont(new Font("Miriam Mono CLM", Font.BOLD, 14));
		misionLabel.setBounds(44, 11, 588, 36);
		frmTemibleOperarioDel.getContentPane().add(misionLabel);
		
		JLabel objetivoLabel = new JLabel("OBJETIVO: Enviar un mensaje secreto entre todos los espias sin ser detectados.");
		objetivoLabel.setFont(new Font("Miriam Mono CLM", Font.BOLD, 14));
		objetivoLabel.setBounds(44, 58, 649, 14);
		frmTemibleOperarioDel.getContentPane().add(objetivoLabel);
		
		JLabel indicadorConexionesContainer = new JLabel("Conexiones");
		indicadorConexionesContainer.setHorizontalAlignment(SwingConstants.CENTER);
		indicadorConexionesContainer.setFont(new Font("Miriam Mono CLM", Font.BOLD, 11));
		indicadorConexionesContainer.setBounds(486, 127, 189, 19);
		frmTemibleOperarioDel.getContentPane().add(indicadorConexionesContainer);
		
		espiasContainer = new JPanel();
		espiasContainer.setBorder(new LineBorder(Color.LIGHT_GRAY));
		espiasContainer.setBackground(Color.WHITE);
		espiasContainer.setBounds(44, 157, 189, 216);
		frmTemibleOperarioDel.getContentPane().add(espiasContainer);
		espiasContainer.setLayout(new GridLayout(10, 0, 0, 0));
		
		
		conexionesContainer = new JPanel();
		conexionesContainer.setBorder(new LineBorder(Color.LIGHT_GRAY));
		conexionesContainer.setBackground(Color.WHITE);
		conexionesContainer.setBounds(486, 157, 189, 216);
		frmTemibleOperarioDel.getContentPane().add(conexionesContainer);
		conexionesContainer.setLayout(new GridLayout(10, 0, 0, 0));
		
		JLabel indicadorInputEspias = new JLabel("Reclutar espia");
		indicadorInputEspias.setHorizontalAlignment(SwingConstants.CENTER);
		indicadorInputEspias.setFont(new Font("Miriam Mono CLM", Font.BOLD, 11));
		indicadorInputEspias.setBounds(275, 127, 166, 14);
		frmTemibleOperarioDel.getContentPane().add(indicadorInputEspias);
			
		JLabel indicadorInputConexiones = new JLabel("Anadir conexiones");
		indicadorInputConexiones.setHorizontalAlignment(SwingConstants.CENTER);
		indicadorInputConexiones.setFont(new Font("Miriam Mono CLM", Font.BOLD, 11));
		indicadorInputConexiones.setBounds(275, 184, 166, 14);
		frmTemibleOperarioDel.getContentPane().add(indicadorInputConexiones);
		
		JButton enviarMensajeButton = new JButton("ENVIAR MENSAJE");
		enviarMensajeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!grafo.isGrafoConexo()) {
					MessageWindow error = new MessageWindow("Error", "Debe existe una via de comunicacion entre todos los espias");
					error.setVisible(true);
				}else {
					if(grafo.getRelacionesEntreEspias().size() == 0) {
						MessageWindow error = new MessageWindow("Error", "Debe existe al menos una conexion entre espias");
						error.setVisible(true);
					}else {
						Kruskal kruskal = new Kruskal(grafo);
						Grafo nuevoGrafo = kruskal.arbolGeneradorMinimo();
						Resultados resultados = new Resultados(nuevoGrafo);
						resultados.setVisible(true);
					}	
				}
				
			}
		});
		enviarMensajeButton.setFont(new Font("Miriam Mono CLM", Font.BOLD, 11));
		enviarMensajeButton.setBounds(290, 390, 136, 23);
		frmTemibleOperarioDel.getContentPane().add(enviarMensajeButton);
		
		JPanel formConexionesContainer = new JPanel();
		formConexionesContainer.setBounds(270, 202, 171, 171);
		frmTemibleOperarioDel.getContentPane().add(formConexionesContainer);
		formConexionesContainer.setLayout(null);
		
		comboBoxEspia1 = new JComboBox();
		comboBoxEspia1.setFont(new Font("Miriam Mono CLM", Font.BOLD, 11));
		comboBoxEspia1.setToolTipText("");
		comboBoxEspia1.setBounds(36, 11, 92, 22);
		formConexionesContainer.add(comboBoxEspia1);
		
		comboBoxEspia2 = new JComboBox();
		comboBoxEspia2.setFont(new Font("Miriam Mono CLM", Font.BOLD, 11));
		comboBoxEspia2.setToolTipText("");
		comboBoxEspia2.setBounds(36, 44, 92, 22);
		formConexionesContainer.add(comboBoxEspia2);
		
		JSlider probabilidadDeExito = new JSlider();
		probabilidadDeExito.setMaximum(100);
		probabilidadDeExito.setBounds(10, 87, 151, 40);
		probabilidadDeExito.setMajorTickSpacing(20);
		probabilidadDeExito.setPaintTicks(true);
		
		
		Hashtable labelTable = new Hashtable();
		labelTable.put( 0, new JLabel("0") );
		labelTable.put( 100, new JLabel("100") );
		probabilidadDeExito.setLabelTable(labelTable);
		
		probabilidadDeExito.setPaintLabels(true);
		
		formConexionesContainer.add(probabilidadDeExito);
		
		JLabel indicadorProbabilidadDeExito = new JLabel("Probabilidad de exito");
		indicadorProbabilidadDeExito.setHorizontalAlignment(SwingConstants.CENTER);
		indicadorProbabilidadDeExito.setFont(new Font("Miriam Mono CLM", Font.BOLD, 11));
		indicadorProbabilidadDeExito.setBounds(0, 70, 171, 14);
		formConexionesContainer.add(indicadorProbabilidadDeExito);
		
		JButton agregarConexionButton = new JButton("+");
		agregarConexionButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String espia1 = comboBoxEspia1.getSelectedItem().toString();
				String espia2 = comboBoxEspia2.getSelectedItem().toString();
				int probabilidadIntercepcion = 100 - probabilidadDeExito.getValue();
				
				if(espia1.equals(espia2)) {
					MessageWindow errorMensaje = new MessageWindow("Error", "Un espia no puede relacionarse consigo mismo");
					errorMensaje.setVisible(true);
				}else {
					boolean isConexionAgregada = grafo.agregarRelacionEntreEspias(espia1, espia2, probabilidadIntercepcion);
					if(isConexionAgregada){
						String nombreConexion = espia1 + " <---> " + espia2;
						conexionesContainer.add(crearEtiquetaConexion(nombreConexion));
						actualizarVistaContainer(conexionesContainer);
					}
					else{
						MessageWindow errorMensaje = new MessageWindow("Error", "Ups, algo salio mal!");
						errorMensaje.setVisible(true);
					}
				}
			}
			
			private Etiqueta crearEtiquetaConexion(String n) {
				int id = conexionesContainer.getComponentCount();
				Etiqueta conexion = new Etiqueta(n, id, grafo, ref, Sujeto.CONEXION);
				return conexion;
			}
		});
		agregarConexionButton.setBounds(55, 138, 54, 23);
		formConexionesContainer.add(agregarConexionButton);
		
		inputEspia = new JTextField();
		inputEspia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
					String nombreEspia = inputEspia.getText();
					if(nombreEspia == "") {
						return;
					}else {
						grafo.agregarEspia(nombreEspia);
						Etiqueta espia = crearEtiquetaEspia(nombreEspia);
						comboBoxEspia1.addItem(nombreEspia);
						comboBoxEspia2.addItem(nombreEspia);
						espiasContainer.add(espia);
						inputEspia.setText("");
						actualizarVistaContainer(espiasContainer);
					}									
				}
			}
			
			private Etiqueta crearEtiquetaEspia(String n) {
				int id = grafo.getCantidadDeEspias();
				Etiqueta ret = new Etiqueta(n, id, grafo, ref, Sujeto.ESPIA);
				return ret;
			}
		});
		inputEspia.setFont(new Font("Miriam Mono CLM", Font.PLAIN, 11));
		inputEspia.setBounds(316, 152, 85, 20);
		frmTemibleOperarioDel.getContentPane().add(inputEspia);
		inputEspia.setColumns(10);
		
		JButton resetButton = new JButton("LIMPIAR");
		resetButton.setFont(new Font("Miriam Mono CLM", Font.BOLD, 11));
		resetButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				reset();
			}
		});
		resetButton.setToolTipText("Reset");
		resetButton.setIcon(null);
		resetButton.setBounds(316, 418, 85, 23);
		frmTemibleOperarioDel.getContentPane().add(resetButton);
	}
	
	public void actualizarEspias() {
		for (int i = 0; i < grafo.getListaDeEspias().size(); i++) {
			String nombre = grafo.getListaDeEspias().get(i).toString();
			comboBoxEspia1.addItem(nombre);
			comboBoxEspia2.addItem(nombre);
			Etiqueta aux = new Etiqueta(nombre, i, grafo, getPrincipal(), Sujeto.ESPIA);
			espiasContainer.add(aux);
		}
	}

	public void actualizarConexiones() {
		for (int i = 0; i < grafo.getRelacionesEntreEspias().size(); i++) {
			Etiqueta aux = new Etiqueta(grafo.getRelacionesEntreEspias().get(i).toStringSinIntercepcion(), i, grafo, getPrincipal(), Sujeto.CONEXION);
			conexionesContainer.add(aux);
		}
	}
	
	public void actualizarVistaContainer(JPanel p) {
		p.repaint();
		p.revalidate();
	}

	@Override
	public void actualizar(Sujeto tipo) {
		if(tipo == Sujeto.CONEXION) {
			conexionesContainer.removeAll();
			actualizarVistaContainer(conexionesContainer);
			actualizarConexiones();
			actualizarVistaContainer(conexionesContainer);
		}else {
			espiasContainer.removeAll();
			comboBoxEspia1.removeAllItems();
			comboBoxEspia2.removeAllItems();
			actualizarVistaContainer(espiasContainer);
			actualizarEspias();
			actualizarVistaContainer(espiasContainer);
		}
	}
	
	private Observador getPrincipal() {
		return this;
	}
	
	private void reset() {
		grafo = new Grafo();
		conexionesContainer.removeAll();
		espiasContainer.removeAll();
		comboBoxEspia1.removeAllItems();
		comboBoxEspia2.removeAllItems();
		actualizarVistaContainer(espiasContainer);
		actualizarVistaContainer(conexionesContainer);
	}
}
