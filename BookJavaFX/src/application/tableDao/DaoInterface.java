package application.tableDao;


import application.model.Book;
import javafx.collections.ObservableList;

public interface DaoInterface<T>{
    
	ObservableList<T>getAll();
    
    void save(T t);
    
    void update(T t, String[] params);
    
    void delete(T t);

	Book get(String id);
}
