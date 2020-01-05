# Leetcode

You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
```

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11

```

# Solution

1. 因为不需要一定从root开始. 那么就有2种情况:
  a. 就是从root开始, 寻找sum的路径.(方法名是findSumFromNodeToChild)
  b. 从root.left, root.right开始, 寻找sum的路径(这个过程又包括了2个过程, 方法是pathSum). 


```java
package leetcode437_PathSumIII;

import utils.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  // 计算root开始的sum + 左子树的sum + 右子树的sum;
  public int pathSum(TreeNode root, int sum) {
    if (root == null) return 0;

    int result = 0;

    result += findSumFromNodeToChild(root, sum);
    result += pathSum(root.left, sum);
    result += pathSum(root.right, sum);
    return result;
  }

  // 从node开始寻找sum
  public int findSumFromNodeToChild(TreeNode node, int sum) {
    if (node == null) return 0;

    int result = 0;
    if (node.val == sum) result++;

    result += findSumFromNodeToChild(node.left, sum - node.val);
    result += findSumFromNodeToChild(node.right, sum - node.val);
    return result;
  }
}

```
