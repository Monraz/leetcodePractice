package may;

import java.util.*;
import java.util.stream.Collectors;

public class LargestRectangleInHistogramV1 {
    /*
     * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
     * return the area of the largest rectangle in the histogram.*/

    public int largestRectangleArea(int[] heights) {
        /*
        * 1.Initialize an integer at zero, this is will be the output.
        * 2.Create a new array with the values sorted from highest to lowest.
        * 3.For each value of the sorted array, traverse the input array and do the following:
        *   -Initialize a counter at 0.
        *   -If a value is equal or greater than the current value from the sorted array, increment counter by 1
        *   -For each next value that is greater or equal than the current sorted value, keep incrementing the counter.
        *   -Keep traversing and incrementing the counter until a value is lower than the sorted value.
        *       -At that point multiply the counter by the sorted value.
        *       -If this value is greater than the current top rectangle Area, save it as the new top area.
        *       -Reset the counter at zero and continue iterating
        */

        int topRectangleArea = 0;
        List<Integer> sortedHeights = Arrays.stream(heights).boxed().collect(Collectors.toSet()).stream().sorted().toList();

        for (Integer sortedHeight : sortedHeights) {
            int adjacentEqualOrGreaterHeights = 0;
            for (int height : heights) {
                if (height >= sortedHeight) {
                    adjacentEqualOrGreaterHeights++;
                } else {
                    if (adjacentEqualOrGreaterHeights > 0 && (adjacentEqualOrGreaterHeights * sortedHeight) > topRectangleArea) {
                        topRectangleArea = adjacentEqualOrGreaterHeights * sortedHeight;
                    }
                    adjacentEqualOrGreaterHeights = 0;
                }
            }
            if (adjacentEqualOrGreaterHeights > 0 && (adjacentEqualOrGreaterHeights * sortedHeight) > topRectangleArea) {
                topRectangleArea = adjacentEqualOrGreaterHeights * sortedHeight;
            }
        }
        return topRectangleArea;
    }
}
