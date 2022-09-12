import java.io.IOException;
import java.util.List;

public interface GeneradorSalida {

	void GenerarTXT(List<Capital> listaCapitales);
	
	void GenerarJenkins(List<Capital> listaCapitales) throws IOException;
}
