package eulerproblems;



public class EulerProblemsHelper {
    
    // compute the greatest common divisor of p and q
    // this method is copied from http://introcs.cs.princeton.edu/java/23recursion/BinaryGCD.java.html
    public static int gcd(int p, int q) {
        if (q == 0) return p;
        if (p == 0) return q;

        // p and q even
        if ((p & 1) == 0 && (q & 1) == 0) return gcd(p >> 1, q >> 1) << 1;

        // p is even, q is odd
        else if ((p & 1) == 0) return gcd(p >> 1, q);

        // p is odd, q is even
        else if ((q & 1) == 0) return gcd(p, q >> 1);

        // p and q odd, p >= q
        else if (p >= q) return gcd((p-q) >> 1, q);

        // p and q odd, p < q
        else return gcd(p, (q-p) >> 1);
    }

}