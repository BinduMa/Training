package com.spring.dbconnection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

public class ExDao {
	
	@Autowired
	private DataSource datasource;
		
	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}

	public DataSource getDatasource() {
		// TODO Auto-generated method stub
		return datasource;
	}
	
	

}
