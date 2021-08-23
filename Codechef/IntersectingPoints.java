import java.util.*;

public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		Main obj=new Main();
		int arr1[]={9,8,5};
		int arr2[]={5,6,3};
		obj.printCoordinates(arr1, arr2);
	}
	
	void printCoordinates(int c1[], int c2[]){
	    if(c1[0]<=c2[0]){
	         for(int i =c1[0]-c1[2];i<c2[0]+c2[2];i++){
	        for(int j=c1[1]-c1[2];j<c2[1]+c2[2];j++){
	            if(((Math.pow((c1[0]-i),2)+Math.pow((c1[1]-j),2))<=Math.pow(c1[2],2))&&((Math.pow((c2[0]-i),2)+(Math.pow((c2[1]-j),2))<=Math.pow(c2[2],2) )))
	            System.out.println("{"+i+","+j+"}");
	        }
	    }
	    }
	    else{
	         for(int i =c2[0]-c2[2];i<c1[0]+c1[2];i++){
	        for(int j=c1[1]-c1[2];j<c2[1]+c2[2];j++){
	            if(((Math.pow((c1[0]-i),2)+Math.pow((c1[1]-j),2))<=Math.pow(c1[2],2))&&((Math.pow((c2[0]-i),2)+(Math.pow((c2[1]-j),2))<=Math.pow(c2[2],2) )))
	            System.out.println("{"+i+","+j+"}");
	        }
	    }
	    }
	   
	}
}
