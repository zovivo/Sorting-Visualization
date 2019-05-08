package models.SortingAlgorithms;

import java.util.ArrayList;

import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import models.Element;

public  class OtherSort extends AbstractSort {
	
	
	
	
	 
    protected SequentialTransition move(StackPane l1, int a ,ArrayList<StackPane> list, double speed) {
    	SequentialTransition sq = new SequentialTransition();
	 	TranslateTransition t1 = new TranslateTransition();
        TranslateTransition t2 = new TranslateTransition();
    	 t1.setDuration(Duration.millis(speed*2));
	        t2.setDuration(Duration.millis(speed));
	        ParallelTransition pl = new ParallelTransition();
	        t1.setNode(l1);
	       t2.setNode(l1);
	       
	        t1.setByX(60*a);
	    
	      
	       
	       
	        pl.getChildren().addAll(t1);
	        sq.getChildren().add(t1);
	
	        return sq;
    	
    }

	public OtherSort() {
		// TODO Auto-generated constructor stub
	}

}
