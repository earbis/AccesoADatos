package neoDatis;
import org.neodatis.odb.ODB;
	import org.neodatis.odb.ODBFactory;
	import org.neodatis.odb.Objects;
public class esto {
	

		public static void main(String[] args) {

			Paises p1 = new Paises(1, "Spain");
			Paises p2= new Paises(2, "USA");
			Jugador j1 = new Jugador("Mario","voleibol","Madrid", 14, p1);
			Jugador j2 = new Jugador("Miguel","tenis","Madrid", 15, p1);
			Jugador j3= new Jugador("Maria","baloncesto","Guadalajara", 15,p1 );
			Jugador j4 = new Jugador("Alicia","tenis","Madrid", 14, p2);
			
			ODB odb = ODBFactory.open("neodatis.test");
			
			odb.store(j1);
			odb.store(j2);
			odb.store(j3);
			odb.store(j4);
			
			
			Objects<Jugador> objects = odb.getObjects(Jugador.class);
			System.out.printf("%d Jugador: %n", objects.size());
			
			int i = 1;
			while(objects.hasNext()) {
				Jugador jug = objects.next();
				System.out.printf("%d: %s, %s, %s, %d, %s %n", i++, jug.getNombre(), jug.getDeporte(), jug.getCiudad(), jug.getEdad(), jug.getPais().toString());
				
			}odb.close();
		}
	}

