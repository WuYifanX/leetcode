# Leetcode

Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

```

Example 1:

Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true
Example 2:

Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false
Example 3:

Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

Output: false
```


# Solution


1. 递归很容易解决
2. 如果不用递归, 可以尝试层序遍历, 然后每层都有一个标记 比如说1|-2|3|.(这里-表示换行了), 反正想一个序列化的方法, 然后生成出来再对比
```java

package leetcode100_SameTree;

import utils.TreeNode;

public class Solution {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if (p != null && q != null && p.val == q.val) {
      return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    return false;
  }
}

```
