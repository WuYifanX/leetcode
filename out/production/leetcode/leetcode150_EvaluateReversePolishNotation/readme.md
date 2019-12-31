# Leetcode
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Note:

Division between two integers should truncate toward zero.
The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.

```
Example 1:
Input: ["2", "1", "+", "3", "*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: ["4", "13", "5", "/", "+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:

Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
Output: 22
Explanation: 
  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
```


# Solution

注意细节:

1. number2和number1的顺序;
2. 使用Deque的话, 其实是比stack更快的. 

```java

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
}

```
