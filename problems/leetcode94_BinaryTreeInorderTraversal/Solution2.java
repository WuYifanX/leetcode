package leetcode94_BinaryTreeInorderTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import utils.TreeNode;

public class Solution2 {

  public class Command {
    public String command;
    public TreeNode node;

    public Command(String command, TreeNode node) {
      this.command = command;
      this.node = node;
    }
  }

  public List<Integer> inorderTraversal(TreeNode root) {
    if (root == null) return new ArrayList<>();

    Deque<Command> stack = new ArrayDeque<>();
    List<Integer> result = new ArrayList<>();
    stack.push(new Command("go", root));

    Command current;
    while (!stack.isEmpty()) {
      current = stack.pop();

      if (current.command.equals("print")) {
        result.add(current.node.val);
      } else {
        if (current.node.right != null) stack.push(new Command("go", current.node.right));
        stack.push(new Command("print", current.node));
        if (current.node.left != null) stack.push(new Command("go", current.node.left));
      }
    }

    return result;
  }
}
