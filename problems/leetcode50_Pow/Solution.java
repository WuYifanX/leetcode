package leetcode50_Pow;

class Solution {
  public double myPow(double x, int n) {
    if (n == 0 || x == 1f) return 1f;

    if (n < 0) {
      return (1 / x) * myPow(1 / x, -(n + 1));
    }

    if (n % 2 == 0) {
      double temp = myPow(x, n / 2);
      return temp * temp;
    }
    return x * myPow(x, n - 1);
  }
}
