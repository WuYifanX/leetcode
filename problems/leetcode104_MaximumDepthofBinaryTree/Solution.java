package leetcode104_MaximumDepthofBinaryTree;

import utils.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public int maxDepth(TreeNode root) {

    if (root == null) {
      return 0;
    }

    int leftDepth = 1;
    int rightDepth = 1;

    if (root.right != null) {
      rightDepth = maxDepth(root.right) + 1;
    }
    if (root.left != null) {
      leftDepth = maxDepth(root.left) + 1;
    }

    return Math.max(rightDepth, leftDepth);
  }
}
