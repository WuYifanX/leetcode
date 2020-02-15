# Leetcode

Validate if a given string can be interpreted as a decimal number.

```
Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
" -90e3   " => true
" 1e" => false
"e3" => false
" 6e-1" => true
" 99e2.5 " => false
"53.5e93" => true
" --6 " => false
"-+3" => false
"95a54e53" => false
```

Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one. However, here is a list of characters that can be in a valid decimal number:

Numbers 0-9
Exponent - "e"
Positive/negative sign - "+"/"-"
Decimal point - "."
Of course, the context of these characters also matters in the input.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button to reset your code definition.


# Solution
1.建立一个有限自动机, 最大的问题在于说找到所有的边缘的case.然后在其中跳转.

```java
class Solution {
  private enum State {
    START,
    INTEGER,
    DECIMAL_WITHOUT_PREVIOUS_INTEGER,
    DECIMAL_WITH_PREVIOUS_INTEGER,
    AFTER_DECIMAL,
    EXPONENT,
    EXPONENT_SIGN,
    AFTER_EXPONENT,
    UNKNOWN
  }

  public boolean isNumber(String s) {
    s = s.trim();
    if (s.length() == 0) return false;

    int index = 0;

    if (s.charAt(0) == '+' || s.charAt(0) == '-') index++;

    State currentState = State.START;
    while (index < s.length()) {
      currentState = getNextState(currentState, s.charAt(index));

      if (currentState == State.UNKNOWN) return false;

      index++;
    }

    if (currentState == State.EXPONENT
        || currentState == State.EXPONENT_SIGN
        || currentState == State.DECIMAL_WITHOUT_PREVIOUS_INTEGER) return false;

    return true;
  }

  private State getNextState(State currentState, Character c) {
    switch (currentState) {
      case START:
        if (c >= '0' && c <= '9') {
          return State.INTEGER;
        }
        if (c == '.') return State.DECIMAL_WITHOUT_PREVIOUS_INTEGER;
        return State.UNKNOWN;
      case DECIMAL_WITHOUT_PREVIOUS_INTEGER:
        if (c >= '0' && c <= '9') {
          return State.AFTER_DECIMAL;
        }
        return State.UNKNOWN;
      case DECIMAL_WITH_PREVIOUS_INTEGER:
        if (c >= '0' && c <= '9') {
          return State.AFTER_DECIMAL;
        }
        if (c == 'e') return State.EXPONENT;
        return State.UNKNOWN;
      case AFTER_DECIMAL:
        if (c == 'e') return State.EXPONENT;
        if (c >= '0' && c <= '9') return State.AFTER_DECIMAL;
        return State.UNKNOWN;
      case INTEGER:
        if (c >= '0' && c <= '9') return State.INTEGER;
        if (c == 'e') return State.EXPONENT;
        if (c == '.') return State.DECIMAL_WITH_PREVIOUS_INTEGER;
        return State.UNKNOWN;
      case EXPONENT:
        if (c >= '0' && c <= '9') return State.AFTER_EXPONENT;
        if (c == '-' || c == '+') return State.EXPONENT_SIGN;
        return State.UNKNOWN;
      case EXPONENT_SIGN:
      case AFTER_EXPONENT:
        if (c >= '0' && c <= '9') return State.AFTER_EXPONENT;
        return State.UNKNOWN;
      default:
        return State.UNKNOWN;
    }
  }
}

```
