package ar.edu.unlam.tallerweb1.domain.usuarios;

public class ServicioRegistracionGoogleImpl implements ServicioRegistracion{
	@Override
	public Boolean esValido(String correo) {
		return (correo.endsWith(".com") && correo.contains("@"));
	}

	@Override
	public Boolean registrarUsuario(String correo, String clave) {
		return true;
	}

}
