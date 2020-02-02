package leetcode152_MaximumProductSubarray;

class Solution2 {
  public int maxProduct(int[] nums) {
    if (nums.length == 0) return 0;

    // 以i为结尾的最大值;
    int[] dpMax = new int[nums.length];
    // 以i为结尾的最小值;
    int[] dpMin = new int[nums.length];
    dpMax[0] = nums[0];
    dpMin[0] = nums[0];
    int result = dpMax[0];

    for (int i = 1; i < nums.length; i++) {
      dpMax[i] = Math.max(dpMin[i - 1] * nums[i], Math.max(dpMax[i - 1] * nums[i], nums[i]));
      dpMin[i] = Math.min(dpMin[i - 1] * nums[i], Math.min(dpMax[i - 1] * nums[i], nums[i]));
      result = Math.max(result, dpMax[i]);
    }

    return result;
  }

  public static void main(String[] args) {
    int[] a = new int[] {-1, -2, -9, -6};
    System.out.println(new Solution2().maxProduct(a));
  }
}
