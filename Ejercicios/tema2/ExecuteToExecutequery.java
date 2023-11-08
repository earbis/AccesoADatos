package tema2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class ExecuteToExecutequery {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/prueba", "Earbis","pass.admin");
		Statement sentencia = conexion.createStatement();
		ArrayList<ResultSet> lista = new ArrayList<>();
		lista.add( sentencia.executeQuery("SELECT * FROM departamentos"));
			for (Iterator<ResultSet> iterator = lista.iterator(); iterator.hasNext();) {
					ResultSet rs =sentencia.getResultSet();
					while (rs.next()) {
						System.out.printf("%d, %s, %s %n", rs.getInt(1),rs.getString(2), rs.getString(3));
					}
					
				
			}
		sentencia.close();
		conexion.close();
		
	}
}
