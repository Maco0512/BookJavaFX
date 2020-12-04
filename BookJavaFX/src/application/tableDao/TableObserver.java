package application.tableDao;

import application.dao.DatabaseDao;

public class TableObserver extends Observer{
	
	private DatabaseDao dao;
	
	public TableObserver(DatabaseDao dao) {
		this.dao=dao;
		dao.attach(this);
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("changed");
	}

}
