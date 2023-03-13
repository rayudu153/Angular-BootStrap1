

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Entered doGet");
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String name = request.getParameter("name1");
		String fname= request.getParameter("fname");
		String branch = request.getParameter("branch");
try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver CLASS loaded");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","tiger");
			if (connection == null) {
				System.out.println("Connection not established with Oracle Data Base");
			}else {
				System.out.println("Success..Connection is established with Oracle DB");
			}
			Statement statement = connection.createStatement();
				
			String insertQuery = "insert into studentStr values(" + name + ",'"+ fname+ "','"+ branch +"' )";
			System.out.println(insertQuery);
			int result = statement.executeUpdate(insertQuery);
			if(result == 0) {
				System.out.println("Record not inserted");
			}else {
				System.out.println("Record inserted into studentStr table");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.println("<h1> Hello "+ name);
		pw.print("</h1>");
		pw.println("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset='utf-8'>\r\n"
				+ "    <meta http-equiv='X-UA-Compatible' content='IE=edge'>\r\n"
				+ "    <title>Boot Strap 2</title>\r\n"
				+ "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD\" crossorigin=\"anonymous\">\r\n"
				+ "    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN\" crossorigin=\"anonymous\"></script>\r\n"
				+ "    <meta name='viewport' content='width=device-width, initial-scale=1'>\r\n"
				+ "    <link rel='stylesheet' type='text/css' media='screen' href='main.css'>\r\n"
				+ "    <script src='main.js'></script>\r\n"
				+ "</head>\r\n"
				+ "<body>");
		pw.println("<div class=\"table-responsive-sm\">\r\n"
				+ "        <h2>Striped Rows</h2>\r\n"
				+ "        <table class=\"table\">\r\n"
				+ "            <!--table-stripped table-border-->\r\n"
				+ "            <thead>\r\n"
				+ "                <tr >\r\n"
				+ "                    <th>");
		pw.println("Name</th>\r\n"
				+ "                    <th>father Name</th>\r\n"
				+ "                    <th>Branch</th>\r\n"
				+ "                </tr>\r\n"
				+ "            </thead>\r\n"
				+ "            <tbody>\r\n"
				+ "                <tr class=\"bg-success\">\r\n"
				+ "                    <td>");
		pw.println(name);
		pw.println("</td>\r\n"
				+ "                    <td>");
		pw.println(fname);
		pw.println("</td>\r\n"
				+ "                    <td>");
		pw.println(branch);
		pw.println("</td>\r\n"
				+ "                </tr>\r\n"
				+ "            </tbody>\r\n"
				+ "        </table>\r\n"
				+ "    </div>\r\n"
				+ "    \r\n"
				+ "   \r\n"
				+ "</body>\r\n"
				+ "</html>");
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
