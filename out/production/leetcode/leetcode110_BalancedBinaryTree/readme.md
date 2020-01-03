# Leetcode

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

 
```

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
 
 ```


# Solution


```java
package leetcode110_BalancedBinaryTree;

import utils.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public boolean isBalanced(TreeNode root) {
    if (root == null) return true;

    return Math.abs(getDepth(root.left) - getDepth(root.right)) <=1 && isBalanced(root.right) && isBalanced(root.left);
  }


  public int getDepth(TreeNode node) {
    if (node == null) {
      return 0;
    }

    return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
  }
}

```
