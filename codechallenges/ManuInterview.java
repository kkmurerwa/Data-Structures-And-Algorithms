package codechallenges;
import java.util.Stack;

// A string s consisting of the letters A, B, C and D is given. The string can be transformed either
// by removing a letter A together with an adjacent letter B or by removing a letter C together with
// an adjacent letter D.
//
// Write a function in Java:
//    class Solution { public String solution (String S); }
//    that, given a string S consisting of N characters, returns any string that:
//    • can be obtained from S by repeatedly applying the described transformation, and
//    • cannot be further transformed.
//    If at some point there is more than one possible way to transform the string, any of the valid transformations may be chosen.
//    Examples:
//    1. Given S = "CBACD", the function may return "C", because one of the possible sequences of h
//    operations is as follows:
//      СВА -> CD -> BA
//    2. Given S = "CABABD" the function may return an empty string, because one possible sequence
//    of operations is:
//      В -> AB -> CD

public class ManuInterview {
    public static void println(Object msg) {
        System.out.println(msg);
    }

    public static String solution(String S) {
        StringBuilder result = new StringBuilder(S);

        boolean transformed;
        do {
            transformed = false;
            for (int i = 0; i < result.length() - 1; i++) {
                char current = result.charAt(i);
                char next = result.charAt(i + 1);

                if ((current == 'A' && next == 'B') || (current == 'B' && next == 'A') || 
                (current == 'C' && next == 'D') || (current == 'D' && next == 'C')) {
                    result.delete(i, i + 2);
                    transformed = true;
                    break;
                }
            }
        } while (transformed);

        return result.toString();
    }

    public static String solution2(String S) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < S.length(); i ++) {
            char curr = S.charAt(i);

            if (!stack.isEmpty()) {
                char prev = stack.peek();
                
                if ((curr == 'A' && prev == 'B') || (curr == 'B' && prev == 'A') || 
                (curr == 'C' && prev == 'D') || (curr == 'D' && prev == 'C')) {
                        stack.pop();
                        continue;
                }
            }

            stack.add(curr);
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }

        return res.toString();
    }

    public static void main(String[] args) {

        // Example 1
        String result1 = solution2("CBACD");
        println(result1 + " - Should be 'C'");  // Output: "C"

        // Example 2
        String result2 = solution2("CABABD");
        println(result2 + " - Should be ''");  // Output: ""
    }
}
