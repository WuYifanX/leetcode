# Leetcode

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

```
For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
 

But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3
```
 

Note:
Bonus points if you could solve it both recursively and iteratively.


# Solution

1. 递归
2. 层序遍历


```java
package leetcode101_SymmetricTree;

import utils.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public boolean isSymmetric(TreeNode root) {
    if (root == null) return true;

    return isSymmetric(root.left, root.right);
  }

  public boolean isSymmetric(TreeNode node1, TreeNode node2) {
    if (node1 == null && node2 == null) {
      return true;
    }

    if (node1 != null && node2 != null && node1.val == node2.val) {
      return isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);
    }

    return false;
  }
}

```
