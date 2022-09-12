
public class Provincia {
	
	private String nombre;
	private int codigo;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Provincia: " +nombre+ " - Codigo de Provincia: " +codigo+ " ||" ;
	}

	public Provincia(String nombre, int codigo) {
		this.nombre = nombre;
		this.codigo = codigo;
	}
	
	
	
	
}
