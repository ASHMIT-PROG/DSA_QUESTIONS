# Move Zeroes

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an integer array `nums`, move all `0`'s to the end of it while maintaining the relative order of the non-zero elements.

 **Note**  that you must do this in-place without making a copy of the array.

 

 **Example 1:** 

```
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

```

 **Example 2:** 

```
Input: nums = [0]
Output: [0]

```

 

 **Constraints:** 

- 1 <= nums.length <= 104
- -231 <= nums[i] <= 231 - 1

 

 **Follow up:**  Could you minimize the total number of operations done?

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 92.74%)  
**Memory:** 47.5 MB (beats 79.80%)  
**Submitted:** 2026-10-31T14:40:13.562Z  

```java

class Solution {
    public void moveZeroes(int[] nums) {

        int index = 0;

        // Step 1: Place all non-zero elements first
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        // Step 2: Fill remaining positions with zeroes
        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/move-zeroes/)