package practicaevaluable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
public static void main(String[] args) {
	try {
		//El Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
	
		//Conectar con la base de datos
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/library", "Earbis", "pass.admin");
		
		//Consulta
		Statement sentencia = conexion.createStatement();
		String sql = "SELECT * FROM books";
		ResultSet result = sentencia.executeQuery(sql);
		
		//ver la consulta
		while(result.next()) {
			System.out.printf("%d, %s, %s %n",result.getInt(1),result.getString(2),result.getString(3));	
		}
		result.close();
		sentencia.close();
		conexion.close();
	} catch (ClassNotFoundException cnfe) {
		cnfe.getMessage();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
}
