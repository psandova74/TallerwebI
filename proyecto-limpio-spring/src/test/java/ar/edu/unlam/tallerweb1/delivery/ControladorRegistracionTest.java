package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioRegistracion;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioRegistracionImpl;
import org.springframework.web.servlet.ModelAndView;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;



public class ControladorRegistracionTest {
	private static final String CORREO = "patricia.sandoval@gmail.com";
	private static final String CORREO_INVALIDO = "patricia";
	private static final String CLAVE = "asdf";
	private ServicioRegistracion servicioRegistracion;
	private ControladorRegistracion controladorRegistracion;
	private DatosRegistracion datosRegistracion;
	private DatosRegistracion datosRegistracionIncorrecta;
	
	@Before
	public void init() {
		this.datosRegistracion = new DatosRegistracion(CORREO,CLAVE);
		this.datosRegistracionIncorrecta = new DatosRegistracion(CORREO_INVALIDO,CLAVE);
		//this.servicioRegistracion = mock(ServicioRegistracionImpl.class);
		this.servicioRegistracion =  new ServicioRegistracionImpl();
		this.controladorRegistracion = new ControladorRegistracion(this.servicioRegistracion);	
	}
	
	@Test
	public void alIngresarARegistrarmeMeMuestraLaPantallaDeRegistro() {
		dadoQueNoExisteElUsuario(this.datosRegistracion, null);
		ModelAndView mav = cuandoMeQuieroRegistrar();
		entoncesMeLllevaALaPantallaDeRegistracion(mav);
	}
	

	@Test
	public void alIngresarCredencialesCorrectasDeUnUsuarioQueNoExisteMeRegistraYLlevaAlLogin() {
		dadoQueNoExisteElUsuario(this.datosRegistracion,true);
		ModelAndView mav = cuandoMeRegistro(this.datosRegistracion);
		entoncesElRegistroEsExitoso(mav);	
	}
	
	@Test
	public void alIngresarCredencialesInvalidasNoMePermiteRegistrarme() {
		dadoQueNoExisteElUsuario(this.datosRegistracionIncorrecta,false);
		ModelAndView mav = cuandoMeRegistro(this.datosRegistracionIncorrecta);
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
	
	private void dadoQueNoExisteElUsuario(DatosRegistracion datosRegistracion, Boolean retorno) {
		//when(this.servicioRegistracion.esValido(datosRegistracion.getCorreo())).thenReturn(retorno);
		//when(this.servicioRegistracion.registrarUsuario(this.datosRegistracion.getCorreo(), this.datosRegistracion.getClave())).thenReturn(retorno);
		this.servicioRegistracion.esValido(datosRegistracion.getCorreo());
		this.servicioRegistracion.registrarUsuario(this.datosRegistracion.getCorreo(), this.datosRegistracion.getClave());
		
	}

	
	private ModelAndView cuandoMeRegistro(DatosRegistracion datosRegistracion) {
		return controladorRegistracion.RegistrarUsuario(datosRegistracion.getCorreo(), datosRegistracion.getClave());
	}
	
	private void entoncesElRegistroEsExitoso(ModelAndView mav) {
		 assertThat(mav.getViewName()).isEqualTo("login");
		 assertThat(mav.getModel().get("msg")).isEqualTo("Registro exitoso");	
	}
	
}
