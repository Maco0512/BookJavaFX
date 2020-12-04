package application.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import application.dao.DatabaseDao;
import application.dao.DatabaseDaoInterface;
import application.model.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BookUIController implements UIInterface{
	
	private Stage stage;
    private final StateUIController sampleController;
    private DatabaseDaoInterface<Book> DatabaseDao;
    
    @FXML
    private TextField txt_id;

    @FXML
    private TextField txt_name;

    @FXML
    private TextField txt_author;

    @FXML
    private Button btn_create;
    
    
    @FXML
    public void initialize() {
        btn_create.setOnAction(event -> {
        	DatabaseDao.create(txt_id.getText().toString(), txt_name.getText().toString(), txt_author.getText().toString());
        	sampleController.setData(DatabaseDao.read());
        });
    }
	
	public BookUIController(StateUIController sampleController) {
		// TODO Auto-generated constructor stub
		this.sampleController=sampleController;
		this.DatabaseDao=new DatabaseDao();
        // Create the new stage
        this.stage = new Stage();

        // Load the FXML file
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Layout.fxml"));
            loader.setController(this);
            stage.setScene(new Scene(loader.load()));
            stage.setTitle("Book Registration");

        } catch (IOException e) {
            e.printStackTrace();
        }
		
		
	}

	@Override
	public void showStage() {
		// TODO Auto-generated method stub'
		stage.show();
		
	}
	

}
