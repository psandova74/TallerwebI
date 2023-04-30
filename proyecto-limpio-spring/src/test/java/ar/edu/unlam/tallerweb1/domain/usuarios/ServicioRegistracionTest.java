package ar.edu.unlam.tallerweb1.domain.usuarios;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class ServicioRegistracionTest {
	private ServicioRegistracion  servicioRegistracion = new ServicioRegistracionImpl();
	private String correo;
	private String clave;
	
	@Test
	public void alIngresarUnCorreoValidoMeDevuelveVerdader0() {
		Boolean esValido = servicioRegistracion.esValido("patricia.sandoval@gmail.com");
		entoncesMiCorreo(esValido);
	}
	
	@Test
	public void alIngresarCredencialesValidasMePuedoRegistrarExitosamente() {
		dadoQueTengoCredencialesValidas();
		Boolean registroExitoso = cuandoMeRegistro(this.correo, this.clave);
		entoncesEs(registroExitoso);
	}

	private void entoncesEs(Boolean registroExitoso) {
		// TODO Auto-generated method stub
		
	}

	private Boolean cuandoMeRegistro(String correo, String clave) {
		return this.servicioRegistracion.registrarUsuario(correo, clave);
	}

	private void dadoQueTengoCredencialesValidas() {
		this.correo="patricia.sandoval@gmail.com";
		this.clave="1234";
		
	}

	private void entoncesMiCorreo(Boolean esValido) {
		assertThat(esValido).isTrue();
	}
	

}
