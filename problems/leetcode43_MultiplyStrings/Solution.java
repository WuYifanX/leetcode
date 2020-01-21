package leetcode43_MultiplyStrings;

class Solution {
  public String multiply(String num1, String num2) {
    if (num1.equals("0") || num2.equals("0")) return "0";

    String longer, shorter;

    if (num1.length() >= num2.length()) {
      longer = num1;
      shorter = num2;
    } else {
      longer = num2;
      shorter = num1;
    }

    String result = "";
    int shortIndex = shorter.length() - 1;
    while (shortIndex >= 0) {
      result =
          stringAdd(
              result,
              innerMultiply(longer, shorter.charAt(shortIndex))
                  + generateZero(shorter.length(), shortIndex));
      shortIndex--;
    }

    return result;
  }

  private String innerMultiply(String stringNumber, char charTimes) {
    int times = charTimes - '0';
    if (times == 0) return "0";
    String result = stringNumber;
    while (times > 1) {
      result = stringAdd(result, stringNumber);
      times--;
    }
    return result;
  }

  private String generateZero(int length, int index) {
    if (length - index - 1 == 0) return "";
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < length - index - 1; i++) {
      sb.append("0");
    }
    return sb.toString();
  }

  private String stringAdd(String s1, String s2) {
    StringBuilder sb = new StringBuilder();
    int s1Index = s1.length() - 1;
    int s2Index = s2.length() - 1;
    int s1Number, s2Number, combination;
    int higher = 0;

    while (s1Index >= 0 && s2Index >= 0) {
      s1Number = s1.charAt(s1Index) - '0';
      s2Number = s2.charAt(s2Index) - '0';

      combination = s1Number + s2Number + higher;

      sb.append(combination % 10);
      higher = combination / 10;
      s1Index--;
      s2Index--;
    }

    while (s1Index >= 0) {
      s1Number = s1.charAt(s1Index) - '0';
      combination = s1Number + higher;
      sb.append(combination % 10);
      higher = combination / 10;
      s1Index--;
    }

    while (s2Index >= 0) {
      s2Number = s2.charAt(s2Index) - '0';
      combination = s2Number + higher;
      sb.append(combination % 10);
      higher = combination / 10;
      s2Index--;
    }

    if (higher != 0) {
      sb.append(higher);
    }

    return sb.reverse().toString();
  }

  public static void main(String[] args) {
    System.out.println(new Solution().multiply("9", "9"));
  }
}
