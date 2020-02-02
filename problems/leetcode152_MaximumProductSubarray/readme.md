# Leetcode

Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

```
Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

```

# Solution

1. 暴力解法:

```java
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

```

2. 因为会有正负值.
所以有dpMin, dpMax分别来记录.
然后取值只会在三个值之间.
具体可以参考

https://leetcode-cn.com/problems/maximum-product-subarray/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--36/

```java
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

```
