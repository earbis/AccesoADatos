package tema2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConsultaEmpleadosMysql {
public static void main(String[] args) {
	

	try {
		//El Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
	
		//Conectar con la base de datos
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/prueba", "Earbis", "pass.admin");
		
		//Consulta
		Statement sentencia = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		String sql = "SELECT * FROM empleados";
		ResultSet result = sentencia.executeQuery(sql);
		//ver la consulta
		while(result.next()) {
			System.out.printf("%d, %s, %s, %d, %s, %f, %f, %n",result.getInt(1),result.getString(2),result.getString(3),result.getInt(4),result.getString(5),result.getFloat(6),result.getFloat(7));	
		}
		/*
		//result.afterLast();
		while(result.previous()) {
			System.out.printf("%d, %s, %s, %d, %s, %f, %f, %n",result.getInt(1),result.getString(2),result.getString(3),result.getInt(4),result.getString(5),result.getFloat(6),result.getFloat(7));	
		}
		
		*/
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
