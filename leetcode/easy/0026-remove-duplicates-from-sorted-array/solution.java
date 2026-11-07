class Solution {
    public int removeDuplicates(int[] nums) {

        // Edge case: If the array is empty, there are no unique elements.
        if (nums.length == 0) {
            return 0;
        }

        // i points to the index of the last unique element.
        int i = 0;

        // Initially, the first element is always unique.

        // j starts from index 1 to check the remaining elements.
        for (int j = 1; j < nums.length; j++) {

            // Check whether the current element is different
            // from the last unique element.
            if (nums[i] != nums[j]) {

                // Move i forward to create space for the next unique element.
                i++;

                // Place the new unique element at index i.
                nums[i] = nums[j];

                // Increase the count of unique elements.
                
            }
        }

        // Return the total number of unique elements.
        return i+1;
    }
}