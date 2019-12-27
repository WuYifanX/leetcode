package leetcode149_MaxPointsOnALine;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  private class Point {
    private int x;
    private int y;

    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  private int maxPoints(int[][] points) {
    Map<String, Integer> slopeMap = new HashMap<>();
    Point pointX, pointY;
    int samePointCount;
    String currentSlope;
    int ans = 0;

    for (int i = 0; i < points.length; i++) {
      pointX = new Point(points[i][0], points[i][1]);
      samePointCount = 1;
      int maxSameSlope = 0;
      for (int j = 0; j < points.length; j++) {
        if (i == j) continue;
        pointY = new Point(points[j][0], points[j][1]);

        if (pointX.x == pointY.x && pointX.y == pointY.y) {
          samePointCount++;
        } else {
          currentSlope = getSlope(pointX, pointY);
          slopeMap.put(currentSlope, slopeMap.getOrDefault(currentSlope, 0) + 1);
          maxSameSlope = Math.max(maxSameSlope, slopeMap.get(currentSlope));
        }
      }
      ans = Math.max(ans, maxSameSlope + samePointCount);
      slopeMap.clear();
    }
    return ans;
  }

  // return "y2 - y1/x2 - x1"
  private String getSlope(Point pointX, Point pointY) {
    if (pointX.x == pointY.x) {
      return "|";
    }

    if (pointX.y == pointY.y) {
      return "-";
    }

    int dY = pointY.y - pointX.y;
    int dX = pointY.x - pointX.x;
    int gcd = dY > dX ? getGCD(dY, dX) : getGCD(dX, dY);
    return dY / gcd + "/" + dX / gcd;
  }

  private static int getGCD(int a, int b) {
    return a % b == 0 ? b : getGCD(b, a % b);
  }

  public static void main(String[] args) {
//    int[][] input = new int[][] {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
    int[][] input = new int[][] {{1, 1}, {2, 2}, {3, 3}};
    System.out.println(new Solution().maxPoints(input));
  }
}
