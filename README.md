PEMBUATAN DB!!!


CREATE DATABASE IF NOT EXISTS db_inventaris_toko;
USE db_inventaris_toko;

CREATE TABLE tabel_kategori (
    id_kategori INT AUTO_INCREMENT PRIMARY KEY,
    nama_kategori VARCHAR(100) NOT NULL
);

CREATE TABLE tabel_supplier (
    id_supplier INT AUTO_INCREMENT PRIMARY KEY,
    nama_supplier VARCHAR(100) NOT NULL,
    telepon VARCHAR(20)
);

CREATE TABLE tabel_barang (
    id_barang INT AUTO_INCREMENT PRIMARY KEY,
    nama_barang VARCHAR(100) NOT NULL,
    stok INT NOT NULL DEFAULT 0,
    harga DECIMAL(12,2) NOT NULL,
    id_kategori INT,
    id_supplier INT,
    FOREIGN KEY (id_kategori)
        REFERENCES tabel_kategori(id_kategori),
    FOREIGN KEY (id_supplier)
        REFERENCES tabel_supplier(id_supplier)
);

CREATE TABLE tabel_transaksi_masuk (
    id_masuk INT AUTO_INCREMENT PRIMARY KEY,
    id_barang INT NOT NULL,
    jumlah_masuk INT NOT NULL,
    tanggal_masuk DATE NOT NULL,
    FOREIGN KEY (id_barang)
        REFERENCES tabel_barang(id_barang)
);

CREATE TABLE tabel_transaksi_keluar (
    id_keluar INT AUTO_INCREMENT PRIMARY KEY,
    id_barang INT NOT NULL,
    jumlah_keluar INT NOT NULL,
    tanggal_keluar DATE NOT NULL,
    FOREIGN KEY (id_barang)
        REFERENCES tabel_barang(id_barang)
);

INSERT INTO tabel_kategori (nama_kategori) VALUES
('Elektronik'),
('Makanan'),
('Alat Tulis'),
('Peralatan Rumah');

INSERT INTO tabel_supplier (nama_supplier, telepon) VALUES
('PT Sumber Jaya', '081234567801'),
('CV Berkah Abadi', '082345678902'),
('UD Mitra Sejahtera', '085678901234');

INSERT INTO tabel_barang
(nama_barang, stok, harga, id_kategori, id_supplier) VALUES
('Mouse Wireless', 20, 75000, 1, 1),
('Keyboard Logitech', 15, 150000, 1, 1),
('Roti Coklat', 30, 10000, 2, 2),
('Buku Tulis', 50, 5000, 3, 3),
('Lampu LED', 25, 35000, 4, 2);

INSERT INTO tabel_transaksi_masuk
(id_barang, jumlah_masuk, tanggal_masuk) VALUES
(1, 10, '2026-10-25'),
(2, 5, '2026-10-26'),
(3, 15, '2026-10-27');

INSERT INTO tabel_transaksi_keluar
(id_barang, jumlah_keluar, tanggal_keluar) VALUES
(1, 2, '2026-10-28'),
(2, 3, '2026-10-28'),
(4, 5, '2026-10-29');


Query untuk melihat seluruh data barang

SELECT
    b.id_barang,
    b.nama_barang,
    b.stok,
    b.harga,
    k.nama_kategori,
    s.nama_supplier,
    s.telepon
FROM tabel_barang b
LEFT JOIN tabel_kategori k
    ON b.id_kategori = k.id_kategori
LEFT JOIN tabel_supplier s
    ON b.id_supplier = s.id_supplier;
