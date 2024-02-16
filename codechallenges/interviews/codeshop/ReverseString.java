package codechallenges.interviews.codeshop;

import java.util.Arrays;
import java.util.Stack;

import static sidequests.TicTacToe.println;

public class ReverseString {
    public static void main(String[] args) {
        String s1 = "  hello world  ";
        println("\nsol1: " + solution2(s1) + ", expected: world hello");
        println("sol1: " + solution(s1) + ", expected: world hello");

        String s2 = "a good   example";
        println("\nsol2: " + solution2(s2) + ", expected: example good a");
        println("sol2: " + solution(s2) + ", expected: example good a");

        String s3 = "  Bob    Loves  Alice   ";
        println("\nsol3: " + solution2(s3) + ", expected: Alice Loves Bob");
        println("sol3: " + solution(s3) + ", expected: Alice Loves Bob");

        String s4 = "Alice does not even like bob";
        println("\nsol4: " + solution2(s4) + ", expected: bob like even not does Alice");
        println("sol4: " + solution(s4) + ", expected: bob like even not does Alice");
    }

    public static String solution(String s) {
        // Pre-process the string by removing leading and trailing spaces
        s = s.trim();

        // Split the string into words
        String[] words = s.split(" ");

        // Reverse the words using a stack
        Stack<String> stack = new Stack<>();

        for (String word : words) {
            if (!word.trim().isEmpty()) {
                stack.push(word);
            }
        }

        // Create a new string by popping the words from the stack
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
            sb.append(" ");
        }

        return sb.toString().trim();
    }

    public static String solution2(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == ' ' && sb.length() > 0) {
                stack.push(sb.toString());
                sb.setLength(0);
            } else if (curr != ' ') {
                sb.append(s.charAt(i));
            }
        }

        if (sb.length() > 0) {
            stack.push(sb.toString());
            sb.setLength(0);
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
            sb.append(" ");
        }

        return sb.toString().trim();
    }
}
