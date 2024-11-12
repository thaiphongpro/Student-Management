/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java3_th04120_th04120.DAO.Impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java3_th04120_th04120.Model.Student;
import java.sql.Connection;
import java.sql.ResultSet;
import java3_th04120_th04120.DAO.StudentService;

/**
 *
 * @author phong
 */
public class StudentServiceImpl implements StudentService{
    List<Student> lists = new ArrayList<>();
    public static List<Student> viewAll(){
        List<Student> lists = new ArrayList<>();
        try {
            Connection conn = DBConnection.getConnection();
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM STUDENTS";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {                
                String maSV = rs.getString(1);
                String hoTen = rs.getString(2);
                String email = rs.getString(3);
                String soDT = rs.getString(4);
                boolean gioiTinh = rs.getBoolean(5);
                String diaChi = rs.getString(6);
                String hinh = rs.getString(7);
                
                Student student = new Student(maSV, hoTen, email, soDT, Boolean.valueOf(gioiTinh), diaChi, hinh);
                
                lists.add(student);
            }
            conn.close();
            rs.close();
            stm.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lists;
    }
    
    public String luuFile(String path){
        File file = new File(path);
        if (file.exists()==false) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                return "Tao file that bai";
            }
        }
        try (FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            for (Student student : lists) {
                oos.writeObject(student);
            }
        } catch (Exception e) {
            return "Luu file that bai";
        }
        return "Luu file thanh cong";
    }
}
