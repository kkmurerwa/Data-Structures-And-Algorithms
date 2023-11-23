package codechallenges;
import java.util.Stack;

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
