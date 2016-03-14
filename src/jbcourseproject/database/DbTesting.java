/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbcourseproject.database;

/**
 *
 * @author Vera Kreuter
 */
public class DbTesting {
    
    private DbConnection dbConnection;
    private EulerSolutionsConnector esc;
    private EulerSolution currentES;
    
    
    public static void main(String[] args) {
        new DbTesting().go();
    }
    
    public void go() {
//        dbConnection = new DbConnection();
//        
//        if (dbConnection.isConnected()) {
//            esc = new EulerSolutionsConnector(dbConnection.getConnection());
//            esc.readAll();
//        } else {
//            System.out.println("keine Verbindung");
//            System.exit(0);
//        }
//        
//        System.out.println(esc.getEulerSolutions());
//        
//        currentES = new EulerSolution("3", "12345");
//        esc.insert(currentES);
//        System.out.println(esc.getEulerSolutions());
//        
//        currentES = new EulerSolution("3", "12345");
//        esc.insert(currentES);
//        System.out.println(esc.getEulerSolutions());
//        
//        currentES = new EulerSolution("4", "435345");
//        esc.insert(currentES);
//        System.out.println(esc.getEulerSolutions());
//        
//        esc.deleteProblemNumber("3");
//        System.out.println(esc.getEulerSolutions());
//        
//        esc.insert("5", "34545");
//        System.out.println(esc.getEulerSolutions());

    }
}
