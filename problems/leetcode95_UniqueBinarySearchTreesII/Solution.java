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
