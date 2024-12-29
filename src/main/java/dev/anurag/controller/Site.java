package dev.anurag.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dev.anurag.encryption.EncryptionUtil;
import dev.anurag.entity.User;
import dev.anurag.model.Model;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Site
 */
@WebServlet("/Site")
public class Site extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Site() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page").toLowerCase();
		switch(page) {
		case "listuser" : {
			listuser(request, response);
			break;
		}
		case "adduser" : {
			adduser(request, response);
			break;
		}
		case "updateuser" : {
			updateUser(request, response);
			break;
		}
		case "deleteuser" : {
			Model.delete(Integer.parseInt(request.getParameter("user_id")));
			listuser(request, response);
			break;
		}
	    default : {
	    	request.setAttribute("title", "errorPage");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			break;
			
	    }
		
	}
			
}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String form = request.getParameter("form").toLowerCase();
		switch(form) {
		case "adduseroperation" : {
			String username = request.getParameter("Username");
			String email = request.getParameter("email");
			String encryptedUsername = EncryptionUtil.encrypt(username);
			String encryptedEmail = EncryptionUtil.encrypt(email);
			User user = new User(encryptedUsername,encryptedEmail);
		    Model.insert(user);
		    listuser(request,response);
		    break;
		}
		case "updateuseroperation":{
			User Updated_user = new User(Integer.parseInt(request.getParameter("user_id")),request.getParameter("Username"), request.getParameter("email"));
		    Model.update(Updated_user);
		    listuser(request,response);
		    break;
			
		}
		
		default : {
		    request.setAttribute("title", "errorPage");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			break;
				
		}
		
	}
		
}
	protected void listuser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> users = new ArrayList<>();
		users = Model.getallUsers();
		request.setAttribute("listuser", users); //The setAttribute function allows you to pass data from a servlet to a JSP (or another resource)
		//for further processing or display. In this case, you are passing the list of users fetched from the Model.getallUsers() function to the listuser.jsp page.
		//So, the relation is that both setAttribute() and getAttribute() are used to pass data between a servlet and a JSP
		request.setAttribute("title", "ListUsers");//We did getAttribute(title) in header.jsp and here we are attaching title with the request and the header will access the title with the help of this.
		request.getRequestDispatcher("listuser.jsp").forward(request, response);
		//The request.getRequestDispatcher("listuser.jsp").forward(request, response); line forwards the request and response objects to the listuser.jsp page.
		//When this JSP page is processed, it can access the "listuser" attribute using JSTL or Expression Language (EL).
	
	}
	protected void adduser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "Adduser");
		request.getRequestDispatcher("adduser.jsp").forward(request, response);
		
	}
	protected void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "Update User");
		request.getRequestDispatcher("updateUser.jsp").forward(request, response);
	}
	
}
