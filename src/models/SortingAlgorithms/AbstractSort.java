package models.SortingAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import models.CNode;
import models.Element;

public abstract class AbstractSort  {
	
	
	
	private SequentialTransition seq = new SequentialTransition();
	
	

	  public SequentialTransition getSq() {
		return seq;
	}

	public void setSq(SequentialTransition sq) {
		this.seq = sq;
	}
	
	public static int[] generateArrayInt(List<StackPane> list) {
		int arr[] = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (((CNode)list.get(i).getChildren().get(0)).getValue());
        }
        return arr;
    }
	
	

	public AbstractSort() {
		// TODO Auto-generated constructor stub
	}

}
