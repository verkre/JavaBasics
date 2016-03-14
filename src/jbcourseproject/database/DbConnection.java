package jbcourseproject.database;

import java.sql.*;

public class DbConnection {

    // Verbindungs-Objekt
    private Connection connection;
    //
    // Verbindungs-Parameter
    private String server;
    private String db;
    private String user;
    private String password;

    public DbConnection() {
//        Properties p = new Properties();
//        try {
//            p.load(new FileReader("src/de(javafish/db/jdbc.properties"));
//        } catch (IOException ex) {
//            System.out.println(ex);
//        }
        server = "localhost"; // 127.0.0.1
        db = "primeeuler";
        user = "root";
        password = "toor";
        
        String connectionString = "jdbc:mysql://" + server + "/" + db;
        
        try {
            connection = DriverManager.getConnection(connectionString, user, password);
        } catch (SQLException ex) {
            System.out.print("in DbConnection constructor --> ");
            System.out.println(ex);
        }
    }
    
    public boolean isConnected() {
        return connection != null; //  && connection.isValid(0);
    }
    
    public Connection getConnection() {
        return connection;
    }
}
