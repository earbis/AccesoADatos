package neoDatis;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class ConsSimples {

    public static void main(String[] args) {
        ODB odb = ODBFactory.open("neodatis.test");

            IQuery query = new CriteriaQuery(Jugador.class, Where.equal("deporte", "tenis"));
            query.orderByAsc("nombre");
            int i = 1;
			

            Objects<Jugador> objects = odb.getObjects(query);
            
            while(objects.hasNext()) {
				Jugador jug = objects.next();
				System.out.printf("%d: %s, %s, %s %n", i++, jug.getNombre(), jug.getDeporte(), jug.getCiudad(), jug.getEdad());
				
			}
            try {
				Jugador jug = (Jugador) odb.getObjects(query).getFirst();
				
            } catch (Exception e) {
				e.getMessage();
			}
            
            
            // Process the retrieved objects
           
        
    }
}
