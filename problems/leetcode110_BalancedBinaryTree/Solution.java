package leetcode110_BalancedBinaryTree;

import utils.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public boolean isBalanced(TreeNode root) {
    if (root == null) return true;

    return Math.abs(getDepth(root.left) - getDepth(root.right)) <=1 && isBalanced(root.right) && isBalanced(root.left);
  }


  public int getDepth(TreeNode node) {
    if (node == null) {
      return 0;
    }

    return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
  }
}
