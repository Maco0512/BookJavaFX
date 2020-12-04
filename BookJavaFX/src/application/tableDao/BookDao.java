package application.tableDao;


import application.model.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BookDao implements DaoInterface<Book>{

	private ObservableList<Book> list=FXCollections.observableArrayList();
    
    public BookDao() {
    }
    
    
    @Override
    public ObservableList<Book> getAll() {
    	ObservableList<Book> list=FXCollections.observableArrayList();
        return list;
    }
    
	@Override
	public void save(Book t) {
		// TODO Auto-generated method stub
		list.add(t);
		
	}

	@Override
	public void update(Book t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Book t) {
		// TODO Auto-generated method stub
		list.remove(t);
	}

	@Override
	public Book get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
