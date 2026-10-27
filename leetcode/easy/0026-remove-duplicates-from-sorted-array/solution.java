
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int i = 0;      // 1st pointer: last unique element ka index
        int j = 1;      // 2nd pointer: array ko traverse karega
        int unique = 1; // Pehla element already unique hai

        while (j < nums.length) {
            if (nums[j] == nums[i]) {
                j++;
            } else {
                nums[i + 1] = nums[j];
                i++;
                unique++;
                j++;
            }
        }

        return unique;
    }
}
