/*
 https://projecteuler.net/problem=4

 Find the largest palindrome made from the product of two 3-digit numbers.
 correct answer: 906609
 */
package jbcourseproject.actions.eulerproblems;

public class Ep4 extends EulerProblem {

    public Ep4() {
        super("Largest palindrome product (Problem 4)");
    }

//    @Override
//    public String describeSelf() {
//        return "Largest palindrome product (Problem 4)";
//    }

    @Override
    public String giveUrl() {
        return "https://projecteuler.net/problem=4";
    }

    @Override
    public long solve() {
        return this.findLargestPalindromeProduct(3);
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

}
