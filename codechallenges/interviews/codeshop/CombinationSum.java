package codechallenges.interviews.codeshop;

import java.util.*;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates1 = {2, 3, 6, 7};
        System.out.println("sol: " + combinationSum(candidates1, 7) + ", expected: [[2, 2, 3], [7]]");

        int[] candidates2 = {2, 3, 5};
        System.out.println("sol: " + combinationSum(candidates2, 8) + ", expected: [[2, 2, 2, 2], [2, 3, 3], [3, 5]]");

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(result, new ArrayList<>(), candidates, target, 0);

        return result;
    }

    public static void backtrack(List<List<Integer>> result, List<Integer> temp, int[] candidates, int remain, int start) {
        if (remain == 0) {
            result.add(new ArrayList<>(temp));
        } else if (remain > 0){
            for (int i = start; i < candidates.length; i++) {
                temp.add(candidates[i]);
                backtrack(result, temp, candidates, remain - candidates[i], i);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
