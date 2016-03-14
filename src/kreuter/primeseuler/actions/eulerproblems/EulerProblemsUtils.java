package kreuter.primeseuler.actions.eulerproblems;


/**
 * This class contains helper methods to efficiently determine the greatest common divisor of two numbers
 * and to generate Pythagorean triples and return their sum.
 * Specific for the use in the solution of the 75th problem from projecteuler.
 */
public final class EulerProblemsUtils {
    
    private EulerProblemsUtils() {}
    
    /**
     * Efficiently computes the greatest common divisor of two integers using bit-shifting operations.
     * This method is copied from http://introcs.cs.princeton.edu/java/23recursion/BinaryGCD.java.html
     * @param p an integer
     * @param q an integer
     * @return the greatest common divisor of p and q
     */
    public static int greatestCommonDivisor(int p, int q) {
        if (q == 0) return p;
        if (p == 0) return q;

        // p and q even
        if ((p & 1) == 0 && (q & 1) == 0) return greatestCommonDivisor(p >> 1, q >> 1) << 1;

        // p is even, q is odd
        else if ((p & 1) == 0) return greatestCommonDivisor(p >> 1, q);

        // p is odd, q is even
        else if ((q & 1) == 0) return greatestCommonDivisor(p, q >> 1);

        // p and q odd, p >= q
        else if (p >= q) return greatestCommonDivisor((p-q) >> 1, q);

        // p and q odd, p < q
        else return greatestCommonDivisor(p, (q-p) >> 1);
    }

    /**
     * An implementation of an algorithm that generates Pythagorean triples from three positive integers.
     * @param m an integer
     * @param n an integer
     * @param k an integer
     * @return the sum of a Pythagorean triple generated from the three arguments
     */
    public static int generatePythagoreanTripleSum(int m, int n, int k) {
        int a = k * (m * m - n * n);
        int b = k * (2 * m * n);
        int c = k * (m * m + n * n);
        return a + b + c;
    }

}