package com.lxy;

import com.lxy.daomain.Student;
import com.lxy.daomain.com.lxy.dao.DAO;

public class Test {
    public static void main(String[] args) {
        String id = "A0001";
        DAO dao = new DAO();
        Student student = dao.selectStudentId(id);
        System.out.println(student);
    }
}
