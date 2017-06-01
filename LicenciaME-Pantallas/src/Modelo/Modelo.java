package Modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Vista.VistaConfiguracion;
import Vista.VistaInscripcion;
import Vista.VistaModificacion;
import Vista.VistaPrincipal;

public class Modelo {
	private int idAct;
	private int idPers;
	private String actividad;
	private String tipo;
	private String fecha;
	private String estado;
	private String url;
	private String usuario;
	private String clave;
	private VistaPrincipal vistaPrincipal;
	private VistaInscripcion vistaInscripcion;
	private VistaConfiguracion vistaConfiguracion;
	private VistaModificacion vistaModificacion;
	private ModeloIni modeloIni;

	// variables persona vistaModificacion
	private int txtDni;
	private int txtCp;
	private int txtMovil;
	private int txtFax;
	private String txtNombre;
	private String txtDireccion;
	private String txtMunicipio;
	private String txtMail;
	// variables representante vistaModificacion
	private int txtDniRepre;
	private String txtNombreApellidosRepre;
	private int txtMovilRepre;
	private int txtCpRepre;
	private int txtFaxRepre;
	private String txtDireccionRepre;
	private String txtMunicipioRepre;
	// variables solicitud vistaModificacion
	private String txtDescSolicitud;
	private int txtRefSolicitud;
	private String txtSueloSolicitud;
	private String txtTipoSolicitud;
	private String txtFechaSolicitud;
	private String txtFechaIniSolicitud;
	private String comboBoxEstado;
	private int txtFtoDniSolicitud;
	private int txtFtoActSolicitud;
	private int txtFtoEscriSolicitud;
	private int txtJustPagoSolicitud;
	private int txtMemActSolicitud;
	private int txtPlanosSolicitud;
	private int txtAutoSolicitud;
	private int txtLicObraSolicitud;
	private int txtCertColegSolicitud;
	//variables solicitud vistaPrincipal
	private String txtDescSolicitudP;
	private String txtFechaSolicitudP;
	private String txtFechaIniSolicitudP;
	private int txtFtoDniSolicitudP;
	private int txtFtoActSolicitudP;
	private int txtFtoEscriSolicitudP;
	private int txtJustPagoSolicitudP;
	private int txtMemActSolicitudP;
	private int txtPlanosSolicitudP;
	private int txtAutoSolicitudP;
	private int txtLicObraSolicitudP;
	private int txtCertColegSolicitudP;
	

	public Modelo() {
		super();
		Properties propiedades = new Properties();
		InputStream entrada = null;
		try {
			File config = new File("conf/configuracion.ini");
			if (config.exists()) {
				entrada = new FileInputStream(config);

				propiedades.load(entrada);

				url = propiedades.getProperty("BaseDatos");
				usuario = propiedades.getProperty("Usuario");
				clave = propiedades.getProperty("Clave");
			} else
				System.err.println("Fichero no encontrado");
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (entrada != null) {
				try {
					entrada.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public Modelo(int idAct, int idPers, String actividad, String tipo, String fecha, String estado) {
		this.idAct = idAct;
		this.idPers = idPers;
		this.actividad = actividad;
		this.tipo = tipo;
		this.fecha = fecha;
		this.estado = estado;
	}

	public Connection getConnection() {
		Connection con;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, usuario, clave);
			return con;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"No se pudo conectar con la base de datos, modifique la informaciï¿½n en la configuraciï¿½n");
			return null;
			// TODO: handle exception
		}
	}

	/*
	 * Execute SQL Query
	 */

	public int insertSolicitud(String fechaSolicitud, String tipo, String descripcionActividad,
			String referenciaCatastral, String tipoSuelo, String fechaInicio, String estado, int fotocopiaDNI,
			int fotocopiaImpuesto, int fotocopiaEscritura, int justificantePago, int memoriaActividad, int planos,
			int licenciaObra, int certificadoColegioOficial, int otrasAutorizaciones) {
		Connection con = getConnection();
		PreparedStatement ps;
		int r = 0;
		int last_inserted_id = -1;
		String query = "INSERT INTO `solicitud` (`fecha`, `tipo`, `desc_actividad`, `ref_catastral`, `tipo_suelo`, `fecha_inicio`, `estado`, `fotocopia_dni`, `fotocopia_imp_actividades`, `fotocopia_escritura`, `justificante_pago`, `memoria_actividad`, `planos`, `licencia_obra`, `otras_autorizaciones`, `certificado_colegio_oficial`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, fechaSolicitud);
			ps.setString(2, tipo);
			ps.setString(3, descripcionActividad);
			ps.setString(4, referenciaCatastral);
			ps.setString(5, tipoSuelo);
			ps.setString(6, fechaInicio);
			ps.setString(7, estado);
			ps.setInt(8, fotocopiaDNI);
			ps.setInt(9, fotocopiaImpuesto);
			ps.setInt(10, fotocopiaEscritura);
			ps.setInt(11, justificantePago);
			ps.setInt(12, memoriaActividad);
			ps.setInt(13, planos);
			ps.setInt(14, licenciaObra);
			ps.setInt(15, certificadoColegioOficial);
			ps.setInt(16, otrasAutorizaciones);

			if (ps.executeUpdate() == 1) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {

					last_inserted_id = rs.getInt(1);

					System.out.println(last_inserted_id);

				}

				DefaultTableModel model = (DefaultTableModel) vistaPrincipal.getTablaInfo();
				model.setRowCount(0);
				ShowJTable();

			} else {
				JOptionPane.showMessageDialog(null, "La información no pudo ser almacenada");
			}
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
		return last_inserted_id;
	}

	public int inertPersona(String nombre, int DNI, String direccion, String municipio, String cp, String fijo,
			String movil, String mail, String tipo) {
		Connection con = getConnection();
		PreparedStatement ps;
		int r = 0;
		int last_inserted_id = -1;
		String query = "INSERT INTO `persona`(`cif`, `nombre`, `direccion`, `municipio`, `cp`, `tlf_fijo`, `tlf_movil`, `email`, `tipo`) VALUES (?,?,?,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, DNI);
			ps.setString(2, nombre);
			ps.setString(3, direccion);
			ps.setString(4, municipio);
			ps.setString(5, cp);
			ps.setString(6, fijo);
			ps.setString(7, movil);
			ps.setString(8, mail);
			ps.setString(9, tipo);

			if (ps.executeUpdate() == 1) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {

					last_inserted_id = rs.getInt(1);

					System.out.println(last_inserted_id);

				}

				DefaultTableModel model = (DefaultTableModel) vistaPrincipal.getTablaInfo();
				model.setRowCount(0);
				ShowJTable();

			} else {
				JOptionPane.showMessageDialog(null, "La información no pudo ser almacenada");
			}
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
		return last_inserted_id;
	}

	public ArrayList<Modelo> getInscripcionesList() {
		ArrayList<Modelo> inscripcionesList = new ArrayList<Modelo>();
		Connection connection = getConnection();

		// HAY QUE QUITAR LOS LEFT JOIN

		String query = "SELECT id_solicitud, persona.cif as cif, solicitud.desc_actividad as nombre, solicitud.tipo as tipoActividad, solicitud.fecha_inicio as fecha, solicitud.estado as estado FROM `solicitud` LEFT JOIN titularidad ON titularidad.solicitud = solicitud.id_solicitud LEFT JOIN persona ON titularidad.persona = persona.id_persona";
		Statement st;
		ResultSet rs;
		try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			Modelo database;
			while (rs.next()) {
				database = new Modelo(rs.getInt("id_solicitud"), rs.getInt("cif"), rs.getString("nombre"),
						rs.getString("tipoActividad"), rs.getString("fecha"), rs.getString("estado"));
				inscripcionesList.add(database);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return inscripcionesList;
	}

	public int inertRepresentante(String nombre, int DNI, String direccion, String municipio, String cp, String fax,
			String movil) {
		Connection con = getConnection();
		PreparedStatement ps;
		int r = 0;
		int last_inserted_id = -1;

		String query = "INSERT INTO `representante`(`nif_nie`, `nombre`, `direccion`, `municipio`, `cp`, `tlf_fijo`, `tlf_movil`) VALUES (?,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, DNI);
			ps.setString(2, nombre);
			ps.setString(3, direccion);
			ps.setString(4, municipio);
			ps.setString(5, cp);
			ps.setString(6, fax);
			ps.setString(7, movil);

			if (ps.executeUpdate() == 1) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {

					last_inserted_id = rs.getInt(1);

					System.out.println(last_inserted_id);

				}
				DefaultTableModel model = (DefaultTableModel) vistaPrincipal.getTablaInfo();
				model.setRowCount(0);
				ShowJTable();

			} else {
				JOptionPane.showMessageDialog(null, "La información no pudo ser almacenada");
			}
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
		return last_inserted_id;

	}

	public void insertarTablaPersonaRepre(int idPersona, int idRepre) {
		Connection con = getConnection();
		String query = "INSERT INTO `representa` ( `persona`, `representante`) VALUES ( ?,? )";
		PreparedStatement ps;

		try {
			ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, idPersona);
			ps.setInt(2, idRepre);

			if (ps.executeUpdate() == 1) {
				DefaultTableModel model = (DefaultTableModel) vistaPrincipal.getTablaInfo();
				model.setRowCount(0);
				ShowJTable();
				vistaInscripcion.dispose();
				JOptionPane.showMessageDialog(null, "Información almacenada satisfactoriamente");
			} else {
				JOptionPane.showMessageDialog(null, "La información no pudo ser almacenada");
			}
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}

	}

	public void insertarTablaPersonaSolicitud(int idPersona, int idAct, String fechaSolicitud) {
		Connection con = getConnection();
		String query = "INSERT INTO `titularidad` (`persona`, `solicitud`, `fecha_inicio`, `fecha_fin`) VALUES ( ?,?,?,? )";
		PreparedStatement ps;

		try {
			ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, idPersona);
			ps.setInt(2, idAct);
			ps.setString(3, fechaSolicitud);
			ps.setString(4, null);

			if (ps.executeUpdate() == 1) {
				DefaultTableModel model = (DefaultTableModel) vistaPrincipal.getTablaInfo();
				model.setRowCount(0);
				ShowJTable();
				vistaInscripcion.dispose();
				JOptionPane.showMessageDialog(null, "Información almacenada satisfactoriamente");
			} else {
				JOptionPane.showMessageDialog(null, "La información no pudo ser almacenada");
			}
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}

	}

	public void datosModificacion(int nRegistro) {

		try {
			Connection con = getConnection();
			if (con == null) {

				System.exit(-1);
			}
			PreparedStatement ps = con.prepareStatement(
					"SELECT persona.cif as cifPersona,persona.direccion as direccionPersona,persona.municipio as municipioPersona,persona.cp as cpPersona,solicitud.estado as estadoSolicitud,persona.tlf_fijo as fijoPersona,persona.tlf_movil as movilPersona,persona.nombre as nombrePersona,persona.email as emailPersona,representante.nif_nie as nifRepre,representante.direccion as direccionRepre,representante.municipio as municipioRepre,representante.cp as cpRepre,representante.tlf_fijo as fijoRepre,representante.tlf_movil as movilRepre,representante.nombre as nombreRepre,solicitud.desc_actividad as descSolicitud,solicitud.ref_catastral as refSolicitud,solicitud.tipo_suelo as sueloSolicitud,solicitud.tipo as tipoSolicitud,solicitud.fecha as fechaSolicitud,solicitud.fecha_inicio as fechaIniSolicitud,solicitud.fotocopia_dni as ftoDniSolicitud,solicitud.fotocopia_imp_actividades as ftoActSolicitud,solicitud.fotocopia_escritura as ftoEscriSolicitud,solicitud.justificante_pago as justPagoSolicitud,solicitud.memoria_actividad as memActSolicitud,solicitud.planos as planosSolicitud,solicitud.otras_autorizaciones as autoSolicitud,solicitud.licencia_obra as licObraSolicitud,solicitud.certificado_colegio_oficial as certColegSolicitud, solicitud.estado as estado FROM persona JOIN titularidad ON persona.id_persona = titularidad.persona JOIN solicitud ON titularidad.solicitud = solicitud.id_solicitud LEFT JOIN representa ON persona.id_persona = representa.persona LEFT JOIN representante ON representante.id_representante = representa.representante WHERE solicitud.id_solicitud = ?");

			ps.setInt(1, nRegistro);
			ResultSet rset = ps.executeQuery();

			int z = 0;
			while (rset.next()) {
				// persona
				txtDni = rset.getInt("cifPersona");
				txtNombre = rset.getString("nombrePersona");
				txtCp = rset.getInt("cpPersona");
				txtMunicipio = rset.getString("municipioPersona");
				txtDireccion = rset.getString("direccionPersona");
				txtFax = rset.getInt("fijoPersona");
				txtMail = rset.getString("emailPersona");
				txtMovil = rset.getInt("movilPersona");
				// representante

				txtDniRepre = rset.getInt("nifRepre");
				txtNombreApellidosRepre = rset.getString("nombreRepre");
				txtCpRepre = rset.getInt("cpRepre");
				txtMunicipioRepre = rset.getString("municipioRepre");
				txtDireccionRepre = rset.getString("direccionRepre");
				txtFaxRepre = rset.getInt("fijoRepre");
				txtMovilRepre = rset.getInt("movilRepre");

				// solicitud
				txtDescSolicitud = rset.getString("descSolicitud");
				txtRefSolicitud = rset.getInt("refSolicitud");
				txtSueloSolicitud = rset.getString("sueloSolicitud");
				txtTipoSolicitud = rset.getString("tipoSolicitud");
				txtFechaSolicitud = rset.getString("fechaSolicitud");
				txtFechaIniSolicitud = rset.getString("fechaIniSolicitud");
				comboBoxEstado = rset.getString("estadoSolicitud");
				txtFtoDniSolicitud = rset.getInt("ftoDniSolicitud");
				txtFtoActSolicitud = rset.getInt("ftoActSolicitud");
				txtFtoEscriSolicitud = rset.getInt("ftoEscriSolicitud");
				txtJustPagoSolicitud = rset.getInt("justPagoSolicitud");
				txtMemActSolicitud = rset.getInt("memActSolicitud");
				txtPlanosSolicitud = rset.getInt("planosSolicitud");
				txtAutoSolicitud = rset.getInt("autoSolicitud");
				txtLicObraSolicitud = rset.getInt("licObraSolicitud");
				txtCertColegSolicitud = rset.getInt("certColegSolicitud");

				z += 1;
			}

		} catch (SQLException s) {
			s.printStackTrace();
		}
		vistaModificacion.datosRegistro();
	}

	/*
	 * Mostrar Tabla
	 */

	public void datosAdicionales(int nRegistro){
		
		try {
			Connection con = getConnection();
			if (con == null) {

				System.exit(-1);
			}
			PreparedStatement ps = con.prepareStatement(
					"SELECT solicitud.desc_actividad as descSolicitud,solicitud.fecha as fechaSolicitud,solicitud.fecha_inicio as fechaIniSolicitud,solicitud.fotocopia_dni as ftoDniSolicitud,solicitud.fotocopia_imp_actividades as ftoActSolicitud,solicitud.fotocopia_escritura as ftoEscriSolicitud,solicitud.justificante_pago as justPagoSolicitud,solicitud.memoria_actividad as memActSolicitud,solicitud.planos as planosSolicitud,solicitud.otras_autorizaciones as autoSolicitud,solicitud.licencia_obra as licObraSolicitud,solicitud.certificado_colegio_oficial as certColegSolicitud FROM persona JOIN titularidad ON persona.id_persona = titularidad.persona JOIN solicitud ON titularidad.solicitud = solicitud.id_solicitud LEFT JOIN representa ON persona.id_persona = representa.persona LEFT JOIN representante ON representante.id_representante = representa.representante WHERE solicitud.id_solicitud = ?");

			ps.setInt(1, nRegistro);
			ResultSet rset = ps.executeQuery();

			int z = 0;
			while (rset.next()) {
				txtFechaSolicitudP = rset.getString("fechaSolicitud");
				txtFechaIniSolicitudP = rset.getString("fechaIniSolicitud");
				txtFtoDniSolicitudP = rset.getInt("ftoDniSolicitud");
				txtFtoActSolicitudP = rset.getInt("ftoActSolicitud");
				txtFtoEscriSolicitudP = rset.getInt("ftoEscriSolicitud");
				txtJustPagoSolicitudP = rset.getInt("justPagoSolicitud");
				txtMemActSolicitudP = rset.getInt("memActSolicitud");
				txtPlanosSolicitudP = rset.getInt("planosSolicitud");
				txtAutoSolicitudP = rset.getInt("autoSolicitud");
				txtLicObraSolicitudP = rset.getInt("licObraSolicitud");
				txtCertColegSolicitudP = rset.getInt("certColegSolicitud");
				
				z += 1;
			}

		} catch (SQLException s) {
			s.printStackTrace();
		}
		vistaPrincipal.datosAdicionales();
	}
	
	

	public void ShowJTable() {
		ArrayList<Modelo> list = getInscripcionesList();
		DefaultTableModel model = (DefaultTableModel) vistaPrincipal.getTablaInfo();

		Object[] row = new Object[6];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getIdAct();
			row[1] = list.get(i).getIdPers();
			row[2] = list.get(i).getActividad();
			row[3] = list.get(i).getTipo();
			row[4] = list.get(i).getFecha();
			row[5] = list.get(i).getEstado();

			model.addRow(row);
		}
	}
	
	public String getTxtDescSolicitudP() {
		return txtDescSolicitudP;
	}

	public void setTxtDescSolicitudP(String txtDescSolicitudP) {
		this.txtDescSolicitudP = txtDescSolicitudP;
	}

	public String getTxtFechaSolicitudP() {
		return txtFechaSolicitudP;
	}

	public void setTxtFechaSolicitudP(String txtFechaSolicitudP) {
		this.txtFechaSolicitudP = txtFechaSolicitudP;
	}

	public String getTxtFechaIniSolicitudP() {
		return txtFechaIniSolicitudP;
	}

	public void setTxtFechaIniSolicitudP(String txtFechaIniSolicitudP) {
		this.txtFechaIniSolicitudP = txtFechaIniSolicitudP;
	}

	public int getTxtFtoDniSolicitudP() {
		return txtFtoDniSolicitudP;
	}

	public void setTxtFtoDniSolicitudP(int txtFtoDniSolicitudP) {
		this.txtFtoDniSolicitudP = txtFtoDniSolicitudP;
	}

	public int getTxtFtoActSolicitudP() {
		return txtFtoActSolicitudP;
	}

	public void setTxtFtoActSolicitudP(int txtFtoActSolicitudP) {
		this.txtFtoActSolicitudP = txtFtoActSolicitudP;
	}

	public int getTxtFtoEscriSolicitudP() {
		return txtFtoEscriSolicitudP;
	}

	public void setTxtFtoEscriSolicitudP(int txtFtoEscriSolicitudP) {
		this.txtFtoEscriSolicitudP = txtFtoEscriSolicitudP;
	}

	public int getTxtJustPagoSolicitudP() {
		return txtJustPagoSolicitudP;
	}

	public void setTxtJustPagoSolicitudP(int txtJustPagoSolicitudP) {
		this.txtJustPagoSolicitudP = txtJustPagoSolicitudP;
	}

	public int getTxtMemActSolicitudP() {
		return txtMemActSolicitudP;
	}

	public void setTxtMemActSolicitudP(int txtMemActSolicitudP) {
		this.txtMemActSolicitudP = txtMemActSolicitudP;
	}

	public int getTxtPlanosSolicitudP() {
		return txtPlanosSolicitudP;
	}

	public void setTxtPlanosSolicitudP(int txtPlanosSolicitudP) {
		this.txtPlanosSolicitudP = txtPlanosSolicitudP;
	}

	public int getTxtAutoSolicitudP() {
		return txtAutoSolicitudP;
	}

	public void setTxtAutoSolicitudP(int txtAutoSolicitudP) {
		this.txtAutoSolicitudP = txtAutoSolicitudP;
	}

	public int getTxtLicObraSolicitudP() {
		return txtLicObraSolicitudP;
	}

	public void setTxtLicObraSolicitudP(int txtLicObraSolicitudP) {
		this.txtLicObraSolicitudP = txtLicObraSolicitudP;
	}

	public int getTxtCertColegSolicitudP() {
		return txtCertColegSolicitudP;
	}

	public void setTxtCertColegSolicitudP(int txtCertColegSolicitudP) {
		this.txtCertColegSolicitudP = txtCertColegSolicitudP;
	}

	public int getIdAct() {
		return idAct;
	}

	public void setIdAct(int idAct) {
		this.idAct = idAct;
	}

	public int getIdPers() {
		return idPers;
	}

	public void setIdPers(int idPers) {
		this.idPers = idPers;
	}

	public String getActividad() {
		return actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getEstado() {
		return estado;
	}

	public int getTxtCp() {
		return txtCp;
	}

	public int getTxtMovil() {
		return txtMovil;
	}

	public int getTxtFax() {
		return txtFax;
	}

	public String getTxtDireccion() {
		return txtDireccion;
	}

	public String getTxtMunicipio() {
		return txtMunicipio;
	}

	public String getTxtMail() {
		return txtMail;
	}

	public int getTxtDniRepre() {
		return txtDniRepre;
	}

	public String getTxtNombreApellidosRepre() {
		return txtNombreApellidosRepre;
	}

	public int getTxtMovilRepre() {
		return txtMovilRepre;
	}

	public int getTxtCpRepre() {
		return txtCpRepre;
	}

	public int getTxtFaxRepre() {
		return txtFaxRepre;
	}

	public String getTxtDireccionRepre() {
		return txtDireccionRepre;
	}

	public String getTxtMunicipioRepre() {
		return txtMunicipioRepre;
	}

	public int getTxtDni() {
		return txtDni;
	}

	public String getTxtNombre() {
		return txtNombre;
	}

	public String getUrl() {
		return url;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getTxtDescSolicitud() {
		return txtDescSolicitud;
	}

	public int getTxtRefSolicitud() {
		return txtRefSolicitud;
	}

	public String getTxtSueloSolicitud() {
		return txtSueloSolicitud;
	}

	public String getTxtTipoSolicitud() {
		return txtTipoSolicitud;
	}
	
	public String getTxtcomboBoxEstado() {
		return comboBoxEstado;
	}

	public java.util.Date getTxtFechaSolicitud()  {
		java.util.Date d = null;
		try {
			d = (parsearFechaSQL(txtFechaSolicitud));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	
	}
	public java.util.Date getTxtFechaIniSolicitud()  {
		java.util.Date d=null;
		try {
			d = (parsearFechaSQL(txtFechaIniSolicitud));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return d;
	
	}
	public java.util.Date parsearFechaSQL(String fechaString) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = sdf.parse(fechaString);
        return utilDate;
}

	
	public int getTxtFtoDniSolicitud() {
		return txtFtoDniSolicitud;
	}

	public int getTxtFtoActSolicitud() {
		return txtFtoActSolicitud;
	}

	public int getTxtFtoEscriSolicitud() {
		return txtFtoEscriSolicitud;
	}

	public int getTxtJustPagoSolicitud() {
		return txtJustPagoSolicitud;
	}

	public int getTxtMemActSolicitud() {
		return txtMemActSolicitud;
	}

	public int getTxtPlanosSolicitud() {
		return txtPlanosSolicitud;
	}

	public int getTxtAutoSolicitud() {
		return txtAutoSolicitud;
	}

	public int getTxtLicObraSolicitud() {
		return txtLicObraSolicitud;
	}

	public int getTxtCertColegSolicitud() {
		return txtCertColegSolicitud;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setVistaPrincipal(VistaPrincipal vistaPrincipal) {
		this.vistaPrincipal = vistaPrincipal;
	}

	public void setVistaInscripcion(VistaInscripcion vistaInscripcion) {
		this.vistaInscripcion = vistaInscripcion;
	}

	public void setVistaModificacion(VistaModificacion vistaModificacion) {
		this.vistaModificacion = vistaModificacion;
	}

	public void setVistaConfiguracion(VistaConfiguracion vistaConfiguracion) {
		this.vistaConfiguracion = vistaConfiguracion;
	}

	public void setModeloIni(ModeloIni modelo) {
		this.modeloIni = modelo;
	}

}
