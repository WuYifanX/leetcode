package leetcode337_HouseRobberIII;

import java.util.HashMap;
import java.util.Map;
import utils.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */

//
//          3
//         / \
//         2   3
//         \   \
//         3   1

class Solution {

  private Map<TreeNode, Integer> memo = new HashMap<>();

  public int rob(TreeNode root) {
    if (root == null) return 0;
    if (root.left == null && root.right == null) return root.val;

    int resultOfRobRoot = root.val;
    int resultOfNotRoot = 0;

    if (memo.containsKey(root)) {
      return memo.get(root);
    }

    // if rob root
    if (root.left != null) {
      resultOfRobRoot += rob(root.left.left) + rob(root.left.right);
    }
    if (root.right != null) {
      resultOfRobRoot += rob(root.right.left) + rob(root.right.right);
    }

    // if not rob root
    if (root.left != null) {
      resultOfNotRoot += rob(root.left);
    }

    if (root.right != null) {
      resultOfNotRoot += rob(root.right);
    }

    memo.put(root, Math.max(resultOfNotRoot, resultOfRobRoot));
    return memo.get(root);
  }
}
