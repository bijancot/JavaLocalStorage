/**
 * Library that used :
 *  - mysql-jdbc
 *  - JSON simple
 *  @author bijancot & tambir
 */

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

import java.util.Scanner;


public class LocalJavaS{
    public static void main(String args[]){
        if(Database.yolo_connect()==200){
            error.GetError(200);
            func.Menu();
        }else if(Database.yolo_connect()==500){
            error.GetError(100);
        }
        
}
}