/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Sanpham {
    private long id;
    private String masp,tensp;
    private int soluong;
    private double dongia;

    public Sanpham() {
    }

    public Sanpham(String tensp, int soluong, double dongia) {
        this.tensp = tensp;
        this.soluong = soluong;
        this.dongia = dongia;
    }
    

    public Sanpham(long id, String masp, String tensp, int soluong, double dongia) {
        this.id = id;
        this.masp = masp;
        this.tensp = tensp;
        this.soluong = soluong;
        this.dongia = dongia;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

    @Override
    public String toString() {
        return "Sanpham{" + "id=" + id + ", masp=" + masp + ", tensp=" + tensp + ", soluong=" + soluong + ", dongia=" + dongia + '}';
    }
        public Object[] toDataRow(){
        return new Object[]{this.id, this.getMasp(), this.getTensp(), this.getSoluong(),this.getDongia()};
    }
        
}
