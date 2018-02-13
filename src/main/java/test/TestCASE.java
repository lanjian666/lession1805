package test;

import entity.Student;
import dao.StudentDAO;

import java.text.ParseException;

public class TestCASE {
    public static void  main(String[] args){
        StudentDAO dao=new StudentDAO();
        try {
            //dao.setObject();
            Student student=dao.getObject("lasdfj1");
            System.out.println(student.getName());
            System.out.println(student.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
