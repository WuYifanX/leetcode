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
