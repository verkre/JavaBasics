/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kreuter.primeseuler.actions.eulerproblems;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import kreuter.primeseuler.database.EulerSolutionsConnector;
import kreuter.primeseuler.utils.Logger;

/**
 *
 * @author Vera Kreuter
 */
public class Ep67 extends EulerProblem {

    public Ep67() {
        super("67", "Maximum path sum II", "https://projecteuler.net/problem=67");
    }

    public Ep67(EulerSolutionsConnector esc) {
        super("67", "Maximum path sum II", "https://projecteuler.net/problem=67", esc);
    }

    @Override
    public String getInfoText() {
        return "By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.\n"
                + "\n"
                + "3\n"
                + "7 4\n"
                + "2 4 6\n"
                + "8 5 9 3\n"
                + "\n"
                + "That is, 3 + 7 + 4 + 9 = 23.\n"
                + "\n"
                + "Find the maximum total from top to bottom in the file available at https://projecteuler.net/project/resources/p067_triangle.txt, a 15K text file containing a triangle with one-hundred rows."
                + "\n\n"
                + "https://projecteuler.net/problem=67";
    }

    @Override
    public String getSolutionString() {
        if (getSolution() == 0) {
            return "The input file could not be read, sorry.";
        }
        // TODO if there is no DB connection *and* the input file cannot be found or read,
        // 0 is stored as the solution (and this error message will be displayed until the program exits)
        writeToLogFile();
        return "The maximum path sum is " + getSolution() + ".";
    }

    @Override
    public long solve() {
        String inputFilePath = "src/p067_triangle.txt";
        String inputFileUrl = "http://projecteuler.net/project/resources/p067_triangle.txt"; // TODO does not work with https
        List<List<Integer>> inputTriangle;
        try {
            inputTriangle = readInputFileFromURL(inputFileUrl);
//        try {
//            inputTriangle = readInputFile(inputFilePath);
        } catch (FileNotFoundException ex) {
            Logger.writeToLogFile("Input file for problem 67 not found");
            return 0;
        } catch (IOException ex) {
            Logger.writeToLogFile("Could not read input file for problem 67");
            return 0;
        }
        return (long) greedyPathSumSolver(inputTriangle);
    }
    
    public int greedyPathSumSolver(List<List<Integer>> inputTriangle) {
        if (inputTriangle.size() == 1) {
            return inputTriangle.get(0).get(0);
        } else {
            int i = inputTriangle.size()-2;
            for (int j = 0; j < inputTriangle.get(i).size(); j++) {
                int firstChild = inputTriangle.get(i + 1).get(j);
                int secondChild = inputTriangle.get(i + 1).get(j + 1);
                int greaterChild = Math.max(firstChild, secondChild);
                inputTriangle.get(i).set(j, inputTriangle.get(i).get(j) + greaterChild);
            }
            inputTriangle.remove(inputTriangle.size() - 1);
            return greedyPathSumSolver(inputTriangle);
        }
    }
    
    public List<List<Integer>> readInputFile(String inputFilePath) throws FileNotFoundException, IOException {
        List<List<Integer>> inputTriangle = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            while ((line = br.readLine()) != null) {
                String[] lineArray = line.split(" ");
                ArrayList<Integer> lineArrayInts = new ArrayList<>();
                for (String intString : lineArray) {
                    int nextInt = Integer.parseInt(intString);
                    lineArrayInts.add(nextInt);
                }
                inputTriangle.add(lineArrayInts);
            }
        }
        return inputTriangle;
    }
    
    public List<List<Integer>> readInputFileFromURL(String url) throws FileNotFoundException, IOException {
        List<List<Integer>> inputTriangle = new ArrayList<>();
        String line;
        URL inputUrl = new URL(url);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputUrl.openStream()))) {
            while ((line = br.readLine()) != null) {
                String[] lineArray = line.split(" ");
                ArrayList<Integer> lineArrayInts = new ArrayList<>();
                for (String intString : lineArray) {
                    int nextInt = Integer.parseInt(intString);
                    lineArrayInts.add(nextInt);
                }
                inputTriangle.add(lineArrayInts);
            }
        }
        return inputTriangle;
    }
    
    
}
