# Pow(x, n)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Implement pow(x, n), which calculates `x` raised to the power `n` (i.e., `xn`).

 

 **Example 1:** 

```
Input: x = 2.00000, n = 10
Output: 1024.00000

```

 **Example 2:** 

```
Input: x = 2.10000, n = 3
Output: 9.26100

```

 **Example 3:** 

```
Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25

```

 

 **Constraints:** 

- -100.0 < x < 100.0
- -231 <= n <= 231-1
- n is an integer.
- Either x is not zero or n > 0.
- -104 <= xn <= 104

## Solution

**Language:** Java  
**Runtime:** 1881 ms  
**Memory:** 44.6 MB  
**Submitted:** 2026-10-22T12:20:19.299Z  

```java
class Solution {
    public double myPow(double x, int n) {
        long N = Math.abs((long) n);

        double ans = 1.0;

        for (long i = 0; i < N; i++) {
            ans *= x;
        }

        if (n < 0) {
            return 1.0 / ans;
        } else {
            return ans;
        }
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/powx-n/)