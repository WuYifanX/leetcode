# Leetcode

Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:
```

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

```
Explanation: All root-to-leaf paths are: 1->2->5, 1->3

# Solution


1. 递归方式来解决

```java
package leetcode257_BinaryTreePaths;

import java.util.ArrayList;
import java.util.List;
import utils.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  private List<String> result;

  public List<String> binaryTreePaths(TreeNode root) {
    if (root == null) return new ArrayList<>();
    result = new ArrayList<>();

    if (root.left == null && root.right == null) {
      result.add(String.valueOf(root.val));
    } else {
      generateTreePath(root, "");
    }
    return result;
  }

  private void generateTreePath(TreeNode node, String s) {
    if (node.right == null && node.left == null) {
      result.add(s + "->" + node.val);
      return;
    }
    if (!s.equals("")) {
      s += "->";
    }
    s += node.val;

    if (node.right != null) {
      generateTreePath(node.right, s);
    }
    if (node.left != null) {
      generateTreePath(node.left, s);
    }
  }
}

```
