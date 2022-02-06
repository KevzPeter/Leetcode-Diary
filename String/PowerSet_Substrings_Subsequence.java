public class MyClass {
    public static void main(String args[]) {
        String s="abc";
        
        MyClass obj=new MyClass();
        obj.printSub(s,"");
        obj.printPowerSet(s);
        obj.printSubstrings(s);
    }
    
    void printSub(String input, String output){
        if(input.length()==0){
            System.out.println(output);
            return;
        }
        printSub(input.substring(1), output+input.charAt(0));
        printSub(input.substring(1), output);
        
    }
    void printSubstrings(String input){
        
        for( int i=0;i<input.length();i++){
            for(int j=i+1;j<=input.length();j++){
                System.out.println(input.substring(i, j));
            }
        }
    }
    
    void printPowerSet(String input){
        int len=input.length();
        char arr[]=input.toCharArray();
        long pow=(long)Math.pow(2, len);
        
        for( int counter=1;counter<pow;counter++){
            for( int i=0;i<counter;i++){
            if((counter&(1<<i))>0) System.out.print(arr[i]);
        }
        System.out.println();
        }
    }
}