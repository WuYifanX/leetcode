package leetcode202_HappyNumber;

public class Solution2 {
  public boolean isHappy(int n) {

    int number = n;
    while (true) {
      number = getHappyResult(number);

      if (number == 1) {
        return true;
      }

      if(number == 4){
        return false;
      }
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
    System.out.println(new Solution2().isHappy(19));
  }
}
