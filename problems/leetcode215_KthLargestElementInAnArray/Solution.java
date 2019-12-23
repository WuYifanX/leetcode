package leetcode215_KthLargestElementInAnArray;

public class Solution {
  public int findKthLargest(int[] nums, int k) {
    // keng: k largest, the index of after sorting is nums.length -k
    // e.g.: [1,2,3,4,5] the 1st largest is length -1 = 4. nums[4] = 5;
    return nums[findKthLargest(nums, 0, nums.length - 1, nums.length - k)];
  }

  // k is the index of sorting. if the k = largest, k = 1; rank = 0
  private int findKthLargest(int[] nums, int start, int end, int rank) {

    int pivot = partition(nums, start, end);
    if (pivot == rank) {
      return pivot;
    } else if (pivot > rank) {
      // end must be the pivot -1
      return findKthLargest(nums, 0, pivot - 1, rank);
    } else {
      // the start must be pivot +1;
      return findKthLargest(nums, pivot + 1, nums.length - 1, rank);
    }
  }

  // find K in [start, end] array;
  private int partition(int[] nums, int start, int end) {

    if (start >= end) {
      return start;
    }

    int randomIndex = (int) ((end - start + 1) * Math.random()) + start;
    swap(nums, start, randomIndex);

    int lessThanPointer = start;
    int cursor = start + 1;
    for (; cursor <= end; cursor++) {
      if (nums[cursor] < nums[start]) {
        lessThanPointer++;
        swap(nums, lessThanPointer, cursor);
      }
    }
    swap(nums, start, lessThanPointer);
    // [start...lessThanPointer -1] is < V;
    // [lessThanPointer+1, end] is >= v;

    return lessThanPointer;
  }

  private void swap(int[] nums, int p, int q) {
    int temp = nums[p];
    nums[p] = nums[q];
    nums[q] = temp;
  }

  public static void main(String[] args) {
    //    Input: [3,2,1,5,6,4] and k = 2
    //    Output: 5

    int[] input = new int[] {3, 1, 2, 4};
    int result = new Solution().findKthLargest(input, 2);
    System.out.println(result);
  }
}
