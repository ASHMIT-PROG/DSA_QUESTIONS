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