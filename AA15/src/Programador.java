import java.time.LocalDate;

public class Programador {
	
	private int id_usuario;
	private String nombre_usuario;
	private LocalDate fechaLogin;
	
	public Programador(int id_usuario, String nombre_usuario, LocalDate fechaLogin) {
		this.id_usuario = id_usuario;
		this.nombre_usuario = nombre_usuario;
		this.fechaLogin = fechaLogin;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public LocalDate getFechaLogin() {
		return fechaLogin;
	}

	public void setFechaLogin(LocalDate fechaLogin) {
		this.fechaLogin = fechaLogin;
	}

	@Override
	public String toString() {
		return "[id_usuario=" + id_usuario + ", nombre_usuario=" + nombre_usuario + ", fechaLogin="
				+ fechaLogin + "]";
	}

	
	
	

}
