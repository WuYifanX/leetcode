package leetcode67_AddBinary;

class Solution {
  public String addBinary(String a, String b) {
    if (a.equals("")) return b;
    if (b.equals("")) return a;

    StringBuilder sb = new StringBuilder();

    int aIndex = a.length() - 1;
    int bIndex = b.length() - 1;

    int increase = 0;
    int temp;

    while (aIndex >= 0 && bIndex >= 0) {
      temp = (a.charAt(aIndex) - '0') + (b.charAt(bIndex) - '0') + increase;
      if (temp >= 2) {
        increase = 1;
        temp = temp - 2;
      } else {
        increase = 0;
      }
      sb.append(temp);
      aIndex--;
      bIndex--;
    }

    while (aIndex >= 0) {
      temp = a.charAt(aIndex) - '0' + increase;
      if (temp >= 2) {
        increase = 1;
        temp = temp - 2;
      } else {
        increase = 0;
      }
      sb.append(temp);
      aIndex--;
    }

    while (bIndex >= 0) {
      temp = b.charAt(bIndex) - '0' + increase;
      if (temp >= 2) {
        increase = 1;
        temp = temp - 2;
      } else {
        increase = 0;
      }
      sb.append(temp);
      bIndex--;
    }

    if (increase == 1) {
      sb.append(increase);
    }

    return sb.reverse().toString();
  }
}

// "1010"
//    "1011"
