import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileNotFoundException;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.

public class WriteJSONSimple {
 public static void main(String[] args){
    JSONParser jsonParser = new JSONParser();
    try{
        Object obj = jsonParser.parse(new FileReader("test.json"));
        JSONObject object = new JSONObject();
        //JSONArray jsonArray = (JSONArray)obj;
        object.put("Nama", "Ardo");
        object.put("Alamat", "Indonesia");
        object.put("No Telp", "0812-2345-6789");

        object.append
        try{
         FileWriter fw = new FileWriter("./test.json");
         fw.write(object.toJSONString());
         fw.flush();
         fw.close();
        }catch(IOException iex){
         iex.printStackTrace();
        }
    }catch(Exception e){
        e.printStackTrace();
    }
  }
 }
