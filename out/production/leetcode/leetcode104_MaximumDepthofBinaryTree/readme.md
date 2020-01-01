# Leetcode

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.



# Solution

```java
package leetcode104_MaximumDepthofBinaryTree;

import utils.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public int maxDepth(TreeNode root) {

    if (root == null) {
      return 0;
    }

    int leftDepth = 1;
    int rightDepth = 1;

    if (root.right != null) {
      rightDepth = maxDepth(root.right) + 1;
    }
    if (root.left != null) {
      leftDepth = maxDepth(root.left) + 1;
    }

    return Math.max(rightDepth, leftDepth);
  }
}

```
