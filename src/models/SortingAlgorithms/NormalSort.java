package models.SortingAlgorithms;

import java.util.ArrayList;
import java.util.Collections;

import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import models.Element;

public  class NormalSort extends AbstractSort {
	
	public static ParallelTransition FillBeforeSwap(StackPane l1, StackPane l2,double speed) {
		 ParallelTransition pt = new ParallelTransition();
	        FillTransition ft1 = new FillTransition();
	        FillTransition ft2 = new FillTransition();
	        ft1.setShape((Element)l1.getChildren().get(0));
	        ft1.setDuration(Duration.millis(speed));
	        ft1.setToValue(Color.GRAY);
	        ft2.setDuration(Duration.millis(speed));
	        ft2.setShape((Element)l2.getChildren().get(0));
	        ft2.setToValue(Color.GRAY);
	        pt.getChildren().addAll(ft1,ft2);
	        return pt;
	 }
	 
	public static ParallelTransition FillAfterSwap(StackPane l1, StackPane l2,double speed) {
		 ParallelTransition pt = new ParallelTransition();
	        FillTransition ft1 = new FillTransition();
	        FillTransition ft2 = new FillTransition();
	        ft1.setShape((Element)l1.getChildren().get(0));
	        ft1.setDuration(Duration.millis(speed));
	        ft1.setToValue(Color.valueOf("#ADD8E6"));
	        ft2.setDuration(Duration.millis(speed));
	        ft2.setShape((Element)l2.getChildren().get(0));
	        ft2.setToValue(Color.valueOf("#ADD8E6"));
	        pt.getChildren().addAll(ft1,ft2);
	        return pt;
	 }
	
	public static ParallelTransition swapMe(StackPane l1, StackPane l2, int a ,ArrayList<StackPane> list, double speed) {
	  
	   TranslateTransition t1 = new TranslateTransition();
       TranslateTransition t2 = new TranslateTransition();
      
       t1.setDuration(Duration.millis(speed));
       t2.setDuration(Duration.millis(speed));
       ParallelTransition pl = new ParallelTransition();
       t1.setNode(l1);
       t2.setNode(l2);
       t1.setByX(60*a);
       t2.setByX(-60*a);
       pl.getChildren().addAll(t1, t2);
       Collections.swap(list, list.indexOf(l1), list.indexOf(l2));
       return pl;  
   }

	public NormalSort() {
		// TODO Auto-generated constructor stub
	}



}
