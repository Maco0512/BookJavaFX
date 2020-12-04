package application.dao;


import application.model.Book;
import javafx.collections.ObservableList;

public interface DatabaseDaoInterface<T> extends ExecuteInterface {
	
	ObservableList<Book>read();
    
    void update(String state,String id);
    
    void delete(String id);

	T get(String id);

	void create(String text1, String text2, String text3);
	
}