package leetcode102_BinaryTreeLevelOrderTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import utils.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution2 {

  public List<List<Integer>> levelOrder(TreeNode root) {

    List<List<Integer>> result = new ArrayList<>();
    Queue<TreeNode> queue = new ArrayDeque<>();

    if (root == null) {
      return new ArrayList<>();
    }
    queue.add(root);
    int nodesCountLeftInThisDepth;
    TreeNode current;

    while (!queue.isEmpty()) {
      nodesCountLeftInThisDepth = queue.size();
      List<Integer> arrayForThisDepth = new ArrayList<>();

      while (nodesCountLeftInThisDepth > 0) {
        current = queue.poll();
        arrayForThisDepth.add(current.val);
        if (current.left != null) queue.add(current.left);
        if (current.right != null) queue.add(current.right);
        nodesCountLeftInThisDepth--;
      }

      result.add(arrayForThisDepth);
    }

    return result;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(0);
    root.right = root;
    root.left = root;
    new Solution2().levelOrder(root);
  }
}
