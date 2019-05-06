package models.SortingAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cnode.CNode;
import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public abstract class AbstractSort {
	
	
	
	private SequentialTransition sq = new SequentialTransition();
	
	

	  public SequentialTransition getSq() {
		return sq;
	}

	public void setSq(SequentialTransition sq) {
		this.sq = sq;
	}
	
	public static int[] generateArrayInt(List<StackPane> list) {
		int arr[] = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(list.get(i).getChildren().get(0).getId());
        }
        return arr;
    }
	
	
	public static StackPane getbyID(ArrayList<StackPane>list, int id ) {
		StackPane sp = null ;
		int a=0;
		for (int i = 0; i < list.size(); i++) {
			int b = Integer.parseInt(list.get(i).getId());
			if(b==id) {
				a=i;
				sp=list.get(i);
				}
			
			
		}
		return sp;
	}
	
	public static void  setbyID(ArrayList<StackPane>list) {
		for (int i = 0; i < list.size(); i++) {
			//list.get(i)
			
		}
		
	}
	
	
	
	
	public static ParallelTransition fttruoc(StackPane l1, StackPane l2,double speed) {
		 ParallelTransition ft = new ParallelTransition();
	        FillTransition ft1 = new FillTransition();
	        FillTransition ft2 = new FillTransition();
	        ft1.setShape((CNode)l1.getChildren().get(0));
	        ft1.setDuration(Duration.millis(speed));
	        ft1.setToValue(Color.BLACK);
	        ft2.setDuration(Duration.millis(speed));
	        ft2.setShape((CNode)l2.getChildren().get(0));
	        ft2.setToValue(Color.BLACK);
	        ft.getChildren().addAll(ft1,ft2);
	        return ft;
	 }
	 
	public static ParallelTransition ftve(StackPane l1, StackPane l2,double speed) {
		 ParallelTransition ft = new ParallelTransition();
	        FillTransition ft1 = new FillTransition();
	        FillTransition ft2 = new FillTransition();
	        ft1.setShape((CNode)l1.getChildren().get(0));
	        ft1.setDuration(Duration.millis(speed));
	        ft1.setToValue(Color.valueOf("#ADD8E6"));
	        ft2.setDuration(Duration.millis(speed));
	        ft2.setShape((CNode)l2.getChildren().get(0));
	        ft2.setToValue(Color.valueOf("#ADD8E6"));
	        ft.getChildren().addAll(ft1,ft2);
	        return ft;
	 }
	
	public static ParallelTransition swapMe(StackPane l1, StackPane l2, int a ,ArrayList<StackPane> list, double speed) {
	 	SequentialTransition sq = new SequentialTransition();
	 	TranslateTransition t1 = new TranslateTransition();
        TranslateTransition t2 = new TranslateTransition();
        ParallelTransition ft = new ParallelTransition();
        FillTransition ft1 = new FillTransition();
        FillTransition ft2 = new FillTransition();
        ParallelTransition ftve = new ParallelTransition();
       
        
       
        t1.setDuration(Duration.millis(speed));
        t2.setDuration(Duration.millis(speed));
        ParallelTransition pl = new ParallelTransition();
        t1.setNode(l1);
        t2.setNode(l2);
       
        t1.setByX(60*a);
        t2.setByX(-60*a);
        ft.getChildren().addAll(ft1,ft2);
       

        pl.getChildren().addAll(t1, t2);
        sq.getChildren().addAll(ft,pl,ftve);
        Collections.swap(list, list.indexOf(l1), list.indexOf(l2));
       // Collections.la
        return pl;
        
    }

	public AbstractSort() {
		// TODO Auto-generated constructor stub
	}

}
