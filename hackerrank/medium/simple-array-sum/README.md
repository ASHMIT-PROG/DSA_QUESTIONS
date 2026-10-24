# Simple Array Sum

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array of integers, find the sum of its elements.

For example, if the array $ar = [1,2,3]$, $1 + 2 + 3 = 6$, so return $6$.  

**Function Description**

Complete the $simpleArraySum$ function with the following parameter(s):  

- $ar[n]$: an array of integers  

**Returns**

- $int$: the sum of the array elements

**Input Format**

The first line contains an integer, $n$, denoting the size of the array. 	
The second line contains $n$ space-separated integers representing the array's elements.  

**Constraints**

 $0 \lt n, ar[i] \le 1000$    

**Output Format**

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-24T18:46:25.957Z  

```java
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'simpleArraySum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY ar as parameter.
     */

    public static int simpleArraySum(List<Integer> ar) {
    // Write your code here
    int sum = 0;
    for (int i = 0;i<ar.size();i++){
        sum = sum+ar.get(i);
    }
    return sum;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arCount = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> ar = new ArrayList<>();

        for (int i = 0; i < arCount; i++) {
            int arItem = Integer.parseInt(arTemp[i]);
            ar.add(arItem);
        }

        int result = Result.simpleArraySum(ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/simple-array-sum/problem)