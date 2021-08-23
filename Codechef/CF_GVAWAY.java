/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class CF_GVAWAY
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
        in.nextLine();
        while(T>0){
            String arr[]=in.nextLine().split(" ");
            int l=Integer.parseInt(arr[0]);
            int r=Integer.parseInt(arr[1]);
            int k=Integer.parseInt(arr[2]);
            if(l==r){
                System.out.println(1);
            }
            else{
                System.out.println(k);
            }
            T--;
        }
    }
}