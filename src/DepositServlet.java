import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.minibankapp.conn.MySQLConnUtils;

import java.io.IOException;
import java.sql.*;

@WebServlet("/DepositServlet")
public class DepositServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {

	PreparedStatement ps = null;

	ResultSet rs = null;

	public DepositServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String addBal = request.getParameter("deposit");
		String uid = request.getParameter("uid");
		System.out.println(uid);

		try {
//			
			MySQLConnUtils mySQLConnUtils = new MySQLConnUtils();
			Connection conn = mySQLConnUtils.getMySQLConnection();
			PreparedStatement ps = conn.prepareStatement("Select balance from accountinfo where userID=?");
			ps.setString(1, uid);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Double balance = Double.parseDouble(rs.getString(1)) + Double.parseDouble(addBal);

			ps = conn.prepareStatement("Update accountinfo set balance=? where userID=?");
			ps.setString(1, String.valueOf(balance));
			ps.setString(2, uid);
			boolean b = ps.execute();
			// if(b==true)
			// System.out.println("Database is updated");

			ps = conn.prepareStatement("Select balance from accountinfo where userID=?");
			ps.setString(1, uid);
			rs = ps.executeQuery();
			rs.next();
			String newBal = rs.getString(1);
			System.out.println(newBal);

			request.setAttribute("newBal", newBal);
			request.setAttribute("addBal", addBal);
			request.setAttribute("uid", uid);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Deposit.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
