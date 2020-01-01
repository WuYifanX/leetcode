# Leetcode

Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

```
For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]


```

# Solution

1. 比较简单, 根据奇偶来判断打印个数.

```java
package leetcode103_BinaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import utils.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if (root == null) return null;

    List<List<Integer>> result = new ArrayList<>();
    Queue<TreeNode> queue = new ArrayDeque<>();

    boolean addElementAtBottom = true;
    int count;
    TreeNode current;
    queue.add(root);

    while (!queue.isEmpty()) {
      LinkedList<Integer> resultForALevel = new LinkedList<>();
      count = queue.size();

      while (count > 0) {
        current = queue.poll();

        if (addElementAtBottom) {
          resultForALevel.add(current.val);
        } else {
          resultForALevel.addFirst(current.val);
        }

        if (current.left != null) queue.add(current.left);
        if (current.right != null) queue.add(current.right);

        count--;
      }
      addElementAtBottom = !addElementAtBottom;
      result.add(resultForALevel);
    }
    return result;
  }
}

```

