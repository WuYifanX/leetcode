package leetcode113_PathSumII;

import java.util.ArrayList;
import java.util.List;
import utils.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  private List<List<Integer>> result;

  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    if (root == null) return new ArrayList<>();

    result = new ArrayList<>();

    pathSum(root, sum, new ArrayList<>());
    return result;
  }

  private void pathSum(TreeNode node, int sum, List<Integer> path) {
    if (node.left == null && node.right == null) {
      if (sum == node.val) {
        path.add(node.val);
        result.add(path);
      }
      return;
    }

    if (node.left != null && sum - node.val > 0) {
      List<Integer> lefts = new ArrayList<>(path);
      lefts.add(node.val);
      pathSum(node.left, sum - node.val, lefts);
    }
    if (node.left != null && sum - node.val > 0) {
      List<Integer> rights = new ArrayList<>(path);
      rights.add(node.val);
      pathSum(node.right, sum - node.val, rights);
    }
  }
}
