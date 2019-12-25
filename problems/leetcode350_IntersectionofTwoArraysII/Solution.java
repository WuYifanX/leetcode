package leetcode350_IntersectionofTwoArraysII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import utils.Logs;

public class Solution {
  public int[] intersect(int[] nums1, int[] nums2) {
    Map<Integer, Integer> maps = new HashMap<>();
    for (int i : nums1) {
      maps.put(i, maps.getOrDefault(i, 0) + 1);
    }

    List<Integer> res = new ArrayList<>();

    for (int j : nums2) {
      if (maps.containsKey(j) && maps.get(j) > 0) {
        res.add(j);
        maps.put(j, maps.get(j) - 1);
      }
    }

    return res.stream().mapToInt(i->i).toArray();
  }

  public static void main(String[] args) {
    Logs.print(new Solution().intersect(new int[] {1, 2, 2, 1}, new int[] {2, 2}));
    Logs.print(new Solution().intersect(new int[] {4, 9, 5}, new int[] {9, 4, 9, 8, 4}));
  }
}
