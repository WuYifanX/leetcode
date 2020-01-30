package leetcode169_MajorityElement;

class Solution2 {
  public int majorityElement(int[] nums) {
    int candidate = nums[0];
    int count = 1;

    for (int i = 1; i < nums.length; i++) {
      if (count == 0) {
        count = 1;
        candidate = nums[i];
        continue;
      }


      count += nums[i] == candidate ? 1 : -1;
    }

    return candidate;
  }
}
