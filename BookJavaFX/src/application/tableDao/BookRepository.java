package application.tableDao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BookRepository {
//	private Connection connection;
//	private Statement statement;
	public BookRepository() {
		
		
	}
//	// TODO Auto-generated method stub
//	try {
//		//1. get a connection to database
//		
//		//2.create a statement
//		
//		//3.execute query 
//		
////		ResultSet rs=stat.executeQuery("select * from Book");
//		//4.Process the result set 	
////		while(rs.next()) {
////			System.out.println(rs.getString("name")+" ,"+rs.getInt("grade"));
////		}
//	}
//	catch(Exception e) {
//		e.printStackTrace();
//	}
//	
//}
// public List<Book> readAll() {
//        List<Book> allBooks = new ArrayList<Book>(books.values());
////        allBooks.sort(Comparator.comparing(Book::getId));
//        return allBooks;
// }

	public void setData(String text, String text2, String text3) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Book","root","Succes0512");
	    Statement statement= connection.createStatement();
		String query="INSERT INTO BOOK VALUES ("+text+","+text2+","+text3+",ready)";
		statement.executeUpdate(query);
		
	}
}
