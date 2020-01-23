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

//
// [[2,6],[7,9]]
//    [15,18]
