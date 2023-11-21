package practicaevaluable;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementyPermisos {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/library", "Earbis","pass.admin");
		
		// Conceder permisos para realizar CRUD a un usuario utilizando PreparedStatement
        String sql = "GRANT SELECT, INSERT, UPDATE, DELETE ON authors TO ?@'localhost' IDENTIFIED BY ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, "Prueba");
        sentencia.setString(2, "pass.admin");
        sentencia.execute();
       
        //ahora establezco la conexion a partir del nuevo usuario y hago los cambios en la tabla
        Connection conexionPrueba = DriverManager.getConnection("jdbc:mysql://localhost/library", "Prueba","pass.admin");
		
		//Inserto una fila en autores
		String sql2 ="INSERT INTO authors VALUES(?,?,?)";
		PreparedStatement sentencia2 = conexionPrueba.prepareStatement(sql2);
		sentencia2.setString(1, "Edgar Mariano Poe");
		sentencia2.setDate(2, Date.valueOf("1809-01-19"));
		sentencia2.setString(3,"Boston");
		System.out.println("filas afectadas: "+sentencia2.executeUpdate());
		
		//He insertado la fila de forma erronea, aquí la modifico
		String sql3 = "UPDATE authors SET author_name = ? where author_name ='Edgar Mariano Poe';";
		PreparedStatement sentencia3 = conexionPrueba.prepareStatement(sql3);
		sentencia3.setString(1, "Edgar Allan Poe");
		System.out.println("filas afectadas: "+sentencia3.executeUpdate());
		
		
		//aqui visualizo la tabla autores y confirmo que el escritor Edgar Allan Poe ha sido introducido como queria
		String sql4 = "SELECT * FROM authors WHERE author_name = ? ;";
		PreparedStatement sentencia4 = conexionPrueba.prepareStatement(sql4);
		sentencia4.setString(1, "Edgar Allan Poe");
		ResultSet rs = sentencia4.executeQuery();
		while (rs.next()) {
			System.out.printf(" Autor: %s", rs.getString(1));
		}
		rs.close();
		
		
		//cierro la conexion de prueba antes de quitarle los permisos al usuario
		conexionPrueba.close();
		
		// Revocar permisos previamente concedidos
        String sql5 = "REVOKE SELECT, INSERT, UPDATE, DELETE ON authors FROM ?@'localhost' ";
        PreparedStatement sentencia5 = conexion.prepareStatement(sql5) ;
            sentencia5.setString(1, "Prueba");
            sentencia5.execute();
        
		
		conexion.close();
	}
}
