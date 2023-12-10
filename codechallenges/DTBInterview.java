package codechallenges;

import java.util.*;

/**
 * Write a function solution that, given a string S consisting of N characters, returns the alphabetically smallest
 * string that can be obtained by removing exactly one letter from S.
 *
 * Examples:
 * 1. Given S = "acb", by removing one letter, you can obtain "ac", "ab" or "cb". Your function should return
 * "ab" (after removing 'c) since it is alphabetically smaller than "ac" and "bo".
 * 2. Given S = "hot", your function should return "ho", which is alphabetically smaller than "ht" and "ot".
 * 3. Given S = "codility", your function should return "edility", which can be obtained by removing
 * the second letter.
 * 4. Given S = "aaaa", your function should return aaa". Any occurrence of 'a' can be removed.
 */
public class DTBInterview {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            println("Please enter a word or type q to quit");
            String inputStr = scanner.nextLine();

            if (inputStr.equals("q") || inputStr.equals("Q")) {
                break;
            }

            println("Input: " + inputStr + " Min Str: " + solution2(inputStr));
        }
    }

    public static String solution(String input) {
        StringBuilder stringBuilder = new StringBuilder();

        int max = 0;
        char maxChar = ' ';
        int insertAt = 0;

        for (int i = 0; i < input.length(); i ++) {
            char temp = input.charAt(i);
            if (max < (int) temp) {
                if (i != 0) {
                    stringBuilder.insert(insertAt, maxChar);
                }
                maxChar = temp;
                max = temp;
                insertAt = i;
            } else {
                stringBuilder.append(temp);
            }
        }

        return stringBuilder.toString();
    }

    public static String solution2(String input) {
        StringBuilder stringBuilder = new StringBuilder();

        for (char ch: input.toCharArray()) {
            stringBuilder.append(ch);
        }

        List<String> toCheck = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            String curr = stringBuilder.substring(0,i) + stringBuilder.substring(i + 1,input.length());

            toCheck.add(curr);
        }

        return poc(toCheck);
    }

    public static String poc(List<String> strings) {
        HashMap<String, Integer> map = new HashMap<>();

        int aAsc = 'a' - 1;
        long minInt = Long.MAX_VALUE;
        String minStr = "";
        for (String str: strings) {
            int val = 1;
            for (char ch: str.toCharArray()) {
                int value = (ch - aAsc);
                val = (val * 10) + value;
            }

            if (val < minInt) {
                minInt = val;
                minStr = str;
            }

            map.put(str, val);
        }

        println("HashMap: " + map);

        return minStr;
    }

    public static void println(Object object) {
        System.out.println(object);
    }
}
