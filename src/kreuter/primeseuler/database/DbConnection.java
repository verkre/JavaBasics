package kreuter.primeseuler.database;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import kreuter.primeseuler.utils.Logger;

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
            Logger.writeToLogFile("AT STARTUP: No database connection --> " + ex.getClass());
            return false;
        }
    }
    
    public boolean isConnected() {
        try {
            return connection != null && connection.isValid(0);
        } catch (SQLException ex) {
            Logger.writeToLogFile("Lost database connection --> " + ex.getClass());
            return false;
        }
    }
    
    public Connection getConnection() {
        return connection;
    }
}
