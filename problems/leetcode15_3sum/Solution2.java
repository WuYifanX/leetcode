package leetcode15_3sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 继续超时
class Solution2 {
  public List<List<Integer>> threeSum(int[] nums) {
    Map<Integer, Integer> countMaps = new HashMap<>();
    List<List<Integer>> res = new ArrayList<>();
    for (int num : nums) {
      countMaps.put(num, countMaps.getOrDefault(num, 0) + 1);
    }

    int target;
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        target = 0 - (nums[i] + nums[j]);
        countMaps.put(nums[i], countMaps.get(nums[i]) - 1);
        countMaps.put(nums[j], countMaps.get(nums[j]) - 1);
        if (countMaps.containsKey(target) && countMaps.get(target) != 0) {
          System.out.print(i);
          System.out.print(j);
          System.out.println();
          int[] a= new int[]{nums[i], nums[j], target};
          Arrays.sort(a);
          res.add(Arrays.asList(a[0], a[1], a[2]));
        }
        countMaps.put(nums[i], countMaps.get(nums[i]) + 1);
        countMaps.put(nums[j], countMaps.get(nums[j]) + 1);
      }
    }
    return deleteDuplicateArray(res);
  }

  // 完成双重List去重;
  private List<List<Integer>> deleteDuplicateArray(List<List<Integer>> origin) {
    List<List<Integer>> result = new ArrayList<>();

    origin.forEach(
        list -> {
          if (!listAlreadyExist(result, list)) {
            result.add(list);
          }
        });
    return result;
  }

  private boolean listAlreadyExist(List<List<Integer>> result, List<Integer> newList) {
    for (List<Integer> integers : result) {
      if (isSameList(newList, integers)) {
        return true;
      }
    }
    return false;
  }

  private int getHash(List<Integer> list) {
    int hash = 0;
    for (int i = 0; i < list.size(); i++) {
      hash += Math.pow(7, i) * list.get(i);
    }
    return hash;
  }

  private boolean isSameList(List<Integer> list1, List<Integer> list2) {
    if (getHash(list1) != getHash(list2)) {
      return false;
    }
    for (int i = 0; i < list1.size(); i++) {
      if (!list1.get(i).equals(list2.get(i))) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    int[] a = new int[] {-1, 0, 1, 2, -1, -4};
    new Solution2().threeSum(a);
  }
}
