# Leetcode

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

```
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
```

# Solution

https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-by-leetcode/

首先得找到第一个`nums[i] < nums[i-1]`, 然后找到第一个这样, 开始遍历这个i, 找到小于i的最接近的来和i换.
换完了之后, 再把

```java
package leetcode31_NextPermutation;

import java.util.Arrays;
import utils.Logs;

class Solution {
  public void nextPermutation(int[] nums) {
    if (nums.length == 0 || nums.length == 1) return;

    int swapIndex;
    for (swapIndex = nums.length - 2; swapIndex >= 0; swapIndex--) {
      if (nums[swapIndex + 1] > nums[swapIndex]) {
        break;
      }
    }

    if (swapIndex == -1) {
      Arrays.sort(nums);
      return;
    }

    int firstBigger = -1;
    for (int i = swapIndex + 1; i < nums.length; i++) {
      if (nums[swapIndex] < nums[i]) {
        if (firstBigger == -1 || nums[i] < nums[firstBigger]) firstBigger = i;
      }
    }

    int temp = nums[firstBigger];
    nums[firstBigger] = nums[swapIndex];
    nums[swapIndex] = temp;

    Arrays.sort(nums, swapIndex + 1, nums.length);
  }
}

```

