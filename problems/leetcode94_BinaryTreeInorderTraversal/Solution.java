package leetcode94_BinaryTreeInorderTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import utils.TreeNode;

public class Solution {
  public List<Integer> inorderTraversal(TreeNode root) {
    if (root == null) return new ArrayList<>();

    Deque<TreeNode> stack = new ArrayDeque<>();
    List<Integer> result = new ArrayList<>();

    TreeNode current = root;
    while (current != null || !stack.isEmpty()) {

      while (current != null) {
        stack.push(current);
        current = current.left;
      }

      current = stack.pop();
      result.add(current.val);
      current = current.right;
    }

    return result;
  }
}
