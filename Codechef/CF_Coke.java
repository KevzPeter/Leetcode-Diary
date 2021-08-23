/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class CF_Coke
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
        in.nextLine();
        while(T>0){
            int N,M,K,L,R;
            String arr[]=in.nextLine().split(" ");
            N=Integer.parseInt(arr[0]);
            M=Integer.parseInt(arr[1]);
            K=Integer.parseInt(arr[2]);
            L=Integer.parseInt(arr[3]);
            R=Integer.parseInt(arr[4]);
            int min_cost=1000000;
            boolean flag=false;
            for(int i=0;i<N;i++){
                String arr2[]=in.nextLine().split(" ");
                int temp=Integer.parseInt(arr2[0]);
                int cost=Integer.parseInt(arr2[1]);
                for(int j=0;j<M;j++){
                    if(temp<K-1)
                    temp++;
                    else if(temp>K+1)
                    temp--;
                    else if(temp<=K+1 &&temp>=K-1)
                    temp=K;
                }
                if(temp<=R&&temp>=L){
                    flag=true;
                    if(cost<=min_cost)
                    min_cost=cost;
                }
            }
            if(flag)
            System.out.println(min_cost);
            else
            System.out.println(-1);
            T--;
        }
	}
}
