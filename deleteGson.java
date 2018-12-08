import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.stream.JsonReader;
import com.sun.org.apache.xpath.internal.operations.Equals;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import java.io.FileWriter;

public class deleteGson{
    public static void main(String[] args){
        Gson gson = new Gson();
        try {
           JsonReader reader = new JsonReader(new FileReader("./user.json"));
           JsonObject inputObj  = gson.fromJson(reader, JsonObject.class);
   
           inputObj.get("messages").getAsJsonArray().get(0);
           JsonArray jarray = inputObj.getAsJsonArray("messages");
   
           //System.out.println(jarray.size());
           System.out.println("lon                 lat");
           for(int i =0; i< jarray.size();i++){
             JsonObject kolo = jarray.get(i).getAsJsonObject();
             JsonObject jolo = kolo.getAsJsonObject();
             if(jolo.get("lon").getAsString().equals("sayanu")){
                jolo.getAsJsonObject().remove("lon");
                jolo.getAsJsonObject().remove("lat");
                jarray.remove(i);
                //System.out.println(jolo.getAsJsonArray().get(0).remove("lat"));
                //System.out.println(jolo.getAsJsonObject().remove("lon"));
                //jolo.addProperty("lon","sayanu");
                //jolo.addProperty("lat","budosen");
                //System.out.println(a+"            "+b);
                continue;
             }
             String a = jolo.get("lon").getAsString();
             String b = jolo.get("lat").getAsString();
             System.out.println(a+"            "+b);
            
           }
             try (FileWriter writor = new FileWriter("./user.json")) {

                gson.toJson(inputObj, writor);
    
            } catch (IOException e) {
                e.printStackTrace();
            }
        }  catch (IOException e) {
       e.printStackTrace();
        }
    }


}