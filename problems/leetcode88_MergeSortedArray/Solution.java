package leetcode88_MergeSortedArray;

import utils.Logs;

class Solution {

  public void merge(int[] nums1, int m, int[] nums2, int n) {

    //    边界条件注意, 如果m = 0, 说明, 需要把nums2的数据搬过来.
    if (n == 0) {
      return;
    }

    int cursor = nums1.length - 1;

    int nums1Cursor = m - 1;
    int nums2Cursor = n - 1;

    // 因为nums1Cursor的起始值是m-1, 所以这个地方是==, nums1Cursor == 0的时候, 遍历还没结束.
    while (nums1Cursor >= 0 && nums2Cursor >= 0) {
      if (nums1[nums1Cursor] > nums2[nums2Cursor]) {
        nums1[cursor] = nums1[nums1Cursor];
        nums1Cursor--;
      } else {
        nums1[cursor] = nums2[nums2Cursor];
        nums2Cursor--;
      }
      cursor--;
    }

    while (nums2Cursor >= 0) {
      nums1[cursor] = nums2[nums2Cursor];
      nums2Cursor--;
      cursor--;
    }
  }

  public static void main(String[] args) {

    //    int[] nums1 = new int[] {1, 2, 3, 0, 0, 0};
    //    int m = 3;
    //    int[] nums2 = new int[] {2, 5, 6};
    //    int n = 3;
    int[] nums1 = new int[] {0};
    int m = 0;
    int[] nums2 = new int[] {1};
    int n = 1;
    new Solution().merge(nums1, m, nums2, n);
    Logs.print(nums1);
  }
}
