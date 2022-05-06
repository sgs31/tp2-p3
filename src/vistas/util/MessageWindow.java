package vistas.util;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MessageWindow extends JFrame {
	
	private JPanel contentPane;

	public MessageWindow(String titulo, String mensaje) {
		setTitle(titulo);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 134);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel mensajeLabel = new JLabel(mensaje);
		mensajeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mensajeLabel.setFont(new Font("Miriam Mono CLM", Font.PLAIN, 11));
		mensajeLabel.setBounds(0, 0, 434, 95);
		contentPane.add(mensajeLabel);
	}
}
