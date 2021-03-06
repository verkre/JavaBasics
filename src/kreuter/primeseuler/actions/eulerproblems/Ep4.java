package kreuter.primeseuler.actions.eulerproblems;

import kreuter.primeseuler.database.EulerSolutionsConnector;

/**
 * EulerProblem sub-menu item/action: Compute and print the result of problem 4.
 */
public class Ep4 extends EulerProblem {

    private static final int inputNumber = 3;
    
    public Ep4() {
        super("4", "Largest palindrome product (Problem 4)", "https://projecteuler.net/problem=4");
    }

    public Ep4(EulerSolutionsConnector esc) {
        super("4", "Largest palindrome product (Problem 4)", "https://projecteuler.net/problem=4", esc);
    }

    @Override
    public long solve() {
        return this.findLargestPalindromeProduct(inputNumber);
    }

    private boolean isPalindromic(int number) {
        String numberString = Integer.toString(number);
        String reverseNumberString = new StringBuilder(numberString).reverse().toString();

        return numberString.equals(reverseNumberString);
    }

    private int findLargestPalindromeProduct(int numberOfDigits) {
        int largestPalindrome = 0;
        for (int i = 1; i < Math.pow(10, numberOfDigits); i++) {
            for (int j = 1; j < Math.pow(10, numberOfDigits); j++) {
                if ((isPalindromic(i * j)) && (i * j > largestPalindrome)) {
                    largestPalindrome = i * j;
                }
            }
        }
        return largestPalindrome;

    }

    @Override
    public String getInfoText() {
        return "A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.\n"
                + "\n"
                + "Find the largest palindrome made from the product of two 3-digit numbers."
                + "\n\n"
                + "https://projecteuler.net/problem=4";
    }

    @Override
    public void setInputNumber(Long newInputNumber) {
        throw new UnsupportedOperationException("This does not take input.");
    }

    @Override
    public String getSolutionString() {
        writeToLogFile();
        return "The largest palindrome number made from the product of two 3-digit numbers is " + this.getSolution() + ".";
    }

}
