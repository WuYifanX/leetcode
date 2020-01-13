# Leetcode
The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.


```

Example 1:

Input: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \ 
     3   1

Output: 7 
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:

Input: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \ 
 1   3   1

Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.



```
# Solution

1. 暴力破解
2. memo: 
3. 牛逼的通过函数的定义来解决这个问题:见Solution2

```java
package leetcode337_HouseRobberIII;

import java.util.HashMap;
import java.util.Map;
import utils.TreeNode;

class Solution {

  private Map<TreeNode, Integer> memo = new HashMap<>();

  public int rob(TreeNode root) {
    if (root == null) return 0;
    if (root.left == null && root.right == null) return root.val;

    int resultOfRobRoot = root.val;
    int resultOfNotRoot = 0;

    if (memo.containsKey(root)) {
      return memo.get(root);
    }

    // if rob root
    if (root.left != null) {
      resultOfRobRoot += rob(root.left.left) + rob(root.left.right);
    }
    if (root.right != null) {
      resultOfRobRoot += rob(root.right.left) + rob(root.right.right);
    }

    // if not rob root
    if (root.left != null) {
      resultOfNotRoot += rob(root.left);
    }

    if (root.right != null) {
      resultOfNotRoot += rob(root.right);
    }

    memo.put(root, Math.max(resultOfNotRoot, resultOfRobRoot));
    return memo.get(root);
  }
}
```


```java

package leetcode337_HouseRobberIII;

import utils.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */

//
//          3
//         / \
//         2   3
//         \   \
//         3   1

class Solution2 {
  public int rob(TreeNode root) {
    if (root == null) return 0;

    int[] result = dp(root);
    return Math.max(result[0], result[1]);
  }

  // try to rob node, return a array{ not rob this root, rob this root};
  public int[] dp(TreeNode node) {
    if (node == null) return new int[] {0, 0};

    int[] left = dp(node.left);
    int[] right = dp(node.right);

    int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
    int rob = node.val + left[0] + right[0];

    return new int[] {notRob, rob};
  }
}

```
