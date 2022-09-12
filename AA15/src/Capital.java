
public class Capital extends Provincia{
	
	private String nombreCapital;
	private Programador programador;


	public Capital(String nombre, int codigo,  String nombreCapital, Programador programador) {
		super(nombre, codigo);
		this.nombreCapital = nombreCapital;
		this.programador = programador;
	}


	public String getNombreCapital() {
		return nombreCapital;
	}


	public void setNombreCapital(String nombreCapital) {
		this.nombreCapital = nombreCapital;
	}


	public Programador getProgramador() {
		return programador;
	}


	public void setProgramador(Programador programador) {
		this.programador = programador;
	}


	@Override
	public String toString() {
		return "Provincia: " +super.getNombre()+ " - Codigo de Provincia: " +super.getCodigo()+ " || " +"Capital: " +nombreCapital+ " - Programador: " +programador;
	}

	
	

}
