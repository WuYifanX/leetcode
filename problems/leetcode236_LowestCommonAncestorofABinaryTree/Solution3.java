package leetcode236_LowestCommonAncestorofABinaryTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import utils.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution3 {

  private boolean isFound = false;

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    if (root == null || root == p || root == q) return root;

    Map<TreeNode, TreeNode> pParent = new HashMap<>();
    pParent.put(root, null);
    DFS(root, p, pParent);

    Map<TreeNode, TreeNode> qParent = new HashMap<>();
    qParent.put(root, null);
    isFound = false;
    DFS(root, q, qParent);
    return findLowestCommonAncestor(pParent, qParent, q, p);
  }

  private TreeNode findLowestCommonAncestor(
      Map<TreeNode, TreeNode> pParent, Map<TreeNode, TreeNode> qParent, TreeNode q, TreeNode p) {

    TreeNode qCurrent = q;
    Set<TreeNode> qPath = new HashSet<>();

    while (qCurrent != null) {
      qPath.add(qCurrent);
      qCurrent = qParent.get(qCurrent);
    }

    for(TreeNode val: qPath){
      System.out.println(val.val);
    }


    TreeNode pCurrent = p;
    while (pCurrent != null) {
      if (qPath.contains(pCurrent)) {
        return pCurrent;
      }
      pCurrent = pParent.get(pCurrent);
    }

    return null;
  }

  private void DFS(TreeNode node, TreeNode target, Map<TreeNode, TreeNode> parent) {
    if (node == target) {
      isFound = true;
      return;
    }
    if (isFound) return;

    if (node.left != null && !isFound) {
      parent.put(node.left, node);
      DFS(node.left, target, parent);
    }

    if (node.right != null && !isFound) {
      parent.put(node.right, node);
      DFS(node.right, target, parent);
    }
  }
}
