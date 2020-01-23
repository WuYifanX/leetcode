# Leetcode

Given a collection of intervals, merge all overlapping intervals.

```
Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.


```

# Solution

```java
package leetcode56_MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public int[][] merge(int[][] intervals) {
    if (intervals.length == 1 || intervals.length == 0) return intervals;

    List<int[]> tempResult = new ArrayList<>();

    Arrays.sort(
        intervals,
        (a, b) -> {
          if (a[0] == b[0]) {
            return a[1] - b[1];
          }
          return a[0] - b[0];
        });

    int[] temp = intervals[0];

    for (int i = 1; i < intervals.length; i++) {

      if (temp[1] >= intervals[i][0]) {
        temp = new int[] {temp[0], Math.max(temp[1], intervals[i][1])};
      } else {
        tempResult.add(temp);
        temp = intervals[i];
      }
    }

    tempResult.add(temp);

    int[][] result = new int[tempResult.size()][2];
    for (int i = 0; i < tempResult.size(); i++) {
      result[i] = tempResult.get(i);
    }

    return result;
  }
}

```
