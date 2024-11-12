/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java3_th04120_th04120.DAO.Impl;

import java.util.ArrayList;
import java.util.List;
import java3_th04120_th04120.Model.Users;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java3_th04120_th04120.DAO.UsersService;
import java3_th04120_th04120.View.ViewLogin;

/**
 *
 * @author phong
 */
public class UsersServiceImpl implements UsersService{
    public static List<Users> viewAll(){
        List<Users> lists = new ArrayList<>();
        try {
            Connection conn = DBConnection.getConnection();
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM USERS";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {                
                String username = rs.getString(1);
                String password = rs.getString(2);
                String role = rs.getString(3);
                
                Users users = new Users(username, password, role);
                
                lists.add(users);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lists;
    }
    
    public static boolean checkLogin(String userName, String password){
        int row = 0;
        try {
            Connection conn = DBConnection.getConnection();
            Statement stm = conn.createStatement();
            String sql = "SELECT count(*) as rowNumber, USERNAME, PASSWORD, ROLE FROM USERS WHERE USERNAME = '"+userName+"' AND PASSWORD = '"+password+"' GROUP BY USERNAME, PASSWORD, ROLE;";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {                
                row = 1;
                String usn = rs.getString(2);
                String pass = rs.getString(3);
                String role = rs.getString(4);
                
                ViewLogin.USERS = new Users(userName, password, role);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (row > 0);
    }
}
