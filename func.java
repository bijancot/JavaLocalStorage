import java.util.Scanner;

import javax.crypto.ExemptionMechanism;

import java.awt.Menu;
import java.sql.PreparedStatement;

public class func{
    static Integer Hasil;
    public static PreparedStatement preparedStatement;
    static Scanner inpxt = new Scanner(System.in);
    static void Menu(){
            System.out.println("\n\n=====-Menu-====");
            System.out.println("1. Lihat Data");
            System.out.println("2. Tambah Data");
            System.out.println("3. Edit Data");
            System.out.println("4. Hapus Data");
            System.out.println("5. Cek Koneksi");
            System.out.println("6. Cek Status Sistem");
            System.out.println("7. sinkronkan");
            System.out.println("0. Keluar");
            System.out.println("===============");
            System.out.println("Pilihan anda >");
    
            try{
                Scanner input = new Scanner(System.in);
                int pilihan = input.nextInt();
    
                switch (pilihan) {
                    case 0:
                    System.out.println("Keluar");
                    Keluar();
                    break;
    
                    case 1:
                    LihatData();
                    break;
    
                    case 2:
                    TambahData();
                    break;
    
                    case 3:
                    EditData();
                    break;
    
                    case 4:
                    HapusData();
                    break;
    
                    case 5:
                    if(Database.yolo_connect()==200){
                        error.GetError(200);
                        Menu();
                    }else if(Database.yolo_connect()==500){
                        error.GetError(100);
                        Menu();
                    }
                    break;
    
                    case 6:
                    CekSistem();
                    Menu();
                    break;
    
                    case 7:
                    SinkronKan();
                    Menu();
                    break;

                    default:
                    System.out.println("Inputen tidak jelas!!, System dihentikan!!");
                    Keluar();
                    break;
                
                }
    
            }catch(Exception e){
                e.printStackTrace();
                Hasil = 400;
            }
    }
    static void LihatData(){

        if(Database.yolo_connect()==200){
            String sql = "SELECT * FROM buku_telpon";
        
        try {
            Database.rs = Database.stmt.executeQuery(sql);
            System.out.println("+--------------------------------+");
            System.out.println("|        Data Buku Telpon        |");
            System.out.println("+--------------------------------+");
            int i = 1;
            System.out.println("+--------------------------------+");
            System.out.println("+--------------------------------+");
            while (Database.rs.next()) {
                int id = Database.rs.getInt("id");
                String Nama = Database.rs.getString("nama");

                System.out.println(String.format(i++ +"   %s", Nama));
            }
            System.out.println("Lihat nomor kontak (masukkan nama depan)>");
            Scanner inpat = new Scanner(System.in);
            String Noma = inpat.nextLine();
            String sqol = "SELECT * FROM buku_telpon where nama like ?";
            PreparedStatement preparedStatement = Database.conn.prepareStatement(sqol);
            preparedStatement.setString(1, "%" + Noma + "%");
            Database.rs = preparedStatement.executeQuery();

            while(Database.rs.next()){
                String Nama = Database.rs.getString("nama");
                String NoTelp = Database.rs.getString("no_telp");
                String Alamat = Database.rs.getString("alamat");
                String Panggilan = Database.rs.getString("panggilan");
                String Email = Database.rs.getString("email");
                System.out.println(String.format(" \nNama Kontak : %s\n No telp : %s\n ALamat : %s\n Panggilan : %s\n Email : %s", Nama, NoTelp,Alamat,Panggilan,Email));
            }
        }
         catch (Exception e) {
            System.out.println("Database dalam masalah segera dialihkan ke penyimpanan lokal");
            Menu();
            //e.printStackTrace();
        }
        Menu();
        }else if(Database.yolo_connect()==500){
            error.GetError(100);
            System.out.println("System dialihkan ke penyimpanan lokal\n");
            func_Gson.GetGSON();
            func.Menu();
        }
        
    }

    static void TambahData(){
        if(Database.yolo_connect()==200){
            String squl = "SELECT * FROM buku_telpon";
            try {
                Database.rs = Database.stmt.executeQuery(squl);
                System.out.println("+-------------------------+");
                System.out.println("|   Tambah Kontak Baru    |");
                System.out.println("+-------------------------+");
                System.out.print("Masukkan Nama Kontak > ");
                Scanner inpot = new Scanner(System.in);
                String Nama = inpot.nextLine();
                while (Database.rs.next()) {
                    int id = Database.rs.getInt("id");
                    String Nxma = Database.rs.getString("nama");
                    if(Nxma.equals(Nama)){
                        System.out.println(String.format("Nama : "+Nama +" Sudah digunakan"));
                        Menu();     
                    }
                    else{
                        continue;
                    }
                }
                System.out.print("Masukkan Nomor Telpon > ");
                String NoTelp = inpot.nextLine();
                System.out.print("Masukkan Alamat Kontak > ");
                String Alamat = inpot.nextLine();
                System.out.print("Masukkan Nama Panggilan Kontak > ");
                String Panggilan = inpot.nextLine();
                System.out.print("Masukkan Alamat Email Kontak > ");
                String Email = inpot.nextLine();
                // query simpan
                


                String sql = "INSERT INTO buku_telpon (nama, no_telp, alamat, panggilan, email) VALUE(?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = Database.conn.prepareStatement(sql);
                preparedStatement.setString(1, Nama);
                preparedStatement.setString(2, NoTelp);
                preparedStatement.setString(3, Alamat);
                preparedStatement.setString(4, Panggilan);
                preparedStatement.setString(5, Email);
                preparedStatement.executeUpdate();
                
                func_Gson.AddGSON(Nama, NoTelp, Alamat, Panggilan, Email);
                // simpan buku
                System.out.println("\n\n+-------------------------------+");
                System.out.println("|  Kontak Berhasil ditambahkan  |");
                System.out.println("+-------------------------------+");
                Menu();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(Database.yolo_connect()==500){
            System.out.println("System dialihkan ke penyimpanan lokal");
            try{
                System.out.println("+-------------------------+");
                System.out.println("|   Tambah Kontak Baru    |");
                System.out.println("+-------------------------+");
                System.out.print("Masukkan Nama Kontak > ");
                Scanner inpot = new Scanner(System.in);
                String Nama = inpot.nextLine();
                System.out.print("Masukkan Nomor Telpon > ");
                String NoTelp = inpot.nextLine();
                System.out.print("Masukkan Alamat Kontak > ");
                String Alamat = inpot.nextLine();
                System.out.print("Masukkan Nama Panggilan Kontak > ");
                String Panggilan = inpot.nextLine();
                System.out.print("Masukkan Alamat Email Kontak > ");
                String Email = inpot.nextLine();
                
                String que = "INSERT INTO buku_telpon (nama, no_telp, alamat, panggilan, email) VALUES('"+Nama+"','"+NoTelp+"','"+Alamat+"','"+Panggilan+"','"+Email+"')";
                func_Gson.AddGSON(Nama, NoTelp, Alamat, Panggilan, Email);
                func_Gson.AddtoTemp(que);
                Menu();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
       
    }
    static void EditData(){

        if(Database.yolo_connect()==200){
            try {
                String sql = "SELECT * FROM buku_telpon where id not like ?";
                preparedStatement = Database.conn.prepareStatement(sql);
                preparedStatement.setInt(1, 0);
                Database.rs = preparedStatement.executeQuery();
                
                System.out.println("+--------------------------------+");
                System.out.println("|        Data Buku Telpon        |");
                System.out.println("+--------------------------------+");
                int i = 1;
                System.out.println("+--------------------------------+");
                System.out.println("+--------------------------------+");
                while (Database.rs.next()) {
                    int id = Database.rs.getInt("id");
                    String Nama = Database.rs.getString("nama");
    
                    System.out.println(String.format(i++ +"   %s", Nama));
                }
                System.out.println("+-------------------------+");
                System.out.println("|       Edit Kontak       |");
                System.out.println("+-------------------------+");
                System.out.print("Masukkan nama kontak yang ingin diedit >");
                try{
                    Scanner inpat = new Scanner(System.in);
                String Noma = inpat.nextLine();
                String sqol = "SELECT * FROM buku_telpon where nama like ?";
                preparedStatement = Database.conn.prepareStatement(sqol);
                preparedStatement.setString(1, "%" + Noma + "%");
                Database.rs = preparedStatement.executeQuery();
                
                }catch(Exception E){
                    E.printStackTrace();;
                    EditData();
                }
    
                while(Database.rs.next()){
                    Scanner yolo = new Scanner(System.in);
                    
                    String id = Database.rs.getString("id");
                    String Nama = Database.rs.getString("nama");
                    String NoTelp = Database.rs.getString("no_telp");
                    String Alamat = Database.rs.getString("alamat");
                    String Panggilan = Database.rs.getString("panggilan");
                    String Email = Database.rs.getString("email");
                    
                    System.out.println("Rubah kontak Sesuai keinginan anda");
                    System.out.print("Nama kontak: "+Nama+" Menjadi > ");
                    String Nema = yolo.nextLine();
                    System.out.print("No Telpon kontak: "+NoTelp+" Menjadi > ");
                    String NeTelp = yolo.nextLine();
                    System.out.print("Alamat kontak: "+Alamat+" Menjadi > ");
                    String Alemat = yolo.nextLine();
                    System.out.print("Panggilan kontak: "+Panggilan+" Menjadi > ");
                    String Penggilan = yolo.nextLine();
                    System.out.print("Email kontak: "+Email+" Menjadi > ");
                    String Emel = yolo.nextLine();
    
                    String sqpl = "UPDATE buku_telpon SET nama=?, no_telp=?, alamat=?, panggilan=?, email=? where id =?";
                  preparedStatement = Database.conn.prepareStatement(sqpl);
                preparedStatement.setString(1, Nema);
                preparedStatement.setString(2, NeTelp);
                preparedStatement.setString(3, Alemat);
                preparedStatement.setString(4, Penggilan);
                preparedStatement.setString(5, Emel);
                preparedStatement.setString(6, id);
                preparedStatement.executeUpdate();
                func_Gson.EditGSON(Nama, Nema, NeTelp, Alemat, Penggilan, Emel);
                Menu();
                }
            } catch (Exception e) {
                e.printStackTrace();
                Menu();
            }
        }else if(Database.yolo_connect()==500){
            System.out.println("System dialihkan ke penyimpanan lokal");
            try {
                
                System.out.println("+--------------------------------+");
                System.out.println("|        Data Buku Telpon        |");
                System.out.println("+--------------------------------+");
                System.out.println("+--------------------------------+");
                System.out.println("+--------------------------------+");
                func_Gson.GetGSON();
                System.out.println("+-------------------------+");
                System.out.println("|       Edit Kontak       |");
                System.out.println("+-------------------------+");
                System.out.print("Masukkan nama kontak yang ingin diedit >");

                    Scanner inpat = new Scanner(System.in);
                String Noma = inpat.nextLine();
                func_Gson.GetGSONS(Noma);
                
    
      
                    Scanner yolo = new Scanner(System.in);
                    
                    System.out.println("Rubah kontak Sesuai keinginan anda");
                    System.out.print("Nama kontak: baru > ");
                    String Nema = yolo.nextLine();
                    System.out.print("No Telpon kontak: baru > ");
                    String NeTelp = yolo.nextLine();
                    System.out.print("Alamat kontak: baru > ");
                    String Alemat = yolo.nextLine();
                    System.out.print("Panggilan kontak: baru > ");
                    String Penggilan = yolo.nextLine();
                    System.out.print("Email kontak: baru > ");
                    String Emel = yolo.nextLine();
    
                    String sqpl = "UPDATE buku_telpon SET nama='"+Nema+"', no_telp='"+NeTelp+"', alamat='"+Alemat+"', panggilan='"+Penggilan+"', email='"+Emel+"' where nama ='"+Noma+"'";
                    func_Gson.AddtoTemp(sqpl);
                    func_Gson.EditGSON(Noma, Nema, NeTelp, Alemat, Penggilan, Emel);
                Menu();
                
            } catch (Exception e) {
                e.printStackTrace();
                Menu();
            }
        }
      
    }
    static void HapusData(){
        if(Database.yolo_connect()==200){
            try {
                String sql = "SELECT * FROM buku_telpon where id not like ?";
                preparedStatement = Database.conn.prepareStatement(sql);
                preparedStatement.setInt(1, 0);
                Database.rs = preparedStatement.executeQuery();
                
                System.out.println("+--------------------------------+");
                System.out.println("|        Data Buku Telpon        |");
                System.out.println("+--------------------------------+");
                int i = 1;
                System.out.println("+--------------------------------+");
                System.out.println("+--------------------------------+");
                while (Database.rs.next()) {
                    //int id = Database.rs.getInt("id");
                    String Nama = Database.rs.getString("nama");
    
                    System.out.println(String.format(i++ +"   %s", Nama));
                }
                Scanner yolo = new Scanner(System.in);
                // ambil input dari user
                System.out.print("Masukkan Nama yang ingin dihapus >  ");
                String Noma = yolo.nextLine();
                
                // buat query hapus
                String sqel = "DELETE FROM buku_telpon WHERE nama=?";
                preparedStatement = Database.conn.prepareStatement(sqel);
                preparedStatement.setString(1, Noma);
                
                // hapus data
                preparedStatement.executeUpdate();
                func_Gson.RemoveGSON(Noma);
                Menu();
            } catch (Exception e) {
                e.printStackTrace();
                Menu();
            }
        }else if(Database.yolo_connect()==500){
            System.out.println("System dialihkan ke penyimpanan lokal");
            
            try{
                Scanner yolo  = new Scanner(System.in);
                System.out.println("+--------------------------------+");
                System.out.println("|        Data Buku Telpon        |");
                System.out.println("+--------------------------------+");
                System.out.println("+--------------------------------+");
                System.out.println("+--------------------------------+");
                func_Gson.GetGSON();
                System.out.println("+-------------------------+");
                System.out.println("|       hapus Kontak      |");
                System.out.println("+-------------------------+");
                System.out.print("Masukkan nama kontak yang ingin dihapus >");
                String Noma = yolo.nextLine();

                String sqel = "DELETE FROM buku_telpon WHERE nama=''"+Noma+"'";
                func_Gson.RemoveGSON(Noma);
                func_Gson.AddtoTemp(sqel);
                
                Menu();


            }catch(Exception e){
                e.printStackTrace();
                Menu();
            }

        }
           
    }

    static void CekSistem(){
        if(Database.yolo_connect()==200){
            System.out.println("Status Koneksi Database : ");
            error.GetError(200);
            System.out.println("\n");
            System.out.println("Sistem Tidak Berjalan normal");
            Menu();
        }else if(Database.yolo_connect()==500){
            System.out.println("Status Koneksi Database : ");
            error.GetError(100);
            System.out.println("\n");
            System.out.println("Sistem Berjalan normal");
            Menu();
        }

    }
    static void SinkronKan(){
        func_Gson.GetQue();
        System.out.println("Sistem Berhasil di sinkronkan!!");
    }
    static void Keluar(){
        System.exit(0);
    }
}