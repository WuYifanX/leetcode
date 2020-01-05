# Leetcode

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]


```


Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 

Note:

All of the nodes' values will be unique.
p and q are different and both values will exist in the binary tree.


```

# Solution

1. 从root到target点的DFS, 记录路径. 然后对比两个路径, 然后第一个分叉点就是公共祖先. 可惜超时; 见Solution1
2. 递归的实现, 对于某一个节点, 分别是去左右子树去找p,q.
如果左子树找到, 右子树找到, 那么就是这个点. 返回上去.
如果左子树找到, 右子树没找到, 那么那么返回左子树的寻找的函数(这个函数就是找到的值).
如果右子树找到, 左子树没找到, 那么返回左子树的函数.
见Solution2

3. 我们使用map来建立一个parent的对应表. Map<node, parent>. 那么我们可以从p, q就可以找到他们经历的路径path.
然后, 我们再用一个p开始去寻找在q的path之中相同点, 如果找得到说明这个点就是答案. 如果不是, 那就p再去父节点. 见Solution3


参考: https://www.hrwhisper.me/algorithm-lowest-common-ancestor-of-a-binary-tree/




```java
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

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) return null;

    if (root == p || root == q) return root;

    paths = new ArrayList<>();
    DFSFromNodeAndFind(root, p, new ArrayList<>());
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
    }

    if (node.left != null) {
      DFSFromNodeAndFind(node.left, target, new ArrayList<>(path));
    }

    if (node.right != null) {
      DFSFromNodeAndFind(node.right, target, new ArrayList<>(path));
    }
  }
}

```


```java
package leetcode236_LowestCommonAncestorofABinaryTree;

import utils.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution2 {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || p == root || q == root) return root;

    TreeNode leftResult = lowestCommonAncestor(root.left, p, q);
    TreeNode rightResult = lowestCommonAncestor(root.right, p, q);

    if (leftResult != null && rightResult != null) return root;

    if (leftResult != null) {
      return leftResult;
    }
    return rightResult;
  }
}

```


```java
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

```
