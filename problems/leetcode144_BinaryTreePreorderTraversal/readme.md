# Leetcode

Given a binary tree, return the preorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]

```
   1
    \
     2
    /
   3
```


Output: [1,2,3]
Follow up: Recursive solution is trivial, could you do it iteratively?

# Solution

1. 递归的肯定是最简单的
2. 如果不让的话, 其实用非递归也是能做的
3. 但是最简单的还是使用栈去模拟计算机的行为, 这个能够统一前中后遍历的非递归实现.
4. 如果不用模拟计算机的栈的方法的话, 就普通的使用栈当然也是能做的, 只是说没办法统一前中后序遍历.


模拟计算机递归
```java


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

```

模拟计算机递归
```java
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

```
