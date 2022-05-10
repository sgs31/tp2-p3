package vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Grafo;
import model.ObjetoArista;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.border.MatteBorder;

public class Resultados extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Grafo grafo;

	public Resultados(Grafo g) {
		grafo = g;
		
		setTitle("Mensaje enviado");
		setBounds(100, 100, 445, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel subtituloContainer = new JPanel();
		subtituloContainer.setBackground(Color.WHITE);
		subtituloContainer.setBounds(0, 0, 436, 39);
		contentPanel.add(subtituloContainer);
		subtituloContainer.setLayout(null);
		
		JTextArea subtitulo = new JTextArea();
		subtitulo.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		subtitulo.setEditable(false);
		subtitulo.setFont(new Font("Miriam Mono CLM", Font.BOLD, 12));
		subtitulo.setLineWrap(true);
		subtitulo.setText("Se envio el mensaje en el siguiente orden para evitar que el mensaje sea interceptado");
		subtitulo.setBounds(0, 0, 426, 39);
		subtituloContainer.add(subtitulo);
		
		JPanel informeContainer = new JPanel();
		informeContainer.setBackground(Color.WHITE);
		informeContainer.setBounds(0, 38, 429, 189);
		contentPanel.add(informeContainer);
		informeContainer.setLayout(new GridLayout(grafo.getRelacionesEntreEspias().size(), 0, 0, 0));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 238, 436, -11);
		contentPanel.add(separator);

		
		for (ObjetoArista o : grafo.getRelacionesEntreEspias()) {
			JLabel aux = new JLabel(o.toString());
			aux.setFont(new Font("Miriam Mono CLM", Font.BOLD, 11));
			aux.setHorizontalAlignment(SwingConstants.CENTER);
			informeContainer.add(aux);
		}
		
		{
			JPanel btnContainer = new JPanel();
			getContentPane().add(btnContainer, BorderLayout.SOUTH);
			btnContainer.setLayout(new GridLayout(0, 1, 0, 0));
			{
				JButton continuar = new JButton("CONTINUAR");
				continuar.setFont(new Font("Miriam Mono CLM", Font.BOLD, 11));
				continuar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
					}
				});
				continuar.setActionCommand("OK");
				btnContainer.add(continuar);
				getRootPane().setDefaultButton(continuar);
			}
		}
	}
}
