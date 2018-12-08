import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.stream.JsonWriter;
import java.io.FileWriter;

public class addjson {

    public static void main(String[] args) {
        try{
            Gson gson = new Gson();
            
            JsonReader reader = new JsonReader(new FileReader("./user.json"));
            JsonObject inputObj  = gson.fromJson(reader, JsonObject.class);
            JsonObject newObject = new JsonObject() ;
            newObject.addProperty("lat", "newValue");
            newObject.addProperty("lon", "newValue");
            inputObj.get("messages").getAsJsonArray().add(newObject);         
            System.out.println(inputObj);
            String yolo = inputObj.toString();
            try (FileWriter writor = new FileWriter("./user.json")) {

                gson.toJson(inputObj, writor);
    
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }

}