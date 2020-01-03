package leetcode404_SumofLeftLeaves;

import utils.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution2 {
  private int result = 0;
  public int sumOfLeftLeaves(TreeNode root) {
    if(root != null){
      if(root.left!= null && root.left.left == null && root.left.right ==null){
        result += root.left.val;
      }

      sumOfLeftLeaves(root.left);
      sumOfLeftLeaves(root.right);
    }

    return result;
  }
}
