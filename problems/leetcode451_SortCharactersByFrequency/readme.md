# Leetcode
Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.


# Solution

1. 需要注意的是关注各个数据结构的api接口, 以适应白板编程.
2. 对于String, Char, List, Array之间的互转需要更加熟悉.

```java
package leetcode451_SortCharactersByFrequency;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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

    int[] freqs = new int[128];
    for (char c : s.toCharArray()) {
      freqs[c]++;
    }

    Queue<TimesAndCharacter> charTimesQueue =
        new PriorityQueue(Comparator.comparingInt((TimesAndCharacter t) -> -1 * t.times));

    for (int i = 0; i < freqs.length; i++) {
      if (freqs[i] != 0) {
        charTimesQueue.add(new TimesAndCharacter((char) i, freqs[i]));
      }
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


```
