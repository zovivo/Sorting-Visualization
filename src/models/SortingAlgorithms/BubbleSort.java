package models.SortingAlgorithms;

import java.util.ArrayList;
import java.util.Collections;

import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class BubbleSort extends NormalSort {
	
	
	

	private SequentialTransition Sort( int[] arr,ArrayList<StackPane> list, double speed) {
		
		  SequentialTransition sq = new SequentialTransition();
		
		  int temp;
		  
		
			  for (int i = 0;i< arr.length-1; i++) { 
		            for (int j = 1;j< arr.length ; j++) {
		                if (arr[j-1]>arr[j]) {
		                    temp = arr[j - 1];
		                    arr[j - 1] = arr[j];
		                    arr[j] = temp;
		                    int a =j-(j-1);
		                    sq.getChildren().add(FillBeforeSwap(list.get(j - 1), list.get(j), speed));
		                    sq.getChildren().add(swapMe(list.get(j - 1), list.get(j),a, list, speed));
		                    sq.getChildren().add(FillAfterSwap(list.get(j), list.get(j - 1), speed));
		                    
		                }
		            }
		            
		        
		           
		            
		        }
		  
	      
	        return sq;
	    }

	public BubbleSort(ArrayList<StackPane> list,double speed) {
		//int [] arr = generateArrayInt(list);
		 setSq(Sort(generateArrayInt(list),list, speed)) ;
		// TODO Auto-generated constructor stub
	}

}
