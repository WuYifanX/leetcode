package leetcode15_3sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution3 {
  public List<List<Integer>> threeSum(int[] nums) {
    if (nums.length < 3) {
      return Collections.emptyList();
    }

    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    int leftCursor, rightCursor, target;
    for (int i = 0; i <= nums.length - 3; i++) {
      // as sorted, i is most small, which is bigger than 0, break;
      if (nums[i] > 0) {
        break;
      }

      // 如果i已经匹配过了, 下次需要跳到和上次不一样的地方去;不然就会出现重复,
      // 比如说[-1, -1, ....] i == 2个-1的时候都是一样的答案. 所以这里需要continue跳过.
      if (i > 0 && nums[i - 1] == nums[i]) {
        continue;
      }

      target = -nums[i];
      leftCursor = i + 1;
      rightCursor = nums.length - 1;

      while (leftCursor < rightCursor) {
        if (nums[leftCursor] + nums[rightCursor] == target) {
          res.add(Arrays.asList(nums[i], nums[leftCursor], nums[rightCursor]));
          leftCursor++;

          // 同理, 这里也需要跳过.
          while (leftCursor < rightCursor && nums[leftCursor] == nums[leftCursor - 1]) {
            leftCursor++;
          }
        }

        if (leftCursor < rightCursor && nums[leftCursor] + nums[rightCursor] > target) {
          rightCursor--;
        }

        if (leftCursor < rightCursor && nums[leftCursor] + nums[rightCursor] < target) {
          leftCursor++;
        }
      }
    }

    return res;
  }

  public static void main(String[] args) {
//    int[] a = new int[] {-1, 0, 1, 2, -1, -4};
    int[] a = new int[] {0,0,0,0,0,0,0,0,0};
    new Solution3().threeSum(a);
  }
}
