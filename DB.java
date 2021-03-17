
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DB {
    
    
    final private String driver = "org.h2.Driver";
    final private String url = "jdbc:h2:file:/Users/hakan/NetBeansProjects/4-Days/db/proje";
    final private String dbUserName = "sa";
    final private String dbUserPass = "";
    
    
    private Connection conn = null;
    private PreparedStatement pre = null;
    
    
    public PreparedStatement con( String query ) {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, dbUserName, dbUserPass);
            pre = conn.prepareStatement(query);
            System.out.println("Connection Success");
        } catch (Exception e) {
            System.err.println("Connection Error : " + e);
        }
        return pre;
    }
    
    
    public void close() {
        try {
            conn.close();
            pre.close();
        } catch (Exception e) {
            System.err.println("Close Error : " + e);
        }
    }
    
    
    
    
}
