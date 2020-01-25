# Leetcode

Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

```
Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3


```

# Solution

1. 参考
https://leetcode-cn.com/problems/unique-binary-search-trees/solution/bu-tong-de-er-cha-sou-suo-shu-by-leetcode/

主要是如何推理出递推表达式:
本问题可以用动态规划求解。

给定一个有序序列 1 ... n，为了根据序列构建一棵二叉搜索树。我们可以遍历每个数字 i，将该数字作为树根，1 ... (i-1) 序列将成为左子树，(i+1) ... n 序列将成为右子树。于是，我们可以递归地从子序列构建子树。
在上述方法中，由于根各自不同，每棵二叉树都保证是独特的。


```java
class Solution {
  public int numTrees(int n) {
    if (n == 0 || n == 1) return n;

    // dp[i]表示i的全部的个数.
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    dp[2] = 2;

    for (int i = 3; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        dp[i] += dp[j - 1] * dp[i - j];
      }
    }

    return dp[n];
  }
}

```
