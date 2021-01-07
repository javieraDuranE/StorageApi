package com.storageApi.conexionBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.storageApi.modelo.Item;


public class FuncionesBD {

    private static Connection con = null;
    private static Statement st;
    private static String query;
    private static ResultSet rs;

    public static Item buscarItem(String id) throws SQLException, Exception {
        con = new ConexionBD().conectar();
        Item item = new Item();
        try {
            st = con.createStatement();
            query = "select * from item where ID='" + id + "'";
            rs = st.executeQuery(query);
            if(rs.next()) {
            	item = new Item(rs.getInt("id"), rs.getString("title"), rs.getInt("category_id"), rs.getDouble("price"), rs.getString("symbol"), rs.getInt("currency_id"), rs.getInt("country_id"), rs.getString("create_at"), rs.getString("modified_at"));
            }                       
            con.close();

        } catch (SQLException exc) {
            System.out.println("Error Al ejecutar Query: " + exc);
        }

        return item;
    }
   
    public static String actualizarItem(String id, String title, String price, String currency, String country) throws SQLException, Exception {
        String valor = "no se ha actualizado el registro";
        con = new ConexionBD().conectar();
        int cont = 0;
        try {

            st = con.createStatement();
            query = "update item set title='" + title + "', price='" + price + "', currency_id=(select ID from currency where shortname ='" + currency + "'),country_id=(select ID from country where shortname ='" + country + "'), modified_at = CURRENT_TIMESTAMP  where ID=" + id;
            cont = st.executeUpdate(query);

            if (cont > 0) {
                valor = "se ha actualizado el registro";
            }

            con.close();
        } catch (SQLException exc) {
            System.out.println("Error Al ejecutar Query: " + exc);
        }

        return valor;
    }

    public static String eliminarItem(String id) throws SQLException, Exception {
        String valor = "no se ha eliminado el registro";
        con = new ConexionBD().conectar();
        int cont = 0;
        try {

            st = con.createStatement();
            query = "delete from item  where ID=" + id;
            cont = st.executeUpdate(query);

            if (cont > 0) {
                valor = "se ha eliminado el registro";
            }

            con.close();
        } catch (SQLException exc) {
            System.out.println("Error Al ejecutar Query: " + exc);
        }

        return valor;
    }

    public static Integer insertarItem(String title, String price, String currency, String country, String category_id) throws SQLException, Exception {
        int respuesta=0;
        con = new ConexionBD().conectar();
        int cont = 0;
        try {

            st = con.createStatement();
            query = "INSERT INTO item( title, category_id, price, currency_id, symbol, country_id, create_at) VALUES ('" + title + "','" + category_id + "','" + price + "',(SELECT ID FROM currency WHERE shortname = '" + currency + "'),'$',(SELECT ID FROM country WHERE shortname = '" + country + "'),CURRENT_TIMESTAMP)";
            cont = st.executeUpdate(query);

            if (cont > 0) {
                st = con.createStatement();
                query = "select * from item where title='" + title+ "' and category_id='"+category_id+"' and price='"+price+"'";
                rs = st.executeQuery(query);
                rs.next();
                do{
                    respuesta =rs.getInt("id");                
                    }while (rs.next());
            }

            con.close();
        } catch (SQLException exc) {
            System.out.println("Error Al ejecutar Query: " + exc);
        }

        return respuesta;
    }

}
