package leetcode238_ProductofArrayExceptSelf;

class Solution {
  public int[] productExceptSelf(int[] nums) {
    if (nums.length == 0 || nums.length == 1) return nums;

    int[] preMultiplyArray = new int[nums.length];
    int[] postMultiplyArray = new int[nums.length];

    preMultiplyArray[0] = 1;
    for (int i = 1; i < nums.length; i++) {
      preMultiplyArray[i] = preMultiplyArray[i - 1] * nums[i - 1];
    }

    postMultiplyArray[nums.length - 1] = 1;
    for (int i = nums.length - 2; i >= 0; i--) {
      postMultiplyArray[i] = postMultiplyArray[i + 1] * nums[i + 1];
    }

    int[] result = new int[nums.length];

    for (int i = 0; i < nums.length ; i++) {
      result[i] = preMultiplyArray[i] * postMultiplyArray[i];
    }

    return result;
  }
}
