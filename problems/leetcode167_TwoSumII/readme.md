# Leetcode

Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

Note:

Your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you may not use the same element twice.
Example:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.


# Thoughts:


# Solution1:

方法1: 暴力, n^2
方法2: 遍历2次, 第一遍构建hashmap, 第二遍查询.
方法3: 遍历1次, 在遍历i的过程中, 不断的把之前的i放入hashmap, 然后求target. 代码如下:

```java

public class Solution {

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> maps = new HashMap<>(nums.length - 1);

    maps.put(nums[0], 0);
    for (int i = 1; i < nums.length; i++) {
      int neededNumber = target - nums[i];
      if(maps.containsKey(neededNumber)){
        return new int[]{maps.get(neededNumber), i};
      }else {
        maps.put(nums[i], i);
      }
    }
    return null;
  }

  public static void main(String[] args) {
    int[] inputs = new int[] {2, 7, 11, 15};
    int[] result = new Solution().twoSum(inputs, 9);
    Logs.print(result);
  }
}

```
