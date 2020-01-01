# Leetcode
Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
```
   1
    \
     2
    /
   3
```

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?


# Solution

1. 递归确实非常容易.
2. 我们使用模拟调用栈的方式来实现, 见solution2
3. 我们使用栈的方式来实现, 思考过程比较复杂, 见solution.


Solution
```java
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

``` 


Solution2

```java

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

```
