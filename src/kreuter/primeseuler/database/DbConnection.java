package kreuter.primeseuler.database;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DbConnection {

    // Verbindungs-Objekt
    private Connection connection;
    //
    // Verbindungs-Parameter
    private String server;
    private String db;
    private String user;
    private String password;

    
    public boolean connect() {
        Properties p = new Properties();
        try {
            p.load(new FileReader("src/kreuter/primeseuler/database/jdbc.properties"));
        } catch (IOException ex) {
            System.out.println(ex);
        }
        server = p.getProperty("server", "localhost");
        db = p.getProperty("db", "primeeuler");
        user = p.getProperty("user", "root");
        password = p.getProperty("password", "");

        String connectionString = "jdbc:mysql://" + server + "/" + db;

        try {
            connection = DriverManager.getConnection(connectionString, user, password);
            return true;
        } catch (SQLException ex) {
            System.out.print("in connect() method in dbConnection --> ");
            System.out.println(ex);
            return false;
        }
    }
    
    public boolean isConnected() {
        return connection != null; //  && connection.isValid(0);
    }
    
    public Connection getConnection() {
        return connection;
    }
}
