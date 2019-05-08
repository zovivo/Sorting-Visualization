package models;

import javafx.animation.TranslateTransition;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class CNode extends Rectangle {
	private static final Color color = Color.valueOf("#ADD8E6");
	private static final double width=40;
	private int CurrentPosition;
	private int value;
	public int getCurrentPosition() {
		return CurrentPosition;
	}

	public void setCurrentPosition(int currentPosition) {
		CurrentPosition = currentPosition;
	}
  public CNode(int value,int position) {
    setValue(value);
    setCurrentPosition(position);
    this.setFill(color);
    this.setWidth(width);
    this.setHeight(value/1000+50);
  }
  
  public void setValue(int value) {
	this.value = value;
}

public CNode(float width, float heigth) {
	    this.setWidth(width);
	    this.setHeight(heigth);
	  }

  public int getValue() {
    return this.value;
  }


}
