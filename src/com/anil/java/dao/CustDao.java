package com.anil.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class CustDao {
	
	
	 public Integer saveCustData( String adharid, String name, String adds1, String adds2) throws SQLException{
		Connection conn=getConnections();
		 PreparedStatement st=null;
		  try {
			  st = conn.prepareStatement("insert into cust (adharid,name,adds1,adds2)values(?,?,?,?)");
			  //st.setInt(1,id);
			  st.setString(1,adharid);
			  st.setString(2, name);
			  st.setString(3, adds1);
			  st.setString(4, adds2);
			  st.executeUpdate();
			  if(st!=null)
					st.close();
			  java.sql.Statement st1 = conn.createStatement();
			  ResultSet rs=st1.executeQuery("select id from  cust where adharid='"+adharid+"' ");
			  Integer id=null;
			  if(rs.next()){
				  id=rs.getInt(1);
			  }
			  return id;
			  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;
		}finally{
			try {
				if(conn!=null)
				conn.close();
				if(st!=null)
					st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public   Connection getConnections(){
		String url = "jdbc:mysql://localhost:3306/";
		  String dbName = "mysql";
		  String driver = "com.mysql.jdbc.Driver";
		  String userName = "anil"; 
		  String password = "anil";
		  Connection conn =null;
		  try {
		  Class.forName(driver).newInstance();
		 conn = DriverManager.getConnection(url+dbName,userName,password);
		  
		  } catch (Exception e) {
		  e.printStackTrace();
		  }
		  
		  return conn;
	}
	
	public static boolean insertData(String Custname, String custAdds ){
		
		return true;
		
		
	}
}
