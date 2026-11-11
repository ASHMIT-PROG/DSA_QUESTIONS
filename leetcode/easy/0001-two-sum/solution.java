class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> pairIdx = new HashMap<>();// here we will use hashmap

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (pairIdx.containsKey(target - num)) {
                return new int[] { i, pairIdx.get(target - num) };
            }
            pairIdx.put(num, i);
        }

        return new int[] {};        
    }
}