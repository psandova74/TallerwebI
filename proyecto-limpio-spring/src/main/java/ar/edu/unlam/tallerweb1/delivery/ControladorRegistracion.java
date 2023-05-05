package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioRegistracion;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

public class ControladorRegistracion {
	private ServicioRegistracion servicioRegistracion;
	
	public ControladorRegistracion(ServicioRegistracion servicioRegistracion) {
		this.servicioRegistracion=servicioRegistracion;
	}

	public static ModelAndView registrarme() {
		return new ModelAndView("registro-usuario");
	}
	
	public  ModelAndView RegistrarUsuario(String correo, String clave) {
		ModelMap model = new ModelMap();
		String viewName = "";
		
		if ( this.servicioRegistracion.esValido(correo) && this.servicioRegistracion.registrarUsuario(correo, clave)){
			model.put("msg", "Registro exitoso");
			viewName = "login";
		} else {
			model.put("msg", "Registro fallido");
			viewName = "registro-usuario";
		}
		return new ModelAndView(viewName,model);
	}

}
