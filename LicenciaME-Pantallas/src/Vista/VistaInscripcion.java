package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import Controlador.Controlador;
import Modelo.Modelo;

public class VistaInscripcion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtMunicipio;
	private JTextField txtDNI;
	private JTextField txtCp;
	private JTextField txtMovil;
	private JTextField txtFax;
	private JTextField txtMail;
	private JTextField txtDniRepre;
	private JTextField txtCpRepre;
	private JTextField txtMovilRepre;
	private JTextField txtFaxRepre;
	private JTextField txtNombreApellidosRepre;
	private JTextField txtDireccionRepre;
	private JTextField txtMunicipioRepre;
	private JEditorPane txtDescrAct = new JEditorPane();
	private JComboBox comboTipo = new JComboBox();
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/dd/MM", getLocale());
	private LocalDate localDate = LocalDate.now();
	private Controlador controlador;
	private Modelo modelo;
	private JDateChooser fechaSolicitud;
	private JDateChooser fechaActividad;
	private JTextField txtReferencia;
	private JComboBox comboSuelo;
	private JCheckBox chckbxFotocopiaDNI;
	private JCheckBox chckbxEscritura;
	private JCheckBox chckbxJustificantePago;
	private JCheckBox chckbxFotocopiaImpuestoActividades;
	private JCheckBox chckbxMemoria;
	private JCheckBox chckbxCertificadoColegio;
	private JCheckBox chckbxPlanoAcotadoDel;
	private JCheckBox chckbxLicenciaObra;
	private JCheckBox chckbxOtrasAutorizaciones;
	private JCheckBox chckbxRequired;

	/**
	 * Create the frame.
	 */
	public VistaInscripcion() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("Formulario de inscripci\u00F3n");
		setBounds(100, 100, 1153, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panelBorde = new JPanel();
		panelBorde.setBackground(SystemColor.inactiveCaption);
		panelBorde.setBounds(0, 0, 566, 503);
		panelBorde.setBorder(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(565, 0, 582, 503);
		panel.setBorder(null);
		
				JPanel panelDoc = new JPanel();
				panelDoc.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Documentaci\u00F3n aportada",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				
						JPanel panelDocGen = new JPanel();
						panelDocGen.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
						
								JPanel panelDocTec = new JPanel();
								panelDocTec.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
								GroupLayout gl_panelDoc = new GroupLayout(panelDoc);
								gl_panelDoc.setHorizontalGroup(
									gl_panelDoc.createParallelGroup(Alignment.TRAILING)
										.addComponent(panelDocGen, GroupLayout.PREFERRED_SIZE, 520, Short.MAX_VALUE)
										.addComponent(panelDocTec, GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
								);
								gl_panelDoc.setVerticalGroup(
									gl_panelDoc.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panelDoc.createSequentialGroup()
											.addComponent(panelDocGen, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(panelDocTec, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
											.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								);
								
										JLabel lblDocumentacinTcnica = new JLabel("Documentaci\u00F3n t\u00E9cnica.");
										lblDocumentacinTcnica.setFont(new Font("Tahoma", Font.BOLD, 11));
										
												chckbxMemoria = new JCheckBox("Dos ejemplares de Memoria de la actividad");
												chckbxMemoria.setFont(new Font("Tahoma", Font.PLAIN, 11));
												
														chckbxPlanoAcotadoDel = new JCheckBox("Plano acotado del local ");
														chckbxPlanoAcotadoDel.setFont(new Font("Tahoma", Font.PLAIN, 11));
														
																chckbxLicenciaObra = new JCheckBox("Licencia de obra");
																chckbxLicenciaObra.setFont(new Font("Tahoma", Font.PLAIN, 11));
																
																		chckbxOtrasAutorizaciones = new JCheckBox(" Otras Autorizaciones");
																		chckbxOtrasAutorizaciones.setFont(new Font("Tahoma", Font.PLAIN, 11));
																		
																				chckbxCertificadoColegio = new JCheckBox("Certificado Colegio Oficial");
																				chckbxCertificadoColegio.setFont(new Font("Tahoma", Font.PLAIN, 11));
																				GroupLayout gl_panelDocTec = new GroupLayout(panelDocTec);
																				gl_panelDocTec.setHorizontalGroup(
																					gl_panelDocTec.createParallelGroup(Alignment.LEADING)
																						.addGroup(gl_panelDocTec.createSequentialGroup()
																							.addContainerGap()
																							.addGroup(gl_panelDocTec.createParallelGroup(Alignment.LEADING)
																								.addComponent(lblDocumentacinTcnica, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
																								.addGroup(gl_panelDocTec.createSequentialGroup()
																									.addGroup(gl_panelDocTec.createParallelGroup(Alignment.LEADING)
																										.addGroup(gl_panelDocTec.createSequentialGroup()
																											.addComponent(chckbxPlanoAcotadoDel)
																											.addPreferredGap(ComponentPlacement.RELATED)
																											.addComponent(chckbxLicenciaObra))
																										.addComponent(chckbxMemoria))
																									.addPreferredGap(ComponentPlacement.RELATED)
																									.addGroup(gl_panelDocTec.createParallelGroup(Alignment.LEADING)
																										.addComponent(chckbxCertificadoColegio, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
																										.addComponent(chckbxOtrasAutorizaciones, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
																							.addContainerGap(19, GroupLayout.PREFERRED_SIZE))
																				);
																				gl_panelDocTec.setVerticalGroup(
																					gl_panelDocTec.createParallelGroup(Alignment.LEADING)
																						.addGroup(gl_panelDocTec.createSequentialGroup()
																							.addContainerGap()
																							.addComponent(lblDocumentacinTcnica)
																							.addPreferredGap(ComponentPlacement.RELATED)
																							.addGroup(gl_panelDocTec.createParallelGroup(Alignment.BASELINE)
																								.addComponent(chckbxMemoria)
																								.addComponent(chckbxCertificadoColegio))
																							.addPreferredGap(ComponentPlacement.RELATED)
																							.addGroup(gl_panelDocTec.createParallelGroup(Alignment.BASELINE)
																								.addComponent(chckbxPlanoAcotadoDel)
																								.addComponent(chckbxLicenciaObra)
																								.addComponent(chckbxOtrasAutorizaciones))
																							.addContainerGap(11, Short.MAX_VALUE))
																				);
																				panelDocTec.setLayout(gl_panelDocTec);
																				
																						chckbxFotocopiaDNI = new JCheckBox("Fotocopia DNI");
																						chckbxFotocopiaDNI.setFont(new Font("Tahoma", Font.PLAIN, 11));
																						
																								chckbxEscritura = new JCheckBox("Fotocopia escritura");
																								chckbxEscritura.setFont(new Font("Tahoma", Font.PLAIN, 11));
																								
																										chckbxJustificantePago = new JCheckBox("Justificante pago");
																										chckbxJustificantePago.setFont(new Font("Tahoma", Font.PLAIN, 11));
																										
																												chckbxFotocopiaImpuestoActividades = new JCheckBox("Fotocopia impuesto actividades");
																												chckbxFotocopiaImpuestoActividades.setFont(new Font("Tahoma", Font.PLAIN, 11));
																												
																														JLabel lblDocGen = new JLabel("Documentaci\u00F3n general.");
																														lblDocGen.setFont(new Font("Tahoma", Font.BOLD, 11));
																																		GroupLayout gl_panelDocGen = new GroupLayout(panelDocGen);
																																		gl_panelDocGen.setHorizontalGroup(
																																			gl_panelDocGen.createParallelGroup(Alignment.LEADING)
																																				.addGroup(gl_panelDocGen.createSequentialGroup()
																																					.addContainerGap()
																																					.addGroup(gl_panelDocGen.createParallelGroup(Alignment.LEADING)
																																						.addGroup(gl_panelDocGen.createSequentialGroup()
																																							.addComponent(chckbxFotocopiaDNI)
																																							.addPreferredGap(ComponentPlacement.RELATED)
																																							.addComponent(chckbxEscritura)
																																							.addPreferredGap(ComponentPlacement.RELATED)
																																							.addComponent(chckbxJustificantePago)
																																							.addPreferredGap(ComponentPlacement.RELATED)
																																							.addComponent(chckbxFotocopiaImpuestoActividades, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
																																						.addComponent(lblDocGen, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
																																					.addGap(328))
																																		);
																																		gl_panelDocGen.setVerticalGroup(
																																			gl_panelDocGen.createParallelGroup(Alignment.LEADING)
																																				.addGroup(gl_panelDocGen.createSequentialGroup()
																																					.addContainerGap()
																																					.addComponent(lblDocGen)
																																					.addPreferredGap(ComponentPlacement.RELATED)
																																					.addGroup(gl_panelDocGen.createParallelGroup(Alignment.BASELINE)
																																						.addComponent(chckbxFotocopiaDNI)
																																						.addComponent(chckbxEscritura)
																																						.addComponent(chckbxJustificantePago)
																																						.addComponent(chckbxFotocopiaImpuestoActividades))
																																					.addGap(59))
																																		);
																																		panelDocGen.setLayout(gl_panelDocGen);
																																		panelDoc.setLayout(gl_panelDoc);
		
				JPanel panelLocal = new JPanel();
				panelLocal.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Local", TitledBorder.LEADING,
						TitledBorder.TOP, null, new Color(0, 0, 0)));
				
						JLabel lblDescrAct = new JLabel("Descripci\u00F3n de la actividad");
										
												JLabel lblTipo = new JLabel("Tipo Actividad");
												comboTipo.setModel(new DefaultComboBoxModel(new String[] {"Seleccione Tipo", "Suelo calificado como industrial", "Suelo urbano", "Casa de ahorro, bancos", "Compa\u00F1ias de seguros", "Bares, Cafetrias, Restaurantes", "Salones recreativos", "Establecimientos Alimentarios", "Hoteles, Hostales, Pensiones", "Terrazas de verano", "Gasolineras, Depositos combustible"}));
												
												JLabel lblReferenciaCatastral = new JLabel("Referencia Catastral");
												
												txtReferencia = new JTextField();
												txtReferencia.setColumns(10);
												
												JLabel lblTipoSuelo = new JLabel("Tipo Suelo");
												
												comboSuelo = new JComboBox();
												comboSuelo.setModel(new DefaultComboBoxModel(new String[] {"Seleccione Tipo", "Urbano", "R\u00FAstico"}));
												GroupLayout gl_panelLocal = new GroupLayout(panelLocal);
												gl_panelLocal.setHorizontalGroup(
													gl_panelLocal.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_panelLocal.createSequentialGroup()
															.addContainerGap()
															.addGroup(gl_panelLocal.createParallelGroup(Alignment.LEADING)
																.addComponent(txtDescrAct, GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
																.addComponent(lblDescrAct)
																.addGroup(gl_panelLocal.createSequentialGroup()
																	.addGroup(gl_panelLocal.createParallelGroup(Alignment.LEADING)
																		.addComponent(txtReferencia, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
																		.addComponent(lblReferenciaCatastral))
																	.addPreferredGap(ComponentPlacement.UNRELATED)
																	.addGroup(gl_panelLocal.createParallelGroup(Alignment.LEADING, false)
																		.addComponent(lblTipo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																		.addComponent(comboTipo, 0, 146, Short.MAX_VALUE))
																	.addPreferredGap(ComponentPlacement.RELATED)
																	.addGroup(gl_panelLocal.createParallelGroup(Alignment.LEADING, false)
																		.addComponent(lblTipoSuelo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																		.addComponent(comboSuelo, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
															.addContainerGap())
												);
												gl_panelLocal.setVerticalGroup(
													gl_panelLocal.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_panelLocal.createSequentialGroup()
															.addComponent(lblDescrAct)
															.addGap(12)
															.addComponent(txtDescrAct, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
															.addPreferredGap(ComponentPlacement.RELATED)
															.addGroup(gl_panelLocal.createParallelGroup(Alignment.BASELINE)
																.addComponent(lblTipo)
																.addComponent(lblReferenciaCatastral)
																.addComponent(lblTipoSuelo))
															.addPreferredGap(ComponentPlacement.RELATED)
															.addGroup(gl_panelLocal.createParallelGroup(Alignment.BASELINE)
																.addComponent(txtReferencia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																.addComponent(comboTipo, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
																.addComponent(comboSuelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
															.addContainerGap(36, Short.MAX_VALUE))
												);
												panelLocal.setLayout(gl_panelLocal);
		
				JButton btnEnviar = new JButton("Enviar");
				btnEnviar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							
						if(getChckbxRequired().isSelected()){
							int idAct=controlador.InsertSolicitud();
							int idPer=controlador.InsertPersona();
							int idRep=controlador.InsertRepresentante();
							controlador.insertarTablaPersonaRepre(idPer, idRep);
							controlador.insertarTablaPersonaSolicitud(idPer, idAct);
						}else{
							int idAct=controlador.InsertSolicitud();
							int idPer=controlador.InsertPersona();
							controlador.insertarTablaPersonaSolicitud(idPer, idAct);
						}
						//controlador.insertTI();
						
					}
				});
				
				
			
				btnEnviar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controlador.cerrarVentanaInscripcion();
					}
				});
				btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(332)
					.addComponent(btnEnviar, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(40, Short.MAX_VALUE)
					.addComponent(panelDoc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(40)
					.addComponent(panelLocal, 0, 0, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelLocal, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addGap(43)
					.addComponent(panelDoc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnEnviar)
						.addComponent(btnCancelar))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);

		JPanel panelInteresado = new JPanel();
		panelInteresado
				.setBorder(new TitledBorder(null, "Interesado", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JPanel panelRepresentante = new JPanel();
		panelRepresentante.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Representante",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelRepresentante.setVisible(true);
		
		txtDniRepre = new JTextField();
		txtDniRepre.setEnabled(false);
		txtDniRepre.setColumns(10);

		JLabel label = new JLabel("DNI/CIF");
		label.setEnabled(false);

		txtCpRepre = new JTextField();
		txtCpRepre.setEnabled(false);
		txtCpRepre.setColumns(10);

		JLabel lblCp_1 = new JLabel("CP");
		lblCp_1.setEnabled(false);

		txtMovilRepre = new JTextField();
		txtMovilRepre.setEnabled(false);
		txtMovilRepre.setColumns(10);

		JLabel label_2 = new JLabel("Tel\u00E9fono M\u00F3vil");
		label_2.setEnabled(false);

		txtFaxRepre = new JTextField();
		txtFaxRepre.setEnabled(false);
		txtFaxRepre.setColumns(10);

		JLabel lblTelfonofax = new JLabel("Tel\u00E9fono/FAX");
		lblTelfonofax.setEnabled(false);

		txtNombreApellidosRepre = new JTextField();
		txtNombreApellidosRepre.setEnabled(false);
		txtNombreApellidosRepre.setColumns(10);

		JLabel label_5 = new JLabel("Apellidos y Nombre o Raz\u00F3n Social");
		label_5.setEnabled(false);

		JLabel label_6 = new JLabel("Direcci\u00F3n");
		label_6.setEnabled(false);

		txtDireccionRepre = new JTextField();
		txtDireccionRepre.setEnabled(false);
		txtDireccionRepre.setColumns(10);

		txtMunicipioRepre = new JTextField();
		txtMunicipioRepre.setEnabled(false);
		txtMunicipioRepre.setColumns(10);

		JLabel label_7 = new JLabel("Municipio (Provincia)");
		label_7.setEnabled(false);
		GroupLayout gl_panelRepresentante = new GroupLayout(panelRepresentante);
		gl_panelRepresentante.setHorizontalGroup(
			gl_panelRepresentante.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelRepresentante.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelRepresentante.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelRepresentante.createSequentialGroup()
							.addGroup(gl_panelRepresentante.createParallelGroup(Alignment.LEADING)
								.addComponent(txtNombreApellidosRepre, GroupLayout.PREFERRED_SIZE, 377, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_5))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelRepresentante.createParallelGroup(Alignment.LEADING)
								.addComponent(label)
								.addComponent(txtDniRepre, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)))
						.addGroup(gl_panelRepresentante.createSequentialGroup()
							.addGroup(gl_panelRepresentante.createParallelGroup(Alignment.LEADING)
								.addComponent(label_6)
								.addComponent(txtDireccionRepre, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelRepresentante.createParallelGroup(Alignment.LEADING)
								.addComponent(label_7, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
								.addComponent(txtMunicipioRepre, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)))
						.addGroup(gl_panelRepresentante.createSequentialGroup()
							.addGroup(gl_panelRepresentante.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCp_1)
								.addComponent(txtCpRepre, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panelRepresentante.createParallelGroup(Alignment.LEADING)
								.addComponent(txtMovilRepre, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_2))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panelRepresentante.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panelRepresentante.createSequentialGroup()
									.addComponent(lblTelfonofax)
									.addGap(46))
								.addComponent(txtFaxRepre))))
					.addGap(54))
		);
		gl_panelRepresentante.setVerticalGroup(
			gl_panelRepresentante.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelRepresentante.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelRepresentante.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5)
						.addComponent(label))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelRepresentante.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNombreApellidosRepre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDniRepre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelRepresentante.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_6)
						.addComponent(label_7))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelRepresentante.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtDireccionRepre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtMunicipioRepre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelRepresentante.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblTelfonofax)
						.addGroup(gl_panelRepresentante.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_2)
							.addComponent(lblCp_1)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelRepresentante.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelRepresentante.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtFaxRepre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtMovilRepre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtCpRepre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelRepresentante.setLayout(gl_panelRepresentante);
		contentPane.setLayout(null);

		setChckbxRequired(new JCheckBox("Requiere representante"));
		getChckbxRequired().setBackground(SystemColor.inactiveCaption);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Fecha", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_panelBorde = new GroupLayout(panelBorde);
		gl_panelBorde.setHorizontalGroup(
			gl_panelBorde.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelBorde.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelBorde.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelRepresentante, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_panelBorde.createParallelGroup(Alignment.LEADING, false)
							.addComponent(getChckbxRequired(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(panelInteresado, GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)))
					.addGap(33))
		);
		gl_panelBorde.setVerticalGroup(
			gl_panelBorde.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelBorde.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelInteresado, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(getChckbxRequired())
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelRepresentante, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
					.addGap(46))
		);
		
		fechaSolicitud = new JDateChooser();
		
		JLabel lblNewLabel = new JLabel("Fecha Solicitud");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblFechaDeInicio = new JLabel("Fecha inicio Actividad");
		lblFechaDeInicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		fechaActividad = new JDateChooser();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(fechaSolicitud, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
					.addGap(58)
					.addComponent(lblFechaDeInicio, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(fechaActividad, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblFechaDeInicio, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(fechaActividad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(fechaSolicitud, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(5)
							.addComponent(lblNewLabel)))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);

		JLabel lblNombre = new JLabel("Apellidos y Nombre o Raz\u00F3n Social");

		txtNombre = new JTextField();
		txtNombre.setColumns(10);

		JLabel lblDireccion = new JLabel("Direcci\u00F3n");

		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);

		JLabel lblMunicipio = new JLabel("Municipio (Provincia)");

		txtMunicipio = new JTextField();
		txtMunicipio.setColumns(10);

		txtDNI = new JTextField();
		txtDNI.setColumns(10);

		JLabel lblDNI = new JLabel("DNI/CIF");

		txtCp = new JTextField();
		txtCp.setColumns(10);

		JLabel lblCp = new JLabel("CP");

		txtMovil = new JTextField();
		txtMovil.setColumns(10);

		JLabel lblMovil = new JLabel("Tel\u00E9fono M\u00F3vil");

		txtFax = new JTextField();
		txtFax.setColumns(10);

		JLabel lblTelefonoFax = new JLabel("Telfono fijo/FAX");

		txtMail = new JTextField();
		txtMail.setColumns(10);

		JLabel lblMail = new JLabel("Direcci\u00F3n e-mail");
		GroupLayout gl_panelInteresado = new GroupLayout(panelInteresado);
		gl_panelInteresado.setHorizontalGroup(gl_panelInteresado.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelInteresado.createSequentialGroup().addContainerGap().addGroup(gl_panelInteresado
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelInteresado.createSequentialGroup()
								.addGroup(gl_panelInteresado.createParallelGroup(Alignment.LEADING)
										.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 377,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNombre))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panelInteresado.createParallelGroup(Alignment.LEADING).addComponent(lblDNI)
										.addComponent(txtDNI, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)))
						.addGroup(gl_panelInteresado.createSequentialGroup().addGroup(gl_panelInteresado
								.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(Alignment.LEADING, gl_panelInteresado.createSequentialGroup()
										.addGroup(gl_panelInteresado.createParallelGroup(Alignment.LEADING)
												.addComponent(lblDireccion).addComponent(txtDireccion,
														GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_panelInteresado.createParallelGroup(Alignment.LEADING, false)
												.addComponent(txtMunicipio).addComponent(lblMunicipio,
														GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)))
								.addGroup(Alignment.LEADING,
										gl_panelInteresado.createSequentialGroup()
												.addGroup(gl_panelInteresado.createParallelGroup(Alignment.LEADING)
														.addComponent(txtMovil, GroupLayout.PREFERRED_SIZE, 155,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblMovil))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_panelInteresado.createParallelGroup(Alignment.LEADING)
														.addComponent(lblTelefonoFax).addComponent(txtFax))))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panelInteresado.createParallelGroup(Alignment.LEADING)
										.addComponent(lblMail).addComponent(lblCp)
										.addComponent(txtCp, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
										.addComponent(txtMail, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))))
						.addContainerGap()));
		gl_panelInteresado.setVerticalGroup(gl_panelInteresado.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelInteresado.createSequentialGroup().addContainerGap()
						.addGroup(gl_panelInteresado.createParallelGroup(Alignment.BASELINE).addComponent(lblNombre)
								.addComponent(lblDNI))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelInteresado.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelInteresado.createParallelGroup(Alignment.BASELINE).addComponent(lblDireccion)
								.addComponent(lblMunicipio).addComponent(lblCp))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelInteresado.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtMunicipio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtCp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelInteresado.createParallelGroup(Alignment.BASELINE).addComponent(lblMovil)
								.addComponent(lblTelefonoFax).addComponent(lblMail))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelInteresado.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtMovil, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtFax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtMail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(118, Short.MAX_VALUE)));
		panelInteresado.setLayout(gl_panelInteresado);
		panelBorde.setLayout(gl_panelBorde);
		contentPane.add(panelBorde);
		contentPane.add(panel);

		getChckbxRequired().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getChckbxRequired().isSelected()) {
					controlador.enableComponents(panelRepresentante, true);
				} else {
					controlador.enableComponents(panelRepresentante, false);
				}

			}
		});
	}


	public String getTxtDniRepre() {
		return txtDniRepre.getText();
	}


	public String getTxtCpRepre() {
		return txtCpRepre.getText();
	}


	public String getTxtMovilRepre() {
		return txtMovilRepre.getText();
	}


	public String getTxtFaxRepre() {
		return txtFaxRepre.getText();
	}


	public String getTxtNombreApellidosRepre() {
		return txtNombreApellidosRepre.getText();
	}


	public String getTxtDireccionRepre() {
		return txtDireccionRepre.getText();
	}


	public String getTxtMunicipioRepre() {
		return txtMunicipioRepre.getText();
	}


	public int getChckbxDNI() {
		if(chckbxFotocopiaDNI.isSelected())
		return 1;
		
		return 0;
	}


	public int getChckbxEscritura() {
		if(chckbxEscritura.isSelected())
			return 1;
			
			return 0;
		
	}


	public int getChckbxJustificantePago() {
		if(chckbxJustificantePago.isSelected())
			return 1;
			
			return 0;
		
	}


	public int getChckbxFotocopiaImpuestoActividades() {
		if(chckbxFotocopiaImpuestoActividades.isSelected())
			return 1;
			
			return 0;
	}





	public int getChckbxChckbxMemoria() {
		if(chckbxMemoria.isSelected())
			return 1;
			
			return 0;
		
	}


	public int getChckbxCertificadoColegio() {
		if(chckbxCertificadoColegio.isSelected())
			return 1;
			
			return 0;
		
	}


	public int getChckbxPlanoAcotadoDel() {
		if(chckbxPlanoAcotadoDel.isSelected())
			return 1;
			
			return 0;
		
	}

	public int getChckbxLicenciaObra() {
		if(chckbxLicenciaObra.isSelected())
			return 1;
			
			return 0;
		
	}


	public int getChckbxOtrasAutorizaciones() {
		if(chckbxOtrasAutorizaciones.isSelected())
			return 1;
			
			return 0;
		
	}


	public String getTxtNombre() {
		return txtNombre.getText();
	}

	public String getTxtDireccion() {
		return txtDireccion.getText();
	}

	public String getTxtMunicipio() {
		return txtMunicipio.getText();
	}

	public String getTxtDNI() {
		return txtDNI.getText();
	}

	public String getTxtCp() {
		return txtCp.getText();
	}

	public String getTxtMovil() {
		return txtMovil.getText();
	}

	public String getTxtFax() {
		return txtFax.getText();
	}

	public String getTxtMail() {
		return txtMail.getText();
	}

	public String gettxtDniRepre() {
		return txtDniRepre.getText();
	}

	public String gettxtCpRepre() {
		return txtCpRepre.getText();
	}

	public String gettxtMovilRepre() {
		return txtMovilRepre.getText();
	}

	public String gettxtFaxRepre() {
		return txtFaxRepre.getText();
	}


	public String gettxtNombreApellidosRepre() {
		return txtNombreApellidosRepre.getText();
	}

	public String gettxtDireccionRepre() {
		return txtDireccionRepre.getText();
	}

	public String gettxtMunicipioRepre() {
		return txtMunicipioRepre.getText();
	}

	
	public String getTxtReferencia() {
		return txtReferencia.getText();
	}

	public String getTxtDescrAct() {
		return txtDescrAct.getText();
	}

	public String getComboTipo(){
		return comboTipo.getSelectedItem().toString();
	}
	
	public String getComboSuelo(){
		return comboSuelo.getSelectedItem().toString();
	}
	
	
	public String getFechaSolicitud() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return  df.format(fechaSolicitud.getDate());
	}
	
	public String getFechaActividad() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return  df.format(fechaActividad.getDate());
	}

	
	
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}


	public JCheckBox getChckbxRequired() {
		return chckbxRequired;
	}


	public void setChckbxRequired(JCheckBox chckbxRequired) {
		this.chckbxRequired = chckbxRequired;
	}
}
