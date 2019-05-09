package models.SortingAlgorithms;

import java.util.ArrayList;

import javafx.animation.SequentialTransition;
import javafx.scene.layout.StackPane;

public interface Sortable {
	
	public SequentialTransition  SortAndDisplay( int[] arr,ArrayList<StackPane> list, double speed) ;

}
