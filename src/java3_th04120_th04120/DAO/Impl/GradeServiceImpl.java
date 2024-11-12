/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java3_th04120_th04120.DAO.Impl;

import java.util.ArrayList;
import java.util.List;
import java3_th04120_th04120.Model.Grade;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java3_th04120_th04120.DAO.GradeService;

/**
 *
 * @author phong
 */
public class GradeServiceImpl implements GradeService{

    List<Grade> lists = new ArrayList<>();
    
    // Lay toan bo du lieu tu bang
    public static List<Grade> getAll() {
        List<Grade> lists = new ArrayList<>();
        try {
            Connection conn = DBConnection.getConnection();
            Statement stm = conn.createStatement();
            String sql = "SELECT G.ID, G.MASV, S.HOTEN, G.TIENGANH, G.TINHOC, G.GDTC, ROUND((G.TIENGANH + G.TINHOC + G.GDTC) / 3.0,2) AS avgDiem FROM GRADE G INNER JOIN STUDENTS S ON G.MASV = S.MASV";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String id = rs.getString(1);
                String maSV = rs.getString(2);
                String hoTen = rs.getString(3);
                String tiengAnh = rs.getString(4);
                String tinHoc = rs.getString(5);
                String gdtc = rs.getString(6);
                String diemTB = rs.getString(7);

                Grade grade = new Grade(Integer.valueOf(id), maSV, hoTen, Integer.valueOf(tiengAnh), Integer.valueOf(tinHoc), Integer.valueOf(gdtc),Double.valueOf(diemTB));

                lists.add(grade);
            }
            rs.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lists;
    }

    // Tim kiem theo mssv
    public List<Grade> searchByMssv(String maSV){
        List<Grade> listSearch = new ArrayList<>();
        try {
            Connection conn = DBConnection.getConnection();
            Statement stm = conn.createStatement();
            String sql = "SELECT G.ID, G.MASV, S.HOTEN, G.TIENGANH, G.TINHOC, G.GDTC, ROUND((G.TIENGANH + G.TINHOC + G.GDTC) / 3.0,2) FROM GRADE G INNER JOIN STUDENTS S ON G.MASV = S.MASV WHERE G.MASV = '"+maSV+"'";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {                
                Grade grade = new Grade();
                grade.setID(rs.getInt(1));
                grade.setMaSV(rs.getString(2));
                grade.setTenSV(rs.getString(3));
                grade.setTiengAnh(rs.getInt(4));
                grade.setTinHoc(rs.getInt(5));
                grade.setGDTC(rs.getInt(6));
                grade.setDiemTB(rs.getDouble(7));
                
                listSearch.add(grade);
            }
        } catch (Exception e) {
            System.out.println("Loi: "+e.toString());
        }
        return listSearch;
    }

    // Hien thi Top 3 Sinh Vien co diem cao nhat
    public List<Grade> Top3SV(){
        List<Grade> lists = new ArrayList<>();
        try {
            Connection conn = DBConnection.getConnection();
            Statement stm = conn.createStatement();
            String sql = "SELECT TOP 3 G.ID, G.MASV, S.HOTEN, G.TIENGANH, G.TINHOC, G.GDTC, ROUND((G.TIENGANH + G.TINHOC + G.GDTC) / 3.0,2) AS diemTB FROM GRADE G INNER JOIN STUDENTS S ON G.MASV = S.MASV ORDER BY diemTB DESC";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {                
                String id = rs.getString(1);
                String maSV = rs.getString(2);
                String hoTen = rs.getString(3);
                String tiengAnh = rs.getString(4);
                String tinHoc = rs.getString(5);
                String gdtc = rs.getString(6);
                String diemTB = rs.getString(7);
                
                Grade grade = new Grade(Integer.valueOf(id), maSV, hoTen, Integer.valueOf(tiengAnh), Integer.valueOf(tinHoc), Integer.valueOf(gdtc),Double.valueOf(diemTB));
            
                lists.add(grade);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return lists;
    }
}
