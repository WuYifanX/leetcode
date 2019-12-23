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
