import java.util.Hashtable;
import java.util.ArrayList;

class some{
    String head;
    String message;
    some(String a, String b){
        head = a;
        message =b;
    }
}

public class error{
    static void GetError(int Error){
        Hashtable<Integer, some> ErrList = new Hashtable<Integer, some>();
        ArrayList<String> kolo = new ArrayList<String>();
        ArrayList<String> polo = new ArrayList<String>();

        polo.add("Database Error");
        polo.add("Koneksi Lancar");
        polo.add("Inputan Bermasalah");

        kolo.add("Koneksi ke database mengalamai masalah!!");
        kolo.add("Koneksi ke database tidak mengalamai masalah!!");
        kolo.add("Inputan anda tidak sesuai");


        for(int i=0; i<kolo.size();i++){
            String hodd = polo.get(i).toString();
            String mess = kolo.get(i).toString();
            ErrList.put(((i+1)*100), new some(hodd,mess));
        }

        System.out.print(ErrList.get(Error).head+"\n");
        System.out.println("Pesan : ");
        System.out.print(ErrList.get(Error).message+"\n");

    }
}