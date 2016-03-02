/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbcourseproject.actions.eulerproblems;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vera
 */
public class EulerProblemTest {
    
    public EulerProblemTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of isSolved method, of class EulerProblem.
     */
    @Test
    public void testIsSolved() {
        System.out.println("isSolved");
        EulerProblem instance = new EulerProblemImpl();
        boolean expResult = false;
        boolean result = instance.isSolved();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of solve method, of class EulerProblem.
     */
    @Test
    public void testSolve() {
        System.out.println("solve");
        EulerProblem instance = new EulerProblemImpl();
        long expResult = 0L;
        long result = instance.solve();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSolution method, of class EulerProblem.
     */
    @Test
    public void testGetSolution() {
        System.out.println("getSolution");
        EulerProblem instance = new EulerProblemImpl();
        long expResult = 0L;
        long result = instance.getSolution();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class EulerProblemImpl extends EulerProblem {

        public long solve() {
            return 0L;
        }

        @Override
        protected String giveDescription() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void execute() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
}
