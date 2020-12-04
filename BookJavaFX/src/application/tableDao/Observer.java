package application.tableDao;

import application.model.Book;

public abstract class Observer {
	protected Book book;
	public abstract void update();
}
