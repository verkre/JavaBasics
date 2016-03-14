/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kreuter.primeseuler.database;

/**
 *
 * @author Vera Kreuter
 */
public class EulerSolution {
    
    private int uid;
    private String problemNumber;
    private String problemSolution;
    
    public EulerSolution() {
        
    }
    
    public EulerSolution(int uid, String problemNumber, String problemSolution) {
        this.uid = uid;
        this.problemNumber = problemNumber;
        this.problemSolution = problemSolution;
    }
    
    public EulerSolution(String problemNumber, String problemSolution) {
        this (0, problemNumber, problemSolution);
    }

    public int getUid() {
        return uid;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getProblemNumber() {
        return problemNumber;
    }

    public void setProblemNumber(String problemNumber) {
        this.problemNumber = problemNumber;
    }

    public String getProblemSolution() {
        return problemSolution;
    }

    public void setProblemSolution(String problemSolution) {
        this.problemSolution = problemSolution;
    }
    
    @Override
    public String toString() {
        return "Problem " + problemNumber + "/ Solution is " + problemSolution;
    }
}
