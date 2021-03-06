# Leetcode

Find the sum of all left leaves in a given binary tree.

```
Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
```
# Solution

1. 递归, 然后在一定的条件下才能result++;

```java
package leetcode404_SumofLeftLeaves;

import utils.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  private int result = 0;

  public int sumOfLeftLeaves(TreeNode root) {
    if (root == null || (root.left == null && root.right == null)) return result;

    return sumOfLeftLeavesWithoutRoot(root);
  }

  public int sumOfLeftLeavesWithoutRoot(TreeNode node) {
    if (node.left == null && node.right == null) result += node.val;

    if (node.left != null) {
      sumOfLeftLeavesWithoutRoot(node.left);
    }

    if (node.right != null && hasLeftLeaf(node.right)) {
      sumOfLeftLeavesWithoutRoot(node.right);
    }

    return result;
  }

  public boolean hasLeftLeaf(TreeNode node) {
    if (node.left != null) return true;
    if (node.right != null) return hasLeftLeaf(node.right);

    return false;
  }
}

```
