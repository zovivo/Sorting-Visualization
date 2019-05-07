package models.SortingAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class RadixSort extends OtherSort {
	

	
	

	static int getMax(int arr[], int n) 
	    { 
	        int mx = arr[0]; 
	        for (int i = 1; i < n; i++) 
	            if (arr[i] > mx) 
	                mx = arr[i]; 
	        return mx; 
	    } 
	  
	    
	    static int[] countSort(int arr[], int n, int exp) 
	    { 
	        int output[] = new int[n]; 
	        int i; 
	        int count[] = new int[10]; 
	        Arrays.fill(count,0); 
	  
	       
	        for (i = 0; i < n; i++) 
	            count[ (arr[i]/exp)%10 ]++; 
	        for (i = 1; i < 10; i++) 
	            count[i] += count[i - 1]; 
	  
	        
	        for (i = n - 1; i >= 0; i--) 
	        { 
	            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i]; 
	            count[ (arr[i]/exp)%10 ]--; 
	            
	        } 
	      
	      System.out.println("\n");
	        for (i = 0; i < n; i++) 
	            arr[i] = output[i]; 
	       
	        return arr;
	    } 
	  
	    static void radixsort(int arr[], int n) 
	    { 
	        
	        int m = getMax(arr, n); 
	 
	        for (int exp = 1; m/exp > 0; exp *= 10) 
	            countSort(arr, n, exp); 
	    } 
	  
	   
	    static void print(int arr[], int n) 
	    { 
	        for (int i=0; i<n; i++) 
	            System.out.print(arr[i]+" "); 
	    } 
	  
	   
	    
	    
		private SequentialTransition Sort(int[] arr, ArrayList<StackPane> list,double speed) {
			SequentialTransition sq = new SequentialTransition();
			int n =arr.length;
			int arr1[] = new int[arr.length];
			for (int i = 0; i < arr1.length; i++) {
				arr1[i] = arr[i];
				
			}
	        int m = getMax(arr, n); 
	        int [] newArr = arr;
	   
	        
	   	 for (int j = 0; j < list.size(); j++) {
   	  		System.out.print(list.get(j).getId()+"  ");
 	 }
	        for (int exp = 1; m/exp > 0; exp *= 10) {
	        	ParallelTransition pt = new ParallelTransition();
	        	for (int i = 0; i < newArr.length; i++) {
	        		arr1[i]=newArr[i];
					
				}
	        	 newArr = countSort(arr, n, exp);
	        	 
	        	
	        	 print(arr1, n);
	        	 System.out.println("\n");
	        	 print(newArr, n);
	        	 ArrayList<StackPane> list2 = new ArrayList<StackPane>();
	        
	        	
	        	 
	        	 	        	 
	        	 
	        	  for (int i = 0; i < arr1.length; i++) {
	        		 // StackPane sp = AbstractSort.getbyID(list, i);
	        		
	        		
	  				for (int j = 0; j < newArr.length; j++) 
	  				{
	  					if (Integer.parseInt(list.get(i).getChildren().get(0).getId())==(newArr[j])) {
	  						
	  						
	  	                   int a=j-Integer.parseInt(list.get(i).getId());
	  	                    System.out.println(a+" "+j+" "+i);
	  	                 list.get(i).setId(String.valueOf(j));
	  	                    pt.getChildren().add(move(list.get(i), a, list, speed));
	  	   				}
	  				}
	  			
	  	
		}	
	        	sq.getChildren().add(pt);  
	        	  
	        	
	        }		
			return sq;
		}
	    
	    
	    
	
	

	public RadixSort(ArrayList<StackPane> list,double speed) {
		
		setSq(Sort(generateArrayInt(list), list,speed));
		
		
	}

}
