//package leetcode438_FindAllAnagramsInAString;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Map.Entry;
//import utils.Logs;
//
//public class Solution1 {
//  public List<Integer> findAnagrams(String s, String p) {
//
//    if (s.length() < p.length()) {
//      return Collections.emptyList();
//    }
//    List<Integer> res = new ArrayList<>();
//  }
//
//  private int getASCIISUM(String s, int start, int end) {
//    int sum = 0;
//    for (int i = start; i <= end; i++) {
//      sum += s.charAt(i) - 'A';
//    }
//    return sum;
//  }
//
//  private boolean isAnagrams(String s, int start, int end, String p) {
//    if (end - start + 1 != p.length()) {
//      return false;
//    }
//
//    Map<Character, Integer> maps = new HashMap<>(p.length());
//    for (int i = 0; i < p.length(); i++) {
//      char c = p.charAt(i);
//      if (maps.containsKey(c)) {
//        maps.put(c, maps.get(c) + 1);
//      } else {
//        maps.put(c, 1);
//      }
//    }
//
//    for (int j = start; j <= end; j++) {
//      char chars = s.charAt(j);
//      if (!maps.containsKey(chars)) {
//        return false;
//      } else {
//        maps.put(chars, maps.get(chars) - 1);
//      }
//    }
//
//    for (Entry<Character, Integer> entry : maps.entrySet()) {
//      if (entry.getValue() != 0) {
//        return false;
//      }
//    }
//    return true;
//  }
//
//  public static void main(String[] args) {
//    Logs.print(new Solution1().findAnagrams("cbaebabacd", "abc"));
//  }
//}
