package tema2;

import java.util.Iterator;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Consulta2 {
	static String bdper = "DBPersonas.yap";
	public static void main(String[] args) {
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), bdper);
		Persona per = new Persona("Juan",null);
		ObjectSet<Persona> result = db.queryByExample(per);
		if (result.size() ==0) {
			System.out.println("No existen Juan...");
		} else {
			for (Iterator<Persona> iterator = result.iterator(); iterator.hasNext();) {
				Persona persona = iterator.next();
				persona.setLoc("Toledo");
				db.store(persona);
				System.out.printf("Nombre: %s, Nueva Ciudad: %s %n", persona.getNombre(), persona.getLoc());
				
			}
			
		}
		db.close();
	}
}
