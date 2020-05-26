import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.minibankapp.conn.MySQLConnUtils;

import java.sql.*;

@WebServlet("/WithdrawServlet")
public class WithdrawServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {

	PreparedStatement ps = null;

	ResultSet rs = null;

	public WithdrawServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String drawBal = request.getParameter("withdraw");
		String uid = request.getParameter("uid");
		System.out.println(uid);
		Double balance1 = null;

		try {

			MySQLConnUtils mySQLConnUtils = new MySQLConnUtils();
			Connection conn = mySQLConnUtils.getMySQLConnection();
			PreparedStatement ps = conn.prepareStatement("Select balance from accountinfo where userID=?");
			ps.setString(1, uid);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Double x = Double.parseDouble(rs.getString(1));
			Double y = Double.parseDouble(drawBal);

			if (x >= y) {
				balance1 = (x - y);
			} else {
				response.sendRedirect("Insufficient.jsp");
				return;
			}

			ps = conn.prepareStatement("Update accountinfo set balance=? where userID=?");
			ps.setString(1, String.valueOf(balance1));
			ps.setString(2, uid);
			boolean b = ps.execute();
			// if(b==true)
			// System.out.println("Database is updated");

			ps = conn.prepareStatement("Select balance from accountinfo where userID=?");
			ps.setString(1, uid);
			rs = ps.executeQuery();
			rs.next();
			String newBal1 = rs.getString(1);
			System.out.println(newBal1);

			request.setAttribute("newBal1", newBal1);
			request.setAttribute("uid", uid);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Withdraw.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
