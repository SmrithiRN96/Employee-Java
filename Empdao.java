package com.Emp;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Empdao {
	public static Connection getConnect() throws ClassNotFoundException, SQLException {
		Connection con=null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/empdetails","root","");
		
		return con;
}
	
	public static int saveDetails(Empdto e) throws ClassNotFoundException, SQLException {
		int status=0;
		
		Connection con=Empdao.getConnect();
		PreparedStatement ps=con.prepareStatement("INSERT INTO DETAILS (NAME,PASSWORD,EMAIL,COUNTRY,GENDER) VALUES (?,?,?,?,?)");
		ps.setString(1, e.getName());
		ps.setString(2, e.getPwd());
		ps.setString(3, e.getEmail());
		ps.setString(4, e.getCountry());
		ps.setString(5, e.getGender());
		status=ps.executeUpdate();
		con.close();
		return status;
		
		
	}
	
	public static int updateDetails(Empdto e) throws ClassNotFoundException, SQLException {
		Connection con=Empdao.getConnect();
		int status=0;
		PreparedStatement ps=con.prepareStatement("UPDATE DETAILS SET NAME=?,PASSWORD=?,EMAIL=?,COUNTRY=?,GENDER=? WHERE ID=?");
		ps.setString(1, e.getName());
		ps.setString(2, e.getPwd());
		ps.setString(3, e.getEmail());
		ps.setString(4, e.getCountry());
		ps.setString(5, e.getGender());
		ps.setInt(6, e.getId());
	 status=ps.executeUpdate();
		con.close();
		return status;
	}
	
	public static List<Empdto> showDetails() throws ClassNotFoundException, SQLException {
		Connection con=Empdao.getConnect();
		List<Empdto> l=new ArrayList<Empdto>();
		PreparedStatement ps=con.prepareStatement("SELECT * FROM DETAILS");
		//ps.setInt(1, e.getId());
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
			Empdto e=new Empdto();
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setPwd(rs.getString(3));
			e.setEmail(rs.getString(4));
			e.setCountry(rs.getString(5));
			e.setGender(rs.getString(6));
			l.add(e);
		}
		con.close();
		return l;
	}
	
	public static Empdto selectbyId(int id) throws ClassNotFoundException, SQLException {
		Connection con=Empdao.getConnect();
		PreparedStatement ps=con.prepareStatement("SELECT * FROM DETAILS WHERE ID=?");
		ps.setInt(1, id);
		Empdto e=new Empdto();
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setPwd(rs.getString(3));
			e.setEmail(rs.getString(4));
			e.setCountry(rs.getString(5));
			e.setGender(rs.getString(6));
	}
		return e;
	}
	
	public static int deleteDetails(int id) throws ClassNotFoundException, SQLException {
		Connection con=Empdao.getConnect();
		Empdto e =new Empdto();
		PreparedStatement ps=con.prepareStatement("DELETE FROM DETAILS WHERE ID=?");
		ps.setInt(1, id);
		int status= ps.executeUpdate();
		return status;
	}
		
	

}
