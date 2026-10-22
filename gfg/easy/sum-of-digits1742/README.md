# Sum Of Digits

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a positive number  **n**. Find the  **sum**  of all the digits of n.

 **Examples:** 

```
Input: n = 687
Output: 21
Explanation: Sum of 687's digits: 6 + 8 + 7 = 21
```

```
Input: n = 12
Output 3
Explanation: Sum of 12's digits: 1 + 2 = 3

```

 **Constraints:** 
1 <= n <= 105

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-22T13:47:20.717Z  

```java
class Solution {
    static int sumOfDigits(int n) {
        // code here
        int sum = 0;
      
        while(n>0){
          int digit = n%10;
            sum = sum+digit;
            n=n/10;
            
        }
        return sum;
    }
    
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/sum-of-digits1742/1)