class Solution {
    public String largestNumber(int[] nums) {
        
        String numarr[]= new String[nums.length];
        for (int i=0;i<nums.length;i++){
            numarr[i]=Integer.toString(nums[i]);
        }
        Arrays.sort(numarr, (a,b)->((b+a).compareTo(a+b)));
        
        // Arrays.sort(numarr, (a,b)->(a.length()==b.length()?
        //                          (a.compareTo(b)):(b.length()-a.length())));
        StringBuilder sb=new StringBuilder();
        if(numarr[0].charAt(0)=='0'){
            return "0";
        }
        for(int i = 0;i<numarr.length;i++)
            sb.append(numarr[i]);
        return sb.toString();
    }
}