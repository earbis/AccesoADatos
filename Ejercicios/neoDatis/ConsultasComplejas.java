package neoDatis;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

public class ConsultasComplejas {
	public static void main(String[] args) {
		
	
	 ODB odb = ODBFactory.open("neodatis.test");
	
	 
	 Values valores = odb.getValues(new ValuesCriteriaQuery(Jugador.class).field("nombre").field("ciudad"));
    while (valores.hasNext()) {
		ObjectValues objectValues = (ObjectValues) valores.next();
		System.out.printf("%s, Ciudad: %s %n",objectValues.getByAlias("nombre"),objectValues.getByIndex(1));	
	}
    
    
    
    Values val = odb.getValues(new ValuesCriteriaQuery(Jugador.class).sum("edad"));
    ObjectValues ov = val.nextValues();
    BigDecimal value = (BigDecimal) ov.getByAlias("edad");
    System.out.printf("Suma de edad: %d %n",value.longValue());	
   
	
	
	Values groupby = odb.getValues(new ValuesCriteriaQuery(Jugador.class).field("ciudad").count("nombre").groupBy("ciudad"));
	while (groupby.hasNext()) {
		ObjectValues objectValues = (ObjectValues) groupby.next();
		System.out.printf("Ciudad: %s, Iteraciones: %s %n",objectValues.getByAlias("ciudad"),objectValues.getByIndex(1));	
	}
	
	
	
	countAvgPais();
	
	}
	
	
	
	
	
	
	private static void countAvgPais() {
		ODB odb = ODBFactory.open("neodatis2.test");
		System.out.println("Numero de jugadores por pais, "+ "max de edad y media de edad: ");
		try {
			
			Values groupby = odb.getValues(new ValuesCriteriaQuery(Jugador2.class, Where.isNotNull("pais")).field(("pais")).count("jugador.nombre").max("edad").sum("edad").groupBy("pais"));
			if (groupby.size() == 0) {
				System.out.println("La consulta no devuelve datos. ");
			}else
			{
				while (groupby.hasNext()) {
					ObjectValues objectValues = (ObjectValues) groupby.next();
					float media = ((BigDecimal) objectValues.getByIndex(0)).floatValue()/((BigInteger) objectValues.getByIndex(1)).floatValue();
					System.out.printf("Pais: %-8s Num jugadores: %d, Edad Maxima: %d, Suma de Edad: %d, Edad media: %.2f %n",
				            objectValues.getByAlias("pais"),
				            objectValues.getByIndex(1),
				            objectValues.getByIndex(2),
				            objectValues.getByIndex(3),
				            media
				    );
					odb.close();
				}
			}
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
			Values groupby = odb.getValues(new ValuesCriteriaQuery(Jugador2.class, Where.isNotNull("pais")).field(("pais")).count("nombre").max("edad").sum("edad").groupBy("pais"));
			while (groupby.hasNext()) {
				ObjectValues objectValues = (ObjectValues) groupby.next();
				float media;
				BigDecimal sumaedad = (BigDecimal) objectValues.getByIndex(0);
				BigInteger cuenta = (BigInteger) objectValues.getByIndex(1);
				media = sumaedad.intValue() / cuenta.intValue();
				System.out.printf("Pais: %-8s Num jugadores: %d, Edad Maxima: %d, Suma de Edad: %d, Edad media: %.2f %n",
			            objectValues.getByAlias("pais"),
			            cuenta,
			            objectValues.getByIndex(2),
			            objectValues.getByIndex(3),
			            media
			    );
			}
		}
	}
}
