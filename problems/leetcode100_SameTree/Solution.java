package leetcode100_SameTree;

import utils.TreeNode;

public class Solution {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if (p != null && q != null && p.val == q.val) {
      return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    return false;
  }
}
