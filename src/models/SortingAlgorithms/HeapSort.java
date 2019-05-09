package models.SortingAlgorithms;

import java.util.ArrayList;

import javafx.animation.SequentialTransition;
import javafx.scene.layout.StackPane;

public class HeapSort extends NormalSort implements Sortable {
	
	
   @Override
	public SequentialTransition SortAndDisplay(int[] arr, ArrayList<StackPane> list, double speed) {
		// TODO Auto-generated method stub
		SequentialTransition sq = new SequentialTransition();
		int step;
		int n = arr.length; 
        for (int i = n / 2 - 1; i >= 0; i--) 
            heapify(arr, n, i, sq,list,speed); 
        for (int i=n-1; i>=0; i--) 
        { 
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp;
            step = i - 0;
            sq.getChildren().add(FillBeforeSwap(list.get(0), list.get(i), speed));
            sq.getChildren().add(swapMe(list.get(0), list.get(i), step, list, speed));
            sq.getChildren().add(FillAfterSwap(list.get(0), list.get(i), speed));
            heapify(arr, i, 0, sq,list, speed); 
        } 
       
		return sq;
	}
	
	void heapify(int arr[], int n, int i, SequentialTransition sq,ArrayList<StackPane> list, double speed) 
    { 
        int max = i;
        int l = 2*i + 1;
        int r = 2*i + 2;
        if (l < n && arr[l] > arr[max]) 
            max = l; 
        if (r < n && arr[r] > arr[max]) 
            max = r; 
        if (max != i) 
        { 
            int swap = arr[i]; 
            arr[i] = arr[max]; 
            arr[max] = swap; 
            int step  = max - i;
            sq.getChildren().add(FillBeforeSwap(list.get(i), list.get(max), speed));
            sq.getChildren().add(swapMe(list.get(i), list.get(max), step, list, speed));
            sq.getChildren().add(FillAfterSwap(list.get(i), list.get(max), speed));
            heapify(arr, n, max, sq,list,speed); 
        } 
    }

	
	public HeapSort( ArrayList<StackPane>list,double speed) {
		
		setSq(SortAndDisplay(generateIntArray(list), list,speed));
		// TODO Auto-generated constructor stub
	}

}
