package leetcode95_UniqueBinarySearchTreesII;

import java.util.ArrayList;
import java.util.List;
import utils.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution2 {

  public List<TreeNode> generateTrees(int n) {
    List<TreeNode>[] dp = new ArrayList[n + 1];
    dp[0] = new ArrayList();
    if (n == 0) return dp[0];

    dp[0].add(null);
    for (int i = 1; i <= n; i++) {
      dp[i] = new ArrayList<>();
      for (int j = 1; j <= i; j++) {
        int leftLength = j - 1; // 左子树长度
        int rightLength = i - j; // 右子树的长度

        for (TreeNode leftElement : dp[leftLength]) {
          for (TreeNode rightElement : dp[rightLength]) {

            TreeNode currentRoot = new TreeNode(j);
            currentRoot.left = leftElement;
            currentRoot.right = clone(rightElement, j);

            dp[i].add(currentRoot);
          }
        }
      }
    }
    return dp[n];
  }

  private TreeNode clone(TreeNode n, int offset) {
    if (n == null) return null;

    TreeNode root = new TreeNode(n.val + offset);
    root.left = clone(n.left, offset);
    root.right = clone(n.right, offset);
    return root;
  }
}
