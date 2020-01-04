package leetcode129_SumRoottoLeafNumbers;

import java.util.ArrayList;
import java.util.List;
import utils.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  List<Integer> result;

  public int sumNumbers(TreeNode root) {
    if (root == null) return 0;
    result = new ArrayList<>();

    sumNumbers(root, 0);

    int sum = 0;
    for (int value : result) {
      sum += value;
    }
    return sum;
  }

  public void sumNumbers(TreeNode node, int val) {
    if (node.left == null && node.right == null) {
      result.add(val * 10 + node.val);
      return;
    }

    if (node.left != null) {
      sumNumbers(node.left, val * 10 + node.val);
    }

    if (node.right != null) {
      sumNumbers(node.right, val * 10 + node.val);
    }
  }
}
