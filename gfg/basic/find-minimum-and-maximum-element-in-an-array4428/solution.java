class Solution {
    public ArrayList<Integer> getMinMax(int[] arr) {
        // code Here
        int min = arr[0];
        int max = arr[0];
        for (int i = 0;i<arr.length;i++){
            if (arr[i]>max){
                max = arr[i];
            }
            if(arr[i]<min){
                min = arr[i];
            }
        }
       ArrayList<Integer> final_min_max = new ArrayList<>();

                final_min_max.add(min);
                final_min_max.add(max);
        return final_min_max;
    } 
}
