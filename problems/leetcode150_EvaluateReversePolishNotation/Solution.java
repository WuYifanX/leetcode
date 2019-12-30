package leetcode150_EvaluateReversePolishNotation;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
  public int evalRPN(String[] tokens) {

    if (tokens.length == 0) return 0;

    Deque<String> stack = new ArrayDeque<>();
    int result = 0;
    for (String ch : tokens) {
      if (ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/")) {
        int number1 = Integer.valueOf(stack.pop());
        int number2 = Integer.valueOf(stack.pop());
        switch (ch) {
          case "+":
            result = number2 + number1;
            break;
          case "-":
            result = number2 - number1;
            break;
          case "*":
            result = number1 * number2;
            break;
          case "/":
            result = number2 / number1;
            break;
        }
        stack.push(String.valueOf(result));
      } else {
        stack.push(ch);
      }
    }
    return Integer.valueOf(stack.pop());
  }

  public static void main(String[] args) {
    String[] input = new String[] {"2", "1", "+", "3", "*"};
    System.out.println(new Solution().evalRPN(input));
  }
}
