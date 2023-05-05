package ar.edu.unlam.tallerweb1.delivery;
import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class EjemploTDDTest {
	@Test
	public void deberiaSerDevolverDEBILCuandoLaContraseniaEsVacia() {
		EjemploTDD ejemploTDD = new EjemploTDD();
		String nivelDeSeguridad =ejemploTDD.EvaluarContrasenia("");
		assertThat(nivelDeSeguridad).isEqualTo("DEBIL");	
	}
	
	@Test
	public void deberiaSerDevolverMEDIANACuandoLaContraseniaTiene8Caracteres() {
		EjemploTDD ejemploTDD = new EjemploTDD();
		String nivelDeSeguridad =ejemploTDD.EvaluarContrasenia("12345678");
		assertThat(nivelDeSeguridad).isEqualTo("MEDIANA");	
	}
	
	@Test
	public void deberiaSerDevolverMEDIANACuandoLaContraseniaTieneAlmenos2Letrasseparadas() {
		EjemploTDD ejemploTDD = new EjemploTDD();
		String nivelDeSeguridad =ejemploTDD.EvaluarContrasenia("11A23A");
		assertThat(nivelDeSeguridad).isEqualTo("MEDIANA");	
	}
	
	@Test
	public void deberiaSerDevolverMEDIANACuandoLaContraseniaTieneAlmenos2LetrasYAlMenos8Caracteres() {
		EjemploTDD ejemploTDD = new EjemploTDD();
		String nivelDeSeguridad =ejemploTDD.EvaluarContrasenia("A3345a6");
		assertThat(nivelDeSeguridad).isEqualTo("MEDIANA");	
	}
	
	@Test
	public void deberiaSerDevolverFUERTECuandoLaContraseniaTieneAlmenos2Letras() {
		EjemploTDD ejemploTDD = new EjemploTDD();
		String nivelDeSeguridad =ejemploTDD.EvaluarContrasenia("1v345b78");
		assertThat(nivelDeSeguridad).isEqualTo("FUERTE");	
	}
	
	@Test
	public void deberiaSerDevolverDEBILCuandoLaContraseniaEsNull() {
		EjemploTDD ejemploTDD = new EjemploTDD();
		String nivelDeSeguridad =ejemploTDD.EvaluarContrasenia(null);
		assertThat(nivelDeSeguridad).isEqualTo("DEBIL");	
	}
	
}
