package ar.edu.unlam.tallerweb1.delivery;
import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class EjemploTDDTest {
	@Test
	public void deberiaSerDevolverDEBILCuandoLaContraseniaEsVacia() {
		EjemploTDD ejemploTDD = new EjemploTDD();
		String nivelDeSeguridad =ejemploTDD.EvaluarContrasenia();
		assertThat(nivelDeSeguridad).isEqualTo("");	
	}
	
	
}
