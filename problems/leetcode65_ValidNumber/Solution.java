package leetcode65_ValidNumber;

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
