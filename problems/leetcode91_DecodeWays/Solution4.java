package leetcode91_DecodeWays;

public class Solution4 {
  public int numDecodings(String s) {
    if (s == null || s.length() == 0 || s.startsWith("0")) return 0;

    int w1 = 1;
    int w2 = 1;
    int w = w2;
    for (int i = 1; i < s.length(); i++) {
      w = 0;
      if (!isValid(s.charAt(i)) && !isValid(s.charAt(i - 1))) {
        return 0;
      }
      if (isValid(s.charAt(i))) w += w1;
      if (isValid(s.charAt(i - 1), s.charAt(i))) w += w2;

      w2 = w1;
      w1 = w;
    }
    return w;
  }

  private boolean isValid(char a) {
    return a != '0';
  }

  public boolean isValid(char a, char b) {
    int number = (a - '0') * 10 + b - '0';
    return number >= 10 && number <= 26;
  }

  public static void main(String[] args) {
    System.out.println(new Solution4().numDecodings("1"));
  }
}
