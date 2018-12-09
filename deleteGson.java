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
   
           inputObj.get("user").getAsJsonArray().get(0);
           JsonArray jarray = inputObj.getAsJsonArray("user");
   
           System.out.println("lon                 lat");
           for(int i =0; i< jarray.size();i++){
             JsonObject kolo = jarray.get(i).getAsJsonObject();
             JsonObject jolo = kolo.getAsJsonObject();
             if(jolo.get("nama").getAsString().equals("budosen")){
                jolo.getAsJsonObject().remove("nama");
                jolo.getAsJsonObject().remove("no_telp");
                jolo.getAsJsonObject().remove("alamat");
                jolo.getAsJsonObject().remove("panggilan");
                jolo.getAsJsonObject().remove("email");
                jarray.remove(i);
                continue;
             }
             String a = jolo.get("nama").getAsString();
             String b = jolo.get("no_telp").getAsString();
             String c = jolo.get("alamat").getAsString();
             String d = jolo.get("panggilan").getAsString();
             String e = jolo.get("email").getAsString();
             System.out.println(a+"\t"+b+"\t"+c+"\t"+d+"\t"+e);
            
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