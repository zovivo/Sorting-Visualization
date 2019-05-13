package models.SortingAlgorithms;

import java.util.ArrayList;
import java.util.Collections;

import javax.sound.midi.Soundbank;

import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import models.Element;

public class BubbleSort extends NormalSort implements Sortable {
	
	
	public static ParallelTransition donePosition(StackPane sp) {
		ParallelTransition pl = new ParallelTransition();
		FillTransition ft = new FillTransition();
		ft.setShape((Element)sp.getChildren().get(0));
        ft.setDuration(Duration.millis(100));
        ft.setToValue(Color.BLUEVIOLET);
        pl.getChildren().add(ft);
		return pl;
		
	}
	
	@Override
	public SequentialTransition SortAndDisplay( int[] arr,ArrayList<StackPane> list, double speed) {
		
		  SequentialTransition sq = new SequentialTransition();
		
		  int temp;
		
		
			  for (int i = 0;i< arr.length; i++) { 
				  int donePosition=0;
		            for (int j = 1; j < arr.length - i; j++) {
		            	 
		                if (arr[j-1]>arr[j]) {
		                    temp = arr[j - 1];
		                    arr[j - 1] = arr[j];
		                    arr[j] = temp;
		                    int a =j-(j-1);
		                    sq.getChildren().add(FillBeforeSwap(list.get(j - 1), list.get(j), speed));
		                    sq.getChildren().add(swapMe(list.get(j - 1), list.get(j),a, list, speed));
		                    sq.getChildren().add(FillAfterSwap(list.get(j), list.get(j - 1), speed));
		                   
		                  
		                }
		           donePosition++;
		                
		            }
		            System.out.println(donePosition);
		            sq.getChildren().add(FillSortedPosition(list.get(donePosition)));
		            
		        
		           
		            
		        }
		  
	      
	        return sq;
	    }

	
	
	
	public BubbleSort(ArrayList<StackPane> list,double speed) {	
		
		 setSq(SortAndDisplay(generateIntArray(list),list, speed)) ;
	
	}
	
	
	

	
}
