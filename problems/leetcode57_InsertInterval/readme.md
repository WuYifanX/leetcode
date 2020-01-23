# Leetcode

Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

```
Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.


```

# Solution


1. 需要考虑3个边界条件:
a. newInterval是第一个
b. newInterval是最后一个
c. newInterval在中间.

```java
package leetcode57_InsertInterval;

import java.util.ArrayList;
import java.util.List;

class Solution {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    if (intervals.length == 0) return new int[][] {newInterval};

    List<int[]> result = new ArrayList<>();
    for (int i = 0; i < intervals.length; ++i) {
      if (newInterval == null) {
        result.add(intervals[i]);
      } else {
        if (intervals[i][1] < newInterval[0]) {
          result.add(intervals[i]);
        } else if (newInterval[1] < intervals[i][0]) {
          result.add(newInterval);
          newInterval = null;
          result.add(intervals[i]);
        } else {
          newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
          newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
        }
      }
    }

    if (newInterval != null) {
      result.add(newInterval);
    }

    return result.toArray(new int[result.size()][2]);
  }
}

```
