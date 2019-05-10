package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.sun.javafx.geom.Shape;

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
import models.Element;
import models.SortingAlgorithms.AbstractSort;
import models.SortingAlgorithms.BubbleSort;
import models.SortingAlgorithms.QuickSort;
import models.SortingAlgorithms.RadixSort;
import models.SortingAlgorithms.HeapSort;
import view.viewcode;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SortViewController  {



	@FXML
	private HBox hBox ;
	
	@FXML
	private Button Play_Pause ;
	@FXML
	private ChoiceBox<String> choicebox ;
	@FXML
	private Button Forward ;
	
	@FXML
	private Button backtoInput ;
	@FXML
	private Button Back;
	@FXML
	private Button sort;
	@FXML
	private  Slider slider ;
    
	private SequentialTransition sq = new SequentialTransition();
	private AbstractSort SortAlgorithm ;
	
	private ArrayList<StackPane> list = new ArrayList<>();
	private double speed = 1000;
	private String[] arr = new String[12];
	
	public static ArrayList<StackPane> sortUI(HBox hBox,ChoiceBox<String> choicebox ) {
		choicebox.setItems(FXCollections.observableArrayList("Bubble Sort","Quick Sort","Heap Sort","Radix Sort"));
		choicebox.setValue("Bubble Sort");
		
		  ArrayList<StackPane> list = new ArrayList<>();
		     for (int i = 0; i < InputViewController.NumberList.size() ; i++) {
		         int num = (Integer.parseInt(InputViewController.NumberList.get(i)));
		         Element node = new Element(num, i);
		         Text text = new Text(String.valueOf(InputViewController.NumberList.get(i)));
		         StackPane stackPane = new StackPane();
		         stackPane.setPrefSize(node.getWidth(), node.getHeight());
		         stackPane.getChildren().addAll(node, text);
		         list.add(stackPane);
	         
	     }
	
	     
	     hBox.getChildren().addAll(list);
	     return list;
			}
	public void initialize() {
	list=sortUI(hBox,choicebox); // ham nay tra ve list <StackPane>
	 slider.valueProperty().addListener(new ChangeListener<Number>() {
         @Override
         public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
             speed = (double) newValue;
         }
     });
	}
	public boolean check() {
		  if(Play_Pause.getText().equals("Resume"))
			  return true;
		  if (Play_Pause.getText().equals("Again")) 
			  return true;
		  return false;
	  }
	  
	public void Play_Pause() {
		if(check())
		{	sq.play();
		Play_Pause.setText("pause");
		}
		else 
		{
			sq.pause();
			Play_Pause.setText("Resume");
		}
	}
	public void forwardClicked() {
		
		Duration a = sq.getCurrentTime();
		
		sq.jumpTo(Duration.millis(a.toMillis()+2000));
	}
	public void backwardClicked() {
		Duration a = sq.getCurrentTime();
		
		sq.jumpTo(Duration.millis(a.toMillis()-2000));
	}
	
	
	public void Sort() {
		choicebox.setDisable(true);
		sort.setDisable(true);
		Play_Pause.setDisable(false);
		Play_Pause.setText("pause");
       	switch (choicebox.getValue()) {
		case "Bubble Sort":
			SortAlgorithm = new BubbleSort(list, speed);
			sq = (SortAlgorithm).getSq();
			
			break;
		
			
		case "Quick Sort":
			SortAlgorithm = new QuickSort(list, speed);
			sq = (SortAlgorithm).getSq();
		
			break;
		case "Heap Sort":
			SortAlgorithm = new HeapSort(list, speed);
			sq = (SortAlgorithm).getSq();
			
			break;
		case "Radix Sort":
			SortAlgorithm = new RadixSort(list, speed);
			 sq=(SortAlgorithm.getSq());
			break;
		default:
			break;
		}
		
	
		 sq.play();
		 
		 
		 sq.setOnFinished(new EventHandler<ActionEvent>() {

			    public void handle(ActionEvent event) {
			    	//System.out.println("end end end");
			        Play_Pause.setText("Again");
			       
			     
			    }
			});
		 
	}
	
	
	public void goBack(ActionEvent e) throws IOException {
		Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/InputView.fxml"));
        
        Parent sampleParent = loader.load();
        InputViewController controller = (InputViewController) loader.getController();
      
      
        Scene scene = new Scene(sampleParent,800,600);
        stage.setScene(scene);
    }
	
	
	
	
	
	public SortViewController() {
		
		
		
	}

}
