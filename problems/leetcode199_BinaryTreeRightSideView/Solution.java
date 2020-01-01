package leetcode199_BinaryTreeRightSideView;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import utils.TreeNode;

public class Solution {
  public List<Integer> rightSideView(TreeNode root) {
    if (root == null) return new ArrayList<>();
    TreeNode current;
    List<Integer> result = new ArrayList<>();
    Queue<TreeNode> queue = new ArrayDeque<>();

    queue.add(root);
    int count;
    while (!queue.isEmpty()) {
      count = queue.size();
      int lastNumberOfLevel = 0;

      while (count > 0) {
        current = queue.poll();
        lastNumberOfLevel = current.val;

        if (current.left != null) queue.add(current.left);
        if (current.right != null) queue.add(current.right);

        count--;
      }
      result.add(lastNumberOfLevel);
    }
    return result;
  }
}
