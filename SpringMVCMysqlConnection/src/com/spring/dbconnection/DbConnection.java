package com.spring.dbconnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.Controller;

import com.spring.dbconnection.ExDao;

@Controller
public class DbConnection{
	
	DataSource ds, ds1, ds2;
	
	@Autowired
    private ExDao exDao;
	
	@RequestMapping("/checkConnection")
	public ModelAndView greet() {
		
		Map<String, String> msg1 = new HashMap<String, String>();
		// TODO Auto-generated method stub
		try {
			ds = exDao.getDatasource();
			/*ds1 = exDao.getDatasource();
			ds2 = exDao.getDatasource();*/
			if(ds.getConnection() != null){
				msg1.put("msg", "Connection success");			
			Connection con = ds.getConnection();
			/*Connection con1 = ds1.getConnection();
			if(con1 != null)
				System.out.println("Connection1 is success");
			Connection con2 = ds2.getConnection();
			if(con2 != null)
				System.out.println("Connection2 is success");*/
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from actor where actor_id <=10");
			while(rs.next()){
				//String s = "rs.getString(2)+ rs.getObject(3)";
				System.out.println("String print:"+rs.getString(2)+ rs.getObject(3));
				msg1.put("result", rs.getString(2)+ rs.getObject(3));
				}
			}
			else
				msg1.put("msg", "Connection failed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ModelAndView("index", msg1);
	}
	
	@RequestMapping("/checkConnection1")
	public ModelAndView greet1() {
		
		Map<String, String> msg2 = new HashMap<String, String>();
		// TODO Auto-generated method stub
		try {
			ds1 = exDao.getDatasource();
			/*ds1 = exDao.getDatasource();
			ds2 = exDao.getDatasource();*/
			if(ds1.getConnection() != null){
				msg2.put("msgnew", "Connection1 success");			
			Connection con = ds1.getConnection();
			/*Connection con1 = ds1.getConnection();
			if(con1 != null)
				System.out.println("Connection1 is success");
			Connection con2 = ds2.getConnection();
			if(con2 != null)
				System.out.println("Connection2 is success");*/
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from actor where actor_id =10");
			while(rs.next()){
				//String s = "rs.getString(2)+ rs.getObject(3)";
				System.out.println("String print:"+rs.getString(2)+ rs.getObject(3));
				msg2.put("resultnew", rs.getString(2)+ rs.getObject(3));
				}
			}
			else
				msg2.put("msgnew", "Connection failed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ModelAndView("index", msg2);
		
	}
		
		@RequestMapping("/checkConnection2")
		public ModelAndView greet2() {
			
			Map<String, String> msg2 = new HashMap<String, String>();
			// TODO Auto-generated method stub
			try {
				ds2 = exDao.getDatasource();
				/*ds1 = exDao.getDatasource();
				ds2 = exDao.getDatasource();*/
				if(ds2.getConnection() != null){
					msg2.put("msgnew1", "Connection2 success");			
				Connection con = ds2.getConnection();
				/*Connection con1 = ds1.getConnection();
				if(con1 != null)
					System.out.println("Connection1 is success");
				Connection con2 = ds2.getConnection();
				if(con2 != null)
					System.out.println("Connection2 is success");*/
				Statement stmt=con.createStatement();  
				ResultSet rs=stmt.executeQuery("select * from actor where actor_id =10");
				while(rs.next()){
					//String s = "rs.getString(2)+ rs.getObject(3)";
					System.out.println("String print:"+rs.getString(2)+ rs.getObject(3));
					msg2.put("resultnew1", rs.getString(2)+ rs.getObject(3));
					}
				}
				else
					msg2.put("msgnew1", "Connection failed");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return new ModelAndView("index", msg2);
	}

}
