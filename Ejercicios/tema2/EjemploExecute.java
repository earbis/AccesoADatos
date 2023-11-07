package tema2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class EjemploExecute {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/prueba", "Earbis","pass.admin");
		Statement sentencia = conexion.createStatement();
		ArrayList<Boolean> lista = new ArrayList<>();
		lista.add( sentencia.execute("INSERT INTO departamentos( `dnombre`, `loc`) VALUES ('RRHH','Madrid')"));
		lista.add( sentencia.execute("UPDATE `departamentos` SET `loc`='Madrid' "));
		lista.add( sentencia.execute("DELETE FROM departamentos WHERE dep_no = 2"));
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
