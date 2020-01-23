package leetcode69_Sqrtx;

class Solution {
  public int mySqrt(int x) {
    if (x == 0) return 0;

    int rightLimit = 46340;
        if (x > rightLimit) {
          return binarySearch(1, rightLimit, x);
        } else {
          return binarySearch(1, x, x);
        }
  }

  private int binarySearch(int left, int right, int targetSquare) {
    if (left >= right) {
      if (right * right <= targetSquare) return right;
      return right - 1;
    }

    int middle = (right - left) / 2 + left;

    long middleSquare = middle * middle;
    if (middleSquare == targetSquare) return middle;
    if (middleSquare > targetSquare) {
      return binarySearch(left, middle - 1, targetSquare);
    } else {
      return binarySearch(middle + 1, right, targetSquare);
    }
  }

  public static void main(String[] args) {
    System.out.println(new Solution().mySqrt(8));
  }
}
