/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java3_th04120_th04120.Model;

import java.io.Serializable;

/**
 *
 * @author phong
 */
public class Grade implements Serializable{

    private int ID;
    private String maSV;
    private String tenSV;
    private int tiengAnh;
    private int tinHoc;
    private int GDTC;
    private double diemTB;

    public Grade() {
    }

    public Grade(int ID, String maSV, String tenSV, int tiengAnh, int tinHoc, int GDTC, double diemTB) {
        this.ID = ID;
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.tiengAnh = tiengAnh;
        this.tinHoc = tinHoc;
        this.GDTC = GDTC;
        this.diemTB = diemTB;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public int getTiengAnh() {
        return tiengAnh;
    }

    public void setTiengAnh(int tiengAnh) {
        this.tiengAnh = tiengAnh;
    }

    public int getTinHoc() {
        return tinHoc;
    }

    public void setTinHoc(int tinHoc) {
        this.tinHoc = tinHoc;
    }

    public int getGDTC() {
        return GDTC;
    }

    public void setGDTC(int GDTC) {
        this.GDTC = GDTC;
    }

    public double getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(double diemTB) {
        this.diemTB = diemTB;
    }

    @Override
    public String toString() {
        return "Grade{" + "ID=" + ID + ", maSV=" + maSV + ", tenSV=" + tenSV + ", tiengAnh=" + tiengAnh + ", tinHoc=" + tinHoc + ", GDTC=" + GDTC + ", diemTB=" + diemTB + '}';
    }

}
