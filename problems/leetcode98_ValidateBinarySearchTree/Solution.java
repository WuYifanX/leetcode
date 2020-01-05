package leetcode98_ValidateBinarySearchTree;

import utils.TreeNode;

public class Solution {
  public boolean isValidBST(TreeNode root) {
    if (root == null) return true;

    return isValidBSTForNode(root);
  }

  private boolean isValidBSTForNode(TreeNode node) {
    if (node == null) return true;
    if (node.left == null && node.right == null) return true;

    if (node.left != null) {
      if (findMax(node.left) >= node.val) {
        return false;
      }
    }

    if (node.right != null) {
      if (findMin(node.right) <= node.val) {
        return false;
      }
    }

    return isValidBSTForNode(node.right) && isValidBSTForNode(node.left);
  }

  private int findMax(TreeNode node) {
    if (node.right == null) {
      return node.val;
    }
    return findMax(node.right);
  }

  private int findMin(TreeNode node) {
    if (node.left == null) return node.val;
    return findMin(node.left);
  }
}
