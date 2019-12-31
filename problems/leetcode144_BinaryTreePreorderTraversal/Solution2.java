package leetcode144_BinaryTreePreorderTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import utils.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution2 {

  public List<Integer> preorderTraversal(TreeNode root) {
    if (root == null) return new ArrayList<>();

    List<Integer> result = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.push(root);

    TreeNode current;
    while (!stack.isEmpty()) {
      current = stack.pop();
      result.add(current.val);
      if (current.right != null) stack.push(current.right);
      if (current.left != null) stack.push(current.left);
    }

    return result;
  }
}
