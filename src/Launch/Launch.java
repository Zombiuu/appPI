package Launch;

import Controlador.Controlador;
import Modelo.Modelo;
import Modelo.ModeloIni;
import Vista.VistaPrincipal;

public class Launch {
	/**
	 * Launch the application.
	 */ 
	public static void main(String[] args) {
		VistaPrincipal vistaPrincipal = new VistaPrincipal();
		ModeloIni modeloIni = new ModeloIni();
		Modelo modelo = new Modelo();

		
		Controlador controlador = new Controlador();

		controlador.setModelo(modelo);
		controlador.setModeloIni(modeloIni);
		controlador.setVistaPrincipal(vistaPrincipal);


		vistaPrincipal.setControlador(controlador);
		vistaPrincipal.setModelo(modelo);

		modelo.setVistaPrincipal(vistaPrincipal);
		modelo.setModeloIni(modeloIni);
		
		modeloIni.setModelo(modelo);
		
		vistaPrincipal.onLoadTable();
		vistaPrincipal.setVisible(true);

	}
}
