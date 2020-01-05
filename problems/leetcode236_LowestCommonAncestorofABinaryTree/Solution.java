package leetcode236_LowestCommonAncestorofABinaryTree;

import java.util.ArrayList;
import java.util.List;
import utils.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  List<List<TreeNode>> paths;
  boolean isFound = false;

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) return null;

    if (root == p || root == q) return root;

    paths = new ArrayList<>();
    DFSFromNodeAndFind(root, p, new ArrayList<>());
    isFound = false;
    DFSFromNodeAndFind(root, q, new ArrayList<>());

    return findLCA(paths.get(0), paths.get(1));
  }

  public TreeNode findLCA(List<TreeNode> pList, List<TreeNode> qList) {

    List<TreeNode> shorterList = pList.size() > qList.size() ? qList : pList;
    List<TreeNode> longerList = pList.size() > qList.size() ? pList : qList;

    for (int i = 0; i < shorterList.size(); i++) {
      if (shorterList.get(i) != longerList.get(i)) {
        return shorterList.get(i - 1);
      }
    }
    return shorterList.get(shorterList.size() - 1);
  }

  public void DFSFromNodeAndFind(TreeNode node, TreeNode target, List<TreeNode> path) {
    path.add(node);
    if (node == target) {
      paths.add(path);
      isFound = true;
    }

    if (node.left != null && !isFound) {
      DFSFromNodeAndFind(node.left, target, new ArrayList<>(path));
    }

    if (node.right != null && !isFound) {
      DFSFromNodeAndFind(node.right, target, new ArrayList<>(path));
    }
  }
}
