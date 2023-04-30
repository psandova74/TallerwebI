package ar.edu.unlam.tallerweb1.delivery;
import static org.assertj.core.api.Assertions.*;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;


public class ControladorLoginTest {
	 @Test
	    public void test(){
	        ControladorLogin controlador = new ControladorLogin(null);

	        ModelAndView  mod= controlador.probandoJSP();

	        assertThat(mod.getViewName()).isEqualTo("probandojsp");
	    }
}
