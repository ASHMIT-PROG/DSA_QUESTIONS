class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0;// left pointer 
        int right = 0;// right pointer
        while (right < nums.length) {// move the right pointer 
            if (nums[right] != 0) {// swap the numbers 
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
        
    }
}


