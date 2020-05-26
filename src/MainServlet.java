
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.minibankapp.conn.MySQLConnUtils;
import com.mysql.jdbc.MySQLConnection;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MiniBankApp")
public class MainServlet extends HttpServlet {

	PreparedStatement ps = null;

	public MainServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String ui = request.getParameter("userid");

		System.out.println("The Account Number : " + ui);

		ResultSet rs = null;

		try {

			MySQLConnUtils mySQLConnUtils = new MySQLConnUtils();
			Connection conn = mySQLConnUtils.getMySQLConnection();
			PreparedStatement ps = conn.prepareStatement("Select userID,balance from accountinfo where userID=?");
			ps.setString(1, ui);

			System.out.println("The connection: " + ps.getConnection());

			rs = ps.executeQuery();

			if (rs.next()) {
				request.setAttribute("uid", ui);
				String balance = rs.getString("balance");
				request.setAttribute("balance", balance);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Success.jsp");
				dispatcher.forward(request, response);

				// response.sendRedirect("Success.html");
			} else
				response.sendRedirect("Error.jsp");
			return;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
