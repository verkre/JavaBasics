/*
https://projecteuler.net/problem=4

Find the largest palindrome made from the product of two 3-digit numbers.
correct answer: 906609
*/
package eulerproblems;


public class Ep4 extends EulerProblem {
    
    private int solution;
    private boolean solutionWasComputed;
    public Ep4() {
        this.solutionWasComputed = false;
    }
    
    public boolean isSolved() {
        return this.solutionWasComputed;
    }
    
    public int showSolution() {
        if (this.solutionWasComputed) {
            this.solution = this.findLargestPalindromeProduct(3);
            this.solutionWasComputed = true;
        }
        return this.solution;
    }
    
    public void execute() {
        System.out.println("The largest palindrome number made from the product of two 3-digit numbers is " + this.showSolution());
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
        this.solution = largestPalindrome;
        solutionWasComputed = true;
        return largestPalindrome;
    
    }

    
}