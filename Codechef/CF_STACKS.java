/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class CF_STACKS
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new
        InputStreamReader(System.in));
		int T =Integer.parseInt(br.readLine());
        // in.nextLine();
        while(T>0){
            int N=Integer.parseInt(br.readLine());
            // in.nextLine();
            String arr[]=br.readLine().split(" ");
            ArrayList<Integer> arr2 = new ArrayList<Integer>();
            arr2.add(Integer.parseInt(arr[0]));
            for (int i=1;i<arr.length;i++){
                boolean flag=false;
                int x =Integer.parseInt(arr[i]);
                    for(int j = 0; j < arr2.size(); j++){
                        if(x<arr2.get(j)){
                            flag=true;
                            arr2.set(j,x);
                            break;
                        }
                    }
                    if(flag==false){
                        arr2.add(x);
                    }
            }
            System.out.print(arr2.size()+" ");
            for(int i: arr2){
                System.out.print(i+" ");
            }
            T--;
        }
    }
}