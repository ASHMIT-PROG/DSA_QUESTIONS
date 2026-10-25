class Solution {
    public int removeDuplicates(int[] nums) {
        int i =0;// 1st pointer 
        int j = 1;// 2nd pointer
        int unique = 1;

        while(j<nums.length){
            if(nums[j]==nums[j-1]){// if two numbers are same consiquitevely 
                j++;
            }
            else if(nums[j]!=nums[j-1]){
                nums[i+1]=nums[j];
                i++;
                unique++;
                j++;
            }
        }
        return unique;
    }
}