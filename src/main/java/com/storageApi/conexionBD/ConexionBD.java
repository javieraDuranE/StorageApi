package com.storageApi.conexionBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
	private Connection con = null;
    private String user;
    private String pass;
    private String url;

   public ConexionBD(){}
    

    public Connection conectar() throws Exception {
        try {
            user = "root";
            pass = "";
            url = "jdbc:mysql://localhost:3306/storage";
           
            con = DriverManager.getConnection(url, user, pass); 
           
        } catch (SQLException sqle) {
            System.out.println("Error conexion" + sqle);
        }catch (Exception e){
            System.out.println(e);
        }
        return con;
    }

    public void cerrarConexion() throws Exception {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
        	System.out.println("Error al cerrar conexion" + e);  
        }
    }
}
