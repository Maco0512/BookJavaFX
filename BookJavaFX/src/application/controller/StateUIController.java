package application.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import application.dao.DatabaseDao;
import application.dao.DatabaseDaoInterface;
import application.model.Book;
import application.tableDao.BookDao;
import application.tableDao.DaoInterface;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class StateUIController implements UIInterface {
	
		private Stage thisStage;
		private DatabaseDaoInterface<Book> DatabaseDao;
//		private DaoInterface<Book> BookDao;
		
	  	@FXML
	    private TableView<Book> tvw_books;

	    @FXML
	    private TableColumn<Book, String> col_id;

	    @FXML
	    private TableColumn<Book, String> col_name;

	    @FXML
	    private TableColumn<Book, String> col_author;

	    @FXML
	    private TableColumn<Book, String> col_status;
	    
		@FXML
	 	private Button btn_create;

	    @FXML
	    private Button btn_rent;

	    @FXML
	    private Button btn_take_back;

	    @FXML
	    private Button btn_book;
	    
	    @FXML
	    private Button btn_delete;
	    
	    ObservableList<Book> data;
	    
	    @FXML
	    public void initialize() {
	          
	    	showTable();
	        btn_create.setOnAction(event -> setLayout());
	        
	        //set state
	        btn_rent.setOnAction(event -> {
	        	DatabaseDao.update("rented", tvw_books.getSelectionModel().getSelectedItem().getId());
	        });
	        btn_take_back.setOnAction(event -> { 
	        	DatabaseDao.update("ready", tvw_books.getSelectionModel().getSelectedItem().getId());
	        });
	        btn_book.setOnAction(event ->  {
	        	DatabaseDao.update("booked", tvw_books.getSelectionModel().getSelectedItem().getId());
	        });
	        btn_delete.setOnAction(event -> {	
	        	DatabaseDao.delete(tvw_books.getSelectionModel().getSelectedItem().getId());
	        	Book book=tvw_books.getSelectionModel().getSelectedItem();
	        	tvw_books.getItems().remove(book);
	        });
	        
	    }
	private void setLayout() {
			// TODO Auto-generated method stub
		UIInterface controller=new BookUIController(this);
        controller.showStage();
		}
	
	public void setData(ObservableList<Book> list) {
		data=list;
		tvw_books.setItems(data);
//		
	}
	public StateUIController() {
		// TODO Auto-generated constructor stub
		thisStage = new Stage();
		this.DatabaseDao=new DatabaseDao();
		
		data=DatabaseDao.read();

        // Load the FXML file
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Sample.fxml"));
            loader.setController(this);
            thisStage.setScene(new Scene(loader.load()));
            thisStage.setTitle("Book");
            

        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
//	@FXML
//    void handleMouseAction(MouseEvent event) {
//		Book book=tvw_books.getSelectionModel().getSelectedItem();
//		System.out.print("id"+book.getId());
//    }
	@Override
	public void showStage() {
        thisStage.show();
    }
	
	public void showTable() {
		col_id.setCellValueFactory(new PropertyValueFactory<Book, String>("Id"));
        col_name.setCellValueFactory(new PropertyValueFactory<Book, String>("Title"));
        col_author.setCellValueFactory(new PropertyValueFactory<Book, String>("Author"));
        col_status.setCellValueFactory(new PropertyValueFactory<Book, String>("State"));
        
        tvw_books.setItems(data);
	}

}
