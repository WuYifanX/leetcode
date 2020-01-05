# Leetcode

Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
Note: Time complexity should be O(height of tree).

```
Example:

root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

Given key to delete is 3. So we find the node with value 3 and delete it.

One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

    5
   / \
  4   6
 /     \
2       7

Another valid answer is [5,2,6,null,4,null,7].

    5
   / \
  2   6
   \   \
    4   7

```

# Solution

1. 最难的就是想清楚每个函数传入什么, 返回什么
2. findTargetNodeAndDelete 找到target值并删除, 然后返回原来的树的节点.
3. deleteMin 删除最小值, 然后返回这个最小值.

因为难点在于说如何保持这个节点的原有结构的情况下删除. 这个利用了递归的返回值来保持位置.

```java
package leetcode450_DeleteNodeInABST;

import utils.TreeNode;

public class Solution {
  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) return null;
    root = findTargetNodeAndDelete(root, key);
    return root;
  }

  public TreeNode findTargetNodeAndDelete(TreeNode node, int key) {
    if (node != null && node.val != key) {
      if (node.val > key) {
        node.left = findTargetNodeAndDelete(node.left, key);
      } else {
        node.right = findTargetNodeAndDelete(node.right, key);
      }
    }else{
      if (node == null || (node.left == null && node.right == null)) return null;
      if (node.right == null) return node.left;
      if (node.left == null) return node.right;
      return innerDeleteNode(node);
    }

    return node;
  }

  public TreeNode innerDeleteNode(TreeNode node) {
    // node has left and right child;
    TreeNode minNode = deleteMin(node.right);
    minNode.left = node.left;
    if(minNode != node.right){
      minNode.right = node.right;
    }
    node.right = null;
    node.left = null;
    return minNode;
  }

  public TreeNode deleteMin(TreeNode node) {
    if (node != null && node.left != null && node.left.left != null) {
      return deleteMin(node.left);
    }

    TreeNode deletedNode = node.left;
    if (deletedNode == null) return node;
    node.left = deletedNode.right;
    return deletedNode;
  }
}

```

