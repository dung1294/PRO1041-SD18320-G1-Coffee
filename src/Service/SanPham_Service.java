/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import model.Sanpham;

/**
 *
 * @author ADMIN
 */
public class SanPham_Service {
    private List<Sanpham> listSP;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;
    public List<Sanpham> getAll(){
        listSP = new ArrayList();
        sql = "SELECT ID,Masp,tensanpham,soluong,dongia FROM Sanpham";
                try {// kết nối được
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();// lấy kết quả của select
            // ném ra tập kết quả rs
            while (rs.next()) {
                Sanpham sv = new Sanpham(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5));
                listSP.add(sv);
            }
            return listSP;  
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
        public int indertsp(Sanpham sp) {
        int kq = 0;
        sql = "insert into Sanpham(Masp,tensanpham,soluong,dongia) values (?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, sp.getMasp());
            ps.setString(2, sp.getTensp());
            ps.setInt(3, sp.getSoluong());
            ps.setDouble(4, sp.getDongia());
            
            kq = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            kq = 0;
        } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception e) {
            }
            return kq;
        }
    }
         public int SuaSP(String Masp , Sanpham sp) {
        sql = "update Sanpham set tensanpham=?, soluong=?, dongia=? where Masp like ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
//            ps.setString(1, sp.getMasp());
            ps.setString(1, sp.getTensp());
            ps.setInt(2, sp.getSoluong());
            ps.setDouble(3, sp.getDongia());
            ps.setString(4, sp.getMasp());
            
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
         public List<Sanpham> selectTen(String ma) {
        try {
            String sql = "SELECT [Masp] ,[tensanpham] ,[soluong], [dongia]  FROM Sanpham WHERE [Masp] LIKE ?";
            try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(1, "%" + ma + "%");
                try (ResultSet rs = ps.executeQuery();) {
                    List<Sanpham> list = new ArrayList<>();
                    while (rs.next()) {
                        Sanpham nv = new Sanpham();
                        nv.setMasp(rs.getString("Masp"));
                        nv.setTensp(rs.getString("tensanpham"));
                        nv.setSoluong(rs.getInt("soluong"));
                        nv.setDongia(rs.getDouble("dongia"));

                        list.add(nv); 
                    }
                    return list;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
