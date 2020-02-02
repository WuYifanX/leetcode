package leetcode152_MaximumProductSubarray;

class Solution {
  public int maxProduct(int[] nums) {
    if (nums.length == 0) return 0;

    int result = nums[0];
    int productTemp;
    for (int i = 0; i < nums.length; i++) {
      productTemp = nums[i];
      for (int j = i; j < nums.length; j++) {
        if (i != j) {
          productTemp *= nums[j];
        }
        result = Math.max(result, productTemp);
        if (productTemp == 0) {
          break;
        }
      }
    }
    return result;
  }
}
