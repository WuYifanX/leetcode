# Leetcode

Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

```
Example:

Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

```


# Solution

1. 递归: 还是考虑区间来划分:
当 ` n=3 ` 的时候, 可以按1, 2, 3为root节点来分别建立树. 假如你用1来作为root, 
那么你左子树可以用null来构建, 右子树可以用[2,3]来构建. 然后这是一个递归的过程.
然后构建出来了之后, 组合拼装起来就可以了.

2. DP: 基本上所有的递归都能写成dp. 这里的话, 需要理解的是, 在你计算[99, 100]的时候, 
你可以借用[1, 2]的结构, 然后在基础之上增加一个offset.

参考答案: https://leetcode-cn.com/problems/unique-binary-search-trees-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-2-7/

```java
package leetcode95_UniqueBinarySearchTreesII;

import java.util.ArrayList;
import java.util.List;
import utils.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {

  private List<TreeNode> result = new ArrayList<>();

  public List<TreeNode> generateTrees(int n) {
    if (n == 0) return result;
    if (n == 1) {
      result.add(new TreeNode(1));
      return result;
    }

    return generateTreeHelper(1, n);
  }

  private List<TreeNode> generateTreeHelper(int left, int right) {
    List<TreeNode> result = new ArrayList<>();
    if (left > right) {
      result.add(null);
      return result;
    }

    if (left == right) {
      result.add(new TreeNode(left));
      return result;
    }

    TreeNode currentNode;
    List<TreeNode> leftList, rightList;
    for (int i = left; i <= right; i++) {
      leftList = generateTreeHelper(left, i - 1);
      rightList = generateTreeHelper(i + 1, right);
      for (TreeNode leftElement : leftList) {
        for (TreeNode rightElement : rightList) {
          currentNode = new TreeNode(i);
          currentNode.left = leftElement;
          currentNode.right = rightElement;
          result.add(currentNode);
        }
      }
    }
    return result;
  }
}

```


```java
package leetcode95_UniqueBinarySearchTreesII;

import java.util.ArrayList;
import java.util.List;
import utils.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution2 {

  public List<TreeNode> generateTrees(int n) {
    List<TreeNode>[] dp = new ArrayList[n + 1];
    dp[0] = new ArrayList();
    if (n == 0) return dp[0];

    dp[0].add(null);
    for (int i = 1; i <= n; i++) {
      dp[i] = new ArrayList<>();
      for (int j = 1; j <= i; j++) {
        int leftLength = j - 1; // 左子树长度
        int rightLength = i - j; // 右子树的长度

        for (TreeNode leftElement : dp[leftLength]) {
          for (TreeNode rightElement : dp[rightLength]) {

            TreeNode currentRoot = new TreeNode(j);
            currentRoot.left = leftElement;
            currentRoot.right = clone(rightElement, j);

            dp[i].add(currentRoot);
          }
        }
      }
    }
    return dp[n];
  }

  private TreeNode clone(TreeNode n, int offset) {
    if (n == null) return null;

    TreeNode root = new TreeNode(n.val + offset);
    root.left = clone(n.left, offset);
    root.right = clone(n.right, offset);
    return root;
  }
}

```
