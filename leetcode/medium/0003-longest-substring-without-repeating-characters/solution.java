
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();

        int left = 0;
        int res = 0;

        for (int right = 0; right < s.length(); right++) {

            // Remove duplicate characters
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add current character
            set.add(s.charAt(right));

            // Update maximum length
            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}
