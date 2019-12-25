package leetcode202_HappyNumber;

import java.util.HashSet;
import java.util.Set;

public class Solution {
  public boolean isHappy(int n) {

    Set<Integer> set = new HashSet<>();
    int number = n;
    while (true) {
      number = getHappyResult(number);

      if (number == 1) {
        return true;
      }

      if (set.contains(number)) {
        return false;
      }

      set.add(number);
    }
  }

  private int getHappyResult(int number) {
    int result = 0;

    for (int i = number; i != 0; i = i / 10) {
      result += Math.pow(i % 10, 2);
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().isHappy(19));
  }
}
