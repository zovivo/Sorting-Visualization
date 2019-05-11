package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class InputViewController implements Initializable {
	
@FXML
private Button Enter;
@FXML
private Button Delete;
@FXML
private Button toSortScene;

@FXML
private TextField numberTextField;
@FXML
private Label CheckandShow;
@FXML
private TableView<String> userTable;
@FXML
private TableColumn<String, String> numbercolumn;

public static ObservableList<String> NumberList  = FXCollections.observableArrayList();

 boolean check(String number) {
	try {
	 int num =	Integer.parseInt(number);
	 if (num < 0) {
		return false;
	}

	} catch (Exception e) {
		return false;
	}
	return true;
}
public void Enter(ActionEvent event) {
	if (check(numberTextField.getText())) {
	String newNumber = new String(numberTextField.getText());
	NumberList.add(newNumber);
	CheckandShow.setText("Completed !");
	numberTextField.clear();
	}else {
		CheckandShow.setText("Wrong data");
	}
	
}

public void Delete(ActionEvent event) {
	String selected = userTable.getSelectionModel().getSelectedItem();
	NumberList.remove(selected);
		
}

public void toSortView(ActionEvent event) throws IOException {
	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/SortView.fxml"));
	Parent userview = loader.load();   // phai load truoc moi duoc goi getController
	//SortViewController sortController =((SortViewController) loader.getController());
	Scene scene = new Scene(userview,800,600);
	stage.setScene(scene);

}




	public InputViewController() {
		// TODO Auto-generated constructor stub
	}

static {
	Random rd = new Random(); // creating Random object
String[] arr = new String[12];
for (int i = 0; i < arr.length; i++) {
	arr[i]= String.valueOf(rd.nextInt(1000));		
}
NumberList = FXCollections.observableArrayList(arr);
}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	/*	 Random rd = new Random(); // creating Random object
	      String[] arr = new String[12];
	      for (int i = 0; i < arr.length; i++) {
			arr[i]= String.valueOf(rd.nextInt(1000));		
		}
	      NumberList = FXCollections.observableArrayList(arr);*/
	      
		
		numberTextField.textProperty().addListener((obs,oldText,newText) -> {Enter.setDisable(newText.trim().isEmpty());});
		numbercolumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()));
		
		userTable.setItems(NumberList);
		
		
	}

}
