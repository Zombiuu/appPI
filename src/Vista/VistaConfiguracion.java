package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import Controlador.Controlador;
import Modelo.ModeloIni;

public class VistaConfiguracion extends JFrame {
	private ModeloIni modeloIni;
	private Controlador controlador;

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtClave;
	private JTextField txtBaseDatos;
	private JButton btnGuardar;

	/**
	 * Create the frame.
	 */
	public VistaConfiguracion() {
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 279);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Configuraci\u00F3n base de datos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JSeparator separator = new JSeparator();

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addGroup(Alignment.LEADING,
								gl_contentPane.createParallelGroup(Alignment.LEADING, false).addComponent(lblNewLabel)
										.addComponent(separator, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(11).addComponent(lblNewLabel)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE).addContainerGap()));
		contentPane.setLayout(gl_contentPane);

		JLabel lblUsuario = new JLabel("Usuario");

		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");

		txtClave = new JTextField();
		txtClave.setColumns(10);

		JLabel lblUrlBaseDe = new JLabel("URL Base de Datos");

		txtBaseDatos = new JTextField();
		txtBaseDatos.setColumns(10);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setEnabled(false);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlador.guardarIni();
				controlador.MostrarTabla();
				btnGuardar.setEnabled(false);
			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.cerrarVentanaConfiguracion();
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(219).addComponent(btnGuardar)
						.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
						.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(15, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addComponent(lblContrasea, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtClave, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(20, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addComponent(lblUsuario, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(20, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addComponent(lblUrlBaseDe, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtBaseDatos, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(20, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap(25, Short.MAX_VALUE)
				.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addComponent(lblUrlBaseDe).addComponent(
						txtBaseDatos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsuario))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblContrasea).addComponent(
						txtClave, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(24).addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(btnGuardar)
						.addComponent(btnCancelar))
				.addContainerGap()));
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}

	public void setTxtUsuario(JTextField txtUsuario) {
		this.txtUsuario = txtUsuario;
	}

	public void setTxtClave(JTextField txtClave) {
		this.txtClave = txtClave;
	}

	public void setTxtBaseDatos(JTextField txtBaseDatos) {
		this.txtBaseDatos = txtBaseDatos;
	}

	public ModeloIni getModeloIni() {
		return modeloIni;
	}

	public Controlador getControlador() {
		return controlador;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public String getTxtUsuario() {
		return txtUsuario.getText();
	}

	public String getTxtClave() {
		return txtClave.getText();
	}

	public String getTxtBaseDatos() {
		return txtBaseDatos.getText();
	}

	public void setModeloIni(ModeloIni modelo) {
		this.modeloIni = modelo;
	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	public void mostrarDatos() {
		txtBaseDatos.setText(modeloIni.getBaseDatos());
		txtUsuario.setText(modeloIni.getUsuario());
		txtClave.setText(modeloIni.getClave());
		btnGuardar.setEnabled(true);
	}
}
