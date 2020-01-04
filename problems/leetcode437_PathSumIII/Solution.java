package leetcode437_PathSumIII;

import utils.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  // 计算root开始的sum + 左子树的sum + 右子树的sum;
  public int pathSum(TreeNode root, int sum) {
    if (root == null) return 0;

    int result = 0;

    result += findSumFromNodeToChild(root, sum);
    result += pathSum(root.left, sum);
    result += pathSum(root.right, sum);
    return result;
  }

  // 从node开始寻找sum
  public int findSumFromNodeToChild(TreeNode node, int sum) {
    if (node == null) return 0;

    int result = 0;
    if (node.val == sum) result++;

    result += findSumFromNodeToChild(node.left, sum - node.val);
    result += findSumFromNodeToChild(node.right, sum - node.val);
    return result;
  }
}
