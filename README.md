Project ini menggunakan logika login custom sederhana (tanpa Spring Security) sehingga cocok untuk pemula yang ingin memahami alur kerja MVC (Model-View-Controller) pada Java.

## ✨ Fitur Utama

* **Multi-Role Login:** Sistem membedakan akses antara dua jenis pengguna:
    * **Petugas (Admin):** Mengakses dashboard admin, melihat statistik perpustakaan, mengelola data buku, dan memantau status peminjaman.
    * **Mahasiswa (User):** Mengakses dashboard user, melihat daftar buku, dan mengecek riwayat peminjaman pribadi.
* **Dashboard Statistik:** Menampilkan ringkasan jumlah buku dipinjam, buku tersedia, dan total anggota secara *real-time*.
* **Manajemen Peminjaman:** Pencatatan status buku (Dipinjam/Kembali).
* **Responsive UI:** Menggunakan **Bootstrap 5** agar tampilan rapi di berbagai ukuran layar.

## 🛠️ Teknologi

* **Backend:** Java JDK, Spring Boot 3.x, Spring Data JPA
* **Frontend:** HTML5, Thymeleaf, Bootstrap 5
* **Database:** MySQL
* **Tools:** Maven, VS Code / IntelliJ IDEA

## ⚙️ Cara Menjalankan Project

Ikuti langkah-langkah berikut untuk menjalankan aplikasi di komputer lokal Anda:

### 1. Clone Repository
bash
git clone [https://github.com/doren10/SpringBoot_Perpustakaan.git](https://github.com/doren10/SpringBoot_Perpustakaan.git)
cd SpringBoot_Perpustakaan

### 2. Konfigurasi Database
Pastikan MySQL sudah berjalan (misal menggunakan XAMPP).
Buat database baru di phpMyAdmin dengan nama: obp
Pastikan file src/main/resources/application.properties sudah sesuai dengan settingan lokal Anda:

server.port=8081
spring.datasource.url=jdbc:mysql://localhost/obp
spring.datasource.username=root
spring.datasource.password=
# Kosongkan password jika default XAMPP kosong
### 3. Jalankan Aplikasi
mvn spring-boot:run
### 4. Akses Web
Buka browser dan kunjungi URL berikut: **👉 http://localhost:8081/login**
**🔐 Akun Default (Demo)**
Gunakan akun berikut untuk mencoba masuk. Password menggunakan Plain Text (tanpa enkripsi) untuk kemudahan simulasi.

Role,Username,Password,Deskripsi
Petugas,Petugas,Petugas,Akses Admin Dashboard
Mahasiswa,Mahasiswa,Mahasiswa,Akses User Dashboard

**📂 Struktur Project**
* **controller:** Mengatur navigasi halaman (LoginController, dsb).
* **entity:** Representasi tabel database (Mahasiswa, Petugas, Peminjaman, Buku).
* **repository:** Interface untuk query ke database (JPA).
* **service:** Logika bisnis (Validasi login manual, hitung stok buku, dsb).
**🤝 Kontribusi**
1. Pull requests dipersilakan. Untuk perubahan besar, harap diskusikan terlebih dahulu melalui Issue.
2. Fork repository ini.
3. Buat branch fitur (git checkout -b fitur-baru).
4. Commit perubahan (git commit -m 'Menambahkan fitur xyz').
5. Push ke branch (git push origin fitur-baru).
6. Buat Pull Request.
