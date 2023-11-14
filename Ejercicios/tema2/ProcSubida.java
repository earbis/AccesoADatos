package tema2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ProcSubida {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/prueba", "Earbis","pass.admin");
			// recuperar parametros de main
			String dep = args[0];
			String subida = args[1];
			
			//construir orden de llamada
			String sql = "{call subida (?,?) }";
			
			//Preparar la llamada 
			CallableStatement llamada = conexion.prepareCall(sql);
			
			//Dar valor a los argumentos
			llamada.setInt(1, Integer.parseInt(dep));
			llamada.setFloat(2, Float.parseFloat(subida));
			
			//Ejecutar el procedimiento
			llamada.executeUpdate();
			System.out.println("Subida realizada..."	);
			
			llamada.close();
			conexion.close();
		} catch (ClassNotFoundException|SQLException e) {
			e.getMessage();
		}
	}
}
