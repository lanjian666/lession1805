package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;
import entity.Student;

/**
 * Servlet implementation class ListServlet
 */
public class ListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String pageStr=request.getParameter("page");
		if ("0".equals(pageStr)||pageStr==null) {
			pageStr="1";
		}
		int page=Integer.parseInt(pageStr);
		List list =new ArrayList();
		StudentDAO dao=new StudentDAO();
		Set<String> setScore = dao.getSet(page);
		if (setScore.size()==0) {
			page=page-1;
			setScore=dao.getSet(page);
		}
		for (String set : setScore) {
			Student student=dao.getObject(set);
			System.out.println(student.getName()+"list");
			list.add(student);
		}
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		request.getRequestDispatcher("list.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
