package ar.edu.unlam.tallerweb1.delivery;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import static org.assertj.core.api.Assertions.*;

public class ControladorLoginTest {
	 @Test
	    public void test(){
	        ControladorLogin controlador = new ControladorLogin(null);

	        ModelAndView = controlador.probandoJSP();

	        assertThat(modelAndView.getViewName()).isEqualTo("probandojsp");
	    }
}
