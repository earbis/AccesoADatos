package practicaevaluable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class SentenciasDML {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/library", "Earbis","pass.admin");
		Statement sentencia = conexion.createStatement();
		ArrayList<Boolean> lista = new ArrayList<>();
		lista.add( sentencia.execute("INSERT INTO publishers(publisher_name, publisher_inauguration, publisher_city) VALUES ('San Ova','1985-03-25','Moscu');"));
		lista.add( sentencia.execute("UPDATE publishers SET publisher_city='Florida' WHERE publisher_city='Nueva York';"));
			for (Iterator<Boolean> iterator = lista.iterator(); iterator.hasNext();) {
				Boolean valor = iterator.next();
				if(valor) {
					ResultSet rs =sentencia.getResultSet();
					while (rs.next()) {
						System.out.printf("%d, %s, %s %n", rs.getInt(1),rs.getString(2), rs.getString(3));
					}
					rs.close();
				}else {
					int f = sentencia.getUpdateCount();
					System.out.printf("Filas afectadas: %d %n", f);
				}
			}
		sentencia.close();
		conexion.close();
		
	}
}
