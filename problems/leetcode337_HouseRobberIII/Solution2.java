package leetcode337_HouseRobberIII;

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

class Solution2 {
  public int rob(TreeNode root) {
    if (root == null) return 0;

    int[] result = dp(root);
    return Math.max(result[0], result[1]);
  }

  // try to rob node, return a array{ not rob this root, rob this root};
  public int[] dp(TreeNode node) {
    if (node == null) return new int[] {0, 0};

    int[] left = dp(node.left);
    int[] right = dp(node.right);

    int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
    int rob = node.val + left[0] + right[0];

    return new int[] {notRob, rob};
  }
}
