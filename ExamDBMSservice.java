package vedant;

import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExamDBMSservice {

	static Connection con;
	static Statement sm;
	static PreparedStatement psm;
	static String query;
	static ResultSet rs;
	static String connectionUrl="jdbc:mysql://localhost:3306/?", userName="root", password="123456";
	public ExamDBMSservice()
	{
			init();
	}
	public void init()
	{
		// get connection
		try {
			con=DriverManager.getConnection(connectionUrl, userName, password );
			sm=con.createStatement();
//			create database if not exist
			query="create database if not exists exam";
			sm.execute(query);
			query="use exam";
			sm.execute(query);
			// create table if not exists
			query="create table if not exists Question (QuestionId int primary key auto_increment, Question varchar(200), A varchar(50), B varchar(50), C varchar(50), D varchar(50), Ans varchar(10))";
			sm.execute(query);
			// Create a preparedStatement object also
			query="insert into Question (Question,A,B,C,D,Ans) values (?,?,?,?,?,?)";
			psm=con.prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e); 
		}
	}//init
	public ArrayList<Question> findAll()
	{
		ArrayList<Question> QList=new ArrayList<Question>();
		query="select * from Question";
		try {
			rs=sm.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block6
			System.out.println(e); 
		}
		int QuestionId;
		String Question,A,B,C,D,Ans;
		Question q;
		try {
			while(rs.next())
			{
				QuestionId=rs.getInt("QuestionId");
				Question=rs.getString("Question");
				A=rs.getString("A");
				B=rs.getString("B");
				C=rs.getString("C");
				D=rs.getString("D");
				Ans=rs.getString("Ans");
				
				q=new Question(QuestionId,Question,A,B,C,D,Ans);
				QList.add(q);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e); 
		}//while		
		return QList;
	}//findAll
	
	boolean add(Question q)
	{
		try {
			psm.setString(1, q.getQ() );
			psm.setString(2, q.getO1() );
			psm.setString(3, q.getO2() );
			psm.setString(4, q.getO3() );
			psm.setString(5, q.getO4() );
			psm.setString(6, q.getAnswer() );
			psm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
				return false;
		}
		return true; //success
	}//add
	
	void remove(Question q)
	{
		
		try {
			query="delete from question where QuestionID="+q.getQuestionID();
			sm.execute(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e); 
		}
	}//remove

}

