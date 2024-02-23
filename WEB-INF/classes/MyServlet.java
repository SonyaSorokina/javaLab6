import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class MyServlet extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html; charset=UTF8");
        PrintWriter out = response.getWriter();

        try{
            String header = request.getParameter("header");
            int rows = Integer.parseInt(request.getParameter("rows"));
            int columns = Integer.parseInt(request.getParameter("columns"));
            String color = request.getParameter("color");
            out.println("<html>");
            out.println("<head><title>"+header+"</title></head>");
            out.println("<body>");
            out.println("<h1>" + header + "</h1>");
            out.println("<table style='background-color:"+color+";'>");
            for (int i=0; i < rows; i++){
                out.println("<tr>");
                for (int j = 0; j < columns; j++){
                    out.println("<td>"+(Math.random()*(100-1)+1)+"</td>");
                }
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("</body></html>");
        } finally{
            out.close();
        }
    }
}
