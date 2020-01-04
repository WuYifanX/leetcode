package leetcode235_LowestCommonAncestorOfABinarySearchTree;

import utils.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) return null;

    TreeNode current = root;
    int larger = Math.max(p.val, q.val);
    int smaller = Math.min(p.val, q.val);

    while (current != null) {
      if (current.val >= smaller && current.val <= larger) {
        return current;
      }

      if (current.val >= larger) {
        current = current.left;
        continue;
      }

      if (current.val <= smaller) {
        current = current.right;
      }
    }

    return current;
  }
}
