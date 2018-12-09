import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.stream.JsonReader;
import com.sun.org.apache.xpath.internal.operations.Equals;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import java.io.FileWriter;

public class func_Gson{
    public static void GetGSON(){
        Gson gson = new Gson();
        try {
           JsonReader reader = new JsonReader(new FileReader("./user.json"));
           JsonObject inputObj  = gson.fromJson(reader, JsonObject.class);
   
           inputObj.get("user").getAsJsonArray().get(0);
           JsonArray jarray = inputObj.getAsJsonArray("user");

           for(int i =0; i< jarray.size();i++){
             JsonObject kolo = jarray.get(i).getAsJsonObject();
             JsonObject jolo = kolo.getAsJsonObject();
             String a = jolo.get("nama").getAsString();
             String b = jolo.get("no_telp").getAsString();
             String c = jolo.get("alamat").getAsString();
             String d = jolo.get("panggilan").getAsString();
             String e = jolo.get("email").getAsString();
             System.out.println(a+"\t"+b+"\t"+c+"\t"+d+"\t"+e);
           }
            }catch (IOException e) {
            e.printStackTrace();
            }
   
    }
    public static void AddGSON(String nama, String no_telp, String alamat, String panggilan, String email){
        try{
            Gson gson = new Gson();
            
            JsonReader reader = new JsonReader(new FileReader("./user.json"));
            JsonObject inputObj  = gson.fromJson(reader, JsonObject.class);
            
            JsonObject newObject = new JsonObject() ;
                newObject.addProperty("nama",nama);
                newObject.addProperty("no_telp",no_telp);
                newObject.addProperty("alamat",alamat);
                newObject.addProperty("panggilan",panggilan);
                newObject.addProperty("email",email);
            
            inputObj.get("user").getAsJsonArray().add(newObject);         
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
    public static void EditGSON(){
        Gson gson = new Gson();

        try {
           JsonReader reader = new JsonReader(new FileReader("./user.json"));
           JsonObject inputObj  = gson.fromJson(reader, JsonObject.class);
   
           inputObj.get("user").getAsJsonArray().get(0);
           JsonArray jarray = inputObj.getAsJsonArray("user");

            for(int i =0; i< jarray.size();i++){
                JsonObject kolo = jarray.get(i).getAsJsonObject();
                JsonObject jolo = kolo.getAsJsonObject();
                
                    if(jolo.get("nama").getAsString().equals("budosen")){
                        jolo.addProperty("nama","budosen");
                        jolo.addProperty("no_telp","089343433433");
                        jolo.addProperty("alamat","jauhh");
                        jolo.addProperty("panggilan","yangg <3");
                        jolo.addProperty("email","budosen@gmail.com");
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
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void RemoveGSON(String Nama){
        Gson gson = new Gson();
        try {
           JsonReader reader = new JsonReader(new FileReader("./user.json"));
           JsonObject inputObj  = gson.fromJson(reader, JsonObject.class);
   
           inputObj.get("user").getAsJsonArray().get(0);
           JsonArray jarray = inputObj.getAsJsonArray("user");

            for(int i =0; i< jarray.size();i++){
                JsonObject kolo = jarray.get(i).getAsJsonObject();
                JsonObject jolo = kolo.getAsJsonObject();
                
                    if(jolo.get("nama").getAsString().equals(Nama)){
                        jolo.getAsJsonObject().remove("nama");
                        jolo.getAsJsonObject().remove("no_telp");
                        jolo.getAsJsonObject().remove("alamat");
                        jolo.getAsJsonObject().remove("panggilan");
                        jolo.getAsJsonObject().remove("email");
                        jarray.remove(i);
                        continue;
                    }

                        //String a = jolo.get("nama").getAsString();
                        //String b = jolo.get("no_telp").getAsString();
                        //String c = jolo.get("alamat").getAsString();
                        //String d = jolo.get("panggilan").getAsString();
                        //String e = jolo.get("email").getAsString();
                        //System.out.println(a+"\t"+b+"\t"+c+"\t"+d+"\t"+e);
            
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