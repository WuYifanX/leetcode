package leetcode202_HappyNumber;

public class Solution3 {
  public boolean isHappy(int n) {

    int slowCursor = n;
    int fastCursor = n;
    do {
      slowCursor = getHappyResult(slowCursor);
      fastCursor = getHappyResult(fastCursor);
      fastCursor = getHappyResult(fastCursor);
    } while (slowCursor != fastCursor);

    return fastCursor == 1;
  }

  private int getHappyResult(int number) {
    int result = 0;

    for (int i = number; i != 0; i = i / 10) {
      result += Math.pow(i % 10, 2);
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(new Solution3().isHappy(19));
  }
}
