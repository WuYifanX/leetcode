package leetcode474_OnesAndZeroes;

class Solution {

  private int[][] memo;

  // '001' is [2, 1, 0]
  // 0 is 2 times, 1 is 1 times, and not bu used.
  private int[][] maps;

  public int findMaxForm(String[] strs, int m, int n) {

    if (strs.length == 0 || (m == 0 && n == 0)) return 0;
    buildMaps(strs);
    memo = new int[m + 1][n + 1];
    //    memo = new int[m + 1][n + 1];
    return innerFindMaxForm(m, n);
  }

  private void buildMaps(String[] strs) {
    maps = new int[strs.length][3];
    for (int i = 0; i < strs.length; i++) {
      maps[i] = count0And1(strs[i]);
    }
  }

  private int[] count0And1(String s) {
    int[] result = new int[3];

    for (char c : s.toCharArray()) {
      if (c == '0') {
        result[0] = result[0] + 1;
      } else {
        result[1] = result[1] + 1;
      }
    }

    return result;
  }

  private int countUsed() {
    int resultCount = 0;
    for (int[] val : maps) {
      if (val[2] == 1) resultCount++;
    }

    return resultCount;
  }

  private int innerFindMaxForm(int m, int n) {
    if (m < 0 || n < 0) {
      return countUsed() - 1;
    }

    if (m == 0 && n == 0) return countUsed();

    if (memo[m][n] != 0) return memo[m][n];

    int count = 0;
    for (int[] currentValue : maps) {
      if (currentValue[2] == 1) continue;
      currentValue[2] = 1;
      count = Math.max(count, innerFindMaxForm(m - currentValue[0], n - currentValue[1]));
      currentValue[2] = 0;
    }

    if (count == 0) {
      count = countUsed();
    }

    memo[m][n] = count;

    return count;
  }

  public static void main(String[] args) {
    System.out.println(
        new Solution()
            .findMaxForm(
                new String[] {
                  "011", "1", "11", "0", "010", "1", "10", "1", "1", "0", "0", "0", "01111", "011",
                  "11", "00", "11", "10", "1", "0", "0", "0", "0", "101", "001110", "1", "0", "1",
                  "0", "0", "10", "00100", "0", "10", "1", "1", "1", "011", "11", "11", "10", "10",
                  "0000", "01", "1", "10", "0"
                },
                44,
                39));
    ////
    //    System.out.println(
    //        new Solution().findMaxForm(new String[] {"010", "001"}, 1, 1));
  }
}
