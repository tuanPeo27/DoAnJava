package MySQL;

import java.sql.*;

public class MySQLDelete {
    private final String URL = "jdbc:mysql://localhost:3306/quanlycaphe";
    private final String USER = "root";
    private final String PASSWORD = "anhtuan2407";

    public MySQLDelete() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void xoasanpham(String masp) {
        String sql = "UPDATE sanpham SET trangthaisp = 'hết bán' " +
                "WHERE masp = '%" + masp + "%'";
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            conn.close();
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void xoanhanvien(String manv) {
        String sql = "UPDATE nhanvien SET TThoatdong = 'Nghỉ việc' " +
                "WHERE manv = '%" + manv + "%'";
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            conn.close();
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void xoanguyenlieu(String manl) {
        String sql = "UPDATE nguyenlieu SET trangthainl = 'Hết' " +
                "WHERE manl = '%" + manl + "%'";
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            conn.close();
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    public static void main(String[] args) {
        new MySQLDelete();
    }
}
// package MySQL;

// import javax.swing.*;
// import javax.swing.table.*;
// import java.awt.*;
// import java.sql.*;

// public class MySQLDelete {
//     private final String URL = "jdbc:mysql://localhost:3306/quanlycaphe";
//     private final String USER = "root";
//     private final String PASSWORD = "anhtuan2407";

//     private JFrame frame;
//     private JTable table;
//     private DefaultTableModel tableModel;
//     private JButton btnDenv, btnDesp, btnDenl;
//     private JScrollPane scrollPane;

//     public MySQLDelete() {
//         frame = new JFrame("Quản lý quán cà phê");
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.setSize(800, 600);
//         frame.setLayout(new BorderLayout());

//         tableModel = new DefaultTableModel();
//         table = new JTable(tableModel);
//         scrollPane = new JScrollPane(table);
//         frame.add(scrollPane, BorderLayout.CENTER);

//         JPanel panel = new JPanel();
//         btnDenv = new JButton("Xóa Nhân viên");
//         btnDesp = new JButton("Xóa Sản phẩm");
//         btnDenl = new JButton("Xóa Nguyên liệu");

//         panel.add(btnDenv);
//         panel.add(btnDesp);
//         panel.add(btnDenl);
//         frame.add(panel, BorderLayout.SOUTH);

//         btnDesp.addActionListener(e -> xoasanpham());
//         btnDenv.addActionListener(e -> xoanhanvien());
//         btnDenl.addActionListener(e -> xoanguyenlieu());

//         try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
//             System.out.println("Kết nối thành công!");
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }

//         frame.setVisible(true);
//     }

//     // Hàm cập nhật trạng thái
//     private void capNhatTrangThai(String tableName, String columnId, String trangThaiColumn, String trangThaiValue, String message) {
//         String id = JOptionPane.showInputDialog("Nhập " + message + " cần cập nhật:");
//         if (id == null || id.trim().isEmpty()) {
//             JOptionPane.showMessageDialog(null, message + " không được để trống!");
//             return;
//         }

//         String sql = "UPDATE " + tableName + " SET " + trangThaiColumn + " = ? WHERE " + columnId + " = ?";
        
//         try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
//              PreparedStatement pstmt = conn.prepareStatement(sql)) {

//             pstmt.setString(1, trangThaiValue);
//             pstmt.setString(2, id);

//             int rowsAffected = pstmt.executeUpdate();
//             if (rowsAffected > 0) {
//                 JOptionPane.showMessageDialog(null, "Cập nhật trạng thái " + message + " thành công!");
//             } else {
//                 JOptionPane.showMessageDialog(null, "Không tìm thấy " + message + " với mã: " + id);
//             }
//         } catch (SQLException e) {
//             JOptionPane.showMessageDialog(null, "Lỗi khi cập nhật trạng thái: " + e.getMessage());
//         }
//     }

//     public void xoasanpham() {
//         capNhatTrangThai("sanpham", "masp", "trangthaisp", "Hết bán", "sản phẩm");
//     }

//     public void xoanhanvien() {
//         capNhatTrangThai("nhanvien", "manv", "TThoatdong", "Nghỉ việc", "nhân viên");
//     }

//     public void xoanguyenlieu() {
//         capNhatTrangThai("nguyenlieu", "manl", "trangthainl", "Hết", "nguyên liệu");
//     }

//     public static void main(String[] args) {
//         new MySQLDelete();
//     }
// }
