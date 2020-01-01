package leetcode107_BinaryTreeLevelOrderTraversalII;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import utils.TreeNode;

public class Solution {

  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
   * right; TreeNode(int x) { val = x; } }
   */
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    if(root == null) return new ArrayList<>();

    Queue<TreeNode> queue = new ArrayDeque<>();
    LinkedList<List<Integer>> result = new LinkedList<>();

    queue.add(root);
    int count;
    TreeNode current;
    while (!queue.isEmpty()) {

      count = queue.size();
      List<Integer> resultForALevel = new ArrayList<>();
      while (count > 0) {
        current = queue.poll();
        resultForALevel.add(current.val);

        if (current.left != null) queue.add(current.left);
        if (current.right != null) queue.add(current.right);

        count--;
      }
      result.addFirst(resultForALevel);
    }

    return result;
  }
}
