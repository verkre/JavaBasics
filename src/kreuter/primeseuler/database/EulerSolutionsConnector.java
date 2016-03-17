package kreuter.primeseuler.database;

import java.sql.*;
import java.util.*;
import kreuter.primeseuler.utils.Logger;

/**
 *
 * @author Vera Kreuter
 */


public class EulerSolutionsConnector {
    
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private List<EulerSolution> eulerSolutions;
    private final DbConnection dbConnection;
    
    public EulerSolutionsConnector(DbConnection dbConnection) {
        try {
            this.connection = dbConnection.getConnection();
            statement = connection.createStatement();
        } catch (SQLException ex) {
            Logger.writeToLogFile("DATABASE: Could not create statement");
        }
        this.dbConnection = dbConnection;
        eulerSolutions = new ArrayList<>();
    }
    
    public void readAll() {
        read("SELECT * FROM `eulersolutions`");
    }
    
    public void readByProblemNumber(String problemNumber) {
        read("SELECT * FROM `eulersolutions` WHERE problemNumber=" + problemNumber);
    }

    
    private void read(String sql) {
        eulerSolutions.clear();
        
        try {
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                EulerSolution eulerSolution = new EulerSolution(
                        resultSet.getInt("uid"),
                        resultSet.getString("problemNumber"),
                        resultSet.getString("problemSolution")
                );
                eulerSolutions.add(eulerSolution);
            }
        } catch (SQLException ex) {
            Logger.writeToLogFile("DATABASE: Could not read table");
        }            
    }
    
    public List<EulerSolution> getEulerSolutions() {
        readAll();
        return new ArrayList<>(eulerSolutions);
    }
    
    public String getSolutionForProblem(String problemNumber) {
        if (! isInDB(problemNumber)) {
            return null;
        } else {
            readByProblemNumber(problemNumber);
            return eulerSolutions.get(0).getProblemSolution();
        }
    }
    
    public boolean isInDB(String problemNumber) {
        readByProblemNumber(problemNumber);
        return (! eulerSolutions.isEmpty());
    }

    public boolean insert(EulerSolution eulerSolution) {
        readByProblemNumber(eulerSolution.getProblemNumber());
        if (!eulerSolutions.isEmpty()) {
            Logger.writeToLogFile("DATABASE: Can not add problem that is already there");
            readAll();
            return false;
        }
        String sql = "INSERT INTO eulersolutions (problemNumber, problemSolution) "
                + "VALUES ('" + eulerSolution.getProblemNumber()
                + "', '" + eulerSolution.getProblemSolution()
                + "')";
        try {
            return statement.executeUpdate(sql) == 1;
        } catch (SQLException ex) {
            Logger.writeToLogFile("DATABASE: Could not update table");
            return false;
        } finally {
            readAll();
        }
    }
    
    public boolean insert(String problemNumber, String problemSolution) {
        readByProblemNumber(problemNumber);
        if (!eulerSolutions.isEmpty()) {
            readAll();
            return false;
        }
        String sql = "INSERT INTO eulersolutions (problemNumber, problemSolution) "
                + "VALUES ('" + problemNumber
                + "', '" + problemSolution
                + "')";
        try {
            return statement.executeUpdate(sql) == 1;
        } catch (SQLException ex) {
            Logger.writeToLogFile("DATABASE: Could not update table");
            return false;
        } finally {
            readAll();
        }
    }
    
    public boolean deleteProblemNumber(String problemNumber) {
        String sql = "DELETE FROM eulersolutions WHERE problemNumber=?";
        try {
            PreparedStatement prep = getConnection().prepareStatement(sql);
            prep.setString(1, problemNumber);
            return prep.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.writeToLogFile("DATABASE: Could not delete from table");
            return false;
        } finally {
            readAll();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public DbConnection getDbConnection() {
        return dbConnection;
    }
}
