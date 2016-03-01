/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseprojectprimes.actions.eulerproblems;

import courseprojectprimes.PrimesHelper;

public class Ep3 extends EulerProblem {

    public Ep3() {
    }

    @Override
    protected String giveDescription() {
        return "Largest prime factor of 600851475143 (Problem 3)";
    }
    
    @Override
    public long solve() {
        return PrimesHelper.findLargestPrimeFactor(600851475143L);
    }
    

    @Override
    public void execute() {
        System.out.println("\nThe largest prime factor of 600851475143 is " + this.getSolution() + ".");
    }

}
