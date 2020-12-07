package com.xworkz.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.xworkz.dto.RocketDTO;

public class RocketDAO {
	private String userName;
	private String password;
	private String url;
	private String driverClass;
 
	private Connection connection;
	
//	public static Date getDate(RocketDTO dto){
//		return new Date(dto.getLaunchDate().getTime());
//	}
	
	
	public RocketDAO() {
		System.out.println("rocket dao");
	}
	
	public void init() throws SQLException, ClassNotFoundException{
		System.out.println("init");
		Class.forName(driverClass);
		connection=DriverManager.getConnection(url,this.userName,this.password);
	    
	}
	
	public void save(RocketDTO dto ) throws SQLException{
		System.out.println("Save");
		PreparedStatement statement;
		statement=connection.prepareStatement("insert into jdbcExamples.rocket_table values(?,?,?)");
		statement.setString(1,dto.getCountry());
		
		
		statement.setDate(2,new Date(dto.getLaunchDate().getTime()) );
		statement.setDouble(3, dto.getCost());
		statement.execute();
		statement.close(); 
	}
	
	public void get(RocketDTO dto ) throws SQLException{
		Statement statement;
		statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery("select * from jdbcexamples.rocket_table");
		
		while(resultSet.next()){
			System.out.println(resultSet.getString(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getString(3));
			
		}
		statement.close();
		
	}
	
	public void update(RocketDTO dto ) throws SQLException{
		System.out.println("update");
		PreparedStatement preparedStatement;
		preparedStatement=connection.prepareStatement("update jdbcexamples.rocket_table set country=? where cost=? ");
		preparedStatement.setString(1, dto.getCountry());
		preparedStatement.setDouble(2, dto.getCost());
		
		preparedStatement.execute();
		preparedStatement.close();
	}
	
	public void delete(RocketDTO dto ) throws SQLException{
		System.out.println("delete");
		PreparedStatement preparedStatement;
		preparedStatement=connection.prepareStatement("delete jdbcexamples.rocket_table where launchDate=? ");
		preparedStatement.setDate(1, new Date(dto.getLaunchDate().getTime()));
		
		
		preparedStatement.execute();
		preparedStatement.close();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDriverClass() {
		return driverClass;
	}

	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}
	
	public void destroy() throws SQLException{
		connection.close();
		System.out.println("close connection");
		
	}
}
