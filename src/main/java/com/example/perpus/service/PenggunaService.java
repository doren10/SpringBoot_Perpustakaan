package com.example.perpus.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.perpus.entity.Mahasiswa;
import com.example.perpus.entity.Petugas;
import com.example.perpus.repository.MahasiswaRepository;
import com.example.perpus.repository.PetugasRepository;
@Service
public class PenggunaService {
    @Autowired
    private MahasiswaRepository mahasiswaRepository;
    @Autowired
    private PetugasRepository petugasRepository;
    // Method untuk menyimpan Mahasiswa atau Petugas
    public void saveMahasiswa(Mahasiswa mahasiswa) {
        mahasiswaRepository.save(mahasiswa);
    }
    public void savePetugas(Petugas petugas) {
        petugasRepository.save(petugas);
    }


    // Method untuk menghapus pengguna berdasarkan ID
    public void deletePenggunaById(Integer id) {
        if (mahasiswaRepository.existsById(id)) {
            mahasiswaRepository.deleteById(id);
        } else if (petugasRepository.existsById(id)) {
            petugasRepository.deleteById(id);
        }
    }
    // Method untuk mendapatkan semua mahasiswa
    public Iterable<Mahasiswa> getAllMahasiswa() {
        return mahasiswaRepository.findAll();
    }
    // Method untuk mendapatkan semua petugas
    public Iterable<Petugas> getAllPetugas() {
        return petugasRepository.findAll();
    }
}