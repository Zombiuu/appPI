package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;

import Controlador.Controlador;
import Modelo.Modelo;

public class VistaPrincipal extends JFrame {
	private JPanel contentPane;
	private JTable TablaInfo;
	private JTextField txtnRegistro;
	private JTextField txtDNI;
	private Controlador controlador;
	private Modelo modelo;
	private TableRowSorter trOrden;
	private JComboBox tipo;
	private JComboBox comboBox;
	private JCheckBox checkBoxFtoImpActP;
	private JCheckBox chckbxOtrasAutorizacionesP;
	private JCheckBox chckbxFotoDniP;
	private JCheckBox chckbxJustificanteDePagoP;
	private JCheckBox chckbxFotocopiaEscriturasP;
	private JLabel lblDescripcionP;
	private JDateChooser fechaSolicitudP;
	private JDateChooser fechaInicioSolicitudP;

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
		lblRaznSocial.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblDocumentacinAportada = new JLabel("Documentaci\u00F3n aportada");
		lblDocumentacinAportada.setFont(new Font("Tahoma", Font.BOLD, 11));

		chckbxFotoDniP = new JCheckBox("Fotocopia DNI / CIF / NIE");
		chckbxFotoDniP.setBackground(SystemColor.inactiveCaption);
		chckbxFotoDniP.setFont(new Font("Tahoma", Font.PLAIN, 11));

		chckbxOtrasAutorizacionesP = new JCheckBox("Otras Autorizaciones");
		chckbxOtrasAutorizacionesP.setBackground(SystemColor.inactiveCaption);
		chckbxOtrasAutorizacionesP.setFont(new Font("Tahoma", Font.PLAIN, 11));

		checkBoxFtoImpActP = new JCheckBox("Fotocopia impuesto de Actividades (Modelo 36)");
		checkBoxFtoImpActP.setBackground(SystemColor.inactiveCaption);
		checkBoxFtoImpActP.setFont(new Font("Tahoma", Font.PLAIN, 11));

		chckbxFotocopiaEscriturasP = new JCheckBox("Fotocopia Escrituras");
		chckbxFotocopiaEscriturasP.setBackground(SystemColor.inactiveCaption);
		chckbxFotocopiaEscriturasP.setFont(new Font("Tahoma", Font.PLAIN, 11));

		chckbxJustificanteDePagoP = new JCheckBox("Justificante de Pago");
		chckbxJustificanteDePagoP.setBackground(SystemColor.inactiveCaption);
		chckbxJustificanteDePagoP.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JLabel lblFechaDeSolicitud = new JLabel("Fecha de Solicitud");
		lblFechaDeSolicitud.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JSeparator separator = new JSeparator();

		JSeparator separator_1 = new JSeparator();

		JLabel lblFechaPrevistaActividad = new JLabel("Fecha prevista actividad");
		lblFechaPrevistaActividad.setFont(new Font("Tahoma", Font.PLAIN, 11));

		lblDescripcionP = new JLabel("New label");

		JLabel lblNewLabel_4 = new JLabel("Informaci\u00F3n adicional");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JDateChooser fechaSolicitudP = new JDateChooser();
		
		JDateChooser fechaInicioSolicitudP = new JDateChooser();
		GroupLayout gl_Descripcion = new GroupLayout(Descripcion);
		gl_Descripcion.setHorizontalGroup(
			gl_Descripcion.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Descripcion.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Descripcion.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Descripcion.createSequentialGroup()
							.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_Descripcion.createSequentialGroup()
							.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_Descripcion.createSequentialGroup()
							.addGroup(gl_Descripcion.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_Descripcion.createSequentialGroup()
									.addComponent(lblDocumentacinAportada, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
									.addGap(298))
								.addComponent(separator, GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
								.addGroup(gl_Descripcion.createSequentialGroup()
									.addGroup(gl_Descripcion.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_Descripcion.createSequentialGroup()
											.addComponent(chckbxFotoDniP, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(chckbxJustificanteDePagoP, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
										.addComponent(checkBoxFtoImpActP, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_Descripcion.createParallelGroup(Alignment.LEADING, false)
										.addComponent(chckbxFotocopiaEscriturasP, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(chckbxOtrasAutorizacionesP, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)))
								.addGroup(gl_Descripcion.createSequentialGroup()
									.addGroup(gl_Descripcion.createParallelGroup(Alignment.LEADING)
										.addComponent(lblFechaDeSolicitud, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
										.addGroup(gl_Descripcion.createSequentialGroup()
											.addComponent(fechaSolicitudP, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)))
									.addGap(21)
									.addGroup(gl_Descripcion.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_Descripcion.createSequentialGroup()
											.addComponent(lblFechaPrevistaActividad, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.RELATED))
										.addComponent(fechaInicioSolicitudP, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE))))
							.addGap(10))
						.addGroup(gl_Descripcion.createSequentialGroup()
							.addComponent(lblRaznSocial, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
							.addGap(289))
						.addGroup(gl_Descripcion.createSequentialGroup()
							.addComponent(lblDescripcionP)
							.addContainerGap(411, Short.MAX_VALUE))))
		);
		gl_Descripcion.setVerticalGroup(
			gl_Descripcion.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_Descripcion.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblRaznSocial, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblDescripcionP)
					.addGap(35)
					.addComponent(lblDocumentacinAportada, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_Descripcion.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxFotoDniP, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(chckbxJustificanteDePagoP, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(chckbxFotocopiaEscriturasP, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_Descripcion.createParallelGroup(Alignment.BASELINE)
						.addComponent(checkBoxFtoImpActP, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(chckbxOtrasAutorizacionesP, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(9)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_Descripcion.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFechaDeSolicitud, GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
						.addComponent(lblFechaPrevistaActividad, GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_Descripcion.createParallelGroup(Alignment.LEADING)
						.addComponent(fechaSolicitudP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(fechaInicioSolicitudP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 7, GroupLayout.PREFERRED_SIZE)
					.addGap(32))
		);
		Descripcion.setLayout(gl_Descripcion);

		JButton btnAlta = new JButton("Solicitud Licencia");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
					controlador.abrirVentanaModificacion();
					DefaultTableModel model = (DefaultTableModel) TablaInfo.getModel();
					int selectedRowIndex = TablaInfo.getSelectedRow();

					controlador.recogerRegistroCambio();

					btnArchivar.setEnabled(true);
				} else {

					controlador.mostrarDatosAdicionales();
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
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlador.reiniciarJTable(TablaInfo);

			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JPanel panelLicencia = new JPanel();
		panelLicencia.setBackground(SystemColor.inactiveCaption);
		panelLicencia.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JLabel lblNewLabel_3 = new JLabel("Buscador");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		GroupLayout gl_Main = new GroupLayout(Main);
		gl_Main.setHorizontalGroup(gl_Main.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, gl_Main
				.createSequentialGroup().addContainerGap(18, Short.MAX_VALUE)
				.addGroup(gl_Main.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_3).addGroup(gl_Main
						.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panelLicencia, GroupLayout.PREFERRED_SIZE, 738, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_Main.createSequentialGroup()
								.addComponent(btnBusqueda, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
								.addGap(497))))
				.addGap(28)));
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

		txtnRegistro = new JTextField();
		txtnRegistro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				txtnRegistro.addKeyListener(new KeyAdapter() {
					public void keyReleased(final KeyEvent arg0) {

						filtroRegistro();

					}
				});
				trOrden = new TableRowSorter(TablaInfo.getModel());
				TablaInfo.setRowSorter(trOrden);
			}
		});
		txtnRegistro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtnRegistro.setColumns(10);

		tipo = new JComboBox();
		tipo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				tipo.addKeyListener(new KeyAdapter() {
					public void keyReleased(final KeyEvent arg0) {

						filtroTipo();

					}
				});
				trOrden = new TableRowSorter(TablaInfo.getModel());
				TablaInfo.setRowSorter(trOrden);
			}
		});

		tipo.setModel(new DefaultComboBoxModel(new String[] {"Seleccione Tipo", "Suelo calificado como industrial", "Suelo urbano", "Casa de ahorro, bancos", "Companias de seguros", "Bares, Cafetrias, Restaurantes", "Salones recreativos", "Establecimientos Alimentarios", "Hoteles, Hostales, Pensiones", "Terrazas de verano", "Gasolineras, Depositos combustible"}));
		tipo.setFont(new Font("Tahoma", Font.PLAIN, 14));

		comboBox = new JComboBox();
		comboBox.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				comboBox.addKeyListener(new KeyAdapter() {
					public void keyReleased(final KeyEvent arg0) {

						filtroEstado();

					}
				});
				trOrden = new TableRowSorter(TablaInfo.getModel());
				TablaInfo.setRowSorter(trOrden);
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "Seleccione estado", "En proceso", "Archivada", "Rechazada", "Aceptada" }));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblDnicifAsociado = new JLabel("DNI/CIF Asociado");
		lblDnicifAsociado.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtDNI = new JTextField();
		txtDNI.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				txtDNI.addKeyListener(new KeyAdapter() {
					public void keyReleased(final KeyEvent arg0) {

						filtroDNI();

					}
				});
				trOrden = new TableRowSorter(TablaInfo.getModel());
				TablaInfo.setRowSorter(trOrden);
			}
		});
		txtDNI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDNI.setColumns(10);
		GroupLayout gl_panelLicencia = new GroupLayout(panelLicencia);
		gl_panelLicencia
				.setHorizontalGroup(gl_panelLicencia.createParallelGroup(Alignment.LEADING).addGroup(gl_panelLicencia
						.createSequentialGroup().addContainerGap().addGroup(gl_panelLicencia
								.createParallelGroup(Alignment.LEADING).addComponent(registroLabel,
										GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panelLicencia.createSequentialGroup()
										.addComponent(txtDNI, GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(Alignment.TRAILING, gl_panelLicencia.createSequentialGroup()
										.addGroup(gl_panelLicencia.createParallelGroup(Alignment.TRAILING)
												.addComponent(txtnRegistro, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														339, Short.MAX_VALUE)
												.addComponent(lblDnicifAsociado, GroupLayout.DEFAULT_SIZE, 339,
														Short.MAX_VALUE))
										.addPreferredGap(ComponentPlacement.RELATED)))
						.addGroup(gl_panelLicencia.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBox, 0, 367, Short.MAX_VALUE)
								.addComponent(lblEstado, GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
								.addGroup(gl_panelLicencia.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(tipoLabel,
												GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(tipo, 0, 367, Short.MAX_VALUE))
						.addContainerGap()));
		gl_panelLicencia.setVerticalGroup(gl_panelLicencia.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelLicencia.createSequentialGroup().addGap(21)
						.addGroup(gl_panelLicencia.createParallelGroup(Alignment.BASELINE)
								.addComponent(registroLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(tipoLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
						.addGap(12)
						.addGroup(gl_panelLicencia.createParallelGroup(Alignment.BASELINE)
								.addComponent(tipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtnRegistro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panelLicencia.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEstado, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDnicifAsociado, GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelLicencia.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
								.addComponent(txtDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(25)));
		panelLicencia.setLayout(gl_panelLicencia);
		Main.setLayout(gl_Main);
		contentPane.setLayout(gl_contentPane);
	}

	public void filtroRegistro() {
		trOrden.setRowFilter(RowFilter.regexFilter(txtnRegistro.getText(), 0));

	}

	public void filtroDNI() {
		trOrden.setRowFilter(RowFilter.regexFilter(txtDNI.getText(), 1));

	}

	public void filtroTipo() {
		trOrden.setRowFilter(RowFilter.regexFilter(tipo.getSelectedItem().toString(), 3));

	}

	public void filtroEstado() {
		trOrden.setRowFilter(RowFilter.regexFilter(comboBox.getSelectedItem().toString(), 5));

	}

	public void onLoadTable() {
		controlador.MostrarTabla();
	}

	public TableModel getTablaInfo() {
		return TablaInfo.getModel();
	}

	public JTable getTablaInfo2() {
		return TablaInfo;
	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public void datosAdicionales() {

		// Solucitud
		lblDescripcionP.setText(modelo.getTxtDescSolicitudP());
		//fechaSolicitudP.setDate(modelo.getTxtFechaSolicitudP());
	//	fechaInicioSolicitudP.setDate(modelo.getTxtFechaIniSolicitudP());
		
		
		 
		if (modelo.getTxtFtoActSolicitudP() == 1) {
			checkBoxFtoImpActP.setSelected(true);
		}
		if (modelo.getTxtFtoDniSolicitudP() == 1) {
			chckbxFotoDniP.setSelected(true);
		}
		if (modelo.getTxtFtoEscriSolicitudP() == 1) {
			chckbxFotocopiaEscriturasP.setSelected(true);
		}
		if (modelo.getTxtJustPagoSolicitudP() == 1) {
			chckbxJustificanteDePagoP.setSelected(true);
		}
		if (modelo.getTxtAutoSolicitudP() == 1) {
			chckbxOtrasAutorizacionesP.setSelected(true);
		}

	}
}
