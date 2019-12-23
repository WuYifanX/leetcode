# Leetcode

Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

Example: 

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.
Follow up:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n). 

# Thoughts:

1. 连续subarray就想到了动态滑动窗.
2. 注意退出的条件.

# Solution1:

1. 双指针, 一定要知道每个指针定义的是什么, 每个循环代表什么. 每一个循环代表什么

```java

package leetcode209_MinimumSizeSubarraySum;

public class Solution {

  public int minSubArrayLen(int s, int[] nums) {
    if (nums.length == 0) {
      return 0;
    }

    int sum = nums[0], minCount = nums.length + 1;
    int leftCursor = 0, rightCursor = 0;

    while (true) {

      // 增加长度 仅仅是在sum不够 并且还没有达到 nums.length -1
      while (sum < s && rightCursor < nums.length - 1) {
        rightCursor++;
        sum += nums[rightCursor];
      }

      // 减少长度, 仅仅在sum足够 并且还没有达到length -1的时候
      while (sum >= s && leftCursor < nums.length - 1) {
        minCount = Math.min(minCount, rightCursor - leftCursor + 1);
        sum -= nums[leftCursor];
        leftCursor++;
      }

      if ((sum < s && rightCursor == nums.length - 1)
          || (sum >= s && leftCursor == nums.length - 1)) {
        break;
      }
    }

    return minCount == nums.length + 1 ? 0 : minCount;
  }

  public static void main(String[] args) {
    //    int[] inputs = new int[] {1, 2, 3, 4, 5};
    int[] inputs = new int[] {1, 4, 4};
    System.out.println(new Solution().minSubArrayLen(4, inputs));
  }
}

```
