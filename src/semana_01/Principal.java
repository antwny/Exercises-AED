package semana_01;
import semana_01.*;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 74, 436, 202);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnProcesar = new JButton("Procesar");
		btnProcesar.setBounds(189, 29, 89, 23);
		contentPane.add(btnProcesar);
		
		btnProcesar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Trabajador t = new Trabajador();
				t.codigo = 69696;
				t.horas = 48;
				t.nombre = "Mamani";
				t.tarifahoraria = 3.5;
				textArea.append( "Codigo : " + t.codigo + "\n");
				textArea.append( "Nombre : " + t.nombre + "\n");
				textArea.append( "Horas : " + t.horas + "\n");
				textArea.append( "Tarifa : " + t.tarifahoraria + "\n");
				textArea.append( "Sueldo Bruto : " + t.sueldobruto() + "\n");
				textArea.append( "Sueldo Neto : " + t.sueldoneto() + "\n");
				textArea.append( "Descuento : " + t.descuento() + "\n");
			}
		});
	}
}
