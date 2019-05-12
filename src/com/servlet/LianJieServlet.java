package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class LianJieServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LianJieServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name1 = request.getParameter("userName");
		String password1 = request.getParameter("password");

		String name2 = null;
		String password2 = null;

		// step 2 加载驱动类
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("加载成功");
			// step 3 连接数据库
			con = (Connection) DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/zhucedb", "root", "");
			System.out.println("connect创建成功");

			// 执行增删改查
			Statement sta = (Statement) con.createStatement();

			// 查询

			ResultSet rs = (ResultSet) sta.executeQuery("select*from yizhuce");
			while (rs.next()) {
				name2 = rs.getString(1);
				password2 = rs.getString(2);

				System.out.println("用户名:\t" + name2 + "\t密码:\t" + password2);

				if (name2.equals(name1) && password2.equals(password1)) {

					HttpSession session = request.getSession();
					session.setAttribute("username", name2);// session存放数据

					request.getRequestDispatcher("/su").forward(request,
							response);
				}
			}

			request.getRequestDispatcher("/Fali").forward(request, response);

		} catch (ClassNotFoundException e) {
			System.out.println("找不到……");
		} catch (SQLException sqle) {
			System.out.println("连接异常");
		}

		// out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		// out.println("<HTML>");
		// out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		// out.println("  <BODY>");
		// out.print("男男女女男男女女奶奶呢 ");
		//
		// out.println("  </BODY>");
		// out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here

	}

}
