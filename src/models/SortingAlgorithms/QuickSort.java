package models.SortingAlgorithms;

import java.util.ArrayList;

import javafx.animation.SequentialTransition;
import javafx.scene.layout.StackPane;

public class QuickSort extends AbstractSort {
	
	 private SequentialTransition Sort(int[] arr, ArrayList<StackPane> list ,double speed) {
		 
		// ArrayList<StackPane> list1 = list;
			SequentialTransition sq = new SequentialTransition();
//			int n = arr.length;
			sort(arr, 0, arr.length-1, sq, list,speed);
			for (int j = 0; j < arr.length; j++) {
	        	System.out.print(arr[j] + " ");
			}
			return sq;
		}
	  
		
		void sort(int arr[], int low, int high, SequentialTransition sq,ArrayList<StackPane> list,double speed) 
	    { 
	        if (low < high) 
	        { 
	            int pi = partition(arr, low, high, sq,list,speed); 
	            sort(arr, low, pi-1, sq,list,speed); 
	            sort(arr, pi+1, high, sq,list,speed); 
	        } 
	    } 
		
		int partition(int arr[], int low, int high, SequentialTransition sq,ArrayList<StackPane> list,double speed) 
	    { 
//			SequentialTransition sq = new SequentialTransition();
			int step;
//			int n = arr.length;
	        int pivot = arr[high];  
	        int i = (low-1);
	        for (int j=low; j<high; j++) 
	        { 
	            if (arr[j] <= pivot) 
	            { 
	                i++; 
	                int temp = arr[i]; 
	                arr[i] = arr[j]; 
	                arr[j] = temp; 
	                step = j - i;
	                sq.getChildren().add(fttruoc(list.get(i), list.get(j),speed));
	                sq.getChildren().add(swapMe(list.get(i), list.get(j), step, list, speed));
	                sq.getChildren().add(ftve(list.get(j), list.get(i), speed));
	            } 
	        } 
	        int temp = arr[i+1]; 
	        arr[i+1] = arr[high]; 
	        arr[high] = temp; 
	        step = (high) - (i+1);
	        sq.getChildren().add(fttruoc(list.get(i+1), list.get(high), speed));
	        sq.getChildren().add(swapMe(list.get(i+1), list.get(high), step, list, speed));
	        sq.getChildren().add(ftve(list.get(i+1), list.get(high), speed));
	  
	        return i+1; 
	    }
	
	
	

	public QuickSort( ArrayList<StackPane> list,double speed) {
		//sint[] arr = generateArrayInt(list);
		setSq(Sort(generateArrayInt(list), list,speed));
		
		// TODO Auto-generated constructor stub
	}

}
