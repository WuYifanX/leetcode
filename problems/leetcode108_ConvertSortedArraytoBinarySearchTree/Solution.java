package leetcode108_ConvertSortedArraytoBinarySearchTree;

import utils.TreeNode;

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
