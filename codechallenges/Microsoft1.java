package codechallenges;

import java.util.HashMap;
import java.util.Map;

// Challenge
// Given an integer array A[], find the number of elements in the array for which A[i] = number of times A[i] occurs 
// in the array. For example, if A[] = [2,2,4,5,3,3,3] we need to return 2. The number 2 occurs 2 times and 3 occurs 
// 3 times and hence the answer is 2.
class Microsoft1 {
    public static int solution(int[] input) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i: input) {
            int count = map.getOrDefault(i, 0) + 1;
            map.put(i,  count);
        }


        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey() == entry.getValue()) {
                res += 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("Solution: " + solution(new int[]{2,2,4,4,4,4,5,3,3,3}));
    }
}