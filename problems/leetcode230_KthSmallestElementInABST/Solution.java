package leetcode230_KthSmallestElementInABST;

import utils.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  private boolean isFound = false;
  private int k;
  private int result;

  public int kthSmallest(TreeNode root, int k) {
    if (root == null) return 0;
    this.k = k;
    inorderTraversal(root);
    return result;
  }

  private void inorderTraversal(TreeNode node) {
    if (isFound) return;
    if (node.left != null) {
      inorderTraversal(node.left);
    }
    k--;
    if (k == 0) {
      result = node.val;
      isFound = true;
    }

    if (node.right != null) {
      inorderTraversal(node.right);
    }
  }
}
