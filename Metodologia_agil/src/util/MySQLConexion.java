package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConexion {
	public static Connection getConexion(){
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver"); 
			String url = "jdbc:mysql://localhost:3306/upc_sistema_control"; 
			// 192.168.1.35
			String usr = "root"; 
			String psw = "mysql"; 
			con = DriverManager.getConnection(url,usr,psw); 
		//	System.out.println("Conectado");
		}catch (ClassNotFoundException e){
			System.out.println("Error >> Driver Instalado!!");
			System.out.println("No conectado");
		}catch(SQLException ex){
			System.out.println("Error >> de conexión con la BD");
			System.out.println("No Conectado");
			
		}
		return con;
	}
}
