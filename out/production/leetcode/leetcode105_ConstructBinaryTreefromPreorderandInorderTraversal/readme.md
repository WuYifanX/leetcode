# Leetcode
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

```
    3
   / \
  9  20
    /  \
   15   7
```



# Solution

```java
package leetcode105_ConstructBinaryTreefromPreorderandInorderTraversal;

import java.util.Arrays;
import java.util.HashMap;
import utils.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder.length == 0 || inorder.length == 0) return null;

    TreeNode root = new TreeNode(preorder[0]);
    if (preorder.length == 1 || inorder.length == 1) return root;

    HashMap<Integer, Integer> maps = new HashMap<>();

    for (int i = 0; i < inorder.length; i++) {
      maps.put(inorder[i], i);
    }

    int inorderRootIndex = maps.get(preorder[0]);
    int[] inorderLeft = Arrays.copyOfRange(inorder, 0, inorderRootIndex);
    int[] inorderRight = Arrays.copyOfRange(inorder, inorderRootIndex + 1, inorder.length);
    int[] preorderLeft = Arrays.copyOfRange(preorder, 1, 1 + inorderLeft.length);
    int[] preorderRight = Arrays.copyOfRange(preorder, 1 + inorderLeft.length, preorder.length);

    root.left = buildTree(preorderLeft, inorderLeft);
    root.right = buildTree(preorderRight, inorderRight);

    return root;
  }
}

```
