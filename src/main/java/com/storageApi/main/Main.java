package com.storageApi.main;

import static com.storageApi.conexionBD.FuncionesBD.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.storageApi.modelo.Item;





@RestController
@RequestMapping("/")
public class Main {
	
		@RequestMapping(value="buscar/{valor}")
        @Produces(MediaType.APPLICATION_JSON)
        public ResponseEntity<Item> buscarID(@PathVariable("valor") String id) throws Exception{
			return ResponseEntity.ok(buscarItem(id));
        }
		@RequestMapping(value="insertar")
        @Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
        public ResponseEntity<String> insertarID( InputStream valores) throws Exception{
			 
			 InputStreamReader isReader = new InputStreamReader(valores);
		      BufferedReader reader = new BufferedReader(isReader);
		      String str;
		      String title="";
		      String price="";
		      String country="";
		      String currency="";
		      String category_id="";
		      while((str = reader.readLine())!= null){

		         if (str.contains("title")) {
		        	 title= str.substring(str.indexOf(":")+1, str.indexOf(",")-1).trim().replace("\"", "");
		        	 System.out.println(title);
		         }
		         if (str.contains("price")) {
		        	 price = str.substring(str.indexOf(":")+1, str.indexOf(",")-1).trim().replace("\"", "");
		        	 System.out.println(price);
		        	 }
		         if (str.contains("country")) {
		        	 country= str.substring(str.indexOf(":")+1, str.indexOf(",")-1).trim().replace("\"", "");
		        	 System.out.println(country);
		        	 }
		         if (str.contains("currency")) {
		        	 currency = str.substring(str.indexOf(":")+1, str.indexOf(",")-1).trim().replace("\"", "");
		        	 System.out.println(currency);
		         }
		         if (str.contains("category_id")) {
		        	 category_id= str.substring(str.indexOf(":")+1).trim().replace("\"", "");
		        	 System.out.println(category_id);
		         }
		      }
			
			return ResponseEntity.ok(""+insertarItem(title,price,currency,country,category_id));
        }
		@RequestMapping(value="eliminar/{valor}")
        @Produces(MediaType.APPLICATION_JSON)
        public ResponseEntity<String> eliminarID(@PathVariable("valor") String id) throws Exception{
			return ResponseEntity.ok(eliminarItem(id));
        }
		@RequestMapping(value="actualizar/{valor}")
        @Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
        public ResponseEntity<String> actualizarID(@PathVariable("valor") String id, InputStream valores) throws Exception{
			 InputStreamReader isReader = new InputStreamReader(valores);
		      BufferedReader reader = new BufferedReader(isReader);
		      String str;
		      String title="";
		      String price="";
		      String country="";
		      String currency="";
		      while((str = reader.readLine())!= null){

			         if (str.contains("title")) {
			        	 title= str.substring(str.indexOf(":")+1, str.indexOf(",")-1).trim().replace("\"", "");
			        	 
			         }
			         if (str.contains("price")) {
			        	 price = str.substring(str.indexOf(":")+1, str.indexOf(",")-1).trim().replace("\"", "");
			        	 
			        	 }
			         if (str.contains("country")) {
			        	 country= str.substring(str.indexOf(":")+1, str.length()-1).trim().replace("\"", "");
			        	 
			        	 }
			         if (str.contains("currency")) {
			        	 currency = str.substring(str.indexOf(":")+1, str.indexOf(",")-1).trim().replace("\"", "");
			        	 
			         }
			       
			      }
			return ResponseEntity.ok(actualizarItem(id,title,price,currency,country));
        }
}
