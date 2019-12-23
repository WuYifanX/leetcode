# Leetcode
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]

# KeyPoint

1. 注意代码的取值意义, 边界条件.
2. 注意某些边界条件的case.

# Solution1:

通过使用双指针, 从尾部开始遍历, 可以不借助辅助空间来完成一次遍历.
