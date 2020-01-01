# Leetcode

Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

```
Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
```


# Solution

1. 在层序遍历过程中, 有一个count计算每个层的数量还是很重要的. 基本上层次遍历都会用到.

```java
package leetcode199_BinaryTreeRightSideView;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import utils.TreeNode;

public class Solution {
  public List<Integer> rightSideView(TreeNode root) {
    if (root == null) return new ArrayList<>();
    TreeNode current;
    List<Integer> result = new ArrayList<>();
    Queue<TreeNode> queue = new ArrayDeque<>();

    queue.add(root);
    int count;
    while (!queue.isEmpty()) {
      count = queue.size();
      int lastNumberOfLevel = 0;

      while (count > 0) {
        current = queue.poll();
        lastNumberOfLevel = current.val;

        if (current.left != null) queue.add(current.left);
        if (current.right != null) queue.add(current.right);

        count--;
      }
      result.add(lastNumberOfLevel);
    }
    return result;
  }
}

```
