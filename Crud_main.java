package jdbc_crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Crud_main {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Crud_main  dd=new Crud_main ();
				//dd.create();
		//        dd.demo_jdbc()
		          dd.insertdata();//host code value insert
//		          dd.deletedata();
//		          dd.insert_Prepare();
//		          dd.updatedata();
	}
	public void updatedata() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/company";
		String uname = "root";
		String pass = "root";
		int id= 2;
		String query = "update emp salary  set salary = 1000 where id="+id;
		Connection con = DriverManager.getConnection(url, uname, pass);
		Statement st = con.createStatement();
			int row = st.executeUpdate(query);
			System.out.println("No of rows:"+row);
			con.close();
		
		
	}
	private void insert_Prepare() throws SQLException {
		String url = "jdbc:mysql://localhost:3308/company";
		String uname = "root";
		String pass = "root";
		Connection con = DriverManager.getConnection(url, uname, pass);
		String query = "INSERT INTO EMP VALUES(?,?,?,?)";
		int id =6;
		String name="cap";
		int Salary =20000;
		float cgpa= 9.5f;

		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, id);
		pst.setString(2, name);
		pst.setInt(3, Salary);
		pst.setFloat(4, cgpa);

		int row = pst.executeUpdate();
		System.out.println("No of row:" + " " + row);
		con.close();

	}
	

	public void deletedata() throws ClassNotFoundException, SQLException {

		String url = "jdbc:mysql://localhost:3306/company";
		String uname = "root";
		String pass = "root";
		int emp_id = 5;
		String query = "DELETE FROM emp WHERE id=" + emp_id;
		Class.forName("com.mysql.cj.jdbc.Driver");// com.mysql.jdbc.Driver
		Connection con = DriverManager.getConnection(url, uname, pass);
		Statement st = con.createStatement();
		int row = st.executeUpdate(query);
		System.out.println("Number of rows " + row);
		st.close();
		con.close();

	}

	public void insertdata() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/company";
		String uname = "root";
		String pass = "root";
		String query = "INSERT INTO emp VALUES ('5','iron','20000','5.5')";
		Class.forName("com.mysql.cj.jdbc.Driver");// com.mysql.jdbc.Driver
		Connection con = DriverManager.getConnection(url, uname, pass);
		Statement st = con.createStatement();
		int row = st.executeUpdate(query);
		System.out.println("Number of rows " + row);
		st.close();
		con.close();

	}

	public void demo_jdbc() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/company";
		String uname = "root";
		String pass = "root]";
		String query = "select * from emp";
		
		Class.forName("com.mysql.cj.jdbc.Driver");// com.mysql.jdbc.Driver
		Connection con = DriverManager.getConnection(url, uname, pass);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			String userdata = rs.getInt(1) + ":" + rs.getString(2);
			System.out.println(userdata);
		}
		st.close();
		con.close();

	}
	private void create() throws SQLException {
		String url="jdbc:mysql://localhost:3306/demo2";
		String user="root";
		String pass="root";
		String query="select * from crud";
		Connection con=DriverManager.getConnection(url,user,pass);
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		while(rs.next()) {
			String userdata=rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3);
			System.out.println(userdata);
		}
		con.close();
		st.close();
		
	}
}


