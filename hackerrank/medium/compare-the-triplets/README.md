# Simple Array Sum

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Alice and Bob each created one problem for HackerRank. A reviewer rates the two challenges, awarding points on a scale from <em>1</em> to <em>100</em> for three categories: <em>problem clarity</em>, <em>originality</em>, and <em>difficulty</em>. 
  
The rating for Alice's challenge is the triplet <em>a = (a[0], a[1], a[2])</em>, and the rating for Bob's challenge is the triplet <em>b = (b[0], b[1], b[2])</em>.
  
The task is to calculate their comparison points by comparing each category:    
   
<ul>
<li> If <em>a[i] > b[i]</em>, then Alice is awarded <em>1</em> point. </li>
<li> If <em>a[i] &lt; b[i]</em>, then Bob is awarded <em>1</em> point. </li>
<li> If <em>a[i] = b[i]</em>, then neither person receives a point.</li>
</ul>
 
  
<strong>Example</strong>   
  
<em>a = [1, 2, 3]</em>  
<em>b = [3, 2, 1]</em>  
<br/ >  
<ul>
<li>For elements *0*, Bob is awarded a point because <em>a[0] &lt; b[0]</em>. </li> 
<li>For the equal elements <em>a[1]</em> and <em>b[1]</em>, no points are earned. </li> 
<li>Finally, for elements <em>2</em>, <em>a[2] > b[2]</em> so Alice receives a point. </li> 
</ul>
  
The return array is <em>[1, 1]</em> with Alice's score first and Bob's second.  
  
<strong>Function Description</strong>  
  
Complete the function <em>compareTriplets</em> with the following parameter(s):  
  

- <em>int a[3]</em>: Alice's challenge rating  
- <em>int b[3]</em>: Bob's challenge rating   

  
<strong>Returns</strong>  
  
- <em>int[2]</em>: the first element is Alice's score and the second is Bob's score

**Input Format**

The first line contains <em>3</em> space-separated integers, <em>a[0]</em>, <em>a[1]</em>, and <em>a[2]</em>, the respective values in triplet <em>a</em>.		
The second line contains <em>3</em> space-separated integers, <em>b[0]</em>, <em>b[1]</em>, and <em>b[2]</em>, the respective values in triplet <em>b</em>.

**Constraints**

   
<ul>
<li> <em>1 &le; a[i] &le; 100</em></li>
<li> <em>1 &le; b[i] &le; 100</em></li>
</ul>

**Output Format**

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-24T18:49:20.375Z  

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

[View on HackerRank](https://www.hackerrank.com/challenges/compare-the-triplets/problem)