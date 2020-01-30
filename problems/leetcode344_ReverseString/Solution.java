package leetcode344_ReverseString;

class Solution {
  public void reverseString(char[] s) {
    if (s.length == 0 || s.length == 1) return;

    int pIndex = 0;
    int qIndex = s.length - 1;

    while (pIndex < qIndex) {
      swap(s, pIndex, qIndex);
      qIndex--;
      pIndex++;
    }
  }

  private void swap(char[] s, int p, int q) {
    char temp = s[p];
    s[p] = s[q];
    s[q] = temp;
  }

  public static void main(String[] args) {
    char[] a = new char[] {'h', 'e', 'l', 'l', 'o'};
    new Solution().reverseString(a);
    System.out.println(a);
  }
}
