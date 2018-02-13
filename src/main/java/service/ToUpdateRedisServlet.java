package service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;
import entity.Student;

/**
 * Servlet implementation class ToUpdateRedisServlet
 */
public class ToUpdateRedisServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String birthdayStr=request.getParameter("birthday");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date birthday=null;
		try {
			birthday=sdf.parse(birthdayStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String description=request.getParameter("description");
		String avgscoreStr=request.getParameter("avgscore");
		double avgscore=Double.parseDouble(avgscoreStr);
		Student student=new Student(id,name,birthday,description,avgscore);
		StudentDAO dao=new StudentDAO();
		try {
			dao.setObject(student);
			dao.setSet(id, avgscore);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("list").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
