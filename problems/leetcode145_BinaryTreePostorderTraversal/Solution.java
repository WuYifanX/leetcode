package leetcode145_BinaryTreePostorderTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import utils.TreeNode;

public class Solution {
  public class Command {
    public String command;
    public TreeNode node;

    public Command(String command, TreeNode node) {
      this.command = command;
      this.node = node;
    }
  }

  public List<Integer> postorderTraversal(TreeNode root) {
    if (root == null) return new ArrayList<>();

    List<Integer> result = new ArrayList<>();
    Deque<Command> stack = new ArrayDeque<>();

    stack.push(new Command("go", root));

    Command current;
    while (!stack.isEmpty()) {
      current = stack.pop();

      if (current.command.equals("print")) {
        result.add(current.node.val);
      } else {
        stack.push(new Command("print", current.node));
        if (current.node.right != null) {
          stack.push(new Command("go", current.node.right));
        }
        if (current.node.left != null) {
          stack.push(new Command("go", current.node.left));
        }
      }
    }
    return result;
  }
}
