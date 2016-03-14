/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbcourseproject.database;

import java.sql.*;
import java.util.*;

/**
 *
 * @author Vera Kreuter
 */


public class EulerSolutionsConnector {
    
    Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private List<EulerSolution> eulerSolutions;
    
    public EulerSolutionsConnector(Connection connection) {
        try {
            this.connection = connection;
            statement = connection.createStatement();
        } catch (SQLException ex) {
            System.out.print("in ESC constructor -->");
            System.out.println(ex);
        }
        
        eulerSolutions = new ArrayList<>();
    }
    
    public void readAll() {
        read("SELECT * FROM `eulersolutions`");
    }
    
    public void readByProblemNumber(String problemNumber) {
        read("SELECT * FROM `eulersolutions` WHERE problemNumber=" + problemNumber);
    }

    
    private void read(String sql) {
        // use prepared statement here?
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
            System.out.print("in ESC.read(String) method -->");
            System.out.println(ex);
        }            
    }
    
    public List<EulerSolution> getEulerSolutions() {
        return new ArrayList<>(eulerSolutions);
    }
    
    public String getSolutionForProblem(String problemNumber) {
        readByProblemNumber(problemNumber);
        if (eulerSolutions.isEmpty()) {
            return null;
        } else {
            return eulerSolutions.get(0).getProblemSolution();
        }
    }

    public boolean insert(EulerSolution eulerSolution) {
        readByProblemNumber(eulerSolution.getProblemNumber());
        if (!eulerSolutions.isEmpty()) {
            System.out.println("this problem is already in the DB");
            readAll();
            return false;
            // if there is already an entry with that number, do not insert another one
        }
        String sql = "INSERT INTO eulersolutions (problemNumber, problemSolution) "
                + "VALUES ('" + eulerSolution.getProblemNumber()
                + "', '" + eulerSolution.getProblemSolution()
                + "')";
        
        try {
            return statement.executeUpdate(sql) == 1;
        } catch (SQLException ex) {
            System.out.print("in ESC insert method -->");
            System.out.println(ex);
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
            System.out.print("in ESC insert method -->");
            System.out.println(ex);
            return false;
        } finally {
            readAll();
        }
    }
    
    // TODO do I even need this? If yes: use prepared statement to prevent SQL injection?
//    public boolean update(EulerSolution eulerSolution) {
//        if (eulerSolution.getUid() == 0) {
//            return false;
//        }
//        // TODO why?
//        
//        String sql = "UPDATE eulersolutions SET "
//                + "problemNumber = '" + eulerSolution.getProblemNumber()+ "', "
//                + "problemSolution = '" + eulerSolution.getProblemSolution()+ "', "
//                + "WHERE uid = '" + eulerSolution.getUid() + "'";
//
//        try {
//            return statement.executeUpdate(sql) == 1;
//        } catch (SQLException ex) {
//            System.out.println(ex);
//            return false;
//        } finally {
//            readAll();
//        }
//    }
    
    public boolean deleteProblemNumber(String problemNumber) {
        
        String sql = "DELETE FROM eulersolutions WHERE problemNumber=?";
        
        try {
            PreparedStatement prep = connection.prepareStatement(sql);
            prep.setString(1, problemNumber);
            return prep.executeUpdate() == 1;

        } catch (SQLException ex) {
            System.out.print("in ESC delete method --> ");
            System.out.println(ex);
            return false;
        
        } finally {
            readAll();
        }
    }
}
