package codechallenges;

public class KamauInterview {
    public static void main(String[] args) {
        System.out.println(solution("codility") + " should be codilit");
        System.out.println(solution("aaaaa") + " should be aaaa");
        System.out.println(solution("acb") + " should be ab");
        System.out.println(solution("hot") + " should be ho");
        System.out.println(solution("curlyfries") + " should be curlfries");
        System.out.println(solution("ggffgztyuhfr") + " should be ggffgtyuhfr");
        System.out.println(solution("john") + " should be jhn");
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
}
