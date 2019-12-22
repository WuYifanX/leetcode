class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        int cursor = 0;
        int replaceIndex = 0;

        while (cursor < nums.length) {
            if (nums[cursor] != 0) {
                nums[replaceIndex] = nums[cursor];
                replaceIndex++;
            }
            cursor++;
        }

        while (replaceIndex < nums.length) {
            nums[replaceIndex] = 0;
            replaceIndex++;
        }
    }
}