import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.stream.JsonReader;
import com.sun.org.apache.xpath.internal.operations.Equals;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import java.io.FileWriter;
import java.sql.*;

public class hapus{
    public static void main(String[] args){
        Gson gson = new Gson();
        try {
           JsonReader reader = new JsonReader(new FileReader("./temp.json"));
           JsonObject inputObj  = gson.fromJson(reader, JsonObject.class);
   
           inputObj.get("dato").getAsJsonArray().get(0);
           JsonArray jarray = inputObj.getAsJsonArray("dato");

           for(int i =0; i< jarray.size();i++){
            JsonObject kolo = jarray.get(i).getAsJsonObject();
            JsonObject jolo = kolo.getAsJsonObject();
            
                if(jolo.get("queue").getAsString().equals("Nama")==false){
                    jolo.getAsJsonObject().remove("queue");
                    jarray.remove(i);
                    continue;
                }
            }
            }catch (IOException e) {
            e.printStackTrace();
            }
    }
}