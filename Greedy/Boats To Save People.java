class Solution {
    public int numRescueBoats(int[] people, int limit) {
        if(people == null || people.length == 0) return 0;
        int boats = 0;
        Arrays.sort(people);
        int n = people.length;
        int left = 0, right = n - 1;
        while(left <= right){
            int sum = people[left] + people[right];
            if(sum <= limit){
                boats++;
                left++;
                right--;
            }
            else{
                boats++;
                right--;
            }
        }
        return boats;
    }
}