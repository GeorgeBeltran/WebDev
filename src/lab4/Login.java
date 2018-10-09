package lab4;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lab4/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	private String getEmail( HttpServletRequest request) {  //maybe change the getName
		Cookie[] cookies = request.getCookies();
		if(cookies != null)
			for(Cookie cookie : cookies)
				if(cookie.getName().equals("email"))		//here too
					return cookie.getValue();
		return null;
		
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        
        out.println("<head>");
        out.println("    <meta charset=\"UTF-8\">");
        out.println("    <title>Login</title>");
        out.println("     <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"container\">");
        
        out.println("<h1>Login</h1>");
        out.println("<form action=\"Login\" method=\"post\">");
        

        
        String email = getEmail(request);
        
        if(email == null)
        	out.println("	Email: <input type=\"text\" name=\"email\" > <br>");
        else
        	out.println("	<strong>" + email + "</strong> <br>");		
        
       
        
        out.println("	  Password");
        out.println("	<input type=\"password\" name=\"password\">");
        out.println("	<br>");	
       
        	
        out.println("	<input type=\"submit\" name=\"loginBtn\" value=\"login\">");
        
        out.println("</form>");
        
       
        
        out.println("</div>");
        out.println("</body>");        
        out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("loginBtn") != null) {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(email == null)
			email = getEmail(request);
		
		
		boolean isValidEmail = email != null && email.equals("acervan5@calstatela.edu");
		boolean isValidPassword = password != null && password.equals("abcd");
		
		if (isValidEmail && isValidPassword) {
			
			Cookie cookie = new Cookie("email", email);

			
		
			response.addCookie(cookie);
			
			
		}
		else {
			
			if (!isValidEmail)
				request.setAttribute("emailError", "Invalid email");
			
			
			if (!isValidPassword)
				request.setAttribute("passwordError", "Invalid password");
	
		doGet(request, response);
		
		return;
			}
		
		}
		response.sendRedirect("MembersOnly");
	}
}
