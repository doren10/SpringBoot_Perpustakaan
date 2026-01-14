package com.example.perpus.service;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.perpus.entity.Peminjaman;
import com.example.perpus.repository.PeminjamanRepository;
@Service
public class PeminjamanService {
    @Autowired
    private final PeminjamanRepository peminjamanRepository;
    public PeminjamanService(PeminjamanRepository peminjamanRepository) {
        this.peminjamanRepository = peminjamanRepository;
    }
    public List<Peminjaman> getAllPeminjaman() {
        return peminjamanRepository.findAll();
    }
    public Peminjaman savePeminjaman(Peminjaman peminjaman) {
        return peminjamanRepository.save(peminjaman);
    }
    public Peminjaman updatePengembalian(Long id, LocalDate tanggalPengembalianBaru) {
        // Ambil data peminjaman dari database
        Peminjaman peminjaman = peminjamanRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Peminjaman tidak ditemukan"));
        // Ambil tanggal jadwal pengembalian
        LocalDate tanggalJadwalPengembalian = peminjaman.getTanggalPengembalian();
        // Hitung denda jika terlambat
        Integer denda = 0;
        if (tanggalPengembalianBaru.isAfter(tanggalJadwalPengembalian)) {
            int hariTerlambat = (int) ChronoUnit.DAYS.between(tanggalJadwalPengembalian, tanggalPengembalianBaru);
            Integer tarifDendaPerHari = 5000; // Contoh tarif denda
            denda = hariTerlambat * tarifDendaPerHari;
        }
        // Perbarui data
        peminjaman.setTanggalPengembalian(tanggalPengembalianBaru);
        peminjaman.setDenda(denda);
        peminjaman.setStatus("kembali");
        // Simpan perubahan ke database
        return peminjamanRepository.save(peminjaman);
    }
}

