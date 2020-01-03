# Leetcode

Given a complete binary tree, count the number of nodes.

Note:

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

```
Example:

Input: 
    1
   / \
  2   3
 / \  /
4  5 6

Output: 6

```

# Solution

1. 递归的求数量, 但是并没有使用到完全二叉树的这个概念.

2. 使用完全二叉树的概念的解法Solution2: 
计算左子树的最矮高度何右子树的最矮高度, 如果相等说明满足 2^n -1;
计算不相等, 那么就是1 + 左子树的数量 + 右子树的数量.
因为完全二叉树肯定可以找到一个节点能够满足公式计算出来的.能够简化计算.


```java
package leetcode222_CountCompleteTreeNodes;

import utils.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public int countNodes(TreeNode root) {
    if (root == null) return 0;

    return countNodes(root.right) + countNodes(root.left) + 1;
  }
}

```


```java
package leetcode222_CountCompleteTreeNodes;

import utils.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution2 {
  public int countNodes(TreeNode root) {
    if (root == null) return 0;

    TreeNode rightCursor = root.right;
    int rightHeight = 1;
    while (rightCursor != null) {
      rightHeight++;
      rightCursor = rightCursor.right;
    }

    TreeNode leftCursor = root.left;
    int leftHeight = 1;
    while (leftCursor != null) {
      leftHeight++;
      leftCursor = leftCursor.left;
    }

    if (leftHeight == rightHeight) {
      return (int) Math.pow(2, leftHeight) - 1;
    } else {
      return countNodes(root.left) + countNodes(root.right) + 1;
    }
  }

  private int getHeight(TreeNode root) {
    if (root == null) return 0;
    return 1 + Math.min(getHeight(root.left), getHeight(root.right));
  }
}

```
