# Leetcode

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 
```


Example 1:

    2
   / \
  1   3

Input: [2,1,3]
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.

```

# Solution

1. 比较tricky的点在于说, 对于一个BST的验证是验证其节点大于左子树的最大树 && 小于右子树的最小点.
而不是仅仅的去判断大于右子树何小于左子树而已.

2. 还有就是需要判断, 相等的数字怎么办. 比如说(1,1). 那么这个是不是一个bst呢?

3. 当然也可以判断中序遍历是不是有序的.
```java

package leetcode98_ValidateBinarySearchTree;

import utils.TreeNode;

public class Solution {
  public boolean isValidBST(TreeNode root) {
    if (root == null) return true;

    return isValidBSTForNode(root);
  }

  private boolean isValidBSTForNode(TreeNode node) {
    if (node == null) return true;
    if (node.left == null && node.right == null) return true;

    if (node.left != null) {
      if (findMax(node.left) >= node.val) {
        return false;
      }
    }

    if (node.right != null) {
      if (findMin(node.right) <= node.val) {
        return false;
      }
    }

    return isValidBSTForNode(node.right) && isValidBSTForNode(node.left);
  }

  private int findMax(TreeNode node) {
    if (node.right == null) {
      return node.val;
    }
    return findMax(node.right);
  }

  private int findMin(TreeNode node) {
    if (node.left == null) return node.val;
    return findMin(node.left);
  }
}

```
