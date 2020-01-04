package leetcode91_DecodeWays;

public class Solution3 {
  public int numDecodings(String s) {
    if (s == null || s.length() == 0 || s.startsWith("0")) return 0;

    int[] dp = new int[s.length() + 1];
    dp[0] = 1;
    dp[1] = 1;
    int result;
    for (int i = 2; i < s.length() + 1; i++) {
      result = 0;

      if (!isValid(s.charAt(i - 1)) && !isValid(s.charAt(i - 2))) {
        return 0;
      }
      if (isValid(s.charAt(i - 1))) result += dp[i - 1];
      if (isValid(s.charAt(i - 2), s.charAt(i - 1))) result += dp[i - 2];

      dp[i] = result;
    }
    return dp[s.length()];
  }

  private boolean isValid(char a) {
    return a != '0';
  }

  public boolean isValid(char a, char b) {
    int number = (a - '0') * 10 + b - '0';
    return number >= 10 && number <= 26;
  }

  public static void main(String[] args) {
    System.out.println(new Solution3().numDecodings("228"));
  }
}
