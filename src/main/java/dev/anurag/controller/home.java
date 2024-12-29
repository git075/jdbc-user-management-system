package dev.anurag.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")
public class home extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public home() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page").toLowerCase();
		switch(page) {
		case "home" : {
			request.setAttribute("title", "HomePage");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			break;
		}
	    default : {
	    	request.setAttribute("title", "errorPage");
			request.getRequestDispatcher("error.jsp").forward(request, response);
			break;
			
	    }
		
		}
		
	}

}
