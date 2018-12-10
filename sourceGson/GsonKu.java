import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.stream.JsonWriter;

public class GsonKu {
   public static void main(String[] args) {

     JsonWriter writer;
     try {
	writer = new JsonWriter(new FileWriter("./user.json"));
			
	writer.beginObject(); // {			
	writer.name("messages"); // "messages" : 
	writer.beginArray(); // [
        writer.beginObject();
        writer.name("lat").value("yolo");
        writer.name("lon").value("kolo");
        writer.endObject();
    //writer.value("msg 1"); // "msg 1"
	//writer.value("msg 2"); // "msg 2"
	writer.endArray(); // ]
			
	writer.endObject(); // }
	writer.close();
			
	System.out.println("Done");
			
     } catch (IOException e) {
	e.printStackTrace();
     }
		
   }

}



        



