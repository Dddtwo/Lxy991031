package com.lxy.daomain.com.lxy.dao;

import com.lxy.daomain.Student;

import java.sql.*;
import java.util.List;

public class DAO {
    private static Connection conn = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    private static String url = "jdbc:mysql://localhost:3306/test";
    private static String username = "root";
    private static String password = "root";
    static {
        try {

            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(url,username,password);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public Student selectStudentId(String Id){

        Student student =null;
        String sql = null;

        try {
            sql = "select * from tbl_student where id=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,Id);
            rs = ps.executeQuery();
            while (rs.next()){
                student = new Student();
                student.setName(rs.getString("name"));
                student.setId(rs.getString("id"));
                student.setAge(rs.getInt("age"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Close();
        }
        return student;
    }

    public static void Close(){
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
