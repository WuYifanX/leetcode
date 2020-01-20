package leetcode22_GenerateParentheses;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
  private List<String> result = new ArrayList<>();
  private Deque<Character> stack = new ArrayDeque<>();

  public List<String> generateParenthesis(int n) {

    if (n == 0) return result;

    innerGenerateParenthesis(n, n);

    return result;
  }

  private void innerGenerateParenthesis(int leftCount, int rightCount) {
    if (leftCount == 0 && rightCount == 0) {
      result.add(generateString());
      return;
    }

    if (leftCount > rightCount) return;

    if (leftCount > 0) {
      stack.addLast('(');
      innerGenerateParenthesis(leftCount - 1, rightCount);
      stack.removeLast();
    }

    if (rightCount > 0) {
      stack.addLast(')');
      innerGenerateParenthesis(leftCount, rightCount - 1);
      stack.removeLast();
    }
  }

  private String generateString() {
    List<Character> result = new ArrayList<>(stack);
    StringBuilder sb = new StringBuilder();
    for (Character c : result) {
      sb.append(c);
    }

    return sb.toString();
  }
}
