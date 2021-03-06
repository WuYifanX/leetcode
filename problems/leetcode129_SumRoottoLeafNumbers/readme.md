# Leetcode

Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.

```
Example:

Input: [1,2,3]
    1
   / \
  2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
Example 2:

Input: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.


```

# Solution

```java
package leetcode129_SumRoottoLeafNumbers;

import java.util.ArrayList;
import java.util.List;
import utils.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  List<Integer> result;

  public int sumNumbers(TreeNode root) {
    if (root == null) return 0;
    result = new ArrayList<>();

    sumNumbers(root, 0);

    int sum = 0;
    for (int value : result) {
      sum += value;
    }
    return sum;
  }

  public void sumNumbers(TreeNode node, int val) {
    if (node.left == null && node.right == null) {
      result.add(val * 10 + node.val);
      return;
    }

    if (node.left != null) {
      sumNumbers(node.left, val * 10 + node.val);
    }

    if (node.right != null) {
      sumNumbers(node.right, val * 10 + node.val);
    }
  }
}

```
