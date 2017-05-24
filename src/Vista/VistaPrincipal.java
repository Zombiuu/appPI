package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.toedter.calendar.JDateChooser;

import Controlador.Controlador;
import Modelo.Modelo;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class VistaPrincipal extends JFrame {
	private JPanel contentPane;
	private JTable TablaInfo;
	private JTextField nRegistro;
	private JTextField textField_3;
	private Controlador controlador;
	private Modelo modelo;

	/**
	 * Create the frame.
	 */
	public VistaPrincipal() {
		setTitle("LicenciaME");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 731);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnDocumentacin = new JMenu("Configuraci\u00F3n");
		menuBar.add(mnDocumentacin);

		JMenuItem mntmConfiguracinBaseDe = new JMenuItem("Configuraci\u00F3n Base de Datos");
		mntmConfiguracinBaseDe.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controlador.abrirVentanaConfiguracion();
			}
		});
		mnDocumentacin.add(mntmConfiguracinBaseDe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel Main = new JPanel();
		Main.setBackground(SystemColor.activeCaption);
		Main.setBorder(new LineBorder(new Color(0, 0, 0)));

		JPanel ZonaDeDatos = new JPanel();
		ZonaDeDatos.setBackground(SystemColor.activeCaption);
		ZonaDeDatos.setBorder(new LineBorder(new Color(0, 0, 0)));

		JPanel Descripcion = new JPanel();
		Descripcion.setBackground(SystemColor.activeCaption);
		Descripcion.setBorder(new LineBorder(new Color(0, 0, 0)));

		JLabel lblRaznSocial = new JLabel("Descripci\u00F3n Actividad");
		lblRaznSocial.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JLabel lblDocumentacinAportada = new JLabel("Documentaci\u00F3n aportada");
		lblDocumentacinAportada.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JCheckBox chckbxNewCheckBox = new JCheckBox("Fotocopia DNI / CIF / NIE");
		chckbxNewCheckBox.setBackground(SystemColor.inactiveCaption);
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JCheckBox chckbxFotocopiaImpuestoDe = new JCheckBox("Fotograf\u00EDas (exterior/interior)");
		chckbxFotocopiaImpuestoDe.setBackground(SystemColor.inactiveCaption);
		chckbxFotocopiaImpuestoDe.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JCheckBox checkBox = new JCheckBox("Fotocopia impuesto de Actividades (Modelo 36)");
		checkBox.setBackground(SystemColor.inactiveCaption);
		checkBox.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JCheckBox chckbxFotocopiaEscrituras = new JCheckBox("Fotocopia Escrituras");
		chckbxFotocopiaEscrituras.setBackground(SystemColor.inactiveCaption);
		chckbxFotocopiaEscrituras.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JCheckBox chckbxJustificanteDePago = new JCheckBox("Justificante de Pago");
		chckbxJustificanteDePago.setBackground(SystemColor.inactiveCaption);
		chckbxJustificanteDePago.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JLabel lblFechaDeSolicitud = new JLabel("Fecha de Solicitud");
		lblFechaDeSolicitud.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JSeparator separator = new JSeparator();

		JSeparator separator_1 = new JSeparator();

		JLabel lblAnotaciones = new JLabel("Anotaciones");
		lblAnotaciones.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JDateChooser dateChooser_2 = new JDateChooser();
		dateChooser_2.setDateFormatString("dd-MM-yyyy");
		dateChooser_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JLabel lblFechaPrevistaActividad = new JLabel("Fecha prevista actividad");
		lblFechaPrevistaActividad.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JDateChooser dateChooser_3 = new JDateChooser();
		dateChooser_3.setDateFormatString("dd-MM-yyyy");
		dateChooser_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JLabel lblNewLabel_1 = new JLabel("New label");

		JLabel lblNewLabel_2 = new JLabel("New label");

		JLabel lblNewLabel_4 = new JLabel("Informaci\u00F3n adicional");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout gl_Descripcion = new GroupLayout(Descripcion);
		gl_Descripcion
				.setHorizontalGroup(
						gl_Descripcion
								.createParallelGroup(
										Alignment.LEADING)
								.addGroup(gl_Descripcion.createSequentialGroup()
										.addContainerGap().addGroup(gl_Descripcion.createParallelGroup(
												Alignment.LEADING)
												.addGroup(
														gl_Descripcion.createSequentialGroup()
																.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE,
																		428, Short.MAX_VALUE)
																.addContainerGap())
												.addGroup(gl_Descripcion.createSequentialGroup()
														.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 428,
																Short.MAX_VALUE)
														.addContainerGap())
												.addGroup(gl_Descripcion.createSequentialGroup().addGroup(gl_Descripcion
														.createParallelGroup(Alignment.TRAILING)
														.addGroup(gl_Descripcion.createSequentialGroup()
																.addComponent(lblDocumentacinAportada,
																		GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
																.addGap(298))
														.addGroup(gl_Descripcion.createSequentialGroup()
																.addComponent(lblAnotaciones, GroupLayout.DEFAULT_SIZE,
																		75, Short.MAX_VALUE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(lblNewLabel_2).addGap(301))
														.addComponent(separator, GroupLayout.DEFAULT_SIZE, 428,
																Short.MAX_VALUE)
														.addGroup(gl_Descripcion.createSequentialGroup()
																.addGroup(gl_Descripcion
																		.createParallelGroup(Alignment.LEADING)
																		.addGroup(gl_Descripcion.createSequentialGroup()
																				.addComponent(chckbxNewCheckBox,
																						GroupLayout.DEFAULT_SIZE, 148,
																						Short.MAX_VALUE)
																				.addPreferredGap(
																						ComponentPlacement.RELATED)
																				.addComponent(chckbxJustificanteDePago,
																						GroupLayout.DEFAULT_SIZE, 117,
																						Short.MAX_VALUE))
																		.addComponent(checkBox,
																				GroupLayout.DEFAULT_SIZE, 265,
																				Short.MAX_VALUE))
																.addPreferredGap(ComponentPlacement.RELATED)
																.addGroup(gl_Descripcion
																		.createParallelGroup(Alignment.LEADING, false)
																		.addComponent(chckbxFotocopiaEscrituras,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(chckbxFotocopiaImpuestoDe,
																				GroupLayout.DEFAULT_SIZE, 163,
																				Short.MAX_VALUE)))
														.addGroup(Alignment.LEADING, gl_Descripcion
																.createSequentialGroup()
																.addGroup(gl_Descripcion
																		.createParallelGroup(Alignment.TRAILING)
																		.addComponent(lblFechaDeSolicitud,
																				Alignment.LEADING,
																				GroupLayout.DEFAULT_SIZE, 158,
																				Short.MAX_VALUE)
																		.addComponent(dateChooser_2, Alignment.LEADING,
																				GroupLayout.DEFAULT_SIZE, 158,
																				Short.MAX_VALUE))
																.addGroup(gl_Descripcion
																		.createParallelGroup(Alignment.LEADING)
																		.addGroup(gl_Descripcion.createSequentialGroup()
																				.addGap(18)
																				.addComponent(dateChooser_3,
																						GroupLayout.DEFAULT_SIZE, 158,
																						Short.MAX_VALUE)
																				.addGap(94))
																		.addGroup(gl_Descripcion.createSequentialGroup()
																				.addGap(21)
																				.addComponent(lblFechaPrevistaActividad,
																						GroupLayout.DEFAULT_SIZE, 249,
																						Short.MAX_VALUE)
																				.addPreferredGap(
																						ComponentPlacement.RELATED)))))
														.addGap(10))
												.addGroup(gl_Descripcion.createSequentialGroup()
														.addComponent(lblRaznSocial, GroupLayout.DEFAULT_SIZE, 149,
																Short.MAX_VALUE)
														.addGap(289))
												.addGroup(gl_Descripcion.createSequentialGroup()
														.addComponent(lblNewLabel_1)
														.addContainerGap(392, Short.MAX_VALUE)))));
		gl_Descripcion.setVerticalGroup(gl_Descripcion.createParallelGroup(Alignment.LEADING).addGroup(gl_Descripcion
				.createSequentialGroup().addContainerGap().addComponent(lblNewLabel_4)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(lblRaznSocial, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_1).addGap(35)
				.addComponent(lblDocumentacinAportada, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_Descripcion.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxNewCheckBox, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(chckbxJustificanteDePago, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(chckbxFotocopiaEscrituras, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(
						gl_Descripcion.createParallelGroup(Alignment.BASELINE)
								.addComponent(checkBox, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(chckbxFotocopiaImpuestoDe, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGap(9)
				.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_Descripcion.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFechaDeSolicitud, GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
						.addComponent(lblFechaPrevistaActividad, GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_Descripcion.createParallelGroup(Alignment.LEADING, false)
						.addComponent(dateChooser_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(dateChooser_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
				.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
				.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 7, GroupLayout.PREFERRED_SIZE).addGap(9)
				.addGroup(gl_Descripcion.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAnotaciones, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
						.addComponent(lblNewLabel_2))
				.addGap(9)));
		Descripcion.setLayout(gl_Descripcion);

		JButton btnAlta = new JButton("Solicitud Licencia");
		btnAlta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controlador.abrirVentanaInscripcion();
			}
		});
		btnAlta.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnArchivar = new JButton("Archivar Licencia");
		btnArchivar.setEnabled(false);
		btnArchivar.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/img/AytoAzul.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addGroup(gl_contentPane
								.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
										.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(Main, GroupLayout.PREFERRED_SIZE, 786, Short.MAX_VALUE)
												.addComponent(ZonaDeDatos, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
														786, Short.MAX_VALUE))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(Descripcion, GroupLayout.DEFAULT_SIZE, 458,
														Short.MAX_VALUE)
												.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 458,
														Short.MAX_VALUE))
										.addContainerGap())
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(btnAlta, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnArchivar, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
										.addGap(964)))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(Main, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(Descripcion, GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
						.addComponent(ZonaDeDatos, GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAlta, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnArchivar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
				.addContainerGap()));

		JScrollPane Panel = new JScrollPane();
		GroupLayout gl_ZonaDeDatos = new GroupLayout(ZonaDeDatos);
		gl_ZonaDeDatos.setHorizontalGroup(gl_ZonaDeDatos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ZonaDeDatos.createSequentialGroup().addContainerGap()
						.addComponent(Panel, GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE).addContainerGap()));
		gl_ZonaDeDatos.setVerticalGroup(gl_ZonaDeDatos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ZonaDeDatos.createSequentialGroup().addContainerGap()
						.addComponent(Panel, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE).addContainerGap()));

		TablaInfo = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		TablaInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getClickCount() == 2) {
					controlador.abrirVentanaInscripcion();
					btnArchivar.setEnabled(true);
				}
			}
		});
		TablaInfo.setSurrendersFocusOnKeystroke(true);
		TablaInfo.setBorder(new LineBorder(new Color(0, 0, 0)));
		TablaInfo.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "N\u00BA Registro",
				"DNI/CIF Asociado", "Actividad", "Tipo", "Fecha Inscripci\u00F3n", "Estado Tr\u00E1mite" }));
		TablaInfo.getColumnModel().getColumn(1).setPreferredWidth(104);
		TablaInfo.getColumnModel().getColumn(4).setPreferredWidth(96);
		TablaInfo.getColumnModel().getColumn(5).setPreferredWidth(89);

		Panel.setViewportView(TablaInfo);
		ZonaDeDatos.setLayout(gl_ZonaDeDatos);

		JButton btnBusqueda = new JButton("Buscar");
		btnBusqueda.setEnabled(false);
		btnBusqueda.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnReset = new JButton("Limpiar b\u00FAsqueda");
		btnReset.setEnabled(false);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JPanel panelLicencia = new JPanel();
		panelLicencia.setBackground(SystemColor.inactiveCaption);
		panelLicencia.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JLabel lblNewLabel_3 = new JLabel("Buscador");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout gl_Main = new GroupLayout(Main);
		gl_Main.setHorizontalGroup(
				gl_Main.createParallelGroup(
						Alignment.LEADING)
						.addGroup(gl_Main.createSequentialGroup().addContainerGap().addGroup(gl_Main
								.createParallelGroup(Alignment.LEADING).addGroup(gl_Main.createSequentialGroup()
										.addGroup(gl_Main.createParallelGroup(Alignment.LEADING)
												.addComponent(panelLicencia, GroupLayout.PREFERRED_SIZE, 738,
														GroupLayout.PREFERRED_SIZE)
												.addGroup(Alignment.TRAILING,
														gl_Main.createSequentialGroup()
																.addComponent(btnBusqueda, GroupLayout.DEFAULT_SIZE, 82,
																		Short.MAX_VALUE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 153,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(497)))
										.addGap(28))
								.addGroup(gl_Main.createSequentialGroup().addComponent(lblNewLabel_3)
										.addContainerGap(690, Short.MAX_VALUE)))));
		gl_Main.setVerticalGroup(gl_Main.createParallelGroup(Alignment.TRAILING).addGroup(gl_Main
				.createSequentialGroup().addGap(19).addComponent(lblNewLabel_3)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(panelLicencia, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_Main.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBusqueda, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnReset, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
				.addContainerGap()));

		JLabel tipoLabel = new JLabel("Tipo de Licencia");
		tipoLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel registroLabel = new JLabel("N\u00BA de Registro de Licencia");
		registroLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

		nRegistro = new JTextField();
		nRegistro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nRegistro.setColumns(10);

		JComboBox tipo = new JComboBox();
		tipo.setModel(new DefaultComboBoxModel(new String[] { "Todas", "Tipo 1", "Tipo 2", "Tipo 3" }));
		tipo.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(
				new DefaultComboBoxModel(new String[] { "En proceso", "Archivada", "Rechazada", "Aceptada" }));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblDnicifAsociado = new JLabel("DNI/CIF Asociado");
		lblDnicifAsociado.setFont(new Font("Tahoma", Font.PLAIN, 14));

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_3.setColumns(10);
		GroupLayout gl_panelLicencia = new GroupLayout(panelLicencia);
		gl_panelLicencia.setHorizontalGroup(
			gl_panelLicencia.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLicencia.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelLicencia.createParallelGroup(Alignment.LEADING)
						.addComponent(registroLabel, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelLicencia.createSequentialGroup()
							.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(Alignment.TRAILING, gl_panelLicencia.createSequentialGroup()
							.addGroup(gl_panelLicencia.createParallelGroup(Alignment.TRAILING)
								.addComponent(nRegistro, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
								.addComponent(lblDnicifAsociado, GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_panelLicencia.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBox, 0, 367, Short.MAX_VALUE)
						.addComponent(lblEstado, GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
						.addGroup(gl_panelLicencia.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tipoLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(tipo, 0, 367, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelLicencia.setVerticalGroup(
			gl_panelLicencia.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelLicencia.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_panelLicencia.createParallelGroup(Alignment.BASELINE)
						.addComponent(registroLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(tipoLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(12)
					.addGroup(gl_panelLicencia.createParallelGroup(Alignment.BASELINE)
						.addComponent(tipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(nRegistro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelLicencia.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEstado, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDnicifAsociado, GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelLicencia.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(25))
		);
		panelLicencia.setLayout(gl_panelLicencia);
		Main.setLayout(gl_Main);
		contentPane.setLayout(gl_contentPane);
	}

	public void onLoadTable() {
		controlador.MostrarTabla();
	}

	public TableModel getTablaInfo() {
		return TablaInfo.getModel();
	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
}
