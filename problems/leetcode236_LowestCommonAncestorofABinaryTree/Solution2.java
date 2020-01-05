package leetcode236_LowestCommonAncestorofABinaryTree;

import utils.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution2 {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || p == root || q == root) return root;

    TreeNode leftResult = lowestCommonAncestor(root.left, p, q);
    TreeNode rightResult = lowestCommonAncestor(root.right, p, q);

    if (leftResult != null && rightResult != null) return root;

    if (leftResult != null) {
      return leftResult;
    }
    return rightResult;
  }
}
