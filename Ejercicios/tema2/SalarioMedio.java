package tema2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class SalarioMedio {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/prueba", "Earbis","pass.admin");
			// recuperar parametros de main
			String dep = args[0];
			
			//construir orden de llamada
			String sql = "{? = call SalarioMedio (?) }";
			
			//Preparar la llamada 
			CallableStatement llamada = conexion.prepareCall(sql);
			//parametro salida
			llamada.registerOutParameter(1, Types.FLOAT);
			//Dar valor a los argumentos
			llamada.setInt(2, Integer.parseInt(dep));
			
			//Ejecutar el procedimiento
			llamada.executeUpdate();
			System.out.printf("Salario medio: %.2f %n", llamada.getFloat(1));
			
			llamada.close();
			conexion.close();
		} catch (ClassNotFoundException|SQLException e) {
			e.getMessage();
		}
	}
}
