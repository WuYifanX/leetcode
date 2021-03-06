package leetcode15_3sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 这个solution的bug在于说
// 需要最后从 List<List<Integer>>去重.
// 但是这个答案超时了.
public class Solution {

  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);

    List<List<Integer>> res = new ArrayList<>();
    int target;
    int searchResult;
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        target = 0 - (nums[i] + nums[j]);
        searchResult = binarySearchInNums(target, nums, j + 1, nums.length - 1);
        if (searchResult != -1) {
          res.add(Arrays.asList(nums[i], nums[j], searchResult));
        }
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

  // find target in [start, end];
  private int binarySearchInNums(int target, int[] nums, int start, int end) {
    if (start > end) {
      return -1;
    }
    int middleIndex = (end - start + 1) / 2 + start;
    int middleValue = nums[middleIndex];

    if (target == middleValue) {
      return middleValue;
    }

    if (middleValue > target) {
      return binarySearchInNums(target, nums, start, middleIndex - 1);
    } else {
      return binarySearchInNums(target, nums, middleIndex + 1, end);
    }
  }

  public static void main(String[] args) {
    int[] a = new int[] {-1, 0, 1, 2, -1, -4};
    new Solution().threeSum(a);
  }
}

