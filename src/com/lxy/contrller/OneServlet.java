package com.lxy.contrller;

import com.lxy.daomain.Student;
import com.lxy.daomain.com.lxy.dao.DAO;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        DAO dao = new DAO();
        Student student = new Student();
        student = dao.selectStudentId(id);

        System.out.println(student);




    }

}
