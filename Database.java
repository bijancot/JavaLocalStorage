import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class Database {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://172.17.0.2/java_local";
    static final String USER = "budosen";
    static final String PASS = "bijan2089";

    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    static Integer Hasil;

    static Integer yolo_connect(){
        
        try {
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
    
            while (!conn.isClosed()) {
                Hasil = 200;
                return Hasil;
        }
            stmt.close();
            conn.close();
    
        } catch (Exception ex) {
            Hasil = 500;
            return Hasil;
        }
        Hasil = 000;
return Hasil;
    }
}