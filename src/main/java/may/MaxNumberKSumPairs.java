package may;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/max-number-of-k-sum-pairs/?envType=study-plan-v2&envId=leetcode-75
public class MaxNumberKSumPairs {

    public static int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> foundValuesCounterMap = new HashMap<>();
        int operations = 0;
        for (int num : nums) {
            int missingPair = k - num;

            if (foundValuesCounterMap.containsKey(missingPair)) {
                operations++;
                int valueCounter = foundValuesCounterMap.get(missingPair);
                if (valueCounter == 1) {
                    foundValuesCounterMap.remove(missingPair);
                } else {
                    foundValuesCounterMap.put(missingPair, valueCounter - 1);
                }
            } else {
                if (foundValuesCounterMap.containsKey(num)) {
                    foundValuesCounterMap.put(num, foundValuesCounterMap.get(num) + 1);
                } else {
                    foundValuesCounterMap.put(num, 1);
                }
            }
        }
        return operations;
    }

    public static void main(String[] args) {
        // Initializing a 2D array that represents an apartment building
        String s1 = "abc";
        String s2 = "ahbgdc";
        int[] nums = {1,4,2,3};
        int maxOperations = maxOperations(nums, 5);
        System.out.println("The maximum number of operations is: " + maxOperations);
    }
}
