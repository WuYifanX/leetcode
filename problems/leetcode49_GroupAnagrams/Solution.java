package leetcode49_GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> stringListMap = new HashMap<>();

    for (String s : strs) {
      char[] c = s.toCharArray();
      Arrays.sort(c);
      String key = String.valueOf(c);
      if (!stringListMap.containsKey(key)) {
        stringListMap.put(key, new ArrayList<>());
      }
      stringListMap.get(key).add(s);
    }

    return new ArrayList<>(stringListMap.values());
  }

  public static void main(String[] args) {
    String[] a = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
    new Solution().groupAnagrams(a);
  }
}
