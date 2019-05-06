package cnode;

import javafx.animation.TranslateTransition;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class CNode extends Rectangle {

  private int value;

  public CNode(int n) {
    this.value = n;
  }
  
  public CNode(float width, float heigth) {
	    this.setWidth(width);
	    this.setHeight(heigth);
	  }

  public int getValue() {
    return this.value;
  }

  public TranslateTransition moveX(int x) {
    TranslateTransition t = new TranslateTransition();
    t.setNode(this);
    t.setDuration(Duration.millis(5000));     // toc do swap
    t.setByX(x);
    return t; 
  }

}
