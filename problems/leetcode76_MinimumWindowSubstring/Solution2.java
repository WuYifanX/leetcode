package leetcode76_MinimumWindowSubstring;

public class Solution2 {

  private int[] targetMap = new int[64];
  private final int nullNumber = -126;

  public String minWindow(String s, String t) {

    for (int i = 0; i < 64; i++) {
      targetMap[i] = nullNumber;
    }

    for (char c : t.toCharArray()) {
      if (targetMap[c - 'A'] == nullNumber) {
        targetMap[c - 'A'] = 0;
      }

      targetMap[c - 'A'] += 1;
    }

    int lowCursor = 0, highCursor = -1;
    int minLowCursor = 0, minHighCursor = -1;
    int minCount = s.length() + 1;
    boolean isTIncluded = false;

    while (highCursor < s.length() && lowCursor < s.length()) {

      // 只有在不包含t的字符和没有达到最后的一位的时候才需要变化
      while (highCursor < s.length() - 1 && !isTIncluded) {
        highCursor++;
        char currentChar = s.charAt(highCursor);

        if (targetMap[currentChar - 'A'] != nullNumber) {
          targetMap[currentChar - 'A'] -= 1;
          if (containTargetCharacters(t)) {
            isTIncluded = true;
          }
        }
      }

      while (isTIncluded && lowCursor < s.length()) {
        if (highCursor - lowCursor + 1 < minCount) {
          minHighCursor = highCursor;
          minLowCursor = lowCursor;
          minCount = highCursor - minLowCursor + 1;
        }
        char currentChar = s.charAt(lowCursor);
        if (targetMap[currentChar - 'A'] != nullNumber) {
          targetMap[currentChar - 'A'] += 1;
          if (!containTargetCharacters(t)) {
            isTIncluded = false;
          }
        }
        lowCursor++;
      }

      if (highCursor == s.length() - 1) {
        break;
      }
    }

    char[] result = new char[minCount];
    if (minCount != s.length() + 1) {
      for (int i = minLowCursor; i <= minHighCursor; i++) {
        result[i - minLowCursor] = s.charAt(i);
      }
    }
    return minCount != s.length() + 1 ? new String(result) : "";
  }

  public boolean containTargetCharacters(String t) {
    for( int i =0; i< 64; i++){
      if(targetMap[i] > 0){
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(new Solution2().minWindow("cabwefgewcwaefgcf", "cae"));
    //    System.out.println(new DPSolution().minWindow("a", "a"));
  }
}
