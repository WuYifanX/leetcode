package leetcode451_SortCharactersByFrequency;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

  private class TimesAndCharacter {
    private Character character;
    private Integer times;

    public TimesAndCharacter(Character character, Integer times) {
      this.character = character;
      this.times = times;
    }
  }

  public String frequencySort(String s) {
    if (s.length() == 0) {
      return "";
    }
    Map<Character, Integer> freqMap = new HashMap<>();
    for (char c : s.toCharArray()) {
      freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
    }

    Queue<TimesAndCharacter> charTimesQueue =
        new PriorityQueue(Comparator.comparingInt((TimesAndCharacter t) -> -1 * t.times));

    for (Entry<Character, Integer> entry : freqMap.entrySet()) {
      charTimesQueue.add(new TimesAndCharacter(entry.getKey(), entry.getValue()));
    }

    List<String> res = new ArrayList<>();

    while (!charTimesQueue.isEmpty()) {
      TimesAndCharacter timesAndCharacter = charTimesQueue.poll();
      res.add(productMultipleCharacter(timesAndCharacter.character, timesAndCharacter.times));
    }

    return String.join("", res);
  }

  public String productMultipleCharacter(Character c, Integer times) {
    List<String> res = new ArrayList<>();
    for (int i = 0; i < times; i++) {
      res.add(String.valueOf(c));
    }
    return String.join("", res);
  }

  public static void main(String[] args) {
    System.out.println(new Solution().frequencySort("tree"));
    System.out.println(new Solution().frequencySort("cccaaa"));
    System.out.println(new Solution().frequencySort("Aabb"));
  }
}
