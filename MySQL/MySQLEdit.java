package MySQL;

import java.sql.*;

public class MySQLEdit {
    private final String URL = "jdbc:mysql://localhost:3306/quanlycaphe";
    private final String USER = "root";
    private final String PASSWORD = "anhtuan2407";

    public MySQLEdit() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void suanhanvien(String manv, String tennv, String sdtnv, String gioitinh, String diachi, String ngaysinh,String luong, String chucvu){
        String sql = "UPDATE nhanvien SET TENNV = ?, SDTNV = ?, GIOITINH = ?, DIACHI = ?, NGAYSINH = ?, LUONG = ?, CHUCVU = ? " +
                        "WHERE MANV = ? ";
        try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, tennv);
            pstmt.setString(2, sdtnv);
            pstmt.setString(3, gioitinh);
            pstmt.setString(4, diachi);
            pstmt.setString(5, ngaysinh);
            pstmt.setString(6, luong);
            pstmt.setString(7, chucvu);
            pstmt.setString(8, manv);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void suatrangthaihoatdong(String manv, String tthd){
        String sql = "UPDATE nhanvien SET TThoatdong = ? " +
                        "WHERE MANV = ? ";
        try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, tthd);
            pstmt.setString(2, manv);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void suakhachhang(String sdtkh, String tenkh){
        String sql = "UPDATE khachhang SET TENKH = ? " +
                        "WHERE SDTKH = ? ";
        try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, tenkh);
            pstmt.setString(2, sdtkh);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void suasanpham(String masp, String tensp, Double giasp){
        String sql = "UPDATE sanpham SET TENSP = ?, GIASP = ? " +
                        "WHERE MASP = ? ";
        try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, tensp);
            pstmt.setDouble(2, giasp);
            pstmt.setString(3,masp);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void suanguyenlieu(String manl, String tennl, Double gianl,String ncc){
        String sql = "UPDATE nguyenlieu SET TENNL = ?, GIANL = ?, NHACC = ? " +
                        "WHERE MANL = ? ";
        try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, tennl);
            pstmt.setDouble(2, gianl);
            pstmt.setString(3, ncc);
            pstmt.setString(4, manl);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
