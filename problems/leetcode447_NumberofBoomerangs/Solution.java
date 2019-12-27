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
