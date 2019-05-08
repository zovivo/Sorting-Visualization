package models;

import controller.Controller;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Element extends StackPane {
	private static final Color color = Color.BLUE;
	private static final double width=40;
	double height;
	private Rectangle node = new Rectangle();
	private int CurrentPosition;
	private Text text ;
	
	public Element(int number,int position ) {
		
	   this.setText(new Text(String.valueOf(number)));
	   this.node.setHeight(number/1000+50);
	 //  this.node.setFill(color.valueOf(value)));
	   this.setPrefSize(width, this.node.getHeight());
	   this.setCurrentPosition(position);
	   this.getChildren().addAll(node,text);
	   this.setId(String.valueOf(text));
	//   node.getchi
		

		
		// TODO Auto-generated constructor stub
	}

	public int getCurrentPosition() {
		return CurrentPosition;
	}

	public void setCurrentPosition(int currentPosition) {
		CurrentPosition = currentPosition;
	}

	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}
	


}
