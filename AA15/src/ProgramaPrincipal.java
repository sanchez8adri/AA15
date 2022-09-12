import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class ProgramaPrincipal implements GeneradorSalida{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		URL url = new URL("https://public.opendatasoft.com/api/records/1.0/search/?dataset=provincias-espanolas&q=&rows=0&sort=-provincia&facet=ccaa&facet=provincia");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		GeneradorSalida gs = new ProgramaPrincipal();
		
		if(conn.getResponseCode()==200) {
			
			Programador programador = new Programador(1, "Adrian Sanchez", LocalDate.now());
			
			Scanner sn = new Scanner(url.openStream());
			StringBuilder str = new StringBuilder();
			
			while(sn.hasNext()) {
				str.append(sn.nextLine());
			}
			
			JSONObject json = new JSONObject(str.toString());
			JSONArray jsonArray = new JSONArray(json.get("facet_groups").toString());
			
			List<Capital> listaCapitales = new ArrayList<>();
			
			JSONObject jsonProvincias = new JSONObject(jsonArray.get(1).toString());
			JSONArray jsonArrayProvincias = new JSONArray(jsonProvincias.get("facets").toString());
			
			for(int i=0; i<jsonArrayProvincias.length();i++) {
				JSONObject jsonCapital = new JSONObject(jsonArrayProvincias.get(i).toString());
				Capital capital = new Capital(jsonCapital.get("name").toString(), i, jsonCapital.getString("path"), programador);
				listaCapitales.add(capital);
			}

			gs.GenerarTXT(listaCapitales);
			gs.GenerarJenkins(listaCapitales);
			
			System.out.println("Lista de capitales almacenadas con éxito.");
			
		}else {
			System.out.println("Conexión expirada");
		}

	}

	@Override
	public void GenerarTXT(List<Capital> listaCapitales) {
		
		File file = new File("capitales.txt");
		FileWriter fw;
		try {
			fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			
			for(Capital capital : listaCapitales) {
				bw.write(capital.toString()+"\n");
			}
			
			bw.close();
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void GenerarJenkins(List<Capital> listaCapitales) throws IOException {


		FileWriter fw = new FileWriter(new File("Jenkinsfile"));
		BufferedWriter bw = new BufferedWriter(fw);
		
		StringBuilder Jenkins = new StringBuilder();
        Jenkins.append("import java.time.LocalDate\r\n");
        Jenkins.append("pipeline{\r\n");
        Jenkins.append("agent any \r\n");
        Jenkins.append("stages{ \r\n");
        Jenkins.append("stage('Main'){ \r\n");
        Jenkins.append("steps{ \r\n");
        Jenkins.append("script{ \r\n");
        Jenkins.append("println LocalDate.now() \r\n");
        for(Capital capital : listaCapitales) {
        	Jenkins.append("println '"+"Provincia " +capital.getNombre() + " - Codigo Provincia: " +capital.getCodigo()+ " - Capital: " +capital.getNombreCapital()+"'   \r\n");
        }
        Jenkins.append("} \r\n");
        Jenkins.append("} \r\n");
        Jenkins.append("} \r\n");
        Jenkins.append("} \r\n");
        Jenkins.append("} \r\n");

        bw.write(Jenkins.toString());
		bw.close();
		fw.close();
		
	}

}
