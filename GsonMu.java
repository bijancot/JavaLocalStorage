import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.stream.JsonReader;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;

public class GsonMu {
   public static void main(String[] args) {
    Gson gson = new Gson();
     try {
        JsonReader reader = new JsonReader(new FileReader("./user.json"));
        JsonObject inputObj  = gson.fromJson(reader, JsonObject.class);

        inputObj.get("messages").getAsJsonArray();
        JsonArray jarray = inputObj.getAsJsonArray("messages");
        JsonObject kolo = jarray.get(0).getAsJsonObject();
        
        System.out.println(kolo.getAsJsonObject().get("lat").getAsString());
        System.out.println(jarray.size());

     }  catch (IOException e) {
	e.printStackTrace();
     }

   }

}