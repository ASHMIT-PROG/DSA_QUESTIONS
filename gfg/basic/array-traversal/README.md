# Array or List Traversal

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

Given an array  **arr[]** of size n that contains integers. Print the elements of the array in a single line with a space between them.

 **Note:**  Don't add a new line at the end.

 **Examples:** 

```
Input: arr[] = [54, 43, 2, 1, 5]
Output: 54 43 2 1 5
Explanation: Just traverse and print the numbers.
```

```
Input: arr[] = [324, 5, 2, 2]
Output: 324 5 2 2
Explanation: Just traverse and print the numbers.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-23T20:04:47.190Z  

```java

class Solution {
    public void arrayTraversal(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/array-traversal/1)