package MySQL;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.sql.*;

public class MySQLExport {
    private final String URL = "jdbc:mysql://localhost:3306/quanlycaphe";
    private final String USER = "root";
    private final String PASSWORD = "anhtuan2407";

    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton btnExhdb, btnExhdnh, btnnv, btnsp, btnnl, btnkh;
    private JScrollPane scrollPane;

    public MySQLExport() {
        frame = new JFrame("Export");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        btnExhdb = new JButton("Xuất HĐ Bán Hàng");
        btnExhdnh = new JButton("Xuất HĐ Nhập Hàng");
        btnnv = new JButton("Nhân viên");
        btnsp = new JButton("Sản phẩm");
        btnnl = new JButton("Nguyên liệu");
        btnkh = new JButton("Khách hàng");

        panel.add(btnExhdb);
        panel.add(btnExhdnh);
        panel.add(btnnv);
        panel.add(btnsp);
        panel.add(btnnl);
        panel.add(btnkh);
        frame.add(panel, BorderLayout.SOUTH);

        btnExhdb.addActionListener(e -> xuathoadonbanhang());
        btnExhdnh.addActionListener(e -> xuathoadonnhaphang());
        btnnv.addActionListener(e -> xuatnhanvien());
        btnsp.addActionListener(e -> xuatsanpham());
        btnnl.addActionListener(e -> xuatnguyenlieu());
        btnkh.addActionListener(e -> xuatkhachhang());
        try {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        conn.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }

        frame.setVisible(true);
    }

    public void xuathoadonbanhang() {
        tableModel.setRowCount(0);
        tableModel.setColumnIdentifiers(new String[] {
                "Mã HĐ", "Thời gian", "Tổng tiền", "Tên NV", "SDT KH", "Mã SP", "Tên SP", "Giá", "Số lượng" });

        String sql = "SELECT h.MAHDBH, h.THOIGIAN, h.TONGTIEN, n.TENNV, h.MAKH, s.MASP, s.TENSP, s.GIASP, c.SOLUONGBAN "
                +
                "FROM hoadonbanhang h " +
                "JOIN chitietban c ON h.MAHDBH = c.MAHDBH " +
                "JOIN sanpham s ON c.MASP = s.MASP " +
                "JOIN nhanvien n ON h.MANV = n.MANV ";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                tableModel.addRow(new Object[] {
                        rs.getString("MAHDBH"),
                        rs.getTime("THOIGIAN"),
                        rs.getDouble("TONGTIEN"),
                        rs.getString("TENNV"),
                        rs.getString("MAKH"),
                        rs.getString("MASP"),
                        rs.getString("TENSP"),
                        rs.getDouble("GIASP"),
                        rs.getInt("SOLUONGBAN")
                });
            }
            conn.close();
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void xuathoadonnhaphang() {
        tableModel.setRowCount(0);
        tableModel.setColumnIdentifiers(
                new String[] { "Mã HĐ", "Thời gian", "Thành tiền", "Tên NV", "Mã NL", "Tên NL", "Giá", "Số lượng" });

        String sql = "SELECT h.MAHDNH, h.THOIGIAN, h.THANHTIEN, nhanvien.TENNV, n.MANL, n.TENNL, n.GIANL, c.SOLUONGNHAP "
                +
                "FROM hoadonnhaphang h " +
                "JOIN chitietnhap c ON h.MAHDNH = c.MAHDNH " +
                "JOIN nguyenlieu n ON c.MANL = n.MANL " +
                "JOIN nhanvien ON h.MANV = nhanvien.MANV";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                tableModel.addRow(new Object[] {
                        rs.getString("MAHDNH"),
                        rs.getTime("THOIGIAN"),
                        rs.getDouble("THANHTIEN"),
                        rs.getString("TENNV"),
                        rs.getString("MANL"),
                        rs.getString("TENNL"),
                        rs.getDouble("GIANL"),
                        rs.getInt("SOLUONGNHAP")
                });
            }
            conn.close();
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void xuatnhanvien() {
        String sql = "SELECT * FROM nhanvien "
                +"WHERE nhanvien.TThoatdong = 'Đang làm việc'";
        tableModel.setRowCount(0);
        tableModel.setColumnIdentifiers(
                new String[] { "Mã NV", "Tên NV", "SĐT NV", "Giới tính", "Địa chỉ", "Ngày sinh", "Lương", "Chức vụ", });
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                tableModel.addRow(new Object[] {
                        rs.getString("MANV"),
                        rs.getString("TENNV"),
                        rs.getString("SDTNV"),
                        rs.getString("GIOITINH"),
                        rs.getString("DIACHI"),
                        rs.getDate("NGAYSINH"),
                        rs.getDouble("LUONG"),
                        rs.getString("CHUCVU")
                });

            }
            conn.close();
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void xuatsanpham() {
        tableModel.setRowCount(0);
        tableModel.setColumnIdentifiers(new String[] { "Mã SP", "Tên SP", "Giá SP" });
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM sanpham");
            while (rs.next()) {
                tableModel.addRow(new Object[] {
                        rs.getString("MASP"),
                        rs.getString("TENSP"),
                        rs.getDouble("GIASP")
                });
            }
            conn.close();
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void xuatnguyenlieu() {
        tableModel.setRowCount(0);
        tableModel.setColumnIdentifiers(new String[] { "Mã NL", "Tên NL", "Giá NL", "Nhà CC" });
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM nguyenlieu");
            while (rs.next()) {
                tableModel.addRow(new Object[] {
                        rs.getString("MANL"),
                        rs.getString("TENNL"),
                        rs.getDouble("GIANL"),
                        rs.getString("NHACC")
                });
            }
            conn.close();
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void xuatkhachhang() {
        tableModel.setRowCount(0);
        tableModel.setColumnIdentifiers(new String[] { "SĐT KH", "Tên KH" });
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM khachhang");
            while (rs.next()) {
                tableModel.addRow(new Object[] {
                        rs.getString("SDTKH"),
                        rs.getString("TENKH")
                });
            }
            conn.close();
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MySQLExport();
    }
}