# Leetcode

# Solution


1. 明显是可以使用hashmap的

2. 有一个 Boyer-Moore Majority Vote Algorithm

  算法思想很简单，但第一个想出来的人是真的强。
  
  我们假设这样一个场景，在一个游戏中，分了若干个队伍，有一个队伍的人数超过了半数。所有人的战力都相同，不同队伍的两个人遇到就是同归于尽，同一个队伍的人遇到当然互不伤害。
  
  这样经过充分时间的游戏后，最后的结果是确定的，一定是超过半数的那个队伍留在了最后。
  
  而对于这道题，我们只需要利用上边的思想，把数组的每个数都看做队伍编号，然后模拟游戏过程即可。
  
  member 记录当前队伍的人数，count 记录当前队伍剩余的人数。如果当前队伍剩余人数为 0，记录下次遇到的人的所在队伍号。
  
  参考: https://leetcode-cn.com/problems/majority-element/solution/mo-er-tou-piao-ha-xi-tong-by-javalangruntimeexcept/
```java

package leetcode169_MajorityElement;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Solution {
  public int majorityElement(int[] nums) {
    if (nums.length == 1) return nums[0];

    Map<Integer, Integer> maps = new HashMap<>();

    for (int num : nums) {
      maps.put(num, maps.getOrDefault(num, 0) + 1);
    }

    Entry<Integer, Integer> maxEntry = null;
    for (Entry<Integer, Integer> entry : maps.entrySet()) {
      if (maxEntry == null) {
        maxEntry = entry;
        continue;
      }

      if (entry.getValue() > maxEntry.getValue()) maxEntry = entry;
    }

    return maxEntry.getKey();
  }
}

```

Solution2 投票算法:

```java
package leetcode169_MajorityElement;

class Solution2 {
  public int majorityElement(int[] nums) {
    int candidate = nums[0];
    int count = 1;

    for (int i = 1; i < nums.length; i++) {
      if (count == 0) {
        count = 1;
        candidate = nums[i];
        continue;
      }

      count += nums[i] == candidate ? 1 : -1;
    }

    return candidate;
  }
}

```
