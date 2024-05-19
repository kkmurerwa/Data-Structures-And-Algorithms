package codechallenges.interviews.microsoft;

import java.util.HashSet;

/**
 * There are two candy shops, both of which have N candies for sale. The first shop sells each candy for one golden
 * coin; the second shop sells each candy for one silver coin. You have N/2 golden coins and N/2 silver ones (Nis even).
 * Each candy is of some particular type (not necessarily unique), represented by an integer. What is the maximum number
 * of different types of candy that you can buy?
 * Write a function:
 * class Solution { public int solution (int[] A, int[] B); }
 * that, given two arrays A and B of N integers, representing types of candies in the first and second shop respectively,
 * returns the maximum possible number of different types of candy that you can buy.
 * For example, given:
 * A = [1, 2, 3, 4]
 * B = [3, 3, 3, 71]
 * the function should return 4. You can, for example, buy candies of types 1, 2 in the first shop and then candies of
 * types 3, 7 in the second shop.
 * Given:
 * A = [2, 2, 2, 2, 2, 2]
 * в = [17, 4, 2, 5, 1, 2]
 * the function should also return 4. In the first shop you can only buy candies of type 2, but then you can buy three
 * candies of other types (for example, 7, 4 and 5) in the second shop.
 * Write an efficient algorithm for the following assumptions:
 * Write an efficient algorithm for the following assumptions:
 * * Nis an integer within the range [2.100,000];
 * * N is even;
 * * each element of arrays A and B is an integer within the range (1..1,000,000,000).
 */
public class MaximumNoOfCandies {
    public static void main(String[] args) {
        int[] candiesA1 = {2, 2, 2, 2, 2, 2};
        int[] candiesB1 = {17, 4, 2, 5, 1, 2};

        System.out.println("Maximum number of different types of candies: " + solution(candiesA1, candiesB1));

        int[] candiesA2 = {1, 2, 3, 4};
        int[] candiesB2 = {3, 3, 3, 7};

        System.out.println("Maximum number of different types of candies: " + solution(candiesA2, candiesB2));

        int[] candiesA3 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] candiesB3 = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3};

        System.out.println("Maximum number of different types of candies: " + solution(candiesA3, candiesB3));
    }

    public static int solution(int[] A, int[] B) {
        int maxCandiesA = A.length / 2;
        int maxCandiesB = B.length / 2;

        HashSet<Integer> hashSet1 = new HashSet<>();
        HashSet<Integer> hashSet2 = new HashSet<>();

        for (int k : A) {
            if (hashSet1.size() >= maxCandiesA) break;
            hashSet1.add(k);
        }

        for (int j : B) {
            if (hashSet2.size() >= maxCandiesB) break;
            hashSet2.add(j);
        }

        return hashSet1.size() + hashSet2.size();
    }
}
