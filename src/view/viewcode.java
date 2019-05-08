package view;

import java.util.ArrayList;
import java.util.Random;

import controller.Controller;
import controller.SortController;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import models.CNode;
import models.Element;;

public class viewcode {
	
	
	// day la 1 doan code nho cho phan view cua man hinh sap xep
	
	public static ArrayList<StackPane> sortUI(HBox hBox,ChoiceBox<String> choicebox ) {
		choicebox.setItems(FXCollections.observableArrayList("bubble sort","quick sort","heap sort","radix sort"));
		choicebox.setValue("bubble sort");
		
		  ArrayList<StackPane> list = new ArrayList<>();
		     Random random = new Random(5);
		     for (int i = 0; i < Controller.NumberList.size() ; i++) {
		         int num = (Integer.parseInt(Controller.NumberList.get(i)));
		         CNode node = new CNode(num, i);
		         Text text = new Text(String.valueOf(Controller.NumberList.get(i)));
		         StackPane stackPane = new StackPane();
		         stackPane.setPrefSize(node.getWidth(), node.getHeight());
		         stackPane.getChildren().addAll(node, text);
		         list.add(stackPane);
	         
	     }
	
	     
	     hBox.getChildren().addAll(list);
	     return list;
			}

	public viewcode() {
		// TODO Auto-generated constructor stub
	}

}
