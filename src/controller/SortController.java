package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.sun.javafx.geom.Shape;

import cnode.CNode;
import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import models.User;
import models.SortingAlgorithms.AbstractSort;
import models.SortingAlgorithms.BubbleSort;
import models.SortingAlgorithms.QuickSort;
import models.SortingAlgorithms.RadixSort;
import models.SortingAlgorithms.HeapSort;
import view.viewcode;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SortController  {



	@FXML
	private HBox hBox ;
	@FXML
	private Label label;
	@FXML
	private Button nextbutton ;
	@FXML
	private ChoiceBox<String> choicebox ;
	
	@FXML
	private Button back;
	@FXML
	private Button sort;
	@FXML
	private Button pause;
	@FXML
	private Button back1;
	@FXML
	private HBox slideBox = new HBox(5);
	@FXML
	private Label slow ;
	@FXML
	private Label fast ;
	@FXML
	private  Slider slider = new Slider(100, 4000, 1000);
    
	
	private SequentialTransition sq = new SequentialTransition();
	
	private static boolean nextflag;
	private ArrayList<StackPane> list = new ArrayList<>();
	private int[] arr;
	private double speed = 1000;
	public void initialize() {
	list=viewcode.sortUI(hBox,choicebox); // ham nay tra ve list <StackPane>
	 slider.valueProperty().addListener(new ChangeListener<Number>() {
         @Override
         public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
             speed = (double) newValue;
         }
     });
	}
	 
	
	
	
	
	
	
	
	
	
	  
	  
	  
	
	  public boolean check() {
		  if(nextbutton.getText().equals("Resume"))
			  return true;
		  if (nextbutton.getText().equals("Again")) 
			  return true;
		  return false;
	  }
	  
	public void next() {
		if(check())
		{	sq.play();
			nextbutton.setText("pause");
		}
		else 
		{
			sq.pause();
			nextbutton.setText("Resume");
		}
	}
	public void dung() {
		
		Duration a = sq.getCurrentTime();
		
		sq.jumpTo(Duration.millis(a.toMillis()+2000));
	}
	public void rollback() {
		Duration a = sq.getCurrentTime();
		
		sq.jumpTo(Duration.millis(a.toMillis()-2000));
	}
	
	
	
	public void sapxep() {
		sort.setDisable(true);
		nextbutton.setDisable(false);
		nextbutton.setText("pause");
        int [] arr1;
		
		
		switch (choicebox.getValue()) {
		case "bubble sort":
		
          sq = (new BubbleSort( list, speed)).getSq();
			
			break;
		
			
		case "quick sort":
			
			
			int [] arr = AbstractSort.generateArrayInt(list);
			//sq = QuickSort(arr, list);
			sq = (new QuickSort(list,speed)).getSq();
		
			break;
		case "heap sort":
			
			
			sq = (new HeapSort(list,speed)).getSq();
			
			break;
		case "radix sort":
			
			for (int i = 0; i < list.size(); i++) {
				list.get(i).setId(String.valueOf(i));
				
			}
			int[] arr2 = AbstractSort.generateArrayInt(list);
			 int n =arr2.length;
			 
			 sq=(new RadixSort(list, speed).getSq());
			//sq=radixSort(arr2, list);
			// radixsort(arr2, n); 
		      //  print(arr2, n); 
	
			break;
		default:
			break;
		}
		
	
		
		 sq.play();
		 
		 
		 sq.setOnFinished(new EventHandler<ActionEvent>() {

			    public void handle(ActionEvent event) {
			    	System.out.println("end end end");
			        nextbutton.setText("Again");
			    }
			});
			
		//sq.pause();
	     
	}
	
	
	public void goBack(ActionEvent e) throws IOException {
		Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/newtest.fxml"));
        
        Parent sampleParent = loader.load();
        Controller controller = loader.getController();
        //controller.show("1");
        
        Scene scene = new Scene(sampleParent,800,600);
        stage.setScene(scene);
    }
	
	
	
	
	
	public SortController() {
		
		
		
	}

}
