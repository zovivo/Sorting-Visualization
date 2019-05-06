package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

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
private TableView<User> userTable;
@FXML
private TableColumn<User, String> phonenumbercolumn;
@FXML
private TableColumn<User, String> usernamecolumn;

@FXML
private TableColumn<User, String> uservalue;
public static ObservableList<User> userList  = FXCollections.observableArrayList(
		new User("0123456789","Tran Manh Cong1"),
		new User("0123456789","Tran anh Cong2"),
		new User("0123456789","Tran Manh ong3"),
		new User("0123456789","Tran Manh Cong4"),
		new User("0123456789","Tran Manh Cong5"),
		new User("0123456789","Tran anh ong6"),
		new User("0123456789","Tran Manh Cong7"),
		new User("0123456789","Tran Manh Cong8"),
		new User("0123456789","Tran anh Cong9"),
		new User("0123456789","Tran Manh Cong10"),
		new User("0123456789","Tran Manh ong11"),
		new User("0123456789","Tran Manh Cong12")
		);


public void show(String a) {
	System.out.println(a);
}


public void nhap(ActionEvent event) {
		
	User newUser = new User(phonenumber.getText(), username.getText());
	userList.add(newUser);
	username.clear();
	phonenumber.clear();
	
}

public void xoa(ActionEvent event) {
	User selected = userTable.getSelectionModel().getSelectedItem();
	userList.remove(selected);
		
}

public void chuyen(ActionEvent event) throws IOException {
	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	for (int i = 0; i < userList.size(); i++) {
		
		System.out.println(userList.get(i).getValue());
		
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
		username.textProperty().addListener((obs,oldText,newText) -> {buttonNhap.setDisable(newText.trim().isEmpty());});
		phonenumber.textProperty().addListener((obs,oldText,newText) -> {buttonNhap.setDisable(newText.trim().isEmpty());});
		
		
		userList = FXCollections.observableArrayList(
				new User("16","A A M"),
				new User("100","A A L"),
				new User("90","A A K"),
				new User("8","A A I"),
				new User("77","A A H"),
				new User("6","A A G"),
				new User("5614","A A F"),
				new User("10","A A E"),
				new User("0","A A D"),
				new User("214","A A C"),
				new User("4453","A A B"),
				new User("3","A A A")
				);
		usernamecolumn.setCellValueFactory(new PropertyValueFactory<User, String>("userName"));
		phonenumbercolumn.setCellValueFactory(new PropertyValueFactory<User, String>("phonenumber"));
		userTable.setItems(userList);
		// TODO Auto-generated method stub
		
	}

}
