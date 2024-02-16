package codechallenges.interviews.safaricom;

import java.util.Arrays;
import java.util.Collections;

/**
 * You are given a string S made of N digits that represents a positive integer.
 * Among all positive integers smaller than S, find the one with the maximum possible sum of digits.
 * Write a function:
 * class Solution { public String solution (String S); }
 * that, given a string S, returns a string representing a positive integer smaller than S with the maximum possible sum of digits. If there is more than one such integer, return any of them. The returned string can only consist of digits and may not contain leading zeros.
 * Examples:
 * 1. Given S = "899", one of the possible correct answers is "898".
 * 2. Given S = "10", the only possible correct answer is "9".
 * 3. Given S = "98", the only possible correct answer is "89".
 * Write an efficient algorithm for the following assumptions:
 * • N is an integer within the range [2.. 100,000);
 * • string S is made only of digits (0-9);
 * • S does not contain leading zeros.
 */
public class MaximumMinimumDigit {
    public static void main(String[] args) {
        int n1 = 98;
        System.out.println("sol1: " + solution(n1) + "\nexpected: 89");

        int n2 = 765;
        System.out.println("sol2: " + solution(n2) + "\nexpected: 675");

        int n3 = 43212;
        System.out.println("sol3: " + solution(n3) + "\nexpected: 34221");

        int n4 = 899;
        System.out.println("sol4: " + solution(n4) + "\nexpected: 898");

        int n5 = 10;
        System.out.println("sol5: " + solution(n5) + "\nexpected: 9");
    }

    public static int solution(int n) {
        System.out.println("\ninput: " + n);
        // Convert the number to a string array
        String[] digits = String.valueOf(n).split("");

        // Sort the array in descending order
        Arrays.sort(digits, Collections.reverseOrder());

        // Swap the first and second elements
        String temp = digits[0];
        digits[0] = digits[1];
        digits[1] = temp;

        // Join the array into a string and convert it back to an integer
        String str = String.join("", digits);

        if (str.charAt(0) == '0') {
            return n-1;
        }

        int res = Integer.parseInt(str);
        if (res > n) {
            return n - 1;
        } else {
            return res;
        }
    }
}
