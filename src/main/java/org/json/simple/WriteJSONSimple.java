package org.json.simple;

/**
 *
 * @author ARDI
 */

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class WriteJSONSimple {
 public static void main(String[] args){
  JSONObject object = new JSONObject();
  object.put("Nama", "Ardi");
  object.put("Alamat", "Indonesia");
  object.put("No Telp", "0812-2345-6789");

  try{
   FileWriter fw = new FileWriter("D:/testing/test.json");
   fw.write(object.toJSONString());
   fw.flush();
   fw.close();
  }catch(IOException iex){
   iex.printStackTrace();
  }
  
 }
}