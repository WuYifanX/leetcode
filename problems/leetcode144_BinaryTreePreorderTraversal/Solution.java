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
class Solution {

  public class Command {
    String command; // go, print
    TreeNode node;

    public Command(String command, TreeNode node) {
      this.command = command;
      this.node = node;
    }
  }

  public List<Integer> preorderTraversal(TreeNode root) {
    if (root == null) return new ArrayList<>();

    List<Integer> result = new ArrayList<>();
    Deque<Command> stack = new ArrayDeque<>();

    stack.push(new Command("go", root));

    Command currentCommand;
    while (!stack.isEmpty()) {
      currentCommand = stack.pop();

      if (currentCommand.command.equals("print")) {
        result.add(currentCommand.node.val);
      } else {
        if (currentCommand.node.right != null)
          stack.push(new Command("go", currentCommand.node.right));
        if (currentCommand.node.left != null)
          stack.push(new Command("go", currentCommand.node.left));
        stack.push(new Command("print", currentCommand.node));
      }
    }
    return result;
  }
}
