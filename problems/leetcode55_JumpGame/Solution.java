package leetcode55_JumpGame;

class Solution {

  private boolean[] isVisited;
  private boolean result;

  public boolean canJump(int[] nums) {
    if (nums.length == 1) return true;

    isVisited = new boolean[nums.length];
    dfs(nums, 0);
    return result;
  }

  private void dfs(int[] nums, int index) {
    if (result) return;

    if (index == nums.length - 1) {
      result = true;
      return;
    }

    isVisited[index] = true;

    for (int i = 1; i <= nums[index]; i++) {
      if (index + i < nums.length && !isVisited[index + i]) {
        dfs(nums, index + i);
      }

      if (index - i >= 0 && !isVisited[index - i]) {
        dfs(nums, index - i);
      }
    }
  }
}
// [2,3,1,1,4]
// [3,2,1,0,4]
