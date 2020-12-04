package application.model;
import javafx.beans.property.*;

public class Book {
	
    private String id;
    private String title;
    private String author;
    
    private enum State{
		  ready,
		  rented,
		  booked,
		  ready1
	}
    State state;

    public Book() {}

    public Book(String id, String title, String author,String state) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.state = State.valueOf(state);
    }

    public void setState(State state) {
		this.state = state;
	}

	public String getId() {
        return id;
    }

    public State getState() {
		return state;
	}

	public void setState(String state) {
		this.state = State.valueOf(state);
	}

	public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
