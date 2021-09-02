class Solution {
    public String reverseWords(String s) {
        
        String[] arr= s.trim().split(" +");
        int n = arr.length;
        for( int i=0; i<n/2;i++){
            String t=arr[i];
            arr[i]=arr[n-i-1];
            arr[n-i-1]=t;
        }
        StringBuilder sb = new StringBuilder();
        for( int i=0; i<n;i++){
            sb.append(arr[i].trim());
            sb.append(" ");
            
        }
        
        return sb.toString().trim();
        
    }
}