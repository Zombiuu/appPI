package Controlador;

import java.awt.Component;
import java.awt.Container;
import java.sql.Date;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Modelo.Modelo;
import Modelo.ModeloIni;
import Vista.VistaConfiguracion;
import Vista.VistaInscripcion;
import Vista.VistaModificacion;
import Vista.VistaPrincipal;

public class Controlador {
	private Modelo modelo;
	private ModeloIni modeloIni;
	private VistaPrincipal vistaPrincipal;
	private VistaInscripcion vistaInscripcion;
	private VistaConfiguracion vistaConfiguracion;
	private VistaModificacion vistaModificacion;
	private int nRegistro;

	private int ultimaSolicitud;
	private int ultimaPersona;

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
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

	public void setModeloIni(ModeloIni modeloIni) {
		this.modeloIni = modeloIni;
	}

	public void abrirVentanaInscripcion() {
		if (vistaInscripcion != null) {
			vistaInscripcion.setVisible(true);
		} else {
			vistaInscripcion = new VistaInscripcion();
		}

		vistaInscripcion.setModelo(modelo);
		vistaInscripcion.setControlador(this);
		modelo.setVistaInscripcion(vistaInscripcion);
		vistaInscripcion.setVisible(true);
	}
	public void abrirVentanaModificacion() {
		
			vistaModificacion = new VistaModificacion();
			vistaModificacion.setModelo(modelo);
			vistaModificacion.setControlador(this);
			modelo.setVistaModificacion(vistaModificacion);
			vistaModificacion.setVisible(true);
		
	}
	public void cerrarVentanaInscripcion() {
		vistaInscripcion.dispose();
		vistaInscripcion = new VistaInscripcion();
		vistaInscripcion.setVisible(false);

	}

	public void cerrarVentanaModificacion() {
		vistaModificacion.dispose();
		vistaModificacion = new VistaModificacion();
		vistaModificacion.setVisible(false);

	}
	public void cerrarVentanaConfiguracion() {
		vistaConfiguracion.dispose();
	}

	public void abrirVentanaConfiguracion() {
		if (vistaConfiguracion != null) {
			vistaConfiguracion.setVisible(true);
		} else {
			vistaConfiguracion = new VistaConfiguracion();
		}
		modeloIni.setVistaConfiguracion(vistaConfiguracion);

		vistaConfiguracion.setModeloIni(modeloIni);
		vistaConfiguracion.setControlador(this);
		mostrarDatos();
		vistaConfiguracion.setVisible(true);
	}

	public int InsertSolicitud() {

		// modelo.insertSolicitud(Integer.parseInt(vistaInscripcion.getTxtDNI()),
		// vistaInscripcion.getTxtDescrAct().getText(),
		// vistaInscripcion.getComboTipo(),
		// vistaInscripcion.getLocalDate());

		// ultimaSolicitud =
		return modelo.insertSolicitud(vistaInscripcion.getFechaSolicitud(), vistaInscripcion.getComboTipo(),
				vistaInscripcion.getTxtDescrAct(), vistaInscripcion.getTxtReferencia(),
				vistaInscripcion.getComboSuelo(), vistaInscripcion.getFechaActividad(), "En proceso",
				vistaInscripcion.getChckbxDNI(), vistaInscripcion.getChckbxFotocopiaImpuestoActividades(),
				vistaInscripcion.getChckbxEscritura(), vistaInscripcion.getChckbxJustificantePago(),
				vistaInscripcion.getChckbxChckbxMemoria(), vistaInscripcion.getChckbxPlanoAcotadoDel(),
				vistaInscripcion.getChckbxLicenciaObra(), vistaInscripcion.getChckbxCertificadoColegio(),
				vistaInscripcion.getChckbxOtrasAutorizaciones());

		// return solicitud;
	}

	public int InsertPersona() {
		if (!vistaInscripcion.getChckbxRequired().isSelected()) {
			return modelo.inertPersona(vistaInscripcion.getTxtNombre(), Integer.parseInt(vistaInscripcion.getTxtDNI()),
					vistaInscripcion.getTxtDireccion(), vistaInscripcion.getTxtMunicipio(), vistaInscripcion.getTxtCp(),
					vistaInscripcion.getTxtFax(), vistaInscripcion.getTxtMovil(), vistaInscripcion.getTxtMail(),
					"Física");
		} else {
			return modelo.inertPersona(vistaInscripcion.getTxtNombre(), Integer.parseInt(vistaInscripcion.getTxtDNI()),
					vistaInscripcion.getTxtDireccion(), vistaInscripcion.getTxtMunicipio(), vistaInscripcion.getTxtCp(),
					vistaInscripcion.getTxtFax(), vistaInscripcion.getTxtMovil(), vistaInscripcion.getTxtMail(),
					"Jurídica");

		}
		
	}

	public int InsertRepresentante() {
		return modelo.inertRepresentante(vistaInscripcion.gettxtNombreApellidosRepre(),
				Integer.parseInt(vistaInscripcion.gettxtDniRepre()), vistaInscripcion.gettxtDireccionRepre(),
				vistaInscripcion.gettxtMunicipioRepre(), vistaInscripcion.gettxtCpRepre(),
				vistaInscripcion.gettxtFaxRepre(), vistaInscripcion.gettxtMovilRepre());
	}

	  public void insertarTablaPersonaRepre(int idPersona, int idRepre){
		  modelo.insertarTablaPersonaRepre(idPersona,idRepre);
		  
		  
	  }
	  
	  public void insertarTablaPersonaSolicitud(int idPersona, int idAct){
		  modelo.insertarTablaPersonaSolicitud(idPersona,idAct,vistaInscripcion.getFechaSolicitud());
		  
		  
		 }
	  
	  
	  // Limpiar tabla
	  public  void reiniciarJTable(javax.swing.JTable Tabla){
	        DefaultTableModel modelo1 = (DefaultTableModel) Tabla.getModel();
	        while(modelo1.getRowCount()>0)modelo1.removeRow(0);
	 
	        TableColumnModel modCol1 = Tabla.getColumnModel();
	        while(modCol1.getColumnCount()>0)modCol1.removeColumn(modCol1.getColumn(0));
	       MostrarTabla();
	    }


	public void MostrarTabla() {
		modelo.ShowJTable();
	}

	public void guardarIni() {
		modeloIni.guardar(vistaConfiguracion.getTxtBaseDatos(), vistaConfiguracion.getTxtUsuario(),
				vistaConfiguracion.getTxtClave());
		vistaConfiguracion.dispose();
	}

	public void mostrarDatos() {
		modeloIni.mostrar();
	}
	
	public void recogerRegistroCambio(){
		nRegistro=Integer.parseInt(String.valueOf(vistaPrincipal.getTablaInfo2().getValueAt(vistaPrincipal.getTablaInfo2().getSelectedRow(),0)));
		modelo.datosModificacion(nRegistro);
		}

	public void mostrarDatosAdicionales(){
		
		nRegistro=Integer.parseInt(String.valueOf(vistaPrincipal.getTablaInfo2().getValueAt(vistaPrincipal.getTablaInfo2().getSelectedRow(),0)));

		modelo.datosAdicionales(nRegistro);
		
	}

	public void enableComponents(Container container, boolean enable) {
		Component[] components = container.getComponents();
		for (Component component : components) {
			component.setEnabled(enable);
			if (component instanceof Container) {
				enableComponents((Container) component, enable);
			}
		}
	}

}
