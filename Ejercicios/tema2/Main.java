package tema2;



import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public class Main {
	static String bdper = "DBPersonas.yap";
	public static void main(String[] args) {
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), bdper);
		Persona p1 = new Persona("Juan","guadalajara");
		Persona p2 = new Persona("Ana","Madrid");
		Persona p3 = new Persona("Luis","Granada");
		Persona p4 = new Persona("Pedro","Madrid");
		db.store(p1);
		db.store(p2);
		db.store(p3);
		db.store(p4);
		db.close();
		
	}
}
