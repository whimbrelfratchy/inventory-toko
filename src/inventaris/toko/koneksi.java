package inventaris.toko;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Feby
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class koneksi {
    private static final String URL =
        "jdbc:mysql://localhost:3306/db_inventaris_toko";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(
                URL, USER, PASSWORD
            );

            System.out.println("Koneksi Database Berhasil!");
            return conn;

        } catch (SQLException e) {
            System.out.println("Koneksi Database Gagal!");
            System.out.println(e.getMessage());
            return null;
        }
    }
}
