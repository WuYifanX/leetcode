# Leetcode

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).
```

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
```


# Solution

参考思路:
将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。
此时有序部分用二分法查找。
无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。就这样循环.




```java
package leetcode33_SearchInRotatedSortedArray;

class Solution {
  public int search(int[] nums, int target) {
    if (nums.length == 0) return -1;
    return partialBinarySearch(nums, 0, nums.length - 1, target);
  }

  private int partialBinarySearch(int[] nums, int start, int end, int target) {
    if (start > end) return -1;
    if (start == end) return nums[start] == target ? start : -1;

    int middle = start + (end - start) / 2;
    if (nums[middle] == target) return middle;

    int partResult1;
    int partResult2;
    if (nums[start] < nums[middle]) {
      partResult1 = binarySearch(nums, start, middle - 1, target);
    } else {
      partResult1 = partialBinarySearch(nums, start, middle - 1, target);
    }

    if (nums[middle] < nums[end]) {
      partResult2 = binarySearch(nums, middle + 1, end, target);
    } else {
      partResult2 = partialBinarySearch(nums, middle + 1, end, target);
    }

    if (partResult1 != -1) {
      return partResult1;
    } else if (partResult2 != -1) {
      return partResult2;
    }

    return -1;
  }

  private int binarySearch(int[] nums, int start, int end, int target) {
    if (start > end) {
      return -1;
    }
    if (start == end) return nums[start] == target ? start : -1;
    if (target > nums[end] || target < nums[start]) return -1;

    int middle = start + (end - start) / 2;
    if (nums[middle] == target) return middle;

    if (nums[middle] > target) {
      return binarySearch(nums, start, middle - 1, target);
    } else {
      return binarySearch(nums, middle + 1, end, target);
    }
  }

  public static void main(String[] args) {
    System.out.println(new Solution().search(new int[] {1, 3}, 0));

  }
}

```
