# Minimum Operations to Make Elements Within K Subarrays Equal

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given an integer array `nums` and two integers, `x` and `k`. You can perform the following operation any number of times (**including zero**):

- Increase or decrease any element of nums by 1.

Return the  **minimum**  number of operations needed to have  **at least**  `k`  *non-overlapping subarrays*  of size  **exactly**  `x` in `nums`, where all elements within each subarray are equal.

 

 **Example 1:** 

 **Input:**  nums = [5,-2,1,3,7,3,6,4,-1], x = 3, k = 2

 **Output:**  8

 **Explanation:** 

- Use 3 operations to add 3 to nums[1] and use 2 operations to subtract 2 from nums[3]. The resulting array is [5, 1, 1, 1, 7, 3, 6, 4, -1].
- Use 1 operation to add 1 to nums[5] and use 2 operations to subtract 2 from nums[6]. The resulting array is [5, 1, 1, 1, 7, 4, 4, 4, -1].
- Now, all elements within each subarray [1, 1, 1] (from indices 1 to 3) and [4, 4, 4] (from indices 5 to 7) are equal. Since 8 total operations were used, 8 is the output.

 **Example 2:** 

 **Input:**  nums = [9,-2,-2,-2,1,5], x = 2, k = 2

 **Output:**  3

 **Explanation:** 

- Use 3 operations to subtract 3 from nums[4]. The resulting array is [9, -2, -2, -2, -2, 5].
- Now, all elements within each subarray [-2, -2] (from indices 1 to 2) and [-2, -2] (from indices 3 to 4) are equal. Since 3 operations were used, 3 is the output.

 

 **Constraints:** 

- 2 <= nums.length <= 105
- -106 <= nums[i] <= 106
- 2 <= x <= nums.length
- 1 <= k <= 15
- 2 <= k * x <= nums.length

## Solution

**Language:** Java  
**Runtime:** 343 ms (beats 89.19%)  
**Memory:** 162.2 MB (beats 64.86%)  
**Submitted:** 2026-11-05T15:15:55.437Z  

```java
import java.util.Arrays;

class Solution {
    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;

        // Step 1: Coordinate compression
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int[] values = Arrays.stream(sorted).distinct().toArray();
        int m = values.length;

        // Assign each number its compressed rank
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            rank[i] = Arrays.binarySearch(values, nums[i]) + 1;
        }

        // Step 2: Fenwick Tree for frequency and prefix sum
        int[] count = new int[m + 1];
        long[] sum = new long[m + 1];

        int size = 1;
        while (size * 2 <= m) size *= 2;

        int need = (x + 1) / 2;
        int windows = n - x + 1;
        long[] cost = new long[windows];

        long windowSum = 0;

        // Step 3: Calculate the cost of making each window equal
        for (int i = 0; i < n; i++) {
            windowSum += nums[i];

            // Add the current element
            for (int p = rank[i]; p <= m; p += p & -p) {
                count[p]++;
                sum[p] += nums[i];
            }

            // Remove the element that leaves the window
            if (i >= x) {
                windowSum -= nums[i - x];

                for (int p = rank[i - x]; p <= m; p += p & -p) {
                    count[p]--;
                    sum[p] -= nums[i - x];
                }
            }

            // Process a complete window of size x
            if (i >= x - 1) {
                int pos = 0;
                int remaining = need;
                long leftSum = 0;

                // Find the median using Fenwick Tree
                for (int bit = size; bit > 0; bit >>= 1) {
                    int next = pos + bit;

                    if (next <= m && count[next] < remaining) {
                        pos = next;
                        remaining -= count[next];
                        leftSum += sum[next];
                    }
                }

                long median = values[pos];
                long leftCount = need - remaining;

                // Minimum operations to make this window equal to its median
                cost[i - x + 1] =
                    median * leftCount - leftSum
                    + (windowSum - leftSum)
                    - median * (x - leftCount);
            }
        }

        // Step 4: DP to choose k non-overlapping windows
        long INF = Long.MAX_VALUE / 4;

        long[] prev = new long[n + 1];
        long[] curr = new long[n + 1];

        for (int j = 1; j <= k; j++) {
            Arrays.fill(curr, INF);

            for (int i = 1; i <= n; i++) {
                // Option 1: Do not select a window ending at i
                curr[i] = curr[i - 1];

                // Option 2: Select the window [i-x, i-1]
                if (i >= x && prev[i - x] != INF) {
                    curr[i] = Math.min(
                        curr[i],
                        prev[i - x] + cost[i - x]
                    );
                }
            }

            // Move to the next DP layer
            long[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[n];
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/minimum-operations-to-make-elements-within-k-subarrays-equal/)