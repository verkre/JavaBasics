package jbcourseproject.actions.eulerproblems;

/**
 * EulerProblem sub-menu item/action: Compute and print the result of problem 4.
 */
public class Ep4 extends EulerProblem {

    private static final int inputNumber = 3;
    
    public Ep4() {
        super("Problem 4", "Largest palindrome product (Problem 4)", "https://projecteuler.net/problem=4");
    }

    @Override
    public long solve() {
        return this.findLargestPalindromeProduct(inputNumber);
    }

    @Override
    public void execute() {
        System.out.println("\nThe largest palindrome number made from the product of two 3-digit numbers is " + this.getSolution());
        printUrl();
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
        return "...";
    }

    @Override
    public void setInputNumber(Long newInputNumber) {
        System.out.println("not possible.");
    }

    @Override
    public String getSolutionString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
