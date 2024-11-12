/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package java3_th04120_th04120.DAO;

import java.util.ArrayList;
import java.util.List;
import java3_th04120_th04120.Model.Student;

/**
 *
 * @author phong
 */
public interface StudentService {
    List<Student> lists = new ArrayList<>();
    
    String luuFile(String path);
}
