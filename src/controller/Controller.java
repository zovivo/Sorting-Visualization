package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.User;

public class Controller implements Initializable {
	
@FXML
private Button buttonNhap;
@FXML
private Button buttonXoa;
@FXML
private Button buttonChuyen;
@FXML
private TextField username;
@FXML
private TextField phonenumber;


@FXML
private TableView<String> userTable;
@FXML
private TableColumn<String, String> phonenumbercolumn;

public static ObservableList<String> userList  = FXCollections.observableArrayList(
		("0123456789"),
		("0123456789"),
		("0123456789"),
		("0123456789"),
		("0123456789"),
		("0123456789"),
		("0123456789"),
		("0123456789"),
		("0123456789"),
		("0123456789"),
		("0123456789"),
		("0123456789")
		);


public void nhap(ActionEvent event) {
		
	String newNumber = new String(phonenumber.getText());
	userList.add(newNumber);
	//username.clear();
	phonenumber.clear();
	
}

public void xoa(ActionEvent event) {
	String selected = userTable.getSelectionModel().getSelectedItem();
	userList.remove(selected);
		
}

public void chuyen(ActionEvent event) throws IOException {
	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	for (int i = 0; i < userList.size(); i++) {
		
		System.out.println(userList.get(i));
		
	}
	FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/sort.fxml"));
	Parent userview = loader.load();   // phai load truoc moi duoc goi getController
	SortController sortController =((SortController) loader.getController());
	//sortController.sortUI();
	
	Scene scene = new Scene(userview,800,600);
	
	
	stage.setScene(scene);
	
	
	
}




	public Controller() {
		// TODO Auto-generated constructor stub
	}




	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//username.textProperty().addListener((obs,oldText,newText) -> {buttonNhap.setDisable(newText.trim().isEmpty());});
		phonenumber.textProperty().addListener((obs,oldText,newText) -> {buttonNhap.setDisable(newText.trim().isEmpty());});
		
		
	userList = FXCollections.observableArrayList(
				("6789"),
				("89"),
				("9"),
				("56"),
				("123"),
				("12"),
				("0"),
				("6"),
				("59"),
				("88"),
				("105"),
				("221")
				);
		//usernamecolumn.setCellValueFactory(new PropertyValueFactory<User, String>("userName"));
		//phonenumbercolumn.setCellValueFactory(new PropertyValueFactory<String, String>("phonenumber"));
		phonenumbercolumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()));
		userTable.setItems(userList);
		// TODO Auto-generated method stub
		
	}

}
