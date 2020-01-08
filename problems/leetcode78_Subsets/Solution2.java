package leetcode78_Subsets;

import java.util.ArrayList;
import java.util.List;

class Solution2 {
  private List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> subsets(int[] nums) {
    if (nums.length == 0) {
      return result;
    }

    result.add(new ArrayList<>());

    for (int i = 0; i < nums.length; i++) {
      int resultSize = result.size();
      for (int j = 0; j < resultSize; j++) {
        List<Integer> temp = new ArrayList<>(result.get(j));
        temp.add(nums[i]);
        result.add(temp);
      }
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(new Solution2().subsets(new int[] {1, 2, 3}));
  }
}
