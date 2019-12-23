package leetcode1_TwoSum;

import java.util.HashMap;
import java.util.Map;
import utils.Logs;

public class Solution {

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> maps = new HashMap<>(nums.length - 1);

    maps.put(nums[0], 0);
    for (int i = 1; i < nums.length; i++) {
      int neededNumber = target - nums[i];
      if(maps.containsKey(neededNumber)){
        return new int[]{maps.get(neededNumber), i};
      }else {
        maps.put(nums[i], i);
      }
    }
    return null;
  }

  public static void main(String[] args) {
    int[] inputs = new int[] {2, 7, 11, 15};
    int[] result = new Solution().twoSum(inputs, 9);
    Logs.print(result);
  }
}
