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
**Runtime:** 3 ms (beats 21.13%)  
**Memory:** 47.2 MB (beats 94.87%)  
**Submitted:** 2026-10-30T14:10:54.496Z  

```java
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



```

---

[View on LeetCode](https://leetcode.com/problems/move-zeroes/)