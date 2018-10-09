package photos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/photos/CreateAlbum")
public class CreateAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        
        out.println("<head>");
        out.println("    <meta charset=\"UTF-8\">");
        out.println("    <title>Create Album</title>");
        out.println("     <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"container\">");
        
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        
        out.println("<h1>Create Album</h1>");
        out.println("	<p class=\"text-right\">");
        out.println("		<a href=\"Albums\"> Back </a>");
        out.println("	</p>");
        out.println("<form action=\"CreateAlbum\" method=\"post\">");
        
        out.println(" 	Album Name: <input type=\"text\" name=\"albumName\"> <br>");
        out.println("	Description: <input type=\"text\" name=\"description\"> <br>");
        out.println("	<input type=\"submit\" name=\"createBtn\" value=\"Create Album\">");
        
        out.println("</form>");
        out.println("");
        out.println("");
        
        
        out.println("</div>");
        out.println("</body>");        
        out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
