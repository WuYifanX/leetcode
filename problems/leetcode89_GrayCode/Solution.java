package leetcode89_GrayCode;

import java.util.ArrayList;
import java.util.List;

class Solution {
  private List<Integer> result = new ArrayList<>();

  public List<Integer> grayCode(int n) {
    if (n == 0) {
      result.add(0);
      return result;
    }
    dfs(n, 0, 0);
    return result;
  }

  private void dfs(int left, int oneCount, int number) {
    if (left == 0) {
      result.add(number);
      return;
    }

    if (oneCount % 2 == 0) {
      dfs(left - 1, oneCount, number * 2);
      dfs(left - 1, oneCount + 1, number * 2 + 1);
    } else {
      dfs(left - 1, oneCount + 1, number * 2 + 1);
      dfs(left - 1, oneCount, number * 2);
    }
  }

  public static void main(String[] args) {
    System.out.println(new Solution().grayCode(2));
  }
}
