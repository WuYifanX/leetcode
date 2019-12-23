package leetcode167_TwoSumII;

import utils.Logs;

public class Solution {

  public int[] twoSum(int[] numbers, int target) {

    int lowerCursor = 0;
    int higherCursor = numbers.length - 1;

    while (higherCursor >= 0 && lowerCursor < higherCursor) {
      if (numbers[lowerCursor] + numbers[higherCursor] == target) {
        return new int[] {lowerCursor + 1, higherCursor + 1};
      } else if (numbers[lowerCursor] + numbers[higherCursor] > target) {
        higherCursor--;
      } else {
        lowerCursor++;
      }
    }

    return null;
  }

  public static void main(String[] args) {
    int[] inputs = new int[] {5, 25, 75};
    int[] result = new Solution().twoSum(inputs, 100);
    Logs.print(result);
  }
}
