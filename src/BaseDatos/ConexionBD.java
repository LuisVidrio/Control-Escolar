package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD 
{
	public static Connection getConnection()
    {
		
		//CREDENCIALES::PERMISOS EN LA BD
		String User = "sa";
		String Psw	= "123";
		
		
        String conexion = "jdbc:sqlserver://localhost:1433;" //DIRECCION LOCAL
                + "database=Ctrl_Escolar;"	
                + "user="+User+";" 					
                + "password="+Psw+";"				 			
                + "loginTimeout=30;";
        try
        {
            Connection con = DriverManager.getConnection(conexion);
            return con;
        }catch(SQLException ex)
        {
            System.out.print(ex.toString());
            return null;
        } 
    }
	
    
}
