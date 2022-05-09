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

public class principal implements Observador{
	
	private JFrame frmTemibleOperarioDel;
	private JTextField inputEspia;
	private Grafo grafo;
	private JPanel espiasContainer;
	private JPanel conexionesContainer;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					principal window = new principal();
					window.frmTemibleOperarioDel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public principal() {
		grafo = new Grafo();
		initialize();
	}

	private void initialize() {
		principal ref = this;
		frmTemibleOperarioDel = new JFrame();
		frmTemibleOperarioDel.setTitle("Temible operario del recontraespionaje");
		frmTemibleOperarioDel.setBounds(100, 100, 734, 491);
		frmTemibleOperarioDel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTemibleOperarioDel.getContentPane().setLayout(null);
		
		JLabel indicadorEspiasContainer = new JLabel("Nuestros espias");
		indicadorEspiasContainer.setHorizontalAlignment(SwingConstants.CENTER);
		indicadorEspiasContainer.setFont(new Font("Miriam Mono CLM", Font.BOLD, 11));
		indicadorEspiasContainer.setBounds(64, 123, 165, 23);
		frmTemibleOperarioDel.getContentPane().add(indicadorEspiasContainer);
		
		JLabel misionLabel = new JLabel("MISION: Temible operario del recontraespionaje.");
		misionLabel.setFont(new Font("Miriam Mono CLM", Font.BOLD, 14));
		misionLabel.setBounds(64, 11, 588, 36);
		frmTemibleOperarioDel.getContentPane().add(misionLabel);
		
		JLabel objetivoLabel = new JLabel("OBJETIVO: Enviar un mensaje secreto entre todos los espias sin ser detectados.");
		objetivoLabel.setFont(new Font("Miriam Mono CLM", Font.BOLD, 14));
		objetivoLabel.setBounds(64, 58, 649, 14);
		frmTemibleOperarioDel.getContentPane().add(objetivoLabel);
		
		JLabel indicadorConexionesContainer = new JLabel("Conexiones");
		indicadorConexionesContainer.setHorizontalAlignment(SwingConstants.CENTER);
		indicadorConexionesContainer.setFont(new Font("Miriam Mono CLM", Font.BOLD, 11));
		indicadorConexionesContainer.setBounds(487, 127, 165, 14);
		frmTemibleOperarioDel.getContentPane().add(indicadorConexionesContainer);
		
		espiasContainer = new JPanel();
		espiasContainer.setBorder(new LineBorder(Color.LIGHT_GRAY));
		espiasContainer.setBackground(Color.WHITE);
		espiasContainer.setBounds(64, 152, 165, 216);
		frmTemibleOperarioDel.getContentPane().add(espiasContainer);
		espiasContainer.setLayout(new GridLayout(10, 0, 0, 0));
		
		
		conexionesContainer = new JPanel();
		conexionesContainer.setBorder(new LineBorder(Color.LIGHT_GRAY));
		conexionesContainer.setBackground(Color.WHITE);
		conexionesContainer.setBounds(487, 152, 165, 216);
		frmTemibleOperarioDel.getContentPane().add(conexionesContainer);
		conexionesContainer.setLayout(new GridLayout(10, 0, 0, 0));
		
		JLabel indicadorInputEspias = new JLabel("Reclutar espia");
		indicadorInputEspias.setHorizontalAlignment(SwingConstants.CENTER);
		indicadorInputEspias.setFont(new Font("Miriam Mono CLM", Font.BOLD, 11));
		indicadorInputEspias.setBounds(275, 127, 166, 14);
		frmTemibleOperarioDel.getContentPane().add(indicadorInputEspias);
		
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
						Etiqueta ESTOQUIEROANADIR = new Etiqueta(nombreEspia);
						espiasContainer.add(ESTOQUIEROANADIR);
						inputEspia.setText("");
						espiasContainer.repaint();
						espiasContainer.revalidate();
						System.out.println(grafo.getListaDeEspias());
						System.out.println(espiasContainer.getComponentCount());
					}									
				}
			}
		});
		inputEspia.setFont(new Font("Miriam Mono CLM", Font.PLAIN, 11));
		inputEspia.setBounds(316, 152, 85, 20);
		frmTemibleOperarioDel.getContentPane().add(inputEspia);
		inputEspia.setColumns(10);
		
		JLabel indicadorInputConexiones = new JLabel("Anadir conexiones");
		indicadorInputConexiones.setHorizontalAlignment(SwingConstants.CENTER);
		indicadorInputConexiones.setFont(new Font("Miriam Mono CLM", Font.BOLD, 11));
		indicadorInputConexiones.setBounds(275, 183, 166, 14);
		frmTemibleOperarioDel.getContentPane().add(indicadorInputConexiones);
		
		JButton enviarMensajeButton = new JButton("ENVIAR MENSAJE");
		enviarMensajeButton.setFont(new Font("Miriam Mono CLM", Font.BOLD, 11));
		enviarMensajeButton.setBounds(290, 390, 136, 23);
		frmTemibleOperarioDel.getContentPane().add(enviarMensajeButton);
		
		JPanel formConexionesContainer = new JPanel();
		formConexionesContainer.setBounds(275, 197, 171, 171);
		frmTemibleOperarioDel.getContentPane().add(formConexionesContainer);
		formConexionesContainer.setLayout(null);
		
		JComboBox comboBoxEspia1 = new JComboBox();
		comboBoxEspia1.setModel(new DefaultComboBoxModel(new String[] {"espia 1", "espia 2"}));
		comboBoxEspia1.setToolTipText("espia");
		comboBoxEspia1.setBounds(36, 11, 92, 22);
		formConexionesContainer.add(comboBoxEspia1);
		
		JComboBox comboBoxEspia2 = new JComboBox();
		comboBoxEspia2.setToolTipText("ELEGIR UN ESPIA");
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
				String espia1 = comboBoxEspia1.getActionCommand();
				String espia2 = comboBoxEspia2.getActionCommand();
				int probabilidadIntercepcion = 100 - probabilidadDeExito.getValue();
				try {
					return;
				}
				catch(Error err) {
					MessageWindow errorMensaje = new MessageWindow("Error", err.toString());
					errorMensaje.setVisible(true);
				}
				
			}
		});
		agregarConexionButton.setBounds(55, 138, 54, 23);
		formConexionesContainer.add(agregarConexionButton);
		
	}
	
	
	public void actualizarEspias() {
		for(String e : grafo.getListaDeEspias()) {
			if(!grafo.getListaDeEspias().contains(e)) {
				JLabel temp = new JLabel(e);
				espiasContainer.add(temp);
			}
		}
	}
	
	public void actualizarConexiones() {
		
	}

	@Override
	public void actualizar() {
		
		
	}
}