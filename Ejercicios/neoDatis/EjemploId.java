package neoDatis;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.OID;
import org.neodatis.odb.core.oid.OIDFactory;

public class EjemploId {
	public static void main(String[] args) {
		ODB odb = ODBFactory.open("NEODATIS.TEST");
		OID oid = OIDFactory.buildObjectOID(3);
		Jugador jug = (Jugador) odb.getObjectFromId(oid);
		System.out.printf( "%s, %s, %d %n", jug.getNombre(), jug.getCiudad(), jug.getEdad());
		odb.close();
	}
} 	
