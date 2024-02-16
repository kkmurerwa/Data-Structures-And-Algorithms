package codechallenges.leetcode;

public class URLHashing {
    public static void main(String[] args) {
        String url = "https://hello.com";
        String hash = "awpixaia";
        int k = 7;

        getHashedUrl(url, hash, k);
    }

    private static String getHashedUrl(String url, String hash_string, int k) {
        int ascBase = 'a' - 1;

        double portions = (double) url.length() / k;
        int arrLen = (int) Math.ceil(portions);
        int[] keys =  new int[arrLen];

        int count = 0;
        int section = 0;
        int sum = 0;
        for (int i = 0; i < url.length(); i++) {
            if (count == 4) {
                keys[section] = sum % hash_string.length();

                count = 0;
                sum = 0;
                section += 1;
            }

            sum += url.charAt(i) - ascBase;

            count += 1;
        }

        System.out.println("Asc " + ascBase);

        return "";
    }
}
