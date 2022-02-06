/*
input : "3+-1i"
        "-5+7i"
*/

class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        int arr1[]=new int[2];
        int arr2[]=new int[2];
        arr1=convertString(num1);
        arr2=convertString(num2);
        int a1=arr1[0];
        int b1=arr1[1];
        int a2=arr2[0];
        int b2=arr2[1];
        int i_square=-1*(b1*b2);
        int real_term=i_square+(a1*a2);
        int i_term=(a1*b2)+(b1*a2);
        String ans=Integer.toString(real_term)+"+"+Integer.toString(i_term)+"i";
        return ans;
        
    }
    
    int[] convertString(String x){
        String converted[]=new String[2];
        for(int i =0 ;i<x.length();i++){
            if(x.charAt(i)=='+'){
                converted[0]=x.substring(0,i);
                converted[1]=x.substring(i+1,x.length()-1);
                break;
            }
        }
        int ans[]=new int[2];
        ans[0]=converted[0].charAt(0)=='-'?(-1*Integer.parseInt(converted[0].substring(1,converted[0].length()))):Integer.parseInt(converted[0]);
        ans[1]=converted[1].charAt(0)=='-'?(-1*Integer.parseInt(converted[1].substring(1,converted[1].length()))):Integer.parseInt(converted[1]);
        return ans;
    }
}