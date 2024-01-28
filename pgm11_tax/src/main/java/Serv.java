

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Servlet implementation class Serv
 */
public class Serv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Serv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String name = request.getParameter("name");
		String salary = request.getParameter("salary");
		String tax = request.getParameter("tax");
		
		PrintWriter pw = response.getWriter();
		File f = new File("h:/see lab/java/pgm11_tax/record.txt");
		
		FileOutputStream fout = new FileOutputStream(f);
		fout.write(("[ Name: " + name + ", Salary: " + salary + ", Tax: " + tax + " ]\n").getBytes());
		fout.close();
		
		pw.println("added");
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
