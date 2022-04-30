package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class principal {

	private JFrame frmTemibleOperarioDel;
	private JTextField inputEspias;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTemibleOperarioDel = new JFrame();
		frmTemibleOperarioDel.setTitle("Temible operario del recontraespionaje");
		frmTemibleOperarioDel.setBounds(100, 100, 756, 500);
		frmTemibleOperarioDel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTemibleOperarioDel.getContentPane().setLayout(null);
		
		JLabel indicadorEspiasContainer = new JLabel("Nuestros espias:");
		indicadorEspiasContainer.setFont(new Font("Miriam Mono CLM", Font.PLAIN, 11));
		indicadorEspiasContainer.setBounds(80, 123, 125, 23);
		frmTemibleOperarioDel.getContentPane().add(indicadorEspiasContainer);
		
		JLabel misionLabel = new JLabel("MISION: Temible operario del recontraespionaje.");
		misionLabel.setFont(new Font("Miriam Mono CLM", Font.BOLD, 14));
		misionLabel.setBounds(64, 11, 388, 36);
		frmTemibleOperarioDel.getContentPane().add(misionLabel);
		
		JLabel objetivoLabel = new JLabel("OBJETIVO: Enviar un mensaje secreto entre todos los espias sin ser detectados.");
		objetivoLabel.setFont(new Font("Miriam Mono CLM", Font.BOLD, 14));
		objetivoLabel.setBounds(64, 58, 649, 14);
		frmTemibleOperarioDel.getContentPane().add(objetivoLabel);
		
		JLabel indicadorConexionesContainer = new JLabel("Conexiones:");
		indicadorConexionesContainer.setFont(new Font("Miriam Mono CLM", Font.PLAIN, 11));
		indicadorConexionesContainer.setBounds(535, 127, 81, 14);
		frmTemibleOperarioDel.getContentPane().add(indicadorConexionesContainer);
		
		JPanel espiasContainer = new JPanel();
		espiasContainer.setBackground(Color.WHITE);
		espiasContainer.setBounds(64, 152, 165, 216);
		frmTemibleOperarioDel.getContentPane().add(espiasContainer);
		
		JLabel lblNewLabel = new JLabel("New label");
		espiasContainer.add(lblNewLabel);
		
		JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setFont(new Font("Miriam Mono CLM", Font.PLAIN, 12));
		addPopup(lblNewLabel, popupMenu);
		
		JButton btnNewButton_2 = new JButton("Eliminar");
		btnNewButton_2.setFont(new Font("Miriam Mono CLM", Font.PLAIN, 11));
		popupMenu.add(btnNewButton_2);
		
		JPanel conexionesContainer = new JPanel();
		conexionesContainer.setBackground(Color.WHITE);
		conexionesContainer.setBounds(496, 152, 155, 216);
		frmTemibleOperarioDel.getContentPane().add(conexionesContainer);
		
		JLabel indicadorInputEspias = new JLabel("Entrenar espia");
		indicadorInputEspias.setFont(new Font("Miriam Mono CLM", Font.PLAIN, 11));
		indicadorInputEspias.setBounds(295, 151, 112, 14);
		frmTemibleOperarioDel.getContentPane().add(indicadorInputEspias);
		
		inputEspias = new JTextField();
		inputEspias.setFont(new Font("Miriam Mono CLM", Font.PLAIN, 11));
		inputEspias.setBounds(305, 176, 86, 20);
		frmTemibleOperarioDel.getContentPane().add(inputEspias);
		inputEspias.setColumns(10);
		
		JLabel indicadorInputConexiones = new JLabel("Anadir conexiones");
		indicadorInputConexiones.setFont(new Font("Miriam Mono CLM", Font.PLAIN, 11));
		indicadorInputConexiones.setBounds(295, 207, 125, 14);
		frmTemibleOperarioDel.getContentPane().add(indicadorInputConexiones);
		
		JButton btnNewButton = new JButton("ENVIAR MENSAJE");
		btnNewButton.setFont(new Font("Miriam Mono CLM", Font.BOLD, 11));
		btnNewButton.setBounds(284, 378, 136, 23);
		frmTemibleOperarioDel.getContentPane().add(btnNewButton);
		
		JPanel formConexionesContainer = new JPanel();
		formConexionesContainer.setBorder(new LineBorder(new Color(0, 0, 0)));
		formConexionesContainer.setBounds(295, 232, 112, 125);
		frmTemibleOperarioDel.getContentPane().add(formConexionesContainer);
		formConexionesContainer.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"espia 1", "espia 2"}));
		comboBox.setToolTipText("espia");
		comboBox.setBounds(10, 11, 92, 22);
		formConexionesContainer.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setToolTipText("ELEGIR UN ESPIA");
		comboBox_1.setBounds(10, 44, 92, 22);
		formConexionesContainer.add(comboBox_1);
		
		JButton btnNewButton_1 = new JButton("+");
		btnNewButton_1.setBounds(26, 91, 54, 23);
		formConexionesContainer.add(btnNewButton_1);
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
}
