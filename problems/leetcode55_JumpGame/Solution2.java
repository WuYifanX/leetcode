package leetcode55_JumpGame;

class Solution2 {
  public boolean canJump(int[] nums) {
    if (nums.length == 1) return true;
    if (nums[0] == 0) return false;

    int maxLength = 0;
    for (int i = 0; i <= maxLength; i++) {
      maxLength = Math.max(maxLength, i + nums[i]);
      if (maxLength >= nums.length - 1) return true;
    }

    return false;
  }
}
// [2,3,1,1,4]
// [3,2,1,0,4]
