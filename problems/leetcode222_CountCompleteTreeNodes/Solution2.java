package leetcode222_CountCompleteTreeNodes;

import utils.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution2 {
  public int countNodes(TreeNode root) {
    if (root == null) return 0;

    TreeNode rightCursor = root.right;
    int rightHeight = 1;
    while (rightCursor != null) {
      rightHeight++;
      rightCursor = rightCursor.right;
    }

    TreeNode leftCursor = root.left;
    int leftHeight = 1;
    while (leftCursor != null) {
      leftHeight++;
      leftCursor = leftCursor.left;
    }

    if (leftHeight == rightHeight) {
      return (int) Math.pow(2, leftHeight) - 1;
    } else {
      return countNodes(root.left) + countNodes(root.right) + 1;
    }
  }

  private int getHeight(TreeNode root) {
    if (root == null) return 0;
    return 1 + Math.min(getHeight(root.left), getHeight(root.right));
  }
}
