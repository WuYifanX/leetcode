# Leetcode

A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is trivially a wiggle sequence.

For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and negative. In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its first two differences are positive and the second because its last difference is zero.

Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence. A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence, leaving the remaining elements in their original order.

Example 1:

Input: [1,7,4,9,2,5]
Output: 6
Explanation: The entire sequence is a wiggle sequence.
Example 2:

Input: [1,17,5,10,13,15,10,5,16,8]
Output: 7
Explanation: There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].
Example 3:

Input: [1,2,3,4,5,6,7,8,9]
Output: 2
Follow up:
Can you do it in O(n) time?


# Solution

Solution1: 计算波峰和波谷的数量:
```java
package leetcode376_WiggleSubsequence;

class Solution {
  public int wiggleMaxLength(int[] nums) {
    if (nums.length <= 1) return nums.length;

    // 计算波峰波谷的个数.
    boolean isIncreasing = true;
    boolean init = true;
    int count = 0;
    for (int i = 1; i < nums.length; i++) {
      if (init) {
        if (nums[i] - nums[i - 1] < 0) {
          isIncreasing = false;
        }
        if (nums[i] != nums[i - 1]) {
          init = false;
          count++;
        }
      } else {
        if (nums[i] - nums[i - 1] > 0 && !isIncreasing) {
          isIncreasing = true;
          count++;
        }
        if (nums[i] - nums[i - 1] < 0 && isIncreasing) {
          isIncreasing = false;
          count++;
        }
      }
    }
    return count + 1;
  }
}

```


2. DP:

比较典型的动态规划题（一般来说，涉及最大最小等极值的情况，都可以朝动态规划去靠，再一个就考虑目标问题是否可以由子问题推导）
本题中，状态转移方程可以考虑为dp[n]表示数组中到第n个数字的最长摆动序列长度，那么这个序列最后一个差值就可能是负数或者正数两种情况，所以一维的状态转移方程不能清楚的表示子问题的状态，需要再加一个维度，dp[n][m]，m表示最后一个差值的状态，0表示为负数，1表示为正数，那么状态转移方程就出来了
差值为负数
dp[n][0] = max(dp[n-1][1]+1, dp[n-1][0]);
差值为正数
dp[n][1] = max(dp[n-1][0]+1, dp[n-1][1]);
当差值为0时，维持上一个数的状态，即:
dp[n][0] = dp[n-1][0];
dp[n][1] = dp[n-1][1];

注意一点就是由于是两个数的差值，我们这里只算了一个数，所以后面需要把第一个数加进来，可以在dp初始化时全部置为1，也可以在循环中处理一下，还可以在最后加上（本题采用的是这种方法），反正意思理解了就行

```java
class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums == null || nums.length < 2) {
			return nums == null ? 0 : nums.length;
		}
		int[][] dp = new int[nums.length+1][2];
		
		for(int i=1; i<nums.length; i++) {
			if(nums[i] - nums[i-1] > 0) {
				dp[i+1][1] = Math.max(dp[i][0]+1, dp[i][1]);
			}else if(nums[i] - nums[i-1] < 0) {
				dp[i+1][0] = Math.max(dp[i][1]+1, dp[i][0]);
			}else {
				dp[i+1][1] = dp[i][1];
				dp[i+1][0] = dp[i][0];
			}
		}
		return Math.max(dp[dp.length-1][1], dp[dp.length-1][0])+1;
    }
}

```

作者：meitianxiaoyixiao
链接：https://leetcode-cn.com/problems/wiggle-subsequence/solution/javashi-xian-chao-guo-100-by-meitianxiaoyixiao/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
