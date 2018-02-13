package service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;
import entity.Student;

/**
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id=UUID.randomUUID().toString().replaceAll("-", "");
		String name=request.getParameter("name");
		System.out.println(name+"add");
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
			dao.setSet(id, avgscore);
			dao.setObject(student);
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
