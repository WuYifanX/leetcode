# Leetcode

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.


# Solution

1. Solution1: dp速度慢;因为dp的定义不对.
2. 正确答案在Solution2: 其中dp[i] 表示前i个的结尾的最大子序列合


```java
package leetcode53_MaximumSubarray;

public class Solution {
  public int maxSubArray(int[] nums) {

    int result = Integer.MIN_VALUE;

    if (nums.length == 0) return 0;
    if (nums.length == 1) return nums[0];

    // i, j is from index i to index j;
    int[] dp = new int[nums.length];

    for (int i = 0; i < nums.length; i++) {
      for (int j = i; j < nums.length; j++) {
        if (i == j) {
          dp[j] = nums[i];
        } else {
          dp[j] = dp[j - 1] + nums[j];
        }
        result = Math.max(dp[j], result);
      }
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
  }
}

```


```java
package leetcode53_MaximumSubarray;

public class Solution2 {
  public int maxSubArray(int[] nums) {

    if (nums.length == 0) return 0;
    if (nums.length == 1) return nums[0];

    // dp[i] 表示前i个的结尾的最大子序列合
    int[] dp = new int[nums.length];

    int result = nums[0];
    dp[0] = nums[0];

    for (int i = 1; i < nums.length; i++) {
      dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
      result = Math.max(result, dp[i]);
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(new Solution2().maxSubArray(new int[] {-2, -1}));
  }
}

```
