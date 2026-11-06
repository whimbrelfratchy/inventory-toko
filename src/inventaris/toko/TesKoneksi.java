package inventaris.toko;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Feby
 */
public class TesKoneksi {
    public static void main(String[] args) {
        if (koneksi.getConnection() != null) {
            System.out.println("Database siap digunakan!");
        } else {
            System.out.println("Database belum terhubung!");
        }
    }
}
