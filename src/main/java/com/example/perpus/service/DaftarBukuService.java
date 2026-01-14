package com.example.perpus.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.perpus.entity.DaftarBuku;
import com.example.perpus.repository.DaftarBukuRepository;
@Service
public class DaftarBukuService {
    @Autowired
    private DaftarBukuRepository daftarBukuRepository;


    public List<DaftarBuku> getAllBooks() {
        return daftarBukuRepository.findAll();
    }
    public Long getTotalBooksAvailable() {
        return daftarBukuRepository.countTotalBooks();
    }
    public DaftarBuku tambahBuku(DaftarBuku buku) {
        return daftarBukuRepository.save(buku);
    }
    public DaftarBuku getBookById(String idBook) {
        return daftarBukuRepository.findById(idBook).orElse(null);
    }
    public void updateBook(DaftarBuku book) {
        daftarBukuRepository.save(book); // Spring Data JPA akan meng-handle update jika ID sudah ada
    }
    public void deleteBookById(String idBook) {
        daftarBukuRepository.deleteById(idBook); // Hapus buku berdasarkan ID
    }
}

