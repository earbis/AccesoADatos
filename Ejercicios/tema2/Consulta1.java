package tema2;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Consulta1 {
	static String bdper = "DBPersonas.yap";
	public static void main(String[] args) {
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), bdper);
		Persona per = new Persona("Juan",null);
		ObjectSet<Persona> result = db.queryByExample(per);
		if (result.size() ==0) {
			System.out.println("No existen Registros de Personas...");
		} else {
			System.out.printf("Numero de registros: %d %n", result.size());
			while(result.hasNext()) {
				Persona p = result.next();
				System.out.printf("Nombre: %s, Ciudad: %s %n", p.getNombre(), p.getLoc());	
			}
		}
		db.close();
	}
}
