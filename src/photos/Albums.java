package photos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns= {"/photos/Albums"}, loadOnStartup=1)
public class Albums extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        
        out.println("<head>");
        out.println("    <meta charset=\"UTF-8\">");
        out.println("    <title>Photo Album</title>");
        out.println("     <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"container\">");
        
        out.println("<h1>My Albums</h1>");
        out.println("<form action=\"PhotoAlbums\" method=\"post\">");
        
        out.println("You have X amount of albums"); // have a counter that keeps track of how many albums i have
        
        
        out.println("	<p class=\"text-right\">");
        out.println("		<a href=\"CreateAlbum\"> Create Album </a>");
        out.println("	</p>");
        
        out.println("");
        out.println("");
        out.println("");
        out.println("");
        out.println("	<p class=\"text\">");
        out.println("		<a href=\"PhotoList\"> View Albums </a>");
        out.println("	</p>");
        out.println("");
       
        
        out.println("</div>");
        out.println("</body>");        
        out.println("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
