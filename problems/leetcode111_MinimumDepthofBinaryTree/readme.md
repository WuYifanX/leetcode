# Leetcode

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

```
Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its minimum depth = 2.

```

# Solution

1. 递归求解: 见Solution
2. 深度优先搜索迭代: 
3. 宽度优先搜索迭代: 层次遍历, 遍历到的第一个子节点, 那就是叶子节点.
```java

package leetcode111_MinimumDepthofBinaryTree;

import utils.TreeNode;

public class Solution {
  public int minDepth(TreeNode root) {
    if (root == null) return 0;
    if (root.left == null && root.right == null) {
      return 1;
    }

    if (root.left != null && root.right != null) {
      return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    if (root.left == null) {
      return minDepth(root.right) + 1;
    }

    return minDepth(root.left) + 1;
  }
}

```
