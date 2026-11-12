package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


@WebServlet("/signup")
public class joinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public joinServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");
		String uname = request.getParameter("username");
	
		
		String sql= "INSERT INTO member(userid, userpw, username,userdate ) VALUES (?,?,?,?)";
		
		  String driverName="com.mysql.jdbc.Driver";
	      String url= "jdbc:mysql://localhost:3306/boardtest";
	      String username="root";
	      String password="12345";
	      
	      Connection conn =null;
	      PreparedStatement pstmt = null;
	      
	      try{
	    	  Class.forName(driverName);
	    	  conn = DriverManager.getConnection(url,username,password);
	    	  
	    	  pstmt = conn.prepareStatement(sql);
	    	 
	    	  pstmt.setString(1, userid);
	    	  pstmt.setString(2, userpw);
	    	  pstmt.setString(3, uname);
	    	 
	   		  int result = pstmt.executeUpdate();
	       	  
	       	  if(result==1){
	       		  System.out.println("");
	       	  }else{
	       		 System.out.println("");
	       	  }
	      }catch(Exception e){
	    	     e.printStackTrace();
	      }finally{
	    	  try{
	    		  if(pstmt != null){
	    			  pstmt.close();
	    	      }
	    		  if(conn !=null){
	    	          conn.close();
	    	      }
	    	  }catch(Exception e){
	        	
	    	  }
	      }
	}
	
	}


