package com.example.perpus.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
@Entity
@Table(name = "book")
public class DaftarBuku {
    @Id
    @Column(name = "id_book", length = 4, nullable = false)
    private String idBook;
    @Column(name = "judul")
    private String judul;
    @Column(name = "pengarang")
    private String pengarang;
    @Column(name = "penerbit")
    private String penerbit;
    @Column(name = "tahun_terbit")
    private String tahunTerbit;
    @Column(name = "jumlah_buku")
    private int jumlahBuku;
    @Column(name = "aksi")
    private String aksi;
    public DaftarBuku(){}
    public DaftarBuku(String idBook, String judul, String pengarang, String penerbit, String tahunTerbit, int jumlahBuku, String aksi){
        this.idBook = idBook;
        this.judul = judul;
        this.pengarang = pengarang;
        this.penerbit = penerbit;
        this.tahunTerbit = tahunTerbit;
        this.jumlahBuku = jumlahBuku;
        this.aksi = aksi;
    }
    public String getIdBook() {
        return idBook;
    }
    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }
    public String getJudul() {
        return judul;
    }
    public void setJudul(String judul) {
        this.judul = judul;
    }
    public String getPengarang() {
        return pengarang;
    }
    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }
    public String getPenerbit() {
        return penerbit;
    }
    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }
    public String getTahunTerbit() {
        return tahunTerbit;
    }
    public void setTahunTerbit(String tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }
    public int getJumlahBuku() {
        return jumlahBuku;
    }
    public void setJumlahBuku(int jumlahBuku) {
        this.jumlahBuku = jumlahBuku;
    }
    public String getAksi() {
        return aksi;
    }
    public void setAksi(String aksi) {
        this.aksi = aksi;
    }
}