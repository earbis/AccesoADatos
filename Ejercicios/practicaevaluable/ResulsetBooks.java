package practicaevaluable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResulsetBooks {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/library", "Earbis","pass.admin");
			Statement sentencia = conexion.createStatement();
			ResultSet rs = sentencia.executeQuery("SELECT * FROM books");
			ResultSetMetaData rsmd = rs.getMetaData();
			int nColumnas = rsmd.getColumnCount();
			String nula;
			System.out.printf("Numero de columnas recuperadas: %d %n", nColumnas);
			for (int i = 1; i < nColumnas; i++) {
				System.out.printf("Columna %d: %n",i);
				System.out.printf("Nombre: %s %n	Tipo: %s %n", rsmd.getColumnName(i), rsmd.getColumnTypeName(i));
				if(rsmd.isNullable(i) == 0) nula = "NO";
				else nula = "SI";
				System.out.printf("Puede ser nula:? %s %n", nula);
				System.out.printf("Maximo ancho de la column: %d %n", rsmd.getColumnDisplaySize(i));
			}
			sentencia.close();
			rs.close();
			conexion.close();
			
		} catch (SQLException|ClassNotFoundException e) {
			// TODO: handle exception
		}
	}
}
