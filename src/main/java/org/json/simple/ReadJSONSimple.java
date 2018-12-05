package org.json.simple;

/**
 *
 * @author ARDI
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJSONSimple {
 public static void main(String[] args){
  JSONParser parser = new JSONParser();
  try {
   Object object = parser.parse(new FileReader("D:/testing/test.json"));
   
   JSONObject jsonObject = (JSONObject) object;
   
   String nama = (String) jsonObject.get("Nama");
   String telp = (String) jsonObject.get("No Telp");
   String alamat = (String) jsonObject.get("Alamat");
   
   System.out.print("Nama : ") ;System.out.println(nama);
   System.out.print("No Telp : ") ;System.out.println(telp);
   System.out.print("Alamat : ") ;System.out.println(alamat);

  } catch (FileNotFoundException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  } catch (IOException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  } catch (ParseException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
  
 }
}