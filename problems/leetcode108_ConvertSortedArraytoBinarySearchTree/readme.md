# Leetcode

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

```
Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5

```
# Solution

1. 最容易想到的就是二分法来生产bst.
```java
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public TreeNode sortedArrayToBST(int[] nums) {
    if (nums.length == 0) return null;

    return buildBST(nums, 0, nums.length - 1);
  }

  private TreeNode buildBST(int[] nums, int start, int end) {
    if (start == end) {
      return new TreeNode(nums[start]);
    }
    if (start > end) return null;
    int middleIndex = start + (end - start) / 2;
    TreeNode root = new TreeNode(nums[middleIndex]);
    root.left = buildBST(nums, start, middleIndex - 1);
    root.right = buildBST(nums, middleIndex + 1, end);
    return root;
  }
}

```
