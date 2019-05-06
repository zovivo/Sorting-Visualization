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
	 
	private ParallelTransition swapMe(StackPane l1, StackPane l2, int step, ArrayList<StackPane> list, double speed) {
        TranslateTransition t1 = new TranslateTransition();
        TranslateTransition t2 = new TranslateTransition();
        t1.setDuration(Duration.millis(speed));
        t2.setDuration(Duration.millis(speed));
        ParallelTransition pl = new ParallelTransition();
        t1.setNode(l1);
        t2.setNode(l2);
        t1.setByX(60*step);
        t2.setByX(-60*step);
        pl.getChildren().addAll(t1, t2);
        Collections.swap(list, list.indexOf(l1), list.indexOf(l2));
        return pl;
    }
	
	
	private SequentialTransition QuickSort(int[] arr, ArrayList<StackPane> list) {
		SequentialTransition sq = new SequentialTransition();
//		int n = arr.length;
		sort(arr, 0, arr.length-1, sq);
		for (int j = 0; j < arr.length; j++) {
        	System.out.print(arr[j] + " ");
		}
		return sq;
	}
	
	void sort(int arr[], int low, int high, SequentialTransition sq) 
    { 
        if (low < high) 
        { 
            int pi = partition(arr, low, high, sq); 
            sort(arr, low, pi-1, sq); 
            sort(arr, pi+1, high, sq); 
        } 
    } 
	
	int partition(int arr[], int low, int high, SequentialTransition sq) 
    { 
//		SequentialTransition sq = new SequentialTransition();
		int step;
//		int n = arr.length;
		int pivot = arr[high];  
        int i = (low-1);
        for (int j=low; j<high; j++) 
        { 
            if (arr[j] <= pivot) 
            { 
                i++; 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
                step = j - i;
                sq.getChildren().add(swapMe(list.get(i), list.get(j), step, list, speed));
            } 
        } 
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
        step = (high) - (i+1);
        sq.getChildren().add(swapMe(list.get(i+1), list.get(high), step, list, speed));
  
        return i+1; 
    } 
  
	
	
	
	
	
	
	
	
	
	  
	  //                    R A D I X S O R T
	  
	  
	  static int getMax(int arr[], int n) 
	    { 
	        int mx = arr[0]; 
	        for (int i = 1; i < n; i++) 
	            if (arr[i] > mx) 
	                mx = arr[i]; 
	        return mx; 
	    } 
	  
	    
	    static int[] countSort(int arr[], int n, int exp) 
	    { 
	        int output[] = new int[n]; 
	        int i; 
	        int count[] = new int[10]; 
	        Arrays.fill(count,0); 
	  
	       
	        for (i = 0; i < n; i++) 
	            count[ (arr[i]/exp)%10 ]++; 
	        for (i = 1; i < 10; i++) 
	            count[i] += count[i - 1]; 
	  
	        
	        for (i = n - 1; i >= 0; i--) 
	        { 
	            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i]; 
	            count[ (arr[i]/exp)%10 ]--; 
	            
	        } 
	      
	      System.out.println("\n");
	        for (i = 0; i < n; i++) 
	            arr[i] = output[i]; 
	       
	        return arr;
	    } 
	  
	    static void radixsort(int arr[], int n) 
	    { 
	        
	        int m = getMax(arr, n); 
	 
	        for (int exp = 1; m/exp > 0; exp *= 10) 
	            countSort(arr, n, exp); 
	    } 
	  
	   
	    static void print(int arr[], int n) 
	    { 
	        for (int i=0; i<n; i++) 
	            System.out.print(arr[i]+" "); 
	    } 
	  
	  
	  
	    
	    
	    private SequentialTransition move(StackPane l1, int a ,ArrayList<StackPane> list, double speed) {
	    	SequentialTransition sq = new SequentialTransition();
		 	TranslateTransition t1 = new TranslateTransition();
	        TranslateTransition t2 = new TranslateTransition();
	    	 t1.setDuration(Duration.millis(speed));
		        t2.setDuration(Duration.millis(speed));
		        ParallelTransition pl = new ParallelTransition();
		        t1.setNode(l1);
		       t2.setNode(l1);
		       
		        t1.setByX(60*a);
		        //t2.setByX(-60*a);
		      
		       
		       
		        pl.getChildren().addAll(t1);
		        sq.getChildren().add(t1);
		       //list.set((list.indexOf(l1))+a, l1);
		        return sq;
	    	
	    }
	    
	    public StackPane getMax() {
	        StackPane MAX = list.get(0);
	        for (StackPane e: list) {
	            if (Integer.parseInt(MAX.getChildren().get(0).getId())<Integer.parseInt(e.getChildren().get(0).getId())) {
	                MAX = e;
	            }
	        }
	        return MAX;
	    }
	    
	    public SequentialTransition swap(int i, int j) {
	    	SequentialTransition animation= new SequentialTransition();
	        StackPane tmp = list.get(i);
	        list.set(i, list.get(j));
	        list.set(j, tmp);

	        list.get(i).setId(String.valueOf(i));
	        list.get(j).setId(String.valueOf(j));

	        TranslateTransition tt1 = new TranslateTransition();
	        tt1.setDuration(Duration.seconds(1));
	        tt1.setByX(60 * (i-j));
	        tt1.setNode(list.get(i));

	        TranslateTransition tt2 = new TranslateTransition();
	        tt2.setDuration(Duration.seconds(1));
	        tt2.setByX(60 * (j-i));
	        tt2.setNode(list.get(j));

	        ParallelTransition pt = new ParallelTransition();
	        pt.getChildren().addAll(tt1, tt2);

	        animation.getChildren().add(pt);
	        return animation;
	    }
	    
	 
	private SequentialTransition radixSort(int[] arr, ArrayList<StackPane> list) {
			SequentialTransition sq = new SequentialTransition();
			int n =arr.length;
			int arr1[] = new int[arr.length];
			for (int i = 0; i < arr1.length; i++) {
				arr1[i] = arr[i];
				
			}
	        int m = getMax(arr, n); 
	        int [] newArr = arr;
	      //  print(arr, n);
	        
	   	 for (int j = 0; j < list.size(); j++) {
   	  		System.out.print(list.get(j).getId()+"  ");
 	 }
	        for (int exp = 1; m/exp > 0; exp *= 10) {
	        	ParallelTransition pt = new ParallelTransition();
	        	for (int i = 0; i < newArr.length; i++) {
	        		arr1[i]=newArr[i];
					
				}
	        	 newArr = countSort(arr, n, exp);
	        	 
	        	 //System.out.println("____________");
	        	 print(arr1, n);
	        	 System.out.println("\n");
	        	 print(newArr, n);
	        	 ArrayList<StackPane> list2 = new ArrayList<StackPane>();
	        
	        	
	        	 
	        	 for (int j = 0; j < list.size(); j++) {
		      	  		System.out.println(list.get(j).getId()+" ------- "+list.get(j).getChildren().get(0).getId());
		      	  		System.out.println(AbstractSort.getbyID(list, j).getChildren().get(0).getId());

		  				
		  			}
	        	 
	        	 
	        	  for (int i = 0; i < arr1.length; i++) {
	        		  StackPane sp = AbstractSort.getbyID(list, i);
	        		
	        		 //list.get(i).setId(String.valueOf(i+a));
	  				for (int j = 0; j < newArr.length; j++) {
	  				 
	  					//System.out.println(Integer.parseInt(list.get(j).getChildren().get(0).getId()));
	  					if (Integer.parseInt(list.get(i).getChildren().get(0).getId())==(newArr[j])) {
	  						
	  						
	  	                   int a=j-Integer.parseInt(list.get(i).getId());
	  	                    System.out.println(a+" "+j+" "+i);
	  	                 list.get(i).setId(String.valueOf(j));
	  	                    pt.getChildren().add(move(list.get(i), a, list, 1500));
	  	                    //pt.setDelay(Duration.millis(2500));
	  	   				}
	  				}
	  			
	  	
		}	
	        	sq.getChildren().add(pt);  
	        	  
	        	
	        }
	        
	        
	        
	        
	        System.out.println("\n");
	        print(arr1, n);
	        System.out.println("\n");System.out.println("\n");
	        print(arr, n);
	        int temp;
	     
	      /*  for (int i = 0; i < arr1.length; i++) {
				for (int j = 0; j < newArr.length; j++) {
					if (arr1[i]==newArr[j]) {
						
						
	                    int a=j-i;
	                    //System.out.println(a);
	                    sq.getChildren().add(move(list.get(i),a, list, speed));
						
					}
				}
			}*/
	        
	        // radixsort(arr, n); 
		    //    print(arr, n); 
			
			
			
			
			
			return sq;
		}
	  
	  
	  
	  
	  
	  
	
	  public boolean check() {
		  if(nextbutton.getText().equals("next"))
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
			nextbutton.setText("next");
		}
	}
	public void dung() {
		
		sq.pause();
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
			sq = QuickSort(arr, list);
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
			sq=radixSort(arr2, list);
			// radixsort(arr2, n); 
		      //  print(arr2, n); 
	
			break;
		default:
			break;
		}
		
		//System.out.println(arr.length);
		
		//sq.setCycleCount(Timeline.INDEFINITE);
		//sq.setDelay(Duration.millis(1000.00));
		
		 sq.play();
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
