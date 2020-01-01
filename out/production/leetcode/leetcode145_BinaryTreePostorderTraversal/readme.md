# Leetcode

Given a binary tree, return the postorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]

```
   1
    \
     2
    /
   3

```
Output: [3,2,1]
Follow up: Recursive solution is trivial, could you do it iteratively?


# Solution

```java

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

```
