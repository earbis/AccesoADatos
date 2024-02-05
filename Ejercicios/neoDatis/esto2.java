package neoDatis;
import org.neodatis.odb.ODB;
	import org.neodatis.odb.ODBFactory;
	import org.neodatis.odb.Objects;
public class esto2 {
	

		public static void main(String[] args) {

			Paises p1 = new Paises(1, "Spain");
			Paises p2= new Paises(2, "USA");
			Jugador2  j1 = new Jugador2("Mario","voleibol","Madrid", 14, p1.getNombre());
			Jugador2 j2 = new Jugador2("Miguel","tenis","Madrid", 15, p1.getNombre());
			Jugador2 j3= new Jugador2("Maria","baloncesto","Guadalajara", 15,p1.getNombre() );
			Jugador2 j4 = new Jugador2("Alicia","tenis","Madrid", 14, p2.getNombre());
			
			ODB odb = ODBFactory.open("neodatis2.test");
			
			odb.store(j1);
			odb.store(j2);
			odb.store(j3);
			odb.store(j4);
			
			
			Objects<Jugador2> objects = odb.getObjects(Jugador2.class);
			System.out.printf("%d Jugador: %n", objects.size());
			
			int i = 1;
			while(objects.hasNext()) {
				Jugador2 jug = objects.next();
				System.out.printf("%d: %s, %s, %s, %d, %s %n", i++, jug.getNombre(), jug.getDeporte(), jug.getCiudad(), jug.getEdad(), jug.getPais().toString());
				
			}odb.close();
		}
		
		
		/**
		 * Esto es lo que hace
		 * @param id
		 * @
		 */
		void nota(){
			int id = 2;
			System.out.println("Prueba");
		}
	}

