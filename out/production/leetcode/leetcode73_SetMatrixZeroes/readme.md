# Leetcode

Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

```
Example 1:

Input: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
Example 2:

Input: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
Follow up:

A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?


```
# Solution


1. 使用了O(m+n)的空间复杂的
2. 优化的话: 空间复杂度 O(2) ，用两个布尔变量就可以解决。方法就是利用数组的首行和首列来记录 0 值。
从数组下标的 A[1][1] 开始遍历，两个布尔值记录首行首列是否需要置0
         
```java
package leetcode73_SetMatrixZeroes;

import java.util.HashSet;
import java.util.Set;

class Solution {

  public void setZeroes(int[][] matrix) {

    Set<Integer> xSet = new HashSet<>();
    Set<Integer> ySet = new HashSet<>();
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          xSet.add(i);
          ySet.add(j);
          break;
        }
      }
    }

    for (Integer x : xSet) {
      for (int i = 0; i < matrix[0].length; i++) {
        matrix[x][i] = 0;
      }
    }

    for (Integer y : ySet) {
      for (int i = 0; i < matrix.length; i++) {
        matrix[i][y] = 0;
      }
    }
  }
}

```
