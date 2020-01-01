# Leetcode
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

```

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]

```

# Solution

1. 当然可以用递归来做, 如果不用递归的话, 那就是有一个数据结构来记录层级. 可以见Solution1
2. 有一个比较巧妙的思路, 就是用一个count来记录这一层剩余的节点数量.

```java

package leetcode102_BinaryTreeLevelOrderTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import utils.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {

  public class TreeNodeWithLevel {
    public int level;
    public TreeNode node;

    public TreeNodeWithLevel(TreeNode node, int level) {
      this.node = node;
      this.level = level;
    }
  }



  public List<List<Integer>> levelOrder(TreeNode root) {

    List<List<Integer>> result = new ArrayList<>();
    Queue<TreeNodeWithLevel> queue = new ArrayDeque<>();
    
    if (root == null) {
      return new ArrayList<>();
    }
    queue.add(new TreeNodeWithLevel(root, 0));

    TreeNodeWithLevel current;
    while (!queue.isEmpty()) {
      current = queue.poll();

      if (result.size() < current.level + 1) {
        result.add(new ArrayList<>());
      }

      result.get(current.level).add(current.node.val);

      if (current.node.left != null)
        queue.add(new TreeNodeWithLevel(current.node.left, current.level + 1));
      if (current.node.right != null)
        queue.add(new TreeNodeWithLevel(current.node.right, current.level + 1));
    }

    return result;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(0);
    root.right = root;
    root.left = root;
    new Solution().levelOrder(root);
  }
}

```

```java

package leetcode102_BinaryTreeLevelOrderTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import utils.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution2 {

  public List<List<Integer>> levelOrder(TreeNode root) {

    List<List<Integer>> result = new ArrayList<>();
    Queue<TreeNode> queue = new ArrayDeque<>();

    if (root == null) {
      return new ArrayList<>();
    }
    queue.add(root);
    int nodesCountLeftInThisDepth;
    TreeNode current;

    while (!queue.isEmpty()) {
      nodesCountLeftInThisDepth = queue.size();
      List<Integer> arrayForThisDepth = new ArrayList<>();

      while (nodesCountLeftInThisDepth > 0) {
        current = queue.poll();
        arrayForThisDepth.add(current.val);
        if (current.left != null) queue.add(current.left);
        if (current.right != null) queue.add(current.right);
        nodesCountLeftInThisDepth--;
      }

      result.add(arrayForThisDepth);
    }

    return result;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(0);
    root.right = root;
    root.left = root;
    new Solution2().levelOrder(root);
  }
}

```
