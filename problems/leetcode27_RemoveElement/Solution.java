package leetcode27_RemoveElement;

class Solution {
  public int removeElement(int[] nums, int val) {
    if (nums.length == 0) {
      return 0;
    }

    int leftCursor = 0;
    int rightCursor = nums.length - 1;

    // [0, rightCursor] is the return array.
    while (leftCursor < rightCursor) {

      if (nums[rightCursor] == val) {
        rightCursor--;
      } else {
        if (nums[leftCursor] == val) {
          nums[leftCursor] = nums[rightCursor];
          rightCursor--;
        }
        leftCursor++;
      }
    }

    // when leftCursor == rightCursor
    if (nums[leftCursor] == val) {
      rightCursor--;
    }

    return rightCursor + 1;
  }

  public static void main(String[] args) {
    int[] intput = new int[] { 3, 2, 2, 3 };
    int res = new Solution().removeElement(intput, 3);
    System.out.println(res);
  }
}
