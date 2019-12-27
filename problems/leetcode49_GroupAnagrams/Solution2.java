package leetcode49_GroupAnagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> stringListMap = new HashMap<>();

    String key;
    for (String s : strs) {
      key = buildKeyForString(s);
      System.out.println(key);
      if (!stringListMap.containsKey(key)) {
        stringListMap.put(key, new ArrayList<>());
      }
      stringListMap.get(key).add(s);
    }

    ArrayList<List<String>> result = new ArrayList<>(stringListMap.values());
    return result;
  }

  private String buildKeyForString(String s) {
    int[] count = new int[26];

    for (char c : s.toCharArray()) {
      count[c - 'a'] += 1;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 26; i++) {
      sb.append("#").append(count[i]);
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    String[] a = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
    new Solution2().groupAnagrams(a);
  }
}
