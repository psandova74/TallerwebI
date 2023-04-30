package ar.edu.unlam.tallerweb1.delivery;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.domain.usuarios.*;


public class ControladorRegistracionTest {
	private static final String CORREO = "patricia.sandoval@gmail.com";
	private static final String CLAVE = "1234";
	private ServicioRegistracion servicioRegistracion;
	private ControladorRegistracion controladorRegistracion;
	private DatosRegistracion datosRegistracion;
	
	@Before
	public void init() {
		//this.servicioRegistracion =new ServicioRegistracionImpl();
		
		this.datosRegistracion = new DatosRegistracion(CORREO,CLAVE);
		this.servicioRegistracion =mock(ServicioRegistracionImpl.class);
		this.controladorRegistracion = new ControladorRegistracion(this.servicioRegistracion);
		
	}
	
	@Test
	public void alIngresarARegistrarmeMeMuestraLaPantallaDeRegistro() {
		dadoQueNoExisteElUsuario();
		ModelAndView mav = cuandoMeQuieroRegistrar();
		entoncesMeLllevaALaPantallaDeRegistracion(mav);
	}
	

	@Test
	public void alIngresarCredencialesCorrectasDeUnUsuarioQueNoExisteMeRegistraYLlevaAlLogin() {
		dadoQueNoExisteElUsuario();
		ModelAndView mav = cuandoMeRegistro(this.datosRegistracion);
		entoncesElRegistroEsExitoso(mav);	
	}
	
	@Test
	public void alIngresarCredencialesInvalidasNoMePermiteRegistrarme() {
		dadoQueNoExisteElUsuario();
		ModelAndView mav = cuandoMeRegistro(this.datosRegistracion);
		entoncesElRegistroFalla(mav);
	}
	
	
	private ModelAndView cuandoMeQuieroRegistrar() {
		return ControladorRegistracion.registrarme();
	}
	
	private void entoncesMeLllevaALaPantallaDeRegistracion(ModelAndView mav) {
		assertThat(mav.getViewName()).isEqualTo("registro-usuario");
		
	}
	
	private void entoncesElRegistroFalla(ModelAndView mav) {
		assertThat(mav.getViewName()).isEqualTo("registro-usuario");
		assertThat(mav.getModel().get("msg")).isEqualTo("Registro fallido");	
	}
	
	private void dadoQueNoExisteElUsuario() {
		when(this.servicioRegistracion.registrarUsuario(this.datosRegistracion.getCorreo(), this.datosRegistracion.getClave())).thenReturn(true);
	}

	private ModelAndView cuandoMeRegistro(DatosRegistracion datosRegistracion) {
		return controladorRegistracion.RegistrarUsuario(datosRegistracion.getCorreo(), datosRegistracion.getClave());
	}
	private void entoncesElRegistroEsExitoso(ModelAndView mav) {
		 assertThat(mav.getViewName()).isEqualTo("login");
		 assertThat(mav.getModel().get("msg")).isEqualTo("Registro exitoso");	
	}
	
}
