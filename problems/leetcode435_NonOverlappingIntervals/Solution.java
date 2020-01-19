package leetcode435_NonOverlappingIntervals;

import java.util.Arrays;

class Solution {
  public int eraseOverlapIntervals(int[][] intervals) {
    if (intervals.length == 0 || intervals.length == 1) return 0;

    Arrays.sort(
        intervals,
        (o1, o2) -> {
          if (o1[o1.length - 1] != o2[o2.length - 1]) return o1[o1.length - 1] - o2[o2.length - 1];

          return o1[0] - o2[0];
        });

    int result = 1;

    int prevDifferentFirstElementIndex = 0;
    for (int i = 1; i < intervals.length; i++) {
      int[] prev = intervals[prevDifferentFirstElementIndex];
      // current first element is equal or bigger than prev LastElement.
      if (intervals[i][0] >= prev[prev.length - 1]) {
        prevDifferentFirstElementIndex = i;
        result++;
      }
    }
    return intervals.length - result;
  }
}
