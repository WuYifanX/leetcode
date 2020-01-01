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
class Solution {

  public class TreeNodeWithLevel {
    public int level;
    public TreeNode node;

    public TreeNodeWithLevel(TreeNode node, int level) {
      this.node = node;
      this.level = level;
    }
  }

  public List<List<Integer>> levelOrder(TreeNode root) {

    List<List<Integer>> result = new ArrayList<>();
    Queue<TreeNodeWithLevel> queue = new ArrayDeque<>();

    if (root == null) {
      return new ArrayList<>();
    }
    queue.add(new TreeNodeWithLevel(root, 0));

    TreeNodeWithLevel current;
    while (!queue.isEmpty()) {
      current = queue.poll();

      if (result.size() < current.level + 1) {
        result.add(new ArrayList<>());
      }

      result.get(current.level).add(current.node.val);

      if (current.node.left != null)
        queue.add(new TreeNodeWithLevel(current.node.left, current.level + 1));
      if (current.node.right != null)
        queue.add(new TreeNodeWithLevel(current.node.right, current.level + 1));
    }

    return result;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(0);
    root.right = root;
    root.left = root;
    new Solution().levelOrder(root);
  }
}
