package tema2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class ProcDatos {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/prueba", "Earbis","pass.admin");
			// recuperar parametros de main
			String dep = args[0];
			
			//construir orden de llamada
			String sql = "{call datos_dep (?,?,?) }";
			
			//Preparar la llamada 
			CallableStatement llamada = conexion.prepareCall(sql);
			
			//Dar valor a los argumentos
			llamada.setInt(1, Integer.parseInt(dep));
			//parametro salida
			llamada.registerOutParameter(2, Types.VARCHAR);
			llamada.registerOutParameter(3, Types.VARCHAR);
			
			//Ejecutar el procedimiento
			llamada.executeUpdate();
			System.out.printf("Nombre Dep: %s, Localidad: %s %n", llamada.getString(2), llamada.getString(3)	);
			
			llamada.close();
			conexion.close();
		} catch (ClassNotFoundException|SQLException e) {
			e.getMessage();
		}
	}
}
