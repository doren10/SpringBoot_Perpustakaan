package com.example.perpus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.perpus.entity.Mahasiswa;
import com.example.perpus.entity.Petugas;
import com.example.perpus.repository.MahasiswaRepository;
import com.example.perpus.repository.PetugasRepository;

@Service
public class LoginService {

    @Autowired
    private MahasiswaRepository mahasiswaRepository;

    @Autowired
    private PetugasRepository petugasRepository;

    public Object validateLogin(String username, String password) {
        // Check Mahasiswa
        Mahasiswa mahasiswa = mahasiswaRepository.findByUsername(username);
        if (mahasiswa != null && mahasiswa.getPassword().equals(password)) {
            return mahasiswa;
        }

        // Check Petugas
        Petugas petugas = petugasRepository.findByUsername(username);
        if (petugas != null && petugas.getPassword().equals(password)) {
            return petugas;
        }

        // Return null if no user is found
        return null;
    }

    public void deleteUser(Integer id) {
        mahasiswaRepository.deleteById(id); // Sesuaikan jika perlu
    }
}
