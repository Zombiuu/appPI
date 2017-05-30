package Modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Vista.VistaConfiguracion;
import Vista.VistaInscripcion;
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
	private ModeloIni modeloIni;

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
		int last_inserted_id=-1;
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
	             if(rs.next()){
	            	 
	            	 
	            	 
	              last_inserted_id = rs.getInt(1);
	                 
	              System.out.println(last_inserted_id);
	              
	            }

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
		 return last_inserted_id;
	}
	
	

	public int inertPersona(String nombre, int DNI, String direccion, String municipio, String cp,String fijo,
			String movil, String mail, String tipo) {
		Connection con = getConnection();
		PreparedStatement ps;
		int r = 0;
		int last_inserted_id=-1;
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
	             if(rs.next()){
	            	 
	            	 
	            	 
	              last_inserted_id = rs.getInt(1);
	                 
	              System.out.println(last_inserted_id);
	              
	            }

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
	
	
	public int inertRepresentante(String nombre, int DNI, String direccion, String municipio,
			String cp, String fax, String movil) {
		Connection con = getConnection();
		PreparedStatement ps;
		int r = 0;
		int last_inserted_id=-1;

		String query="INSERT INTO `representante`(`nif_nie`, `nombre`, `direccion`, `municipio`, `cp`, `tlf_fijo`, `tlf_movil`) VALUES (?,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, DNI);
			ps.setString(2,nombre );
			ps.setString(3, direccion);
			ps.setString(4, municipio);
			ps.setString(5, cp);
			ps.setString(6, fax);
			ps.setString(7, movil);
			
			
			
			
		
			if (ps.executeUpdate() == 1) {
				 ResultSet rs = ps.getGeneratedKeys();
	             if(rs.next()){
	            	 
	              last_inserted_id = rs.getInt(1);
	                 
	                 System.out.println(last_inserted_id);
	              
	            }
				DefaultTableModel model = (DefaultTableModel) vistaPrincipal.getTablaInfo();
				model.setRowCount(0);
				ShowJTable();
				JOptionPane.showMessageDialog(null, "Información almacenada satisfactoriamente");
				vistaInscripcion.dispose();
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
		  String query = "INSERT INTO `representa` ( `persona`, `representante`) VALUES ( ?,? );";
		  PreparedStatement ps;
		  
		  try {
		  ps = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
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
	
	public void insertarTablaPersonaSolicitud(int idPersona, int idAct,String fechaSolicitud) {
		  Connection con = getConnection();
		  String query = "INSERT INTO `titularidad` (`persona`, `solicitud`, `fecha_inicio`, `fecha_fin`) VALUES ( ?,?,?,? );";
		  PreparedStatement ps;
		  
		  try {
		  ps = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
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


	/*
	 * Mostrar Tabla
	 */

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

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setVistaPrincipal(VistaPrincipal vistaPrincipal) {
		this.vistaPrincipal = vistaPrincipal;
	}

	public void setVistaInscripcion(VistaInscripcion vistaInscripcion) {
		this.vistaInscripcion = vistaInscripcion;
	}

	public void setVistaConfiguracion(VistaConfiguracion vistaConfiguracion) {
		this.vistaConfiguracion = vistaConfiguracion;
	}

	public void setModeloIni(ModeloIni modelo) {
		this.modeloIni = modelo;
	}

}
