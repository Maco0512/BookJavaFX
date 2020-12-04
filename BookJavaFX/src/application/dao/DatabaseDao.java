package application.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import application.model.Book;
import application.tableDao.Observer;
import application.tableDao.TableObserver;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DatabaseDao implements DatabaseDaoInterface<Book>{
	
	private Connection connection;
	private List<Observer> observers = new ArrayList<Observer>();
	
	
	public DatabaseDao() {
		connection=DBConnection.getConnection();
	}
	@Override
	public void executeQuery(String query) {
		// TODO Auto-generated method stub
		Statement statement;
		try {
			statement=connection.createStatement();
			statement.executeUpdate(query);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void create(String text1,String text2,String text3) {
		// TODO Auto-generated method stub
		String query="INSERT INTO BOOK VALUES ( '"+text1+"','"+text2+"','"+text3+"', 'ready')";
		executeQuery(query);
		notifyAllObservers();
		
	}

	@Override
	public ObservableList<Book> read() {
		// TODO Auto-generated method stub
		ObservableList<Book> list=FXCollections.observableArrayList();
		String query="Select * from Book";
		Statement statement;
		ResultSet resultSet;
		try {
			statement=connection.createStatement();
			resultSet=statement.executeQuery(query);
			Book books;
			while(resultSet.next()) {
				books=new Book(resultSet.getString("id"),resultSet.getString("Title"),resultSet.getString("Author"),resultSet.getString("State"));
				list.add(books);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void update(String state,String id) {
		// TODO Auto-generated method stub
		String query="UPDATE Book SET State='"+state+"' Where id='"+id+"'";
		executeQuery(query);
		notifyAllObservers();
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		String query="Delete from Book Where id='"+id+"'";
		executeQuery(query);
		notifyAllObservers();
		
	}
	
	public void notifyAllObservers(){
	      for (Observer observer : observers) {
	         observer.update();
	      }
	      new TableObserver(this);
	 }
	public void attach(Observer observer){
	      observers.add(observer);		
	   }
	
	@Override
	public Book get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
