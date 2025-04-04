package MySQL;

import java.sql.*;

public class MySQLInsert {

    private final String URL = "jdbc:mysql://localhost:3306/quanlycaphe";
    private final String USER = "root";
    private final String PASSWORD = "anhtuan2407";

    public MySQLInsert() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void nhapnhanvien(String manv, String tennv, String sdtnv, String gioitinh, String diachi, String ngaysinh,
            String luong, String chucvu) {
        String sql = "INSERT INTO nhanvien (manv, tennv, sdtnv, gioitinh, diachi, ngaysinh, luong, chucvu) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, manv);
            pstmt.setString(2, tennv);
            pstmt.setString(3, sdtnv);
            pstmt.setString(4, gioitinh);
            pstmt.setString(5, diachi);
            pstmt.setString(6, ngaysinh);
            pstmt.setString(7, luong);
            pstmt.setString(8, chucvu);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Thêm nhân viên thành công!");
            } else {
                System.out.println("Thêm nhân viên thất bại!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void nhapsanpham(String masp, String tensp, Double gia) {
        String sql = "INSERT INTO sanpham (masp, tensp, giasp) " +
                "VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, masp);
            pstmt.setString(2, tensp);
            pstmt.setDouble(3, gia);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Thêm sản phẩm thành công!");
            } else {
                System.out.println("Thêm sản phẩm thất bại!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void nhapnguyenlieu(String manl, String tennl, Double gia, String nhacc) {
        String sql = "INSERT INTO nguyenlieu (manl, tennl, gianl, nhacc) " +
                "VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, manl);
            pstmt.setString(2, tennl);
            pstmt.setDouble(3, gia);
            pstmt.setString(4, nhacc);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Thêm nguyên liệu thành công!");
            } else {
                System.out.println("Thêm nguyên liệu thất bại!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void nhapkhachhang(String sdtkh, String tenkh) {
        String sql = "INSERT INTO khachhang (sdtkh, tenkh) " +
                "VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, sdtkh);
            pstmt.setString(2, tenkh);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Thêm khách hàng thành công!");
            } else {
                System.out.println("Thêm khách hàng thất bại!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void nhaphoadonnhap(String mhdnh, Timestamp thoigian, Double thanhtien, String manv) {
        String sql = "INSERT INTO hoadonnhaphang (MAHDNH, THOIGIAN, THANHTIEN, MANV) " +
                "VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, mhdnh);
            pstmt.setTimestamp(2, thoigian);
            pstmt.setDouble(3, thanhtien);
            pstmt.setString(4, manv);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Thêm hóa đơn nhập thành công!");
            } else {
                System.out.println("Thêm hóa đơn nhập thất bại!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void nhaphoadonban(String mhdbh, Timestamp thoigian, Double tongtien, String manv, String sdtkh) {
        String sql = "INSERT INTO hoadonbanhang (MAHDBH, THOIGIAN, TONGTIEN, MANV, MAKH) " +
                "VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, mhdbh);
            pstmt.setTimestamp(2, thoigian);
            pstmt.setDouble(3, tongtien);
            pstmt.setString(4, manv);
            pstmt.setString(5, sdtkh);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Thêm hóa đơn bán thành công!");
            } else {
                System.out.println("Thêm hóa đơn bán thất bại!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void nhapchitietnhap(String mhdn,String mnl,String slnhap) {
        String sql =  "INSERT INTO chitietnhap (MAHDNH, MANL, SOLUONGNHAP) " +
                "VALUES (?, ?, ?)";
        try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, mhdn);
            pstmt.setString(2, mnl);
            pstmt.setString(3, slnhap);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Thêm chi tiết nhập thành công!");
            } else {
                System.out.println("Thêm chi tiết nhập thất bại!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            
        }

    }

    public void nhapchitietban(String mhdb, String msp, String slban){
        String sql = "INSERT INTO chitietban (MAHDBH, MASP, SOLUONGBAN) " +
                "VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, mhdb);
            pstmt.setString(2, msp);
            pstmt.setString(3, slban);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Thêm chi tiết bán thành công!");
            } else {
                System.out.println("Thêm chi tiết bán thất bại!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        // MySQLInsert insert = new MySQLInsert();
    }
}
