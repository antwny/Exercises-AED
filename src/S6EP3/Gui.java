package S6EP3;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Gui extends JFrame {

	private JPanel contentPane;
	private JTextField txtfAdicionar;
	public ArregloTemperaturas at = new ArregloTemperaturas();
	private JTextArea txta = new JTextArea();
	private JButton btnadicionar;
	private JButton elimFinal;
	DecimalFormat df = new DecimalFormat("#.0");

	public Gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 529, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Temperatura (\u00B0C) :");
		lblNewLabel.setBounds(5, 17, 114, 14);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblNewLabel);

		txtfAdicionar = new JTextField();
		txtfAdicionar.setBounds(125, 14, 227, 20);
		contentPane.add(txtfAdicionar);
		txtfAdicionar.setColumns(10);

		JButton btnadicionar = new JButton("Adicionar");
		btnadicionar.setBounds(362, 11, 141, 23);
		contentPane.add(btnadicionar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 115, 498, 160);
		contentPane.add(scrollPane);

		scrollPane.setViewportView(txta);

		JButton elimFinal = new JButton("Eliminar al final");
		elimFinal.setBounds(270, 45, 233, 23);
		contentPane.add(elimFinal);

		JButton elimTodo = new JButton("Eliminar todo");
		elimTodo.setBounds(5, 45, 227, 23);
		contentPane.add(elimTodo);

		JButton reemplazar = new JButton(
				"Remplazar primera temperatura normal");
		reemplazar.setHorizontalAlignment(SwingConstants.LEFT);
		reemplazar.setBounds(5, 81, 228, 23);
		contentPane.add(reemplazar);

		JButton incrementar = new JButton("Incrementar temperaturas");
		incrementar.setBounds(270, 81, 233, 23);
		contentPane.add(incrementar);

		btnadicionar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					at.adicionar(Integer.parseInt(txtfAdicionar.getText()));
					listar();
					txtfAdicionar.setText("");
				}
				catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null,
							"Error:  no es un número válido.",
							"Error de formato", JOptionPane.ERROR_MESSAGE);
				}
			}

		});

		elimFinal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (at.tamaño() != 0)
					at.eliminarAlFinal();
				listar();
			}
		});

		elimTodo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				at.eliminarTodo();
				listar();
			}
		});

		reemplazar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				at.remplazarPrimeraTemperaturaNormal();
				listar();

			}
		});

		incrementar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (at.tamaño() == 0) {
					listar();
				}
				else {
					at.incrementarTemperaturas();
					listar();
				}

			}
		});

	}

	public void listar() {
		txta.setText("");

		if (at.tamaño() == 0) {
			txta.setText("Todo Limpio");
		}
		else {
			for (int i = 0; i < at.tamaño(); i++) {
				if (at.obtener(i) != 0)
					txta.append(df.format(at.obtener(i)) + " °C" + "\n");
			}
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
