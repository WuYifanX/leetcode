package leetcode222_CountCompleteTreeNodes;

import utils.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public int countNodes(TreeNode root) {
    if (root == null) return 0;

    return countNodes(root.right) + countNodes(root.left) + 1;
  }
}
