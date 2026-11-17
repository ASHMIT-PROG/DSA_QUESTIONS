# Longest Palindromic Substring

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a string `s`, return  *the longest*   *palindromic*   *substring*  in `s`.

 

Original
Java
 **Example 1:** 

```
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

```

 **Example 2:** 

```
Input: s = "cbbd"
Output: "bb"

```

 

 **Constraints:** 

- 1 <= s.length <= 1000
- s consist of only digits and English letters.

## Solution

**Language:** Java  
**Runtime:** 20 ms (beats 36.45%)  
**Memory:** 42.8 MB (beats 94.28%)  
**Submitted:** 2026-11-17T17:54:16.826Z  

```java
class Solution {
    public String longestPalindrome(String s) {
        int resLen = 0;
        int resIdx = 0;

        for (int i = 0; i < s.length(); i++) {
            //odd length
            int left = i;
            int right = i;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > resLen) {
                    resIdx = left;
                    resLen = right - left + 1;
                }
                left--;
                right++;
            }

            // even length
            left = i;
            right = i + 1;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > resLen) {
                    resIdx = left;
                    resLen = right - left + 1;
                }
                left--;
                right++;
            }
        }

        return s.substring(resIdx, resIdx + resLen);
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/longest-palindromic-substring/)