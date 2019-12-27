# Leetcode

Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).

Example:

Input:
[[0,0],[1,0],[2,0]]

Output:
2

Explanation:
The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]

# Solution

1. 这个能成立一定是在三个点之间. 比如说a, b, c. 一定是 ab = bc . 一定有一个重合的点才可以.
2. 所以这里需要去使用每个点都去遍历除了自己的其他的点. 也就是去找这个的过程. 比如说从a开始,找ab, ac. 同理, 遍历的时候也是去找别的.
3. 所以需要有一个东西来储存距离. 这里使用hashmap. 如果发现没有这个距离, 就把这个距离放进去. 如果找到了相同的距离, 比如说找到的距离是1, 已经有ab距离是1了. 现在有ac也是1.  
那么也就是可以有ab, ac相等. 这种就有2个情况, 是[a, b, c] and [a, c, b]. 增加次数完毕之后, 还得把map的次数+1.
这个时候碰到了距离ad 距离也是相等的. 去map查, 发现这个距离已经出现了2次. 那么这就增加了 ad + ab and ad + ac. 每个组可以颠倒顺序,也就是2 * 2. 然后再把这个次数+1, 变成3.
4. 如果, 已经把把a这个点遍历完了, 那么这个map的数据其实可以抹去. 然后再去遍历b.
5. 如果开始遍历b的时候,我们还有没有必要去从a去计算ba的距离. 其实是有必要的, 因为从a开始的时候是没有包含这种情况: ba, bc. 也就是[b, a, c] and [b, c, a].
6. 因为计算距离这个事情会大量重复, 其实是可以考虑把计算值存储起来, 那么下次的话会更快.


```java

package leetcode447_NumberofBoomerangs;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  private double[][] distanceMemo;

  public int numberOfBoomerangs(int[][] points) {
    distanceMemo = new double[points.length][points.length];
    Map<Double, Integer> maps = new HashMap<>();
    double distance;
    int result = 0;
    int currentTimes;
    for (int i = 0; i < points.length; ++i) {
      for (int j = 0; j < points.length; j++) {
        if (i == j) continue;
        distance = calcuateDistanceBetweenTwoPoint(points, i, j);
        if (maps.containsKey(distance)) {
          currentTimes = maps.get(distance);
          result += 2 * currentTimes;
          maps.put(distance, currentTimes + 1);
        } else {
          maps.put(distance, 1);
        }
      }
      maps.clear();
    }
    return result;
  }

  private double calcuateDistanceBetweenTwoPoint(int[][] points, int i, int j) {
    if (distanceMemo[i][j] != 0) {
      return distanceMemo[i][j];
    }

    double distance =
        Math.pow(points[i][1] - points[j][1], 2) + Math.pow(points[i][0] - points[j][0], 2);
    distanceMemo[i][j] = distance;
    distanceMemo[j][i] = distance;
    return distance;
  }

  public static void main(String[] args) {
    int[][] input = new int[][] {{0, 0}, {1, 0}, {2, 0}};

    System.out.println(new Solution().numberOfBoomerangs(input));
  }
}

```
