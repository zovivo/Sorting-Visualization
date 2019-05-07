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
	
	

	public AbstractSort() {
		// TODO Auto-generated constructor stub
	}

}
